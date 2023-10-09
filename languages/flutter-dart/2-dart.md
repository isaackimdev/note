## 2. dart

- dart 2011~ created by google
- cross platform language

#### 다트 파일 실행하기
다트 파일은 main() 함수를 프로그램의 진입점(entry point)으로 삼는다. 즉, 다트 엔진이 다트 언어로 작성된 .dart 파일을 실행하면 main() 함수를 호출하면서 프로그램이 실행된다.

#### 다트 파일의 구성 요소
다트 파일은 top level에 프로그램의 구성 요소인 변수와 함수, 클래스를 선언할 수 있다. java 처럼 객체지향 프로그래밍에 목적을 둔 언어는 톱 레벨에 작성할 수 있는 구성 요소가 클래스뿐이다. 따라서 자바 같은 언어에서는 함수와 변수를 꼭 클래스 내부에 작성해야 한다. 

하지만 다트 언어는 top level에 클래스뿐만 아니라 변수와 함수도 선언할 수 있다. 즉, 변수와 함수를 꼭 클래스로 묶을 필요는 없다.

top level은 어느 요소에도 속하지 않는 최상위 영역을 말한다. 즉 어느 중괄호({})에도 속하지 않는 영역이다.

#### dart 언어에서 제공되는 패키지 라이브러리
|플랫폼 종류|라이브러리 종류|지원하는 내용|
|-|-|-|
|멀티 플랫폼|dart:async|비동기프로그래밍|
|멀티 플랫폼|dart:collection|LinkedList, HashMap 등 집합 데이터|
|멀티 플랫폼|dart:convert|JSON 같은 데이터의 인코딩과 디코딩|
|멀티 플랫폼|dart:core|내장(built-in) 타입, 컬렉션 등|
|멀티 플랫폼|dart:developer|디버거나 인스펙터 등 개발자 도구|
|멀티 플랫폼|dart:math|수학 함수|
|네이티브 플랫폼|dart:io|파일, 소켓, HTTP 등 앱에서 발생하는 입출력|
|네이티브 플랫폼|dart:isolate|동시성 프로그래밍(일종의 스레드 프로그래밍)|
|웹 플랫폼|dart:html|HTML 요소|
|웹 플랫폼|dart:indexed_db|키-값 형태의 데이터 저장|
|웹 플랫폼|dart:web_audio|오디오 핸들링|
|웹 플랫폼|dart:web_gl|3D 그래픽|
|웹 플랫폼|dart:web_sql|SQL 기반 데이터 저장|
