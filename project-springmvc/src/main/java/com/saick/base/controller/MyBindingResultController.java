package com.saick.base.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.saick.base.controller.requestobject.OrderCommitRequestObject4;

/**
 * 备注:在BindingResult测试类
 * 
 * @author Liubao
 * @Version 1.0
 * 
 */
@Controller
@RequestMapping("/binding")
public class MyBindingResultController {

    /**
     * 批量操作(根据用户ids删除,指定只能是post提交方式])
    * 请求参数【字符串以逗号分隔】
    * 使用数组类型接收
    */
   @RequestMapping(value = "/intBatch", method = { RequestMethod.POST })
   public String intBatch(Long ids[]) {
        System.out.println(Arrays.toString(ids));
        return "user/userlist";
    }
   @RequestMapping(value = "/stringBatch", method = { RequestMethod.POST })
   public String stringBatch(String[] strs) {
       System.out.println(Arrays.toString(strs));
       return "user/userlist";
   }

   /**
    * get方式请求参数
    */
    @RequestMapping(value="/testRequestParam",method={RequestMethod.POST,RequestMethod.GET})
    public String testRequestParam(@RequestParam(defaultValue = "2", value = "groupId", required = true) String groupId) throws Exception {
        System.out.println(groupId);
        return "user/userlist";
    }
    
    /**
     * 用户修改页面：添加了校验 @PathVariable，可以使用它在请求参数路径中，类是Restful风格
     */
    @RequestMapping("/testPathvariable/{userid:\\d+}")
    public String testPathvariable(Model model,@PathVariable String userid,
             @RequestBody Map<String, Object> requestMap)throws Exception{
        System.out.println("userid="+userid);
        return "user/useredit";
    }


    /**
     *  @Validated 和BindingResult
     */
    @RequestMapping(value = "/testValidated.action", method = RequestMethod.POST)
    public String testValidated(
            @RequestBody( required = true ) Map<String, Object> orderDetailParam,
            @RequestHeader( required = true )  Map<String, Object> headMap,
            /*@RequestHeader( required = true ) @Validated SaikeMobileHead saikemobilehead,BindingResult br1,*/
            /*@RequestHeader( required = true ) @Validated OrderCommitRequestHeader saikemobilehead,BindingResult br1,*/
            @RequestBody( required = true ) @Validated OrderCommitRequestObject4 object,BindingResult br2,
            HttpServletRequest request) {
        if (br2.hasErrors()) {
//            br2.reject(errorCode, defaultMessage);
//            errors.reject("username.length.error", new Object[]{5, 10})
            List<ObjectError> errors = br2.getAllErrors();
            for (ObjectError error : errors) {
                String message = error.getDefaultMessage();
                String code = error.getCode();
                System.out.println(code+":"+message);
            }
            return "userAdd";
        }
        return "redirect:userList.action";
    }


    /**
     * @InitBinder 注册可以接收日期类型数据的编辑器
     */
    /*@InitBinder
    protected void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception {
        // 注入集合的编辑器(使用接口类型)
         binder.registerCustomEditor(List.class, new CustomCollectionEditor(ArrayList.class));
    }*/
}
