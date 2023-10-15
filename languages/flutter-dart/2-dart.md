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


#### 라이브러리 불러오기 
다트 파일에서 라이브러리를 이용하려면 윗부분에 import 예약어로 선언해야 한다. 선언하지 않고 사용할 수 있는 라이브러리는 다트 엔진에서 제공하는 dart:core 뿐이다.

*주의 : lib 폴더를 벗어나서 접근할 수 없음

#### package 접두사로 불러오기
플러터 자체나 외부 패키지를 불러올 때는 주로 package 접두사를 사용한다.

import 'package:http/http.dart';
- http : 패키지이름
- /http.dart : 다트 파일명

#### dart 접두사로 불러오기
다트 언어에서 기본으로 제공하는 라이브러리를 불러올 때는 dart 접두사를 사용합니다.
```dart
# dart 접두사로 불러오기
import 'dart:core';
import 'dart:async';
```

#### 외부에서 사용할 수 없게 제한하기
다트에는 public, private 같은 접근 제한자가 없다. 다트에서 일반적인 변수 선원 varName은 외부에서 접근이 가능하다. 다트에서는 언더 바(_)를 사용해서 외부에서는 사용할 수 없도록 한다. _varName처럼 사용하면 된다.


### as, show, import
---

#### 식별자에 별칭 정의하기 as
```dart
import 'test1.dart' as Test1
main() { }
```

위 예시 코드에서 as를 사용했다. test1.dart 파일 내부에 변수, 함수, 클래스가 있다고 하면 main() 함수에서 test1.dart 파일내에 있는 요소를 사용한다고 할 때 as 뒤에 별칭으로 접근하여서 사용해야 한다.
- Test1.변수
- Test1.함수()
- Test1.클래스

#### 특정 요소 불러오기 show
필요한 요소만 갖고 와서 사용할 때 사용하는 키워드 show
```dart
import 'test1.dart' show no1, User1;

main() {
    no1 = 30;
    User1 user1 = User1();

    sayHello1(); // error
}
```
show 뒤에 선언된 no1, User1은 사용할 수 있지만, 그 외의 호출은 오류가 발생한다.

#### 특정 요소 숨기기 hide (show와 반대되는 개념)
특정한 요소를 제외할 때 사용한다.
```dart
import 'test1.dart' hide sayHello1, User1;

main() {
    no1 = 30;
    sayHello1(); // error
    User1 user1 = User1();  // error
}
```



### Library
---
다트 파일에서 다른 다트파일을 포함할 때 part나 part of 예약어를 사용할 수 있다. 특히 Library 예약어와 함께 라이브러리를 만들 때 유용하다.

다음 예제를 보자.
```dart
// a.dart
int aData = 10;
```

```dart
// b.dart
int bData = 20;
```

```dart
// test.dart
import 'a.dart';
import 'b.dart';

main() {
    print('$aData, $bData');
}
```
test.dart 파일에서 각 파일을 import 하고 있다. 라이브러리라고 한다면 많은 file을 전부 import 할 것인가? 이를 해결해주는 '라이브러리 만들기'를 보자.

```dart
// a.dart
part of my_lib;
int aData = 10;
```

```dart
// b.dart
part of my_lib;
int bData = 20;
```

```dart
// myLib.dart
Library my_lib;
part 'a.dart';
part 'b.dart';
```

```dart
// test.dart
import 'myLib.dart'

main() {
    print('$aData, $bData');
}
```

1. 기존의 a.dart, b.dart 파일은 part of 라는 예약어를 써서 my_lib 이라는 라이브러리에 속한다고 명시한다.
2. 라이브러리로 묶어줄 myLib.dart 파일을 생성한다. 그리고 Library 키워드로 라이브러리임을 명시하고, 라이브러리로 포함할 파일을 part 키워드를 써서 포함시킨다.
3. 라이브러리르 사용하고자 하는 test.dart 에서 myLib.dart 파일 하나만 import 해도 a.test, b.test 파일의 변수를 모두 사용할 수 있다. 
4. 위 과정은 __라이브러리__ 를 만들어 사용하는 것으로 볼 수 있다.



### 다트에서 모든 변수는 객체다.
int, bool, String, User 등 모든 변수가 다 '객체'다. 

기본 타입도 모두 클래스다.

int a = 10; 이처럼 숫자 대입이 가능하지만 클래스, 객체이기 때문에 null도 대입이 된다.

#### 다트의 타입 클래스
다트에선 dart:core와 dart:typed_data 라이브러리에서 타입 클래스를 제공한다.

|라이브러리|타입 클래스|데이터
|-|-|-
|dart:core library|bool|true, false
|dart:core library|double|실수
|dart:core library|int|정수
| |num|숫자(double과 int의 상위 클래스)
| |String|문자열
|dart:typed_data|ByteData|바이트


#### 문자열

문자별의 비교 : ==

문자열 내에 동적 변수 데이터 표현 : "문자열 ${var}"


#### 형 변환

- num
    - int
    - double

double 변수에 int를 대입할 수 없다. 상속관계가 아니기 때문에.

넣으려면 함수로 변환하여서 변환한 다음에 대입하여야 한다.

- toDouble()
- toInt()
- toString()

다음은 문자열 내에 동적 변수를 사용하는 예제 및 형변환 예제 소스 코드이다.
```dart
main() {
  int no = 10;
  String name = "kim";
  String myFun() {
    return "kim";
  }
  print("no: $no, name $name, 10+20: ${10+20}, myFun(): ${myFun()}");

  int n1 = 10;
  double d1 = 10.0;
  // double d2 = n1; // error
  // int n2 = d1; // error

  double d2 = n1.toDouble();
  int n2 = d1.toInt();
}
```

#### 상수 변수 const, final
다트에는 상수가 되는 시점에 따라 컴파일 타임과 런 타임 상수 변수로 구분된다.
- 컴파일 타임에 상수 변수 선언하는 예약어 : const
- 런타임에 상수 변수로 선언하는 예약어 : final

컴파일 시점의 상수 변수에는 초기값을 같이 선언해주어야 한다. 

```dart
const String data1 = 'hello';
final int no1 = 10;

class User {
  static const String data2 = 'hello';
  final int no2;
  User(this.no2);

  void some() {
    const String data3 = 'hello';
    final int no3;
    no3 = 10;
    int result = no3 + 10;
    // data1 = 'world'; //error
  }

}

```