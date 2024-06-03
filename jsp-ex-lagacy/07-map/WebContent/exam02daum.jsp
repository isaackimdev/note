<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Daum 지도 시작하기</title>
</head>
<body>
	<div id="map" style="width:500px;height:400px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c34d442169a7cea9e5bde3045c68f83d"></script>
	<script>
	window.onload = function() {
		var container = document.getElementById('map');
		var options = {
			center: new daum.maps.LatLng(38.450701, 126.570667),
			level: 3
		};

		var map = new daum.maps.Map(container, options);
	}
	</script>
</body>
</html>