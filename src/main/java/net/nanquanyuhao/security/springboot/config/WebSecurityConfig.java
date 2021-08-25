package net.nanquanyuhao.security.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring Security 配置类
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 定义用户信息服务（查询用户信息）
     *
     * @return
     */
    /*@Bean
    @Override
    protected UserDetailsService userDetailsService() {

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
        manager.createUser(User.withUsername("lisi").password("456").authorities("p2").build());

        return manager;
    }*/

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("123");
        auth.inMemoryAuthentication().withUser("lucy").password(password).roles("admin");
    }*/

    /**
     * 密码编码器
     *
     * @return
     */
    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }*/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 安全拦截机制（最重要）
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 临时关闭 csrf
        http.csrf().disable()
                .authorizeRequests()
                //.antMatchers("/r/r1").hasAuthority("p1")
                //.antMatchers("/r/r2").hasAuthority("p2")
                // 所有 /r/** 请求必须认证通过；/test/** 请求必须认证通过，为适配后来添加的 test 控制器
                .antMatchers("/r/**", "/test/**").authenticated()
                // 除了上述的 /r/** ，其他的请求可以任意访问
                .anyRequest().permitAll()
                .and()
                // 允许表单登录
                .formLogin()
                // 通常用于自定义的登录页面地址，未认证跳转会跳转至此登陆页，默认不设置是 /login
                .loginPage("/login-view")
                // 实际验证登录表单的地址
                .loginProcessingUrl("/user/login")
                // 自定义登录成功的页面地址
                .successForwardUrl("/login-success")
                // 以下配置为设置 session 的管理策略，此处配置为有需要则创建
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                // 以下两行是追加登录相关的配置
                .and().logout()
                // 设置登录调用的地址以及登出后跳转到的位置
                .logoutUrl("/logout").logoutSuccessUrl("/login-view?logout");
    }
}
