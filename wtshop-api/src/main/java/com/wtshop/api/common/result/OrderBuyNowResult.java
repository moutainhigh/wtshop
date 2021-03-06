package com.wtshop.api.common.result;

import com.wtshop.model.*;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.List;

/**
 * 描述：
 *
 * @author Shi Qiang
 * @date 2018/6/14 13:49
 */
public class OrderBuyNowResult implements Serializable{


    private String taxUrl;

    private Double delivery;

    private Member member;

    private Receiver receiver;

    private Goods goods;

    private Integer quantity;

    private String receiveTime;

    private Boolean is_freeMoney;

    private Boolean is_useMiaobi;
    private Boolean is_useMiao;

    public Boolean getIs_useMiao() {
        return is_useMiao;
    }

    public void setIs_useMiao(Boolean is_useMiao) {
        this.is_useMiao = is_useMiao;
    }

    private Boolean is_Integral;
    private String integralDesc;

    private String miaoBiDesc;

    public Boolean getIs_Integral() {
        return is_Integral;
    }

    public void setIs_Integral(Boolean is_Integral) {
        this.is_Integral = is_Integral;
    }

    public String getIntegralDesc() {
        return integralDesc;
    }

    public void setIntegralDesc(String integralDesc) {
        this.integralDesc = integralDesc;
    }

    private List<PriceResult> priceList;

    private String realPrice;

    private String couponPrice;

    private Double[] param;

    private Boolean is_promotion;

    private Double payPrice;

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    private Identifier identifier;

    private String  discountedPrice;

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    private List<String> specifications;

    public List<String> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<String> specifications) {
        this.specifications = specifications;
    }

    public OrderBuyNowResult(String taxUrl, Double delivery, Member member, Receiver receiver, Goods goods, Integer quantity, String receiveTime, Boolean is_freeMoney, Boolean is_useMiaobi,Boolean is_useMiao, String miaoBiDesc, List<PriceResult> priceList, String realPrice, String couponPrice, Double[] param, Boolean is_promotion, Double payPrice,List<String> specifications,Identifier identifier
                   ,Boolean is_Integral,String  integralDesc   ) {
        this.taxUrl = taxUrl;
        this.delivery = delivery;
        this.member = member;
        this.receiver = receiver;
        this.goods = goods;
        this.quantity = quantity;
        this.receiveTime = receiveTime;
        this.is_freeMoney = is_freeMoney;
        this.is_useMiaobi = is_useMiaobi;
        this.is_useMiao = is_useMiao;
        this.miaoBiDesc = miaoBiDesc;
        this.priceList = priceList;
        this.realPrice = realPrice;
        this.couponPrice = couponPrice;
        this.param = param;
        this.is_promotion = is_promotion;
        this.payPrice = payPrice;
        this.specifications = specifications;
        this.identifier = identifier;
        this.is_Integral = is_Integral;
        this.integralDesc = integralDesc;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Double payPrice) {
        this.payPrice = payPrice;
    }

    public String getTaxUrl() {
        return taxUrl;
    }

    public void setTaxUrl(String taxUrl) {
        this.taxUrl = taxUrl;
    }


    public Double getDelivery() {
        return delivery;
    }

    public void setDelivery(Double delivery) {
        this.delivery = delivery;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Boolean getIs_freeMoney() {
        return is_freeMoney;
    }

    public void setIs_freeMoney(Boolean is_freeMoney) {
        this.is_freeMoney = is_freeMoney;
    }

    public Boolean getIs_useMiaobi() {
        return is_useMiaobi;
    }

    public void setIs_useMiaobi(Boolean is_useMiaobi) {
        this.is_useMiaobi = is_useMiaobi;
    }

    public String getMiaoBiDesc() {
        return miaoBiDesc;
    }

    public void setMiaoBiDesc(String miaoBiDesc) {
        this.miaoBiDesc = miaoBiDesc;
    }

    public List<PriceResult> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<PriceResult> priceList) {
        this.priceList = priceList;
    }

    public String getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(String realPrice) {
        this.realPrice = realPrice;
    }

    public String getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(String couponPrice) {
        this.couponPrice = couponPrice;
    }

    public Double[] getParam() {
        return param;
    }

    public void setParam(Double[] param) {
        this.param = param;
    }

    public Boolean getIs_promotion() {
        return is_promotion;
    }

    public void setIs_promotion(Boolean is_promotion) {
        this.is_promotion = is_promotion;
    }
}
