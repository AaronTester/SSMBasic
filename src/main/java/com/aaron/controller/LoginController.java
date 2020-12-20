package com.aaron.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/6
 */
@Controller
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login/validate")
    @ResponseBody
    public String validate(HttpSession session, String username, String password) {
        logger.info("username: "+username+"  password: "+password);
        if(username != null && password != null
                && !"".equals(username) && !"".equals(password)) {
            session.setAttribute("USER_INFO",username);
            return JSON.toJSONString(true);
        }
        return JSON.toJSONString(false);
    }

    @PostMapping("/login/logOut")
    @ResponseBody
    public String logOut(HttpSession session) {
        session.removeAttribute("USER_INFO");
        return JSON.toJSONString(true);
    }
}
