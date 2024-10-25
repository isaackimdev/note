# React.js

[react란](https://nextjs.org/learn/foundations/from-javascript-to-react/getting-started-with-react)

react는 ui를 만들기 위한 library

html에서 javascript를 사용해서 ui를 만드는 방법이 있다. '명령형'

그런데 명령형은 모든 절차를 코드로 작성해야 한다.

예) 명령형 피자 만들기 : 도우 준비 > 야채 준비 > 굽기 > 꺼내기 등

react는 선언형이라고 할 수 있는데

예) 피자 주문 -끝-

javascript로 html을 컴파일 하기 위해 react에선 JSX를 사용한다.
이때 babel lib이 필요하다.

next 개발에 필요한 lib
- react
- react-dom
- next

패키지 설치 명령어
`npm install react react-dom next`


## react-foundations
[react-foundations](https://nextjs.org/learn/react-foundations)

- ex1 : html + js 코드에서 react.js library를 추가하여 명령형에서 선언형 코드로 변환
- ex2 : JSX
- ex3 : Components - 모듈
- ex4 : Props - 데이터 전달
- ex5 : State - 모듈 내 실시간 상태관리, hook 이라고도 함.


```
Q : What is the difference between props and state?

A : Props are read-only information that's passed to components. State is information that can change over time, usually triggered by user interaction.
```

## from react.js to next.js
index.html 파일이 있는 곳에 빈 package.json 생성 후 아래 명령어 실행

```sh
npm install react@latest react-dom@latest next@latest
```
