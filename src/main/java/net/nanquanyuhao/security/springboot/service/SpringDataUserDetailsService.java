package net.nanquanyuhao.security.springboot.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 自定已用户信息服务实现类
 */
@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    /**
     * 根据藏哈后查询用户信息
     *
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        // 将来连接数据库根据账号查询用户信息
        System.out.println("username=" + s);
        // 暂时采用模拟方式
        UserDetails userDetails = User.withUsername("zhangsan").password("123").authorities("p1").build();

        return userDetails;
    }
}
