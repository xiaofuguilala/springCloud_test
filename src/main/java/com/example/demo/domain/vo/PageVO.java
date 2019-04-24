package com.example.demo.domain.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PageVO {
    /**
     * 页数 从1开始
     */
    private Integer index;

    /**
     * 每页个数
     */
    private Integer size;

    /**
     * Vo对象
     */
//    private T data;
}
