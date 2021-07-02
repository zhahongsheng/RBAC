package com.example.user_access_management.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一标准返回结果类
 * @author zhahsh
 * @date 2021/7/2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    /**
     * 错误代码
     */
    private int errCode;

    /**
     * 错误信息
     */
    private String errMsg;

    /**
     * 返回数据
     */
    private T data;

    public Result(int errCode) {
        this.errCode = errCode;
    }

    public Result(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public static <C> Result<C> ok() {
        Result<C> result = new Result<>();
        result.setErrCode(0);
        return result;
    }

    public static <C> Result<C> ok(C data) {
        Result<C> result = new Result<>();
        result.setErrCode(0);
        result.setData(data);
        return result;
    }

    public static <C> Result<C> fail(){
        Result<C> result = new Result<>();
        result.setErrCode(1);
        return result;
    }

    public static <C> Result<C> fail(int errCode){
        Result<C> result = new Result<>();
        result.setErrCode(errCode);
        return result;
    }

    public static <C> Result<C> fail(int errCode, String errMsg){
        Result<C> result = new Result<>();
        result.setErrCode(errCode);
        result.setErrMsg(errMsg);
        return result;
    }
}
