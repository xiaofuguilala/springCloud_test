package com.example.demo.domain.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Created by 96599 on 2019/4/23.
 */
@Data
@Accessors(chain = true)
public class PatientDto {
    /**
     * 病人名字
     */
    private String userName;

    /**
     * 床号
     */
    private  String bedNum;

    /**
     * 住院号
     */
    private String hospitalcard;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private int age;
    /**
     * 出生日期
     */
    private Date birth;
    /**
     * 第几次化疗
     */
    private int chemothrapy;

    /**
     * 是否做了切除肿瘤的手术
     */
    private int cancer;
    /**
     * 创建时间
     */
    private Date createTime;
}
