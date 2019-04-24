package com.example.demo.domain.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ReceiveBackVo {

    /**
     * 接收算法名称
     */
    private String albackname;

    /**
     * 接收模型名称
     */
    private String modelbackname;
}