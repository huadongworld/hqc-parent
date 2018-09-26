package com.ys.hdc.test.misc;

/**
 * @author HD
 * @date 2018/9/7 11:30
 */
public class CompanyDistanceInfoResponse extends ResponseResult {

    private String resultObject;

    public CompanyDistanceInfoResponse(String success, String code, String msg, String resultObject) {
        super(success, code, msg);
        this.resultObject = resultObject;
    }

    public CompanyDistanceInfoResponse() {
        super();
    }

    public String getResultObject() {
        return resultObject;
    }

    public void setResultObject(String resultObject) {
        this.resultObject = resultObject;
    }
}
