package net.nanquanyuhao.security.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Administrator
 * @version 1.0
 **/
@Configuration //就相当于springmvc.xml文件
public class WebConfig implements WebMvcConfigurer {

    /**
     * 用于对照新增的 url
     * 实现无业务逻辑跳转
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // 用于自动将根路径下的访问重定向至登陆页面
        registry.addViewController("/").setViewName("redirect:/login-view");
        // 此处 setViewName("login") 会寻找项目路径下 /WEB-INF/view/login.jsp 页面，即访问 /login-view 就会到登录页
        registry.addViewController("/login-view").setViewName("login");

        // 处理自定义未授权页面的情况
        registry.addViewController("/unauth").setViewName("unauth");
        // 为简单模拟登出，处理登录成功的页面
        registry.addViewController("/login-success").setViewName("success");
    }
}