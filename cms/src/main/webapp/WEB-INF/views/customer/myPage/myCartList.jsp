<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__text">
                        <h4>Shopping Cart</h4>
                        <div class="breadcrumb__links">
                            <a href="./index.html">Home</a>
                            <a href="./shop.html">Shop</a>
                            <span>Shopping Cart</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shopping Cart Section Begin -->
    <section class="shopping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="shopping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:choose>
                            	<c:when test="${empty myCartList}">
                            		<tr align="center">
                            			<td colspan="5"><h5>조회된 상품이 없습니다</h5></td>
                            		</tr>
                  				</c:when>
                  				<c:otherwise>
                  					<c:forEach var="myCart" items="${myCartList }">
		                                <tr>
		                                    <td class="product__cart__item">
		                                        <div class="product__cart__item__pic">
		                                            <img src="img/shopping-cart/cart-1.jpg" alt="">
		                                        </div>
		                                        <div class="product__cart__item__text">
		                                            <h6>${myCart.goodsNm }</h6>
		                                            <h5>${myCart.price } 원</h5>
		                                        </div>
		                                    </td>
		                                    <td class="quantity__item">
		                                        <div class="quantity">
		                                            <div class="pro-qty-2">
		                                                <input type="text" value="${myCart.cartGoodsQty }"/>
		                                            </div>
		                                        </div>
		                                    </td>
		                                    <td class="cart__price">${myCart.price * myCart.cartGoodsQty } 원</td>
		                                    <td class="cart__close"><i class="fa fa-close"></i></td>
		                                </tr>
                                	</c:forEach>
                                </c:otherwise>
							</c:choose>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="continue__btn">
                                <a href="#">Continue Shopping</a>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="continue__btn update__btn">
                                <a href="#"><i class="fa fa-spinner"></i> Update cart</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="cart__discount">
                        <h6>Discount codes</h6>
                        <form action="#">
                            <input type="text" placeholder="Coupon code">
                            <button type="submit">Apply</button>
                        </form>
                    </div>
                    <div class="cart__total">
                        <h6>Cart total</h6>
                        <ul>
                            <li>Subtotal <span>$ 169.50</span></li>
                            <li>Total <span>$ 169.50</span></li>
                        </ul>
                        <a href="#" class="primary-btn">Proceed to checkout</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shopping Cart Section End -->

</body>
</html>