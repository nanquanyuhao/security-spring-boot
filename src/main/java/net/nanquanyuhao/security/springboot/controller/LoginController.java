package net.nanquanyuhao.security.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
public class LoginController {

    @RequestMapping(value = "/login-success", produces = "text/plain;charset=utf-8")
    public String loginSuccess() {
        return "登录成功";
    }

    /**
     * 资源访问逻辑
     *
     * @return
     */
    @GetMapping(value = "/r/r1", produces = {"text/plain;charset=utf-8"})
    public String r1() {
        return "访问资源 1";
    }

    /**
     * 资源访问逻辑 2
     *
     * @return
     */
    @GetMapping(value = "/r/r2", produces = {"text/plain;charset=utf-8"})
    public String r2() {
        return "访问资源 2";
    }
}