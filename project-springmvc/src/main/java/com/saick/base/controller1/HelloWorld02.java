package com.saick.base.controller1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

/**
 * 方式1：创建一个类，实现HttpRequestHandler接口，直接进行requesr的转发
 * 
 * @author Liubao
 * @2014年12月16日
 * 
 */
public class HelloWorld02 implements HttpRequestHandler {
    /**
     * 不用返回任何数值,直接转发到指定页面即可,和之前的servlet十分相似
     */
    @Override
    public void handleRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message", "这是新的request testing...");
        request.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(request,response);
    }

}
