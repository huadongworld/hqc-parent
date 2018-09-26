package com.ys.hdc.test.misc;

/**
 * @author HD
 * @date 2018/9/7 11:38
 */
public class ResponseResult {

    private String success;
    private String code;
    private String msg;

    public ResponseResult(String success, String code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult() {
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
