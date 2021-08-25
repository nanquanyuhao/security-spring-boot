package net.nanquanyuhao.security.springboot.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Administrator
 * @version 1.0
 **/
@Data
@TableName("t_user")
public class UserDto {

    public static final String SESSION_USER_KEY = "_user";

    //用户身份信息
    private String id;

    private String username;

    private String password;

    private String fullname;

    private String mobile;
}
