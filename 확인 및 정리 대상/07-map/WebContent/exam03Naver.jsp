<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 
// 네이버 지도 - 특정 주소에 마커 표시 - web
// https://openapi.map.naver.com/openapi/v3/maps.js?clientId=YOUR_CLIENT_ID&submodules=geocoder
// 위에서 YOUR_CLIENT_ID는 애플리케이션 등록시 발급되는 20자리 영문 대문자와 소문자 조합입니다 예) VagkBddrZ5JdHbcd5DfK (O)
// 구 API키 (32글자의 영어 소문자와 숫자 조합)은 사용불가 예) f8a20b93f0bf315be90d4a35145ef0fa (X)
 -->
 
<!DOCTYPE html>
<html>
  <head>
      <meta charset="UTF-8">
      <title>네이버 지도 API - 주소로 지도 표시하기</title>
      <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=YOUR_CLIENT_ID&submodules=geocoder"></script>
  </head>
  <body>
    <div id="map" style="width:100%;height:400px;"></div>
    <script>
      var map = new naver.maps.Map('map');
      var myaddress = '불정로 6';// 도로명 주소나 지번 주소만 가능 (건물명 불가!!!!)
      naver.maps.Service.geocode({address: myaddress}, function(status, response) {
          if (status !== naver.maps.Service.Status.OK) {
              return alert(myaddress + '의 검색 결과가 없거나 기타 네트워크 에러');
          }
          var result = response.result;
          // 검색 결과 갯수: result.total
          // 첫번째 결과 결과 주소: result.items[0].address
          // 첫번째 검색 결과 좌표: result.items[0].point.y, result.items[0].point.x
          var myaddr = new naver.maps.Point(result.items[0].point.x, result.items[0].point.y);
          map.setCenter(myaddr); // 검색된 좌표로 지도 이동
          // 마커 표시
          var marker = new naver.maps.Marker({
            position: myaddr,
            map: map
          });
          // 마커 클릭 이벤트 처리
          naver.maps.Event.addListener(marker, "click", function(e) {
            if (infowindow.getMap()) {
                infowindow.close();
            } else {
                infowindow.open(map, marker);
            }
          });
          // 마크 클릭시 인포윈도우 오픈
          var infowindow = new naver.maps.InfoWindow({
              content: '<h4> [네이버 개발자센터]</h4><a href="https://developers.naver.com" target="_blank"><img src="https://developers.naver.com/inc/devcenter/images/nd_img.png"></a>'
          });
      });
      </script>
  </body>
</html>
