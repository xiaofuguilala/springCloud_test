package com.example.demo.domain.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("model_list")
public class AlModelEntity {
    public AlModelEntity(){}

    //标记数据表主键
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @TableField("modelname")
    private String modelname;

    @TableField("modeladds")
    private String modeladds;
}