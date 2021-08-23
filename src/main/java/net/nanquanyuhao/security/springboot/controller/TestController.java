package net.nanquanyuhao.security.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nanquanyuhao
 * @version 1.0
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("hello")
    public String loginSuccess() {

        return "hello security";
    }
}
