package com.spring.cms.goods.dto;


import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class GoodsDto {
	
	private String goodsCd;
	private String goodsNm;
	private String price;
	private String discountRate;
	private String stock;
	private String sort;
	private String size;
	private String point;
	private String part;
	private String color;
	private String intro;
	private String goodsFileName;
	private Date enrollDt;
	public String getGoodsCd() {
		return goodsCd;
	}
	public void setGoodsCd(String goodsCd) {
		this.goodsCd = goodsCd;
	}
	public String getGoodsNm() {
		return goodsNm;
	}
	public void setGoodsNm(String goodsNm) {
		this.goodsNm = goodsNm;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(String discountRate) {
		this.discountRate = discountRate;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getGoodsFileName() {
		return goodsFileName;
	}
	public void setGoodsFileName(String goodsFileName) {
		this.goodsFileName = goodsFileName;
	}
	public Date getEnrollDt() {
		return enrollDt;
	}
	public void setEnrollDt(Date enrollDt) {
		this.enrollDt = enrollDt;
	}
	@Override
	public String toString() {
		return "GoodsDto [goodsCd=" + goodsCd + ", goodsNm=" + goodsNm + ", price=" + price + ", discountRate="
				+ discountRate + ", stock=" + stock + ", sort=" + sort + ", size=" + size + ", point=" + point
				+ ", part=" + part + ", color=" + color + ", intro=" + intro + ", goodsFileName=" + goodsFileName
				+ ", enrollDt=" + enrollDt + "]";
	}
	
	
	

}
