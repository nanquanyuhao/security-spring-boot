package net.nanquanyuhao.security.springboot.dao;

import net.nanquanyuhao.security.springboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户数据访问类
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据账号查询用户信息
     *
     * @param username
     * @return
     */
    public UserDto getUserByUsername(String username) {

        String sql = "select id, username, password, fullname, mobile from t_user where username = ?";
        // 连接数据库查询用户
        List<UserDto> list = jdbcTemplate.query(sql, new Object[]{username},
                new BeanPropertyRowMapper(UserDto.class));
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
}
