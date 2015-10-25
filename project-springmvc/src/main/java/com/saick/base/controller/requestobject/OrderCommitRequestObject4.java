package com.saick.base.controller.requestobject;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 * 订单提交请求参数封装的对象,进行表单提交校验
 * 尽量使用基本对象包装类
 * 
 * 最终版本，注释删除或者保留即可！！！
 * 
 * @author Liubao
 * @version 2.0
 */
@SuppressWarnings("rawtypes")
public class OrderCommitRequestObject4 implements Serializable{
    private static final long serialVersionUID = -4723197208631580373L;
    
    @NotNull(message = "userId不能为空")
    private Long userId;// 用户id
    
    @NotNull(message = "maintVelmodelId不能为空")
    //@Min(value = 1, message = "maintVelmodelId最小值为1")
    private Long maintVelmodelId;// 保养车型id

    //@NotBlank(message = "{username.already.exists}")
    //@NotBlank(message = "&quot;username.already.exists&quot;")
    @NotBlank(message = "dealerCode不能为空")
    private String dealerCode;// 经销商code
    
    @NotBlank(message = "orderUName不能为空")
    //@Size(min = 1,max=10, message = "orderUName的长度最小为1,最大为10！")
    private String orderUName;// 用户名
    
    @Range(min=0, max=2000000000,message="vkt的取值范围为0-2000000000")
    private String vkt;// 行驶公里数
    
    @NotBlank(message = "vlp不能为空")
    //@Size(min = 6, max=8,message = "vlp字符串的长度最大为8！")
    //@Pattern(regexp = "^[\u4e00-\u9fa5]{1}[a-zA-Z]{1}[a-zA-Z_0-9]{4}[a-zA-Z_0-9_\u4e00-\u9fa5]$", message = "vlp格式不正确！")
    private String vlp;// 车牌号

    @NotBlank(message = "startDate不能为空")
    @Size(max = 10, min = 10, message = "startDate字符串的长度为10！")
    //@Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$", message = "startDate格式不正确！")
    private String startDate;// 预约保养日期
    
    @NotBlank(message = "timeArea不能为空")
    @Length(min=11, max=11,message = "timeArea的长度为11！")
    //@Pattern(regexp = "^([0-2][0-9][:][0-5][0-9])[-]([0-2][0-9][:][0-5][0-9])$", message = "timeArea格式不正确！")
    private String timeArea;// 保养时间段
    
    @Size(max = 11, min = 11, message = "orderUTel的长度为11！")
    //@Pattern(regexp = "^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$", message = "orderUTel格式不正确！")
    private String orderUTel;// 用户电话
    
    //@DecimalMin(value="0",inclusive=false ,message = "maintAmt的最小值大于0！")
    //@Pattern(regexp = "^\\d+\\.(\\d{2})$", message = "maintAmt格式不正确！")
    private String maintAmt;// 保养金额（订单总金额）
    
    @Range(min=0, max=1,message="laborhourDs的取值范围为0-1")
    //@Digits(integer=1,fraction=1,message = "laborhourDs的小数点格式不正确！")
    //@Pattern(regexp = "^[0-1][.][0-9]$", message = "laborhourDs格式不正确！")
    private String laborhourDs;// 工时折扣
    
    @NotEmpty
    private List<Map> orderProjList;//保养项目不可以为空
    
    private String userRemark;// 用户备注，可以为空
    private String dealerProductCode;// 经销商折扣商品code，允许为空
    
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
    private long mdseTypeId; 
    private long dsId; 
    private float partsDs; 
    private String csrvProdListClassName; 
    private String orderProjListClassName; 
    private String orderPartsListClassName; 
    private String maintMdseId; 
    private List<Map> csrvProdList; 
    
    public List<Map> getOrderProjList() {
        return orderProjList;
    }
    public void setOrderProjList(List<Map> orderProjList) {
        this.orderProjList = orderProjList;
    }
    
    public String getMaintMdseId() {
        return maintMdseId;
    }
    public void setMaintMdseId(String maintMdseId) {
        this.maintMdseId = maintMdseId;
    }
    public List<Map> getCsrvProdList() {
        return csrvProdList;
    }
    public void setCsrvProdList(List<Map> csrvProdList) {
        this.csrvProdList = csrvProdList;
    }
    public long getMdseTypeId() {
        return mdseTypeId;
    }
    public void setMdseTypeId(long mdseTypeId) {
        this.mdseTypeId = mdseTypeId;
    }
    public long getDsId() {
        return dsId;
    }
    public void setDsId(long dsId) {
        this.dsId = dsId;
    }
    public float getPartsDs() {
        return partsDs;
    }
    public void setPartsDs(float partsDs) {
        this.partsDs = partsDs;
    }
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
    
    public String getOrderPartsListClassName() {
        return orderPartsListClassName;
    }
    public void setOrderPartsListClassName(String orderPartsListClassName) {
        this.orderPartsListClassName = orderPartsListClassName;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMaintVelmodelId() {
        return maintVelmodelId;
    }

    public void setMaintVelmodelId(Long maintVelmodelId) {
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
        return "OrderCommitRequestObject4 [userId=" + userId
                + ", maintVelmodelId=" + maintVelmodelId + ", dealerCode="
                + dealerCode + ", orderUName=" + orderUName + ", vkt=" + vkt
                + ", vlp=" + vlp + ", startDate=" + startDate + ", timeArea="
                + timeArea + ", orderUTel=" + orderUTel + ", maintAmt="
                + maintAmt + ", laborhourDs=" + laborhourDs + ", userRemark="
                + userRemark + ", dealerProductCode=" + dealerProductCode
                + ", orderProjList=" + orderProjList + ", source=" + source
                + ", payType=" + payType + ", pickVelAmt=" + pickVelAmt
                + ", invTitle=" + invTitle + ", invType=" + invType
                + ", retVelAddr=" + retVelAddr + ", isUnSelect=" + isUnSelect
                + ", orderAmt=" + orderAmt + ", dyType=" + dyType
                + ", pickVelAddr=" + pickVelAddr + ", retVelAmt=" + retVelAmt
                + ", maintDate=" + maintDate + ", mdseTypeId=" + mdseTypeId
                + ", dsId=" + dsId + ", partsDs=" + partsDs
                + ", csrvProdListClassName=" + csrvProdListClassName
                + ", orderProjListClassName=" + orderProjListClassName
                + ", orderPartsListClassName=" + orderPartsListClassName + "]";
    }

}
