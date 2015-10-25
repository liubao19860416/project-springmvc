package com.saick.base.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saick.base.dao.entiy.User;
import com.saick.base.dao.entiy.UserList;
import com.saick.base.service.api.IUserService;

/**
 * 备注:在Controller内部转发使用return "forward:action路径"实现
 * 
 * @author Liubao
 * @Version 1.0
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {

    // 批量添加使用 
    private static final String DEFAULT_SIMPLEDATEFORMAT ="yyyy-MM-dd";

    @Resource
    private IUserService userService;
    
    /**
     * 用户查询列表：添加了请求参数  
     * 
     * @RequestParam(defaultValue = "2", value = "groupId", required = true) String groupId
     * 
     * groupid是用户类型,需求：进入查询页面默认显示哪个类型的用户
     */
    @RequestMapping("/userlist")
    public String userlist(HttpServletRequest request,HttpServletResponse response,
            @RequestParam(defaultValue = "2", value = "groupId", required = true) String groupId) throws Exception {
        System.out.println(groupId);
        return "user/userlist";
    }
    
    /**
     * TODO 
     * 用户修改页面：添加了校验 @PathVariable，可以使用它在请求参数路径中，类是Restful风格
     */
    @RequestMapping("/useredit/{userid:\\d+}")
    public String useredit(Model model,@PathVariable String userid)throws Exception{
        System.err.println("userid="+userid);
        return "user/useredit";
    }
    /**
     * 批量添加提交：封装request请求一个实体，实体中存在需要批量提交的对象List即可
     */
    @RequestMapping("/useraddlistsubmit")
    public String useraddlistsubmit(Model model,UserList users)throws Exception{
        System.out.println(users.getUserList());
        return "success";
    }

    /**
     *  查询列表的显示方法
     */
    @RequestMapping(value = "/userList.action", method = RequestMethod.GET)
    public String userList(Model model) {
        // 查询数据库,获取所有用户信息
        List<User> userList = userService.findUserList();
        if (userList == null) {
            // 防止出现空指针
            userList = new ArrayList<User>();
        }
        model.addAttribute("userList", userList);
        System.out.println("执行了查询所有用户列表..." + userList);
        return "userList";
    }

    /**
     *  get方式, 跳转到添加用户页面的方法
     */
    @RequestMapping(value = "/userAdd.action", method = RequestMethod.GET)
    public String userAdd(Long id, Model model) {
        if (id != null) {
            // 更新用户页面,查询数据库,获取需要回显的数据
            User user = userService.findUserById(id);
            model.addAttribute("user", user);
            // model.addAttribute(user);
        }
        // 否则,直接跳转到添加新用户页面,不做任何操作
        return "userAdd";
    }

    /**
     * get方式, 跳转到批量添加用户页面的方法
     */
    @RequestMapping(value = "/userAddMany.action", method = RequestMethod.GET)
    public String userAddMany(Model model, UserList userList) {
        // 直接跳转到添加批量新用户页面,不做任何操作
        return "userAddMany";
    }

    /**
     *  post方式,直接提交表单,添加用户的方法(这里的model可以省略吗?)
     *  
     *  @Validated 和BindingResult
     */
    @RequestMapping(value = "/userAdd.action", method = RequestMethod.POST)
    public String userAdd(Long id, Model model, @Validated User user,BindingResult br) {
        // 默认使用转发的方式到指定页面(校验位置)
        if (br.hasErrors()) {
            // 这时候需要添加回显数据
            // model.addAttribute("user", user);
            return "userAdd";
        }
        if (id != null) {
            System.out.println("执行更新用户操作..." + user);
            // 更新或者添加用户，这里不用设置id
            // user.setId(id);
            userService.updateUser(user);
        } else {
            System.out.println("执行添加用户操作..." + user);
            userService.saveUser(user);
        }
        // 添加完成后,跳转到显示用户列表页面(使用了重定向的方式实现)
        return "redirect:userList.action";
    }

    /**
     * 批量删除用户操作(根据用户ids删除,指定只能是post提交方式])
     * 字符串以逗号分隔，springmvc使用数组类型接收
     */
    @RequestMapping(value = "/userDelete.action", method = { RequestMethod.POST })
    public String userDelete(Long ids[]) {
        System.out.println("正在执行批量删除用户的id是:" + Arrays.toString(ids));
        if (ids != null && ids.length > 0) {
            userService.deleteUserByIds(ids);
        }
        // 添加完成后,跳转到显示用户列表页面(使用了重定向的方式实现)
        return "redirect:/user/userList.action";
    }

    /**
     * 请求user对象格式的json数据,即{name:value,name2:value2}键值对的格式
     * 使用RequestBody 将客户端传来的json串传为User对象
     * 提交采用普通的get/post方式,默认内容类型为application/x-www-form-urlencoded
     */
    @RequestMapping("/requestJSON.action")
    public @ResponseBody User requestJSON(@RequestBody User user) {
        System.out.println("响应信息为:" + user);
        user.setNickname("新名字");
        return user;
    }

    /**
     * 提交没有请求参数
     * 响应结果为数据列表
     * 创建对象的list数据，通过@ResponseBody转为json对象集合的格式
     */
    @RequestMapping("/responseJSONList.action")
    public @ResponseBody List<User> responseJSONList() {
        // 获取对象集合
        List<User> userList = userService.findUserList();
        // 返回数据
        return userList;
    }

    /**
     * @InitBinder 注册可以接收日期类型数据的编辑器
     * 字符串以逗号分隔，springmvc使用数组类型接收
     * 暂时未使用到日期类型
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception {
        // 注册时间的编辑器
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(DEFAULT_SIMPLEDATEFORMAT), true));
        // 注入集合的编辑器(使用接口类型)
         binder.registerCustomEditor(List.class, new CustomCollectionEditor(ArrayList.class));
    }
}
