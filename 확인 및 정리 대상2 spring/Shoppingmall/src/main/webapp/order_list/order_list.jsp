<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
     
  /*cart 부분*/   
   #wrapper{
	width:1200px;
	margin: auto;
}
#title {
	border-bottom: seashell 1px solid;
	width: 300px;
	margin:auto;
	font-weight: normal;
}

ul{list-style: none; margin: 0; padding: 0;}
/** 상단부 배상상품 셀렉트 탭버튼 */
/** 내용과 1px 겹쳐져야 하고, 레이어 띄우기 */
ul.tab {list-style: none; position: relative; z-index: 100;}
/** 개별 버튼에 대한 기본 크기와 가로 정렬 */
ul.tab li {
	width: 150px; height: 30px;
	float:left;
	text-align: center; padding-top: 12px;
	font-weight: bolder;
	border: 1px solid lightgrey;
}
/** 탭 버튼의 기본 배경 처리와 글자 형태 처리 */
ul.tab li{
	background-color: lightgray;
	border-bottom: 0; 
}
ul.tab li a{color:grey; text-decoration: none; font-weight: normal;}
ul.tab li a:active{color:grey; text-decoration: none; }
ul.tab li a:focus{color:grey; text-decoration: none;}
ul.tab li a:hover{color:grey; text-decoration: none;}
ul.tab li a:visited{color:grey; text-decoration: none;}


.pix{display: inline-block; float: right; color:lightgrey;}
/** 현재 활성 탭 배경 처리 */
ul.tab li.selected {background-color: white;border-bottom: 0;}
ul.tab li.selected a {font-weight: bold;}
#sub {
	margin-top:142.5px;
	border-top: 1px solid lightgrey; 
}

table{width:1190px; margin:auto;}

th{ 
	text-decoration: none;
	font-weight: normal;
	text-align: center;
	text-decoration: none;
	border-bottom: 1px solid seashell;
	background-color: seashell;
}
.quantityButton {
	background-color: White;
	border:0.5px solid seashell;
	width:1px;
	height:10px;
}
.lastIn {
	text-align: center;
	padding-left:110px;
}
thead {	background-color: seashell;}

/** 	카트에 담긴 테이블 내 버튼	 */
.changeButton{ background-color:  white;	width:90px;	}
.orderButton, .deleteButton2 {background-color: black;	color: white;	width:90px;	}
.wishButton, .deleteCartButton {background-color:  seashell;	width:90px;	}
.orderButton, .wishButton, .deleteButton{height:27px; text-align: center;}

/** 	중간부 버튼 	*/
.deleteCartButton, .deleteButton2, .sheetButton {height:30px;}
.deleteButton, .sheetButton{	background-color:  white;	width:90px;	}
.deleteCartButton {width:110px;}

.deleteButton2:hover {background-color: white; color: black;}

td {border-bottom: 2px solid seashell; }

/**		최하단부 버튼		*/
.shoppingutton, .orderSelectButton, .orderAllButton{width:120px; height:40px;}
.orderAllButton{background-color: black; color:white;}
.orderSelectButton{background-color: lightgray; color:black;}
.shoppingutton{background-color: white; color:black;}
.lastButton{
	margin: 0 auto;	
	padding: auto;
	align-content: center;
}
/** 이용안내 */
.inform {border: 1px solid seashell; width: 1190; margin: auto;}
   
   
.order_total{
 width:1190px; margin:auto;
 margin-bottom: 50px;
}   

.btn_payment{
	color: white;
	font-size:40px;
	text-align:center;
	width: 200px;
	height: 50px;
	border: 1px solid black;
	background-color: black;
	padding-top: 10px;
}

.btn_payment:hover{
	background-color: white;
	color: black;
	cursor: pointer;
}
</style>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	/* 상단 탭 버튼  */
	$(function() {
		$("ul.tab li").click(function() {
			$("ul.tab li").not(this).removeClass("selected");
			$(this).addClass("selected");
		});
	});
	
	$(function() {
		$('tr').each(function(index, item) {
			$(this).find('input[type="text"]').addClass('quantity' + index);
			$(this).find('strong:eq(0)').children().addClass('itemPrice' + index);
			$(this).find('strong:eq(1)').children().addClass('sumPrice' + index);
			$(this).find('img:eq(1)').addClass('QuantityUp' + index);
			$(this).find('img:eq(2)').addClass('QuantityDown' + index);
			$(this).find('input[type="button"]').addClass('changeButton' + index);
			
			var itemPrice = $('.itemPrice' + index).text();
			var count = $('.quantity' + index).val();
			var result = count * itemPrice;
			$('.sumPrice' + index).text(result);
		});
		
		$('tr').each(function(index, item) {
			$('.QuantityUp' + index).click(function() {
				var count = $('.quantity' + index).val();
				count++;
				$('.quantity' + index).val(count);
				var itemPrice = $('.itemPrice' + index).text();
				var result = count * itemPrice;
				$('.sumPrice' + index).text(result);
			});
			
			$('.QuantityDown' + index).click(function() {
				var count = $('.quantity' + index).val();
				if(count > 1) count--;
				$('.quantity' + index).val(count);
				var itemPrice = $('.itemPrice' + index).text();
				var result = count * itemPrice;
				$('.sumPrice' + index).text(result);
			});
			
			$('.changeButton' + index).click(function() {
				var count = $(".quantity" + index).val();
				if(count == 0 || count < 0){
					alert("수량 [0] 혹은 [0] 보다 작은 수를 설정할 수 없습니다.");
					return false;
				}
				$(".quantity" + index).val(count);
				var itemPrice = $('.itemPrice' + index).text();
				var result = count * itemPrice;
				$('.sumPrice' + index).text(result);
			});
		});
	});
	
	/* 전체 체크박스 선택/해제 */
	$(function() {
		// 전체선택 체크박스 클릭
		$(".checkAll").click(function() {
			// 만약 전체 선택 체크박스가 체크된 상태일 경우
			if($(".checkAll").prop("checked")){
				// 해당화면에 전체 checkbox들을 체크해준다.
				$("input[type=checkbox]").prop("checked",true);
			// 전체선택 체크박스가 해제된 경우
			} else {
				// 해당 화면에 모든 checkbox들의 체크를 해제시킨다.
				$("input[type=checkbox]").prop("checked",false);
			}
		});
		
		$('#pay').click(function () {
			if(document.orderForm.name.value==""){
				alert("[주문자 이름]을 입력하세요.");
				document.orderForm.name.focus();
			}else if(document.orderForm.addr1.value==""){
				alert("[주소]를 입력하세요.");
				document.orderForm.addr1.focus();
			}else if(document.orderForm.addr2.value==""){
				alert("[상세주소]를 입력하세요.");
				document.orderForm.addr2.focus();
			}else if(document.orderForm.phone1.value==""){
				alert("[전화번호]를 입력하세요.");
				document.orderForm.phone1.focus();
			}else{
				alert("구매완료 되었습니다. 감사합니다.");
				location.href='/Shoppingmall/shop_member/myOrder';
			}
		});
	});
</script>
</head>
<body>
<form action="" method="post" name="orderForm">
<div id="wrapper">
	<h2 id="title" align="center" style="margin-bottom:100px;">
		ORDER PAGE
	</h2>
	<br>
	<table>
	<caption style="caption-side:top; text-align: left"><strong>일반상품</strong></caption>
		<thead>
			<tr height="50px">
				<th width="15px">
					<input type="checkbox" class="checkAll">
				</th>
				<th width="90px">이미지</th>
				<th width="350px">상품정보</th>
				<th width="90px">판매가</th>
				<th colspan="3" width="280px">수량</th>
				<th width="90px">배송비</th>
				<th colspan="2" width="180px">합계</th>
			</tr>
		</thead>
		
		<tbody>	
			<tr align="center" height="120px">
				<td><input type="checkbox"></td>
				<td><img src="../image/shop5.jpg" width="89" height="119"></td>
				<td>
					상품명(블랙/화이트) [옵션:xxx]
				</td>
				<td style="font-size: 12pt;"><!-- 판매가 -->
					<strong><span>20000</span></strong>
				</td>
				<td>
					<span>
					<input type="text" size="1" value="1">
					<img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/btn_quantity_up.gif"
						alt="증가" onclick="">
					<img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/btn_quantity_down.gif"
						 alt="감소" onclick="">
					</span>
					<input type="button" value="변경">
				</td>
				<td></td>
				<td></td>
				<td></td>
				<td style="font-size: 12pt;">
					<strong><span></span></strong>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr height="50" style="background:seashell;">
				<td colspan="10">
					<span style="float:left; padding-top: 15px; padding-left:5px;">
						[기본배송]
					</span>
					<p style="float:right;">상품구매금액<span></span> + 배송비 0 (무료) = 합계 : <span>원</span></p>
				</td>
			</tr>
			
			<tr>
				<td colspan="10" style="border-bottom: 0;">
					<strong>선택상품을</strong> <input type="button" value="삭제하기" class="deleteButton2">
				</td>
			</tr>
		</tfoot>
	</table>
	<hr>
	
	<table>
		<caption style="caption-side:top; text-align: left"><strong>주문자 정보</strong><img style="margin-left: 980px;" src="/Shoppingmall/image/ico_required.png" >필수 입력 사항</caption>
		<tr>
					<th>이름<img src="/Shoppingmall/image/ico_required.png" > </th>
					<td>
						<input type="text" name="name" maxlength="50" size="20">
					</td>
		</tr>
				
		<tr>
					<th>주소<img src="/Shoppingmall/image/ico_required.png" ></th>
					
					<td>
					    <br> 
						<input type="text" name=""  size="8"> 우편번호<br><br>
						<input type="text" name="addr1" size="30"> 기본주소 <br><br>
						<input type="text" name="addr2" size="30"> 나머지주소<br><br>	
					</td>
		</tr>
		
		<tr>
					<th>휴대전화<img src="/Shoppingmall/image/ico_required.png" ></th>
					<td>
						<select name="phone1" style="width:60px" >
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="018">018</option>
						<option value="019">019</option>
						
					</select> -
					<input name="phone2" size="6" id="mobile2" maxlength="4" > -
					<input name="phone3" size="6" id="mobile3" maxlength="4" >
	  		
					</td>
				</tr>
				
		<tr>
					<th >이메일</th>
					<td>
						<input type="text" name="email1" maxlength="50">@
						<select name="email2">
							<option value="">-이메일 선택-</option>
							<option value="naver">naver.com</option>
							<option value="daum">daum.net</option>
							<option value="nate">nate.com</option>
							<option value="hotmail">hotmail</option>	
							<option value="yahoo">yahoo.com</option>	
							<option value="empas">empas.com</option>	
							<option value="korea">korea.com</option>	
							<option value="dream">dreamwiz.com</option>	
							<option value="gmail">gmail.com</option>	
														
						</select>
					</td>
				</tr>		
						
	</table>
	<br><br><br>
	<table>
		<thead>
			<tr height="50px">
				<th>총 상품금액</th>
				<th>총 배송비</th>
				<th>결제예정금액</th>
			</tr>
		</thead>
		<tr align="center" height="90px" style="font-weight:bold;font-size: 18pt;">
			<td>108,500원</td>
			<td>+0원</td>
			<td>=108,500원</td>
		</tr>
	</table>
	
	<hr>
	
	        <div class="order_total">
            <p class="paymentAgree" id="paymentAgree"><input id="check_agree" name="check_agree" type="checkbox"  /><label for="check_agree" >결제정보를 확인하였으며, 구매진행에 동의합니다.</label></p>
            <input class="btn_payment" value="결제하기"  id="pay">

    </div>
   </div> 
   </form>
</body>
</html>