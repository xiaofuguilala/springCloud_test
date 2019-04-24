package com.example.demo.domain.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class UserInfoVo {

    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空")
    private String account;

    /**
     * 用户密码
     */
    @NotBlank(message = "用户密码不能为空")
    private String passwd;

}