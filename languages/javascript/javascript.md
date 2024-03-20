# javascript

## window 객체
- window.onload : Web Page 로드된 후 이벤트 감지
    - 함수를 적용해주면 웹 페이지 로드 후 실행된다. 
```js
window.onload = function() { alert("Hello"); }
```

## document 객체
- document.getElementById( string target ) : html에서 id가 target이 되는 html element 객체를 선택한다.

```html
<script>
    var h1 = document.getElementById("hello");
</script>
<body>
    <h1 id="hello"></h1>
</body>
```

## html Element 객체
### htmlElement 이하 ele로 줄임
- ele.innerHTML : 선택 태그 내부에 값을 넣는다.
```js
ele.innerHTML = "Hello world";
```