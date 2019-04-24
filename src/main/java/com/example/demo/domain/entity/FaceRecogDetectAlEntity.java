package com.example.demo.domain.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("facerecognition_detect")
public class FaceRecogDetectAlEntity {
    public FaceRecogDetectAlEntity(){}

    //标记数据表主键
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @TableField("algorithmname")
    private String algorithmname;

    @TableField("algorithmadds")
    private String algorithmadds;
}