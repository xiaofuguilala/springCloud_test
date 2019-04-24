package com.example.demo.domain.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Created by 96599 on 2019/4/23.
 * 病人类
 */
@Data
@Accessors(chain = true)
@TableName("patient")
public class PatientEntity {

    //标记数据表主键
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @TableField("patientName")
    private String patientName;

    @TableField("patientBed")
    private String patientBed;

    @TableField("hospitId")
    private String hospitId;

    @TableField("patientSex")
    private String patientSex;

    @TableField("patientAge")
    private int patientAge;

    @TableField("patientBirth")
    private Date patientBirth;

    @TableField("patientChemotherapy")
    private int patientChemotherapy; //第几次化疗

    @TableField("patientCancer")
    private int patientCancer; //0代表没呀切除肿瘤，1表示切除

    @TableField("patientRecordTime")
    private Date patientRecordTime;

}
