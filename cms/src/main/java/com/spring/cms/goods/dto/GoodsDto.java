package com.spring.cms.goods.dto;


import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class GoodsDto {
	
	private String goodsCd;
	private String goodsNm;
	private int price;
	private int discountRate;
	private int stock;
	private String sort;
	private String goodsSize;
	private int point;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getGoodsSize() {
		return goodsSize;
	}
	public void setGoodsSize(String goodsSize) {
		this.goodsSize = goodsSize;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
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
	
	
	
	
	
	
	

}
