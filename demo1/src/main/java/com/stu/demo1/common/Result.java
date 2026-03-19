package com.stu.demo1.common;

public class Result<T> {
    private String msg;
    private Integer code;
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> res = new Result<>();
        res.code = ResultCode.SUCCESS.getCode();
        res.msg = ResultCode.SUCCESS.getMsg();
        res.data = data;
        return res;
    }

    public static <T> Result<T> error(ResultCode code) {
        Result<T> res = new Result<>();
        res.code = code.getCode();
        res.msg = code.getMsg();
        return res;
    }

    // 右键生成 Getter 和 Setter 方法
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public Integer getCode() { return code; }
    public void setCode(Integer code) { this.code = code; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}