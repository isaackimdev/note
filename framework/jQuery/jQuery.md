# jQuery

- jQuery : jQuery는 javascript 기반 라이브러리
- 사용방법 : 보통 html 파일 상단에 jQuery lib 소스를 연결 후 사용

```html
<script type="text/javascript" src="libs/jquery-3.3.1.min.js"></script>
<script>
    function hello($) {
        // .은 class 선택자, #은 id 선택자
		var h1 = $(".hello");
		h1.html("Hello jQuery!");
	}
    
    // jQuery() : window.onload 동작과 비슷하게 동작한다.
    jQuery(hello);
</script>

<body>
    <h1 id="hello" class="hello"></h1>
</body>
```

- html Element 선택 방법, 선택자(selector)
	- 예제 : [selector.html](selector.html)

```js
	$(function() {
		// id값에 의한 접근. 가장 일반적인 방법이다.
		$("#title").html("두번째 제목");
		// 자식셀렉터의 사용
		$("div#container > h1#title").html("제목입니다.");
		// 자손셀렉터의 사용
		$("div#container div.box").html("안녕하세요.");
		// 자손셀렉터를 사용하여 모든 <li> 태그를 지정
		$("ul > li").html("목록입니다.");
		//두번 <li>태그만 지정한다. eq(n)은 0부터 카운트 한다.
		$("ul > li:eq(1)").html("jQuery 고유의 방식도 있습니다.");
		// 복수 요소를 지정한다.
		$("p, pre").html("다중요소 선택");
		// name 속성이 source인 항목만 지정
		$("pre[name='source']").html("CSS의 선택자");
		// <li>태그의 첫 번째 항목과 미지막 항목
		$("ul > li:first-child").html("First-Child");
		$("ul > li:last-child").html("Last-Child");
	});
```

```html
<body>
	<div id="container">
		<h1 id="title"></h1>
		<div class="box"></div>
		<ul>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
	<p></p>
	<pre></pre>
	<pre name='source'></pre>
</body>
```

- event listener : 특정 요소의 event를 감지한다.
```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div {
	border: 1px lightgray solid;
	width: 155px;
	height: 55px;
}
</style> 
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	// 입력된 key 값 [고유한 key의 number가 반환됨, ASKII 값 반환]
	$(function() {
		$("#input > input[type='text']").keydown(function(e) {
			$('#result').html(e.which + "번 키 눌러짐" + getKeyName(e.which));
		});
	});
	// 키 코드값을 파라미터로 받아서 키보드의 이름을 리턴하는 함수
	function getKeyName(keyCode) {
		// 키 코드와 버튼 이름에 대한 JSON 배열 정의
		var keyMap = [
			{code: 8, name: "backspace_key"},
			{code: 9, name: "tab_key"},
			{code: 13, name: "enter_key"},
			{code: 16, name: "shift_key"},
			{code: 17, name: "ctrl_key"},
			{code: 18, name: "alt_key"},
			{code: 19, name: "pausebreak_key"},
			{code: 20, name: "capslock_key"},
			{code: 27, name: "esc_key"},
			{code: 65, name: "a_key"},
		];
		// 반복문을 배열의 크기만큼 진행
		for(var i=0; i<keyMap.length; i++) {
			// JSON의 특정 값과 키코드가 같다면?
			if(keyMap[i].code == keyCode) {
				// 값을 리턴 --> 즉시 종료
				return keyMap[i].name;
			}
		}
	}
</script>
</head>
<body>
<h1> Key Event Check</h1>
<div id="input">
	<input type="text">
</div>
<h2>result</h2>
<div id="result"></div>
</body>
</html>
```