package com.bdqn.ssm_springboot.controller;

import com.bdqn.ssm_springboot.pojo.User;
import com.bdqn.ssm_springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/")
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/login")
    public String login(User user, Model model, HttpSession session) {
        User login = userService.userLogin(user);
        if (login == null) {
            String error = "账号或密码错误！";
            model.addAttribute("error", error);
            return "login";
        } else {
            session.setAttribute("login", login);
            return "main";
        }
    }

    @RequestMapping(value = "/loginOut")
    public String loginOut(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
