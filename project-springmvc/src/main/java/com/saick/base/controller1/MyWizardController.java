package com.saick.base.controller1;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.saick.base.dao.entiy.User;

/**
 * 自定义向导表单控制器
 * 
 * @author Liubao
 * @2014年12月16日
 * 
 */
@SuppressWarnings("deprecation")
public class MyWizardController extends AbstractWizardFormController {

    public MyWizardController() {
        this.setCommandClass(User.class);
        this.setCommandName("user");
    }

    /**
     * 执行顺序2
     * 执行显示form表单的页面操作
     */
    @Override
    protected ModelAndView showForm(HttpServletRequest request,HttpServletResponse response, BindException errors)
            throws Exception {
        System.out.println("显示表单的方法执行了");
        return super.showForm(request, response, errors);
    }

    /**
     * 执行顺序4：完成提交的时候执行
     * 执行显示form表单的页面操作
     */
    @Override
    protected ModelAndView processFinish(HttpServletRequest request,HttpServletResponse response, Object command, BindException errors)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView("success");
        User user = (User) command;
        System.out.println("向导表单控制器提交的方法执行了" + user);
        modelAndView.addObject("user", user);
        // 成功提交后跳转的视图
        return modelAndView;
    }

    /**
     * 执行顺序3：取消操作的时候执行
     * 取消表单的操作
     */
    @Override
    protected ModelAndView processCancel(HttpServletRequest request,HttpServletResponse response, Object command, BindException errors)
            throws Exception {
        // 取消表单后,跳转的视图
        return new ModelAndView("cancel");
    }

    /**
     * 执行顺序1：每次都会执行
     * 注册属性编辑器（字符串转日期）
     */
    @Override
    protected void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }

}
