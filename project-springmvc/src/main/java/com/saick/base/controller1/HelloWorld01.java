package com.saick.base.controller1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 方式1：创建一个类，实现Controller接口
 * 
 * @author Liubao
 * @2014年12月16日
 * 
 */
public class HelloWorld01 implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Hello World!!!");
        // 两种方式,也可以在构造方法中实现,例如
        // modelAndView = new ModelAndView("hello.jsp");
        // 设置返回的jsp地址
        modelAndView.setViewName("hello");
        return modelAndView;
    }

}
