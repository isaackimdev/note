<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bg.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		$(".item").click(function() {
			var item_name = $(this).find('.item_name').text();
			location.href="/Shoppingmall/item/itemView?item_name="+ item_name +"&pg=${pg}";
		});
		
	});
</script>
</head>
<body>
	
	<div class="title">
        
             <h2>
                <span>PANTS</span>                
             </h2>   
             
    </div> <br>
    <div class="detail_category">
        <a href="" class="it">스키니</a>
	 	<a href="" class="it">긴바지</a>
	 	<a href="" class="it">일자바지</a>
		<a href="" class="it">배기바지</a>
		<a href="" class="it">반바지</a>
		<a href="" class="it">슬랙스</a>
		<a href="" class="it">조거</a>
		<a href="" class="it">부츠컷</a>	
	 	 
    </div> <br><br><br> 
    <div class="product">
			 		<div class="item_title">
		<!-- 				<h2>new arrivals</h2>
						<p>최근 업데이트 된 신상품입니다.</p>  -->
					</div>
				
					<!-- 메인 아이템 리스트 -->
					
					<ul class="main_items">
						<c:forEach var="itemDTO" items="${list }">
							<li id="item" class="item">
								<div class="box">
									<a name="BoxName"><img src="../storage/${itemDTO.item_img }" class="thumb"> </a>
									<p class="name">
											<a href=""><span style="font-size: 11px; color: #333333;" class="item_name">${itemDTO.item_name }<br><br></span> </a>
									</p>
									<p class="icon"></p>
									<ul class="product ">
										<li class="record">
										<strong class="title displaynone">
											<span style="font-size: 13px; color: #000000; font-weight: bold;">판매가</span> :
										</strong>
											<span style="font-size: 13px; color: #000000; font-weight: bold;">${itemDTO.item_price }원</span>
											<span id="span_type" style=""> </span>
									</ul>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
      <br><br><br><br><br><br>
     <div class="pagination">   <!--  spage=현재 페이지 -->
                <c:if test="${startPage != 1}">
                    <a href='?page=${startPage-1}'>[ 이전 ]</a>
                </c:if>
                
                <c:forEach var="a" begin="${startPage}" end="${endPage}">
                    <c:if test="${pageNum == spage}">
                        ${pageNum} 
                    </c:if>
                    <c:if test="${pageNum != spage}">
                        <a href='=${pageNum}'>${pageNum} </a>
                    </c:if>
                </c:forEach>
                
                <c:if test="${endPage != maxPage }">
                    <a href='=${endPage+1 }'>[다음]</a>
                </c:if>
  	   </div> 

   
      
        
       
</body>
</html>