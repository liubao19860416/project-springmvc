package com.saick.base.controller1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.saick.base.dao.entiy.User;

/**
 * 简单用户表单提交的Controller
 * 
 * @author Liubao
 * @2014年12月19日
 * 
 */
@SuppressWarnings("deprecation")
public class MyFormController extends SimpleFormController {

    public MyFormController() {
        this.setCommandClass(User.class);
        this.setCommandName("user");
    }

    /**
     * 执行顺序3：提交表单的时候执行
     * 提交表单执行的方法
     */
    @Override
    public void doSubmitAction(Object command) throws Exception {
        User user = (User) command;
        System.out.println("doSubmitAction-----user:" + user);
        System.out.println("执行了表单的提交方法");
        super.doSubmitAction(command);
    }

    /**
     * 执行顺序2：
     * 转向form表单显示调用的方法(好像使用其他的重载方法是不可以的)
     */
    @SuppressWarnings("rawtypes")
    @Override
    protected ModelAndView showForm(HttpServletRequest request,HttpServletResponse response, BindException errors, Map controlModel)
            throws Exception {
        System.out.println("执行了显示表单方法");
        return super.showForm(request, response, errors, controlModel);
    }

    /**
     * 执行顺序1：每个页面都会被执行
     * 注册属性编辑器（字符串转日期）
     */
    @Override
    protected void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }

}
