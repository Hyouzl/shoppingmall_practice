<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>

	$().ready(function() {
	
		$("#btnOverlapped").click(function checkDuplicateId(){
			
		    var memberId = $("#memberId").val();
		   
		    if (memberId == ''){
		   		alert("ID를 입력하세요");
		   		return;
		    }
		   
		    $.ajax({
		       type : 'get',
		       url  : "${contextPath}/customer/member/checkDuplicatedId?memberId=" + memberId,
		       success : function(ischeck){
		          if (ischeck == "duplicate"){
					  alert("사용할 수 있는 ID입니다.");
		          }
		          else {
		          	  alert("사용할 수 없는 ID입니다.");
		          }
		       }
		    });
		    
		 });	
		
		
		$("form").submit(function(){
			
			var dateBirth = $("#birthY").val() + "-" + $("#birthM").val() + "-" + $("#birthD").val();
			$("[name='dateBirth']").val(dateBirth);
			
			if ($("#smsstsYn").val() != "Y") {
				$(this).val("N");
			}
			if ($("#emailstsYn").val() != "Y") {
				$(this).val("N")
			}
			
			if ($("#passwd").val() != $("#confirmPasswd").val()) {
				alert("비밀번호를 확인하세요.");
				$("#passwd").focus();
				return false;
			}
			
			
		});
		
	});
</script>
<title>Insert title here</title>
</head>
<body>
 <!-- Breadcrumb Section Begin -->

    <!-- Breadcrumb Section End -->

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
          <form action="${contextPath }/customer/member/register" method="post"  class="checkout__form">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <h6 class="checkout__title">register</h6>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Id<span>*</span></p>
                                        <input type="text" name="memberId" id="memberId" maxlength="20" placeholder="아이디를 입력하세요. ">&emsp;
                                        <input type="button" id="btnOverlapped" value="중복확인" />
                                    </div>
                                </div>
                            </div>
                           
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Password<span>*</span></p>
                                        <input type="password" id="passwd" name="passwd" placeholder="비밀번호를 입력하세요.">
                                    </div>
                                </div>
                            </div>
                            
                             <div class="col-sm-12">
                                <div class="checkout__input">
                                    <p>Password check <span>*</span></p>
                                    <input type="password" id="confirmPasswd" name="confirmPasswd"placeholder="비밀번호를 확인하세요.">
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Name<span>*</span></p>
                                        <input type="text" name="memberNm" maxlength="20">
                                    </div>
                                </div> 
                            </div>
                            
                            <div class="row">
                                <div class="col-lg-6">
                                    <div >
                                        <p>sex<span>*</span></p>
                                        <input type="radio" name="sex" value="m" checked /> 남성&emsp;&emsp;&emsp;
										<input type="radio" name="sex" value="w" />여성
                                    </div>
                                </div>
                            </div>
                            
                             <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Phone<span>*</span></p>
                                        <select id="hp1" >
											<option>없음</option>
											<option selected value="010">010</option>
											<option value="011">011</option>
											<option value="019">019</option>
										</select> - 
										<input size="10px" type="text" id="hp2"> - 
										<input size="10px" type="text" id="hp3">
										<input type="checkbox" id="smsstsYn" name="smsstsYn"  value="Y" checked/>
										<input type="hidden" name="hp">
                                    </div>
                                </div>
                            </div>
                            
                               <div class="row">
	                                <div class="col-lg-6">
	                                    <div class="checkout__input">
	                                        <p>Email<span>*</span></p>
	                                        <input type="email" name="email" >  
	                                    </div>
	                                </div>
	                            </div>
	                            <div class="row">
	                                 <div class="checkout__input__checkbox">
	                                    <label for="emailstsYn">
	                                        수신 동의할꺼?
	                                        <input type="checkbox" id="emailstsYn" name="emailstsYn" value="Y" checked>
	                                        <span class="checkmark"></span>
	                                    </label>
	                                </div>
                                </div>
                            </div>
                            
                            
                             <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Address<span>*</span></p>
                                        <input type="text" placeholder="우편번호 입력" id="zipcode" name="zipcode" >
	                					<input type="button" onclick="javascript:execDaumPostcode()" value="검색">
	                					<br><br>
	                           			도로명 주소 : <input type="text" name="roadAddress" id="roadAddress" size="60"> <br>
										지번 주소 : <input type="text"  name="jibunAddress" id="jibunAddress" size="60"> <br>
										나머지 주소: <input type="text" name="namujiAddress" id="namujiAddress" size="60"/>
                                    </div>
                                </div>
                            </div>
                            
                             <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Birth<span>*</span></p>
                                        <select id="birthY" >
											<c:forEach var="year" begin="1" end="100">
												<option value="${1922 + year}" selected>${1922 + year}</option>
											</c:forEach>
										</select> 년 
										<select id="birthM">
										  	<c:forEach var="month" begin="1" end="12">
											   <c:choose>
													<c:when test="${month < 10 }">
														<option value="0${month}">0${month}</option>
													</c:when>
													<c:otherwise>
														<option value="${month}">${month}</option>
													</c:otherwise>
												</c:choose>
										  	</c:forEach>
										</select> 월  
										<select id="birthD">
											<c:forEach var="day" begin="1" end="31">
												<c:choose>
													<c:when test="${day < 10 }">
														<option value="0${day}">0${day}</option>
													</c:when>
													<c:otherwise>
														<option value="${day}">${day}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select> 일 &emsp;
										<input type="hidden" name="dateBirth">
                                    </div>
                                </div>
                            </div>
                            
                            <button type="submit" class="site-btn">register</button>
                       
        
                        </div>
                </form>
              </div>
    </section>
    <!-- Checkout Section End -->
</body>
</html>