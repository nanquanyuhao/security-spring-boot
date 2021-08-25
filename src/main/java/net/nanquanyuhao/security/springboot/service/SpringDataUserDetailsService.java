package net.nanquanyuhao.security.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.nanquanyuhao.security.springboot.dao.UserDao;
import net.nanquanyuhao.security.springboot.mapper.UserMapper;
import net.nanquanyuhao.security.springboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 自定已用户信息服务实现类
 */
@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据藏哈后查询用户信息
     *
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    /*@Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        // 将来连接数据库根据账号查询用户信息
        UserDto userDto = userDao.getUserByUsername(s);
        if (userDto == null) {
            // 如果用户查不到，返回 null，由 provider 来抛出异常
            return null;
        }

        // 根绝用户的 id 查询用户的权限
        List<String> permissions = userDao.findPermissionByUserId(userDto.getId());
        // 将 permissions 转成数组
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);
        UserDetails userDetails = User.withUsername(userDto.getUsername())
                .password(userDto.getPassword()).authorities(permissionArray).build();

        return userDetails;
    }*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 调用userMapper方法，根据用户名查询数据库
        QueryWrapper<UserDto> wrapper = new QueryWrapper<>();
        // where username = ?
        wrapper.eq("username", username);
        UserDto user = userMapper.selectOne(wrapper);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }

        // 根绝用户的 id 查询用户的权限
        List<String> permissions = userDao.findPermissionByUserId(user.getId());
        // 将 permissions 转成数组
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);
        UserDetails userDetails = User.withUsername(user.getUsername())
                .password(user.getPassword()).authorities(permissionArray).build();

        return userDetails;
    }
}
