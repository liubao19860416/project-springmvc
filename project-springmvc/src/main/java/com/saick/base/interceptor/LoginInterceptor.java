package com.saick.base.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户身份认证拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 第一个方法： 在执行controller方法之前调用此方法 可以用于权限控制拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {

        // 如果是登录页面则放行
        if (request.getRequestURI().indexOf("login.action") >= 0) {
            return true;
        }
        HttpSession session = request.getSession();
        // 如果用户已登录也放行
        if (session.getAttribute("user") != null) {
            return true;
        }
        // 用户没有登录,跳转到登录页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        System.out.println("LoginInterceptor  preHandle.....");
        return false;
    }

    /**
     * 第二个方法： 在controller方法执行后返回视图之前执行此方法 ;
     * 用于将系统的公用数据取出来放到modelAndView，
     * 例如：定义一个baseurl将系统根路径在每个请求中放到modelAndView中
     */
    @Override
    public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
         modelAndView.addObject("baseurl", request.getContextPath());
        System.out.println("LoginInterceptor  postHandle.....");
    }

    /**
     * 第三个方法： controller方法执行完成后调用此方法 ;
     * 用于：全局的异常处理，将错误信息写入日志表 监控系统执行性能（执行时间）等
     */
    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception exception)
            throws Exception {
        System.out.println("LoginInterceptor  afterCompletion.....");

    }

}
