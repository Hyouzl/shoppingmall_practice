<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />	
<!DOCTYPE html>
<meta charset="utf-8">
<head>
<script>
	$().ready(function(){
		
		$("[name='part']").val("${goodsDto.part}");
		$("[name='sort']").val("${goodsDto.sort}");
		
	});

</script>
</head>
<body>

    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="${contextPath }/"><i class="fa fa-home"></i>Admin</a>
                        <span>modify Goods</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Contact Section Begin -->
    <section class="contact spad">
        <div class="container">
            <form action="${contextPath }/admin/goods/adminGoodsModify" method="post" enctype="multipart/form-data" class="checkout__form" >
                <input type="hidden" name="goodsCd" value="${goodsDto.goodsCd }">
                <div class="row">
                    <div class="col-lg-8">
                        <h5>상품수정</h5>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="checkout__form__input">
                                    <p>상품이미지<span>*</span></p>
                                    <input type="file" name="goodsFileName" value="${goodsDto.goodsFileName }">
                                </div>
                            </div>
                            <div class="col-sm-12">
                                <div class="checkout__form__input">
                                    <p>상품명 <span>*</span></p>
                                    <input type="text" name="goodsNm" value="${goodsDto.goodsNm }">
                                </div>
                            </div>
                            <div class="col-sm-12">
                                <div class="checkout__form__input">
                                    <p>가격 <span>*</span></p>
                                    <input type="text" name="price" value="${goodsDto.price }">
                                </div>
                            </div>
                            <div class="col-sm-12">
                                <div class="checkout__form__input">
                                    <p>할인율 <span>*</span></p>
                                    <input type="text" name="discountRate" value="${goodsDto.discountRate }">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="checkout__form__input">
                                    <p>재고 <span>*</span></p>
                                    <input type="text" name="stock" value="${goodsDto.stock }">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="checkout__form__input">
                                    <p>색상 <span>*</span></p>
                                    <input type="text" name="color" value="${goodsDto.color }">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="checkout__form__input">
                                    <p>사이즈 <span>*</span></p>
                                    <input type="text" name="goodsSize" value="${goodsDto.goodsSize }">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="checkout__form__input">
                                    <p>분류 <span>*</span></p>
                                      <select name="sort">
                                    	<option value="general" <c:if test="${goodsDto.sort eq 'general'}">selected</c:if>>일반</option>
                                    	<option value="new" <c:if test="${goodsDto.sort eq 'new'}">selected</c:if>>신상</option>
                                    	<option value="best" <c:if test="${goodsDto.sort eq 'best'}">selected</c:if>>베스트셀러</option>
                                    	<option value="steady" <c:if test="${goodsDto.sort eq 'steady'}">selected</c:if>>세일상품</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="checkout__form__input">
                                    <p>적립포인트(P) <span>*</span></p>
                                    <input type="text" name="point" value="${goodsDto.point }">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="checkout__form__input">
                                    <p>종류<span>*</span></p>
                                    <select name="part" >
                                    	<option value="top" <c:if test="${goodsDto.part eq 'top'}">selected</c:if>>TOP&TEE</option>
                                    	<option value="blouse" <c:if test="${goodsDto.part eq 'blouse'}">selected</c:if>>BLOUSE</option>
                                    	<option value="sweater" <c:if test="${goodsDto.part eq 'sweater'}">selected</c:if>>SWEATER</option>
                                    	<option value="dress" <c:if test="${goodsDto.part eq 'dress'}">selected</c:if>>DRESS</option>
                                    	<option value="skirts" <c:if test="${goodsDto.part eq 'skirts'}">selected</c:if>>SKIRTS</option>
                                    	<option value="pants" <c:if test="${goodsDto.part eq 'pants'}">selected</c:if>>PANTS</option>
                                    	<option value="shoes" <c:if test="${goodsDto.part eq 'shoes'}">selected</c:if>>SHOES</option>
                                    	<option value="acc" <c:if test="${goodsDto.part eq 'acc'}">selected</c:if>>ACC</option>
                                    </select>
                                </div>
                            </div>

                            <div class="col-sm-12">
                                <div class="checkout__form__input">
                                    <p>상품소개<span>*</span></p>
                                    <textarea rows="5" cols="100" name="intro">${goodsDto.intro }</textarea> 
                                	<script>CKEDITOR.replace("intro");</script>
                                </div>
                            </div>

                        </div>
                    <br>
	                	<div align="right">
	                		<button type="submit" class="site-btn"><span class="icon_pencil-edit"></span> 수정</button>
	                	</div>
                    </div>
                   </div>
                </form>
            </div>
        </section>
        <!-- Checkout Section End -->