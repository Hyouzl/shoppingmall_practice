<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="${contextPath }/"><i class="fa fa-home"></i>Admin</a>
                        <span>add Goods</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Contact Section Begin -->
    <section class="contact spad">
        <div class="container">
            <form action="${contextPath }/admin/goods/adminGoodsAdd" method="post" enctype="multipart/form-data" class="checkout__form" >
                <div class="row">
                    <div class="col-lg-8">
                        <h5>상품등록</h5>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="checkout__form__input">
                                    <p>상품이미지<span>*</span> <span class="icon_upload"></span> </p>
                                    <input type="file" name="goodsFileName">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="checkout__form__input">
                                    <p>상품명 <span>*</span></p>
                                    <input type="text" name="goodsNm" placeholder="상품명을 입력하세요.">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="checkout__form__input">
                                    <p>색상 <span>*</span></p>
                                    <input type="text" name="color" placeholder="색상을 입력하세요.">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="checkout__form__input">
                                    <p>가격 <span>*</span></p>
                                    <input type="text" name="price" placeholder="가격을 입력하세요.">
                                </div>
                            </div>
 							

                            <div class="col-sm-6">
                                <div class="checkout__form__input">
                                    <p>할인율 <span>*</span></p>
                                    <input type="text" name="discountRate" placeholder="할인율을 입력하세요.">
                                </div>
                            </div>
                            
                              <div class="col-sm-6">
                                <div class="checkout__form__input">
                                    <p>사이즈 <span>*</span></p>
                                 	<input type="text" name="goodsSize" placeholder="사이즈를 입력하세요.">
                                </div>
                            </div>
                            
                            <div class="col-sm-12">
                                <div class="checkout__form__input">
                                    <p>재고 <span>*</span></p>
                                    <input type="text" name="stock" placeholder="재고를 입력하세요.">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="checkout__form__input">
                                    <p>종류<span>*</span></p>
                                    <select name="sort">
                                    	<option value="top">TOP&TEE</option>
                                    	<option value="blouse">BLOUSE</option>
                                    	<option value="sweater">SWEATER</option>
                                    	<option value="dress">DRESS</option>
                                    	<option value="skirts">SKIRTS</option>
                                    	<option value="pants">PANTS</option>
                                    	<option value="shoes">SHOES</option>
                                    	<option value="acc">ACC</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="checkout__form__input">
                                    <p>분류 <span>*</span></p>
                                    <select name="part">
                                    	<option value="general">일반</option>
                                    	<option value="new">신상</option>
                                    	<option value="best">베스트셀러</option>
                                    	<option value="steady">세일상품</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="checkout__form__input">
                                   <p>적립포인트(P) <span>*</span></p>
                                    <input type="text" name="point" placeholder="적립 포인트(P)를 입력하세요.">
                                </div>
                            </div>
                            <!--  <div class="col-sm-6">
                                <div class="checkout__form__input">
                                    <p>분 <span>*</span></p>
                                    <input type="date" name="publishedDt">
                                </div>
                            </div> -->


                            <div class="col-sm-12">
                                <div class="checkout__form__input">
                                    <p>상품소개<span>*</span></p>
                                    <textarea rows="5" cols="100" name="intro" placeholder="상품소개를 입력하세요."></textarea> 
                                	<script>CKEDITOR.replace("intro");</script>
                                </div>
                            </div>
                           </div>
                        <br>
		                <div align="right">
		                	<button type="submit" class="site-btn"><span class="icon_plus"></span> 등록</button>
		                </div>
                    </div>
                    </div>
                </form>
            </div>
        </section>
        <!-- Checkout Section End -->


</body>
</html>