package com.saick.base.controller.requestobject;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 订单提交请求参数封装的对象
 * 
 * @author Liubao
 * @version 2.0
 */
@SuppressWarnings("rawtypes")
public class OrderCommitRequestObject implements Serializable{
    private static final long serialVersionUID = -4723197208631580373L;
    
    @Max(value = 10000, message = "userId最大值为10000(包括10000) ")
    @Min(value = 0, message = "userId最小值为0(包括0) ")
    private int userId;// 用户id

    // @NotNull(message = "{username.empty}", groups = {OrderCommitRequestObject.class })
    //@NotEmpty(message = "参数不能为空2")//有问题
    //@NotNull(message = "参数不能为空1")
    @NotBlank(message = "参数不能为空3")//推荐使用
    //@NotBlank(message = "{username.empty}")//推荐使用
    @Size(max = 32, min = 1, message = "userId字符串的长度最大为32，最小为1！")
    private String dealerCode;// 经销商code

    //@Pattern(regexp = "[a-zA-z0-9:-]{10}", message = "日期格式长度为10！")
    @Size(max = 10, min = 10, message = "startDate字符串的长度为10！")
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$", message = "日期格式长度为10！")
    //@Pattern(regexp = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$", message = "日期格式长度为10！")
    //@Future(message="必须是一个将来的日期")
    private String startDate;// 预约保养日期
    //@Pattern(regexp = "[a-zA-z0-9:-]{10}", message = "时间段格式长度为11！")
    @Pattern(regexp = "^([0,1,2][0-9][:][0,1,2][0-9])[-]([0,1,2][0-9][:][0,1,2][0-9])$", message = "时间段格式长度为11！")
    @Size(max = 11, min = 11, message = "timeArea字符串的长度为11！")
    private String timeArea;// 保养时间段
    //@Pattern(regexp = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$", message = "手机格式不正确！")
    @Pattern(regexp = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$", message = "手机格式不正确！")
    @Size(max = 11, min = 11, message = "orderUTel字符串的长度为11！")
    private String orderUTel;// 用户电话
    //@Pattern(regexp = "[0-9]+", message = "订单总金额格式不正确！")
    //@DecimalMax("1000000")
    //@DecimalMin(value="0",inclusive=false)
    @Pattern(regexp = "^\\d+\\.(\\d{2})$", message = "订单总金额格式不正确！")
    @Min(value = 1, message = "maintAmt最小值为1(包括1) ")
    private String maintAmt;// 保养金额（订单总金额）
    @Pattern(regexp = "^[0][.][0-9]$", message = "工时折扣格式不正确！")
    //限制必须为一个小数，且整数部分的位数不能超过integer，小数部分的位数不能超过fraction
    @Digits(integer=1,fraction=1)
    private String laborhourDs;// 工时折扣
    
    // @Email(message = "邮箱填写错误！")
    // 限制必须是一个将来的日期
    //@Future(message="必须是一个将来的日期")
    //限制必须是一个过去的日期
    //@Past(message="必须是一个过去的日期")
    
    /**
     * 需要自定义校验器
     */
     //@NotNull(message = "参数不能为空1")
     //@NotBlank(message = "参数不能为空3")//推荐使用
    private List<Map> orderProjList;// List<Map>不可以为空？？？
    
    public List<Map> getOrderProjList() {
        return orderProjList;
    }
    public void setOrderProjList(List<Map> orderProjList) {
        this.orderProjList = orderProjList;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getDealerCode() {
        return dealerCode;
    }
    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
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
    @Override
    public String toString() {
        return "OrderCommitRequestObject [userId=" + userId + ", dealerCode="
                + dealerCode + ", startDate=" + startDate + ", timeArea="
                + timeArea + ", orderUTel=" + orderUTel + ", maintAmt="
                + maintAmt + ", laborhourDs=" + laborhourDs + "]";
    }

}
