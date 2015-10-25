package com.saick.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saick.base.dao.entiy.User;

/**
 * 转发控制器测试类：redirect和forward，默认为forward；
 * 
 */
@Controller
@RequestMapping("/test")
public class RedirectAndForwardController {

    @RequestMapping("/a.action")
    public String a(String groupid, User user) throws Exception {
        return "redirect:/to/b.action?groupid=" + groupid + "&student.name="+ user.getUsername();
    }

    @RequestMapping("/b.action")
    public String b(String groupid, User user) throws Exception {
        return "success";
    }

    @RequestMapping("/c.action")
    public String c(String groupid, User user) throws Exception {
        return "forward:/test/d.action";
    }

    @RequestMapping("/d.action")
    public String d(String groupid, User user) throws Exception {
        return "success";
    }
}
