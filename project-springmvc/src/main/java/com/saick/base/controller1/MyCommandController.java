package com.saick.base.controller1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.saick.base.dao.entiy.User;

/**
 * 数值属性绑定Controller
 * 
 * @author Liubao
 * @2014年12月23日
 * 
 */
@SuppressWarnings("deprecation")
public class MyCommandController extends AbstractCommandController {
    //在默认构造方法中设置
    public MyCommandController() {
        super.setCommandClass(User.class);
    }

    protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
        // 让框架认识command是person，绑定
        User p = (User) command;
        System.out.println(p);
        return new ModelAndView("index");
    }

}
