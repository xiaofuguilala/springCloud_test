package com.example.demo.domain.bean;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Accessors(fluent = true)
public class ResultTotal<T> {

    private Integer code;

    private String message;

    private T data;

    private ResultTotal(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public static ResultTotal success() {
        return new ResultTotal(ResultEnum.SUCCESS);
    }

    public static ResultTotal fail() {
        return new ResultTotal(ResultEnum.FAIL);
    }

}