<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="initial-scale=1.0,user-scalable=no">
<script type="text/javascript" 
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=723312ae673dd03314399393123e66c9"></script>
<script type="text/javascript">
	window.onload = function() {
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new daum.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
			level: 3 //지도의 레벨(확대, 축소 정도)
		};

		var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴

	}
</script>
</head>
<body>
<div id="map" style="width:500px;height:400px;"></div>

</body>
</html>