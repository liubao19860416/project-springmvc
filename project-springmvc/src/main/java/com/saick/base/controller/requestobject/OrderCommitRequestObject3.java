package com.saick.base.controller.requestobject;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 备份
 * 
 * @author Liubao
 * @version 2.0
 */
@SuppressWarnings("rawtypes")
public class OrderCommitRequestObject3 implements Serializable{
    private static final long serialVersionUID = -4723197208631580373L;
    
    //@NotBlank(message = "{username.empty}")
    //@NotBlank(message = "参数不能为空3")
    @NotNull(message = "参数不能为空3")
    @Min(value = 0, message = "userId最小值为0(包括0) ")
    private long userId;// 用户id
    
    @Min(value = 0, message = "车型id最小值为0")
    private long maintVelmodelId;// 保养车型id

    @Size(min = 1, message = "userId字符串的长度最小为1！")
    private String dealerCode;// 经销商code
    
    @Size(min = 1, message = "userId字符串的长度最小为1！")
    private String orderUName;// 用户名
    
    @Min(value = 0, message = "vkt最小值为0(包括0) ")
    private String vkt;// 行驶公里数
    
    //^[\u4e00-\u9fa5]{1}[a-zA-Z]{1}[a-zA-Z_0-9]{4}[a-zA-Z_0-9_\u4e00-\u9fa5]$|^[a-zA-Z]{2}\d{7}$
    //"^[(\u4e00-\u9fa5)|(a-zA-Z)]{1}[a-zA-Z]{1}[a-zA-Z_0-9]{4,6}[a-zA-Z_0-9_\u4e00-\u9fa5]$"
    //^[\u4e00-\u9fa5]{1}[a-zA-Z]{1}[a-zA-Z_0-9]{4}[a-zA-Z_0-9_\u4e00-\u9fa5]$
    @Pattern(regexp = "^[\u4e00-\u9fa5]{1}[a-zA-Z]{1}[a-zA-Z_0-9]{4}[a-zA-Z_0-9_\u4e00-\u9fa5]$", message = "车牌号格式！")
    @Size(min = 1, max=7,message = "vlp字符串的长度最小为1！")
    private String vlp;// 车牌号

    @Size(max = 10, min = 10, message = "startDate字符串的长度为10！")
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$", message = "日期格式长度为10！")
    //@Pattern(regexp = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$", message = "日期格式长度为10！")
    private String startDate;// 预约保养日期
    
    @Pattern(regexp = "^([0-2][0-9][:][0-5][0-9])[-]([0-2][0-9][:][0-5][0-9])$", message = "时间段格式长度为11！")
    @Size(max = 11, min = 11, message = "timeArea字符串的长度为11！")
    private String timeArea;// 保养时间段
    
    @Pattern(regexp = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$", message = "手机格式不正确！")
    @Size(max = 11, min = 11, message = "orderUTel字符串的长度为11！")
    private String orderUTel;// 用户电话
    
    //@DecimalMin(value="0",inclusive=false)
    @Pattern(regexp = "^\\d+\\.(\\d{2})$", message = "订单总金额格式不正确！")
    @Min(value = 1, message = "maintAmt最小值为1(包括1) ")
    private String maintAmt;// 保养金额（订单总金额）
    
    @Pattern(regexp = "^[0][.][0-9]$", message = "工时折扣格式不正确！")
    @Digits(integer=1,fraction=1)
    private String laborhourDs;// 工时折扣
    //private float laborhourDs;// 工时折扣
    
    private String userRemark;// 用户备注，可以为空
    private String dealerProductCode;// 经销商折扣商品code，允许为空
    private List<Map> orderProjList;// List<Map>不可以为空
    
    public List<Map> getOrderProjList() {
        return orderProjList;
    }
    public void setOrderProjList(List<Map> orderProjList) {
        this.orderProjList = orderProjList;
    }
    
    /**
     * 其他备用可为空参数
     */
    private String source; 
    private String payType; 
    private String pickVelAmt; 
    private String invTitle; 
    private String invType; 
    private String retVelAddr; 
    private String isUnSelect; 
    private String orderAmt; 
    private String dyType; 
    private String pickVelAddr; 
    private String retVelAmt; 
    private String maintDate; 
    private String csrvProdListClassName; 
    private String orderProjListClassName; 
    
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getPayType() {
        return payType;
    }
    public void setPayType(String payType) {
        this.payType = payType;
    }
    public String getPickVelAmt() {
        return pickVelAmt;
    }
    public void setPickVelAmt(String pickVelAmt) {
        this.pickVelAmt = pickVelAmt;
    }
    public String getInvTitle() {
        return invTitle;
    }
    public void setInvTitle(String invTitle) {
        this.invTitle = invTitle;
    }
    public String getInvType() {
        return invType;
    }
    public void setInvType(String invType) {
        this.invType = invType;
    }
    public String getRetVelAddr() {
        return retVelAddr;
    }
    public void setRetVelAddr(String retVelAddr) {
        this.retVelAddr = retVelAddr;
    }
    public String getIsUnSelect() {
        return isUnSelect;
    }
    public void setIsUnSelect(String isUnSelect) {
        this.isUnSelect = isUnSelect;
    }
    public String getOrderAmt() {
        return orderAmt;
    }
    public void setOrderAmt(String orderAmt) {
        this.orderAmt = orderAmt;
    }
    public String getDyType() {
        return dyType;
    }
    public void setDyType(String dyType) {
        this.dyType = dyType;
    }
    public String getPickVelAddr() {
        return pickVelAddr;
    }
    public void setPickVelAddr(String pickVelAddr) {
        this.pickVelAddr = pickVelAddr;
    }
    public String getRetVelAmt() {
        return retVelAmt;
    }
    public void setRetVelAmt(String retVelAmt) {
        this.retVelAmt = retVelAmt;
    }
    public String getMaintDate() {
        return maintDate;
    }
    public void setMaintDate(String maintDate) {
        this.maintDate = maintDate;
    }
    public String getCsrvProdListClassName() {
        return csrvProdListClassName;
    }
    public void setCsrvProdListClassName(String csrvProdListClassName) {
        this.csrvProdListClassName = csrvProdListClassName;
    }
    public String getOrderProjListClassName() {
        return orderProjListClassName;
    }
    public void setOrderProjListClassName(String orderProjListClassName) {
        this.orderProjListClassName = orderProjListClassName;
    }
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getMaintVelmodelId() {
        return maintVelmodelId;
    }

    public void setMaintVelmodelId(long maintVelmodelId) {
        this.maintVelmodelId = maintVelmodelId;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getOrderUName() {
        return orderUName;
    }

    public void setOrderUName(String orderUName) {
        this.orderUName = orderUName;
    }

    public String getVkt() {
        return vkt;
    }

    public void setVkt(String vkt) {
        this.vkt = vkt;
    }

    public String getVlp() {
        return vlp;
    }

    public void setVlp(String vlp) {
        this.vlp = vlp;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTimeArea() {
        return timeArea;
    }

    public void setTimeArea(String timeArea) {
        this.timeArea = timeArea;
    }

    public String getOrderUTel() {
        return orderUTel;
    }

    public void setOrderUTel(String orderUTel) {
        this.orderUTel = orderUTel;
    }

    public String getMaintAmt() {
        return maintAmt;
    }

    public void setMaintAmt(String maintAmt) {
        this.maintAmt = maintAmt;
    }

    public String getLaborhourDs() {
        return laborhourDs;
    }

    public void setLaborhourDs(String laborhourDs) {
        this.laborhourDs = laborhourDs;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }

    public String getDealerProductCode() {
        return dealerProductCode;
    }

    public void setDealerProductCode(String dealerProductCode) {
        this.dealerProductCode = dealerProductCode;
    }

    @Override
    public String toString() {
        return "OrderCommitRequestObject [userId=" + userId
                + ", maintVelmodelId=" + maintVelmodelId + ", dealerCode="
                + dealerCode + ", orderUName=" + orderUName + ", vkt=" + vkt
                + ", vlp=" + vlp + ", startDate=" + startDate + ", timeArea="
                + timeArea + ", orderUTel=" + orderUTel + ", maintAmt="
                + maintAmt + ", laborhourDs=" + laborhourDs + ", userRemark="
                + userRemark + ", dealerProductCode=" + dealerProductCode + "]";
    }

}
