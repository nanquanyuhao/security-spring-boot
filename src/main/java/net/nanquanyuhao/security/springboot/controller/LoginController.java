package net.nanquanyuhao.security.springboot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
public class LoginController {

    /**
     * 登录成功请求处理
     *
     * @return
     */
    @RequestMapping(value = "/login-success", produces = "text/plain;charset=utf-8")
    public String loginSuccess() {

        // 提示屈居用户名称登录成功
        return getUsername() + "登录成功";
    }

    /**
     * 资源访问逻辑
     *
     * @return
     */
    @GetMapping(value = "/r/r1", produces = {"text/plain;charset=utf-8"})
    @PreAuthorize("hasAuthority('p1')") // 拥有 p1 权限才可以访问
    public String r1() {
        return getUsername() + "访问资源 1";
    }

    /**
     * 资源访问逻辑 2
     *
     * @return
     */
    @GetMapping(value = "/r/r2", produces = {"text/plain;charset=utf-8"})
    @PreAuthorize("hasAuthority('p2')") // 拥有 p2 权限才可以访问
    public String r2() {
        return getUsername() + "访问资源 2";
    }

    /**
     * 获取当前用户信息
     *
     * @return
     */
    private String getUsername() {

        String username = null;
        // 当前认证通过的用户身份
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 用户身份
        Object principal = authentication.getPrincipal();
        if (principal == null) {
            username = "匿名";
        }
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }

        return username;
    }
}
