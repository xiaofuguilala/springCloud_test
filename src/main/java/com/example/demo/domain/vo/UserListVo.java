package com.example.demo.domain.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class UserListVo {

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    private String username;

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

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    private String email;

    /**
     * 电话
     */
    @NotBlank(message = "电话不能为空")
    private String phone;

    /**
     * 证件号
     */
    @NotBlank(message = "证件号不能为空")
    private String card;

    /**
     * 生日
     */
    @NotBlank(message = "生日不能为空")
    private String birth;

    /**
     * 性别
     */
    @NotBlank(message = "性别不能为空")
    private String sex;
}