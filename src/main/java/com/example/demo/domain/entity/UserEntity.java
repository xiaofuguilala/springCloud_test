package com.example.demo.domain.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

//标记表名(此注解为必须，下面的字段注解可选)
@Data
@Accessors(chain = true)
@TableName("person_list")
public class UserEntity {
    public UserEntity(){}

    //标记数据表主键
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @TableField("personname")
    private String personname;

    @TableField("personaccount")
    private String personaccount;

    @TableField("personpasswd")
    private String personpasswd;

    @TableField("personemail")
    private String personemail;

    @TableField("personphone")
    private String personphone;

    @TableField("personcard")
    private String personcard;

    @TableField("personbirth")
    private String personbirth;

    @TableField("personsex")
    private String personsex;
}