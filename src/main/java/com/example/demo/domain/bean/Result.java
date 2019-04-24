package com.example.demo.domain.bean;

/**
 * @author royhsu
 * @version V1.0
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @telphone 18215595056
 * @date 2018/12/28 17:47
 */
public class Result {
    private Boolean success;
    private Integer code;
    private String msg;
    private Object data;

    private Result() {

    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    /**
     * 成功请求的返回
     * @return
     */
    public Result ok() {
        this.success = Boolean.TRUE;
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = ResultEnum.SUCCESS.getMessage();
        return this;
    }

    public Result setData(Object data){
        this.data = data;
        return this;
    }

    /**
     * 失败请求返回的构造
     * @return
     */
    public Result fail(){
        this.success = Boolean.FALSE;
        return this;
    }

    public Result setResultEnum(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMessage();
        return this;
    }

    public Result setCode(int code){
        this.code = code;
        return this;
    }

    public Result setMessage(String message){
        this.msg = message;
        return this;
    }

    public static Result builder(){
        return new Result();
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
