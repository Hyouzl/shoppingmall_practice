<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<script>
	
	function adminGoodsRemove(goodsCd) {
		if (confirm("정말로 삭제하시겠습니까?")) {
			location.href = "${contextPath}/admin/goods/adminGoodsRemove?goodsCd="+goodsCd;
		}
	}
	
	function gerateGoodsExcelExport() {
		location.href = "${contextPath}/admin/goods/goodsExcelExport";
	}

</script>
</head>
<body>
	<!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="${contextPath }/"><i class="fa fa-home"></i> Admin</a>
                        <span>Goods List</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Shop Cart Section Begin -->
    <section class="shop-cart spad">
        <div class="container">
            <div class="row">	
                <div class="col-lg-12">
	            	<div class="cart__btn update__btn" align="right">
						<a href="javascript:gerateGoodsExcelExport();"><span class="icon_folder_download"></span>Excel</a>
					</div>
                    <div class="shop__cart__table">

                            	<c:choose>
                            		<c:when test="${empty goodsList}">
                            			<tr>
		                                    <td colspan="4" align="center"><h6>조회된 상품이 없습니다.</h6></td>
		                                </tr>	
                            		</c:when>
                            		<c:otherwise>
		                            	<c:forEach var="goodsDto" items="${goodsList }" varStatus="i">
		                            		
		                            		  <div class="col-lg-4 col-md-6 col-sm-6">
                    							<div class="blog__item">
                       								<div class="blog__item__pic set-bg" data-setbg="img/blog/blog-7.jpg"></div>
                        							<div class="blog__item__text">
                            							<span><img src="img/icon/calendar.png" alt=""> <fmt:formatDate value="${goodsDto.enrollDt }" pattern="yyyy-MM-dd"/></span>
                            							<div class="cart__product__item__title">
			                                            	<h6><a href="${contextPath }/goods/goodsDetail?goodsCd=${goodsDto.goodsCd}">${goodsDto.goodsNm }</a></h6>
			                                        		<p>${goodsDto.part} | ${goodsDto.stock} 개 | <fmt:formatNumber value="${goodsDto.price }"/>원</p>
			                                				<a href="${contextPath }/admin/goods/adminGoodsModify?goodsCd=${goodsDto.goodsCd}"><span class="icon_pencil-edit"></span></a>
			                                				<a href="javascript:adminGoodsRemove(${goodsDto.goodsCd });"><span class="icon_trash_alt"></span></a>
			          
			                                        	</div>
			        
                        							</div>
                    							</div>
               						 		</div>
		                            		
		                            	</c:forEach>
                            		</c:otherwise>
                            	</c:choose>
         
                    </div>
	            <div align="right">
	                <button type="button" onclick="javascript:location.href='${contextPath}/admin/goods/adminGoodsAdd'" class="site-btn"><span class="icon_plus"></span> 등록</button>
	            </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shop Cart Section End -->
</body>
</html>