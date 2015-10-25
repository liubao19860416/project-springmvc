package com.saick.base.controller.requestobject;

/**
 * "saikemobilehead" http请求头信息类
 */
public class SaikeMobileHead {

    private String appCode;
    private String appVersion;
    private String deviceId;
    private String plateformType;
    private String sourceCode;
    private String userAccount;
    private String userToken;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getPlateformType() {
        return plateformType;
    }

    public void setPlateformType(String plateformType) {
        this.plateformType = plateformType;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
    
}
