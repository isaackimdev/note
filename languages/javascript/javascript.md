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
- document.write( string ) : html에 내용을 작성한다.

```js
// html의 body보다 먼저 실행된다.
document.write("<h1>안녕 자바스크립트!!</h1>");
```

## html Element 객체
### htmlElement 이하 ele로 줄임
- ele.innerHTML : 선택 태그 내부에 값을 넣는다.
```js
ele.innerHTML = "Hello world";
```


## basic examples
- [변수의 선언과 할당](./exam02.html)
- [사칙연산](./exam03.html)
- [조건문](./exam06.html)
- [function](./exam09.html)
- [function2](./exam10.html)
- [function3](./exam11.html)
- [내장함수](./exam12.html)
- [Not a Number(NaN)](./exam13.html)
- [alert etc..](./exam14.html)
- [document.getElementById, innerHTML](./exam15.html)
- [event listener](./exam16.html)
- [window onload](./exam17.html)
- [script in html](./exam18.html)
- [js 응용](./exam20.html)
- [array, for](./exam21.html)
- [setInterval](./exam22.html)
- [popup | window.open](./exam23.html)
- [location.href](./exam24.html)
- [history.forward](./exam25.html)
- [js form](./exam26.html)
- [js object 만들기](./calc.js)

