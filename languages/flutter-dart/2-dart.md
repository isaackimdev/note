# 2. dart

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

#### var와 dynamic 타입

지정 외 변수 선언 키워드
- var : 타입 유추
    - var 값을 선언할 때 값을 대입하지 않으면 dynamic 타입으로 본다.
- dynamic : 어떠한 타입도 재-대입이 가능하다.

```dart
// var, dynamic
class User {}

main() {
  dynamic data = 10;
  data = 'hello';
  data = true;
  data = User();

  var no1 = 10;
  no1 = 20;
  // no1 = true; // error

  var no2;  // dynamic
  no2 = 10;
  no2 = true;
  no2 = 'hello';
}
```

### List, Set, Map
- List : 다트에서는 배열이 리스트고, 리스트가 곧 배열이다.
- Set : 집합이다. 중복을 허용하지 않는 리스트로 볼 수 있다.
- Map : 키와 값으로 구성되어 있다.

#### List

```dart
// List 사용 예
main() {
  List list1 = [10, 'hello', true];
  list1[0] = 20;
  list1[1] = 'world';
  print('List : [${list1[0]}, ${list1[1]}, ${list1[2]}]');
}
```
위와 같이 타입 선언없이 List를 선언하여 사용한다면 dynamic type으로 사용될 수 있다.

특정 타입을 선언하여서 사용할 경우 제네릭을 사용한다.
```dart
main() {
  List<int> list2 = [10, 20, 30];
  list2[0] = 'hello';
}
```


리스트 크기 지정하기
```dart
main() {
  var list3 = List<int>.filled(3, 0);
  print(list3); // [0, 0, 0]

  list3[0] = 10;
  list3[1] = 20;
  list3[2] = 30;
  print(list3); // [10, 20, 30]

  list3.add(40);  // Runtime error
}
```
위에서 사용된 filled() 함수는 List의 생성자이다. 다른 언어들과 달라서 생소하다. 첫 번째 인자는 size이다. 두 번째 인자는 List의 초기값이다.

다음은 add() 함수를 사용해서 List에 값을 추가하려고 한다. 사이즈를 이미 고정으로 정해서 위 코드는 오류가 난다. 오류가 나지 않게 하려면 다른 설정을 추가한다.

```dart
main() {
  var list3 = List<int>.filled(3, 0, growable: true);
  list3.add(40);
  print(list3);
}
```
결괏값
```[0, 0, 0, 40]```


__특정한 로직으로 리스트 초기화하기__

generate()

```dart
main() {
  var list4 = List<int>.generate(3, (index) => index * 10, growable: true);
  print(list4);
}
```


#### Set
Set은 List와 마찬가지로 여러 건의 데이터를 저장하는 컬렉션 타입의 클래스이며 인덱스 값으로 데이터에 접근한다. 리스트와 차이는 중복 데이터를 허용하지 않는다. 집합 타입 변수를 선언하면서 초기화할 때는 중괄호({})를 이용한다.

```dart
main() {
  Set<int> set1 = {10, 20, 10};
  print(set1);
  set1.add(30);
  set1.add(40);
  print(set1);

  Set<int> set2 = Set();
  set2.add(10);
  set2.add(20);
  print(set2);
}
```

#### Map
여러 건의 데이터를 키와 값 형태로 저장하는 타입이다.

```dart
main() {
  Map<String, String> map1 = {'one':'hello', 'two':'world'};
  print(map1['one']);
  map1['one'] = 'world';
  print(map1['one']);
}
```


### Null Safety
Null safety란 프로그래밍 언어가 특정 변수의 타입에 대해서 nullable과 non-null을 구분하는 것을 말한다.
이때 그 언어가 Null safety를 지원한다고 볼 수 있다.

클래스 변수가 선언은 되어 있는데 주소값을 갖지 않는 경우를 null로 본다. 주소값을 갖지 않는다는 것은 메모리에 할당되지 않았다는 것을 의미한다.

__NPE__, Null Pointer Exception 을 발생시킨다.
```runtime error```

프로그래밍 언어에서 말하는 Null Safety는 개발자가 null 을 체크하는 것이 아니라 컴파일러가 null을 체크하도록 하는 것이 null safety를 지원하는 것이라 한다.

How? 타입으로 최소한의 정보로 컴파일러에게 제공한다.

Null Safety
  - type
  - 연산자

dart에서도 Null Safety를 제공한다. 플러터 2.0이 나오면서 다트언어가 2.12.0 버전으로 업데이트되면서 Null Safety를 제공하게 됐다.

#### Null 허용과 Null 불허
```dart
int a1 = 10;  // non-null
int? a2 = 10; // nullable

int a3;  // error
int? a4; // nullable

a3 = null; // error
a4 = null; // nullable
```

+var 키워드에는 '?'연산을 붙여 사용할 수 없다. null check를 사용할 수 없다.

var, dynamic에는 null 할당이 가능하다.

#### 자동 형 변환 체크
```dart
int a1 = 10;
int? a2 = 10;

main() {
  a1 = a2;  // 오류
  a2 = a1;  // 성공
}
```
위에서 오류가 나는 부분을 __명시적 형 변환__ 으로 해결할 수 있다.
```dart
int a1 = 10;
int? a2 = 10;

main() {
  a1 = a2 as int;
}
```

#### 초기화를 미루는 late 연산자 (선언과 동시에 값을 주지 못할 때)

```dart
int a1;       // 컴파일 오류
late int a2;  // 성공
```

### Null Safety 연산자

객체가 Null일 때 접근하면 NPE가 발생한다. Null Safety, 코드에서 Null check를 할 것인가, Compiler에게 Null check를 시킬 것인가. Dart, flutter에서는 Null Safety를 지원한다고 했다. 그럼 Compile 에게 어떤 Type에 대한 정보를 주어야 한다. Type이 nullable이냐, non-null이냐.

```dart
int a = 10;
a = null; // error

int? b = 10;
b = null; // o
```

기본적으로는 non-null 변수를 선언하는 것이 좋다. null이 들어갈 수 있는 경우에만 nullable로 선언해주는 게 좋다. nullable이 편할 수도 있지만, 객체를 선언해놓고 할당되지 않은 값에 접근하면 NPE가 발생하기 때문이다.

다음 코드를 보자.

```dart
User? obj = null; // User() or null;
obj.name; // error
obj.sayHello(); // error
```

왜 위 코드는 오류가 날까? nullable로 선언하게 되면 null이 대입이 가능하다.
그렇다면 객체에 접근을 할 때 null인 객체의 멤버에 접근을 하면 npe가 발생한다.
그렇기 때문에 null check를 해주는 연산자를 추가한다.

```dart
User? obj = null; // User(); or null
obj?.name;
obj?.sayHello();
```

#### Null check 연산자 - !연산자
null이면 NPE 오류를 발생해달라는 연산자다.

```dart
int? a1 = 20;

main() {
  a1!;
  a1 = null;
  a1!;  // runtime error
}
```
#### 멤버에 접근할 때 ?., ?[ ] 연산자

널 허용 객체의 멤버에 접근하기
```dart
String? ste = "hello";

main() {
  str.isEmpty;  // error
}
```

널 객체의 멤버에 접근할 때 null 반환하기
```dart
main() {
    int? no1 = 10;
    // null 이면 접근을 안하고 null을 return 아니면 접근한다.
    bool? result1 = no1?.isEven; 
    print('result 1 : $result1');

    no1 = null;
    bool? result2 = no1?1.isEven;
    print('result 2 : $result2');
}
// true
// null
```

널 리스트에 인덱스로 접근할 때 null 반환하기
```dart
main() {
  List<int>? list = [10, 20, 30];
  print('list[0] : ${list?[0]}');
  list = null;
  print('list[0] : ${list?[0]}');
}
// list[0] : 10
// list[0] : null
```

#### 값을 대입할 때 ??= 연산자
널일 때 대입하지 않기
```dart
main() {
  int? data3;
  data3 ??= 10;
  print('data3 : $data3');
  data3 ??= null;
  print('data3 : $data3');
}
// data3 : 10
// data3 : 10
```

#### 값을 대체할 때 ?? 연산자
널일 때 값 대체하기
```dart
main() {
  String? data4 = 'hello';
  String? result = data4 ?? 'world';
  print('result : $result');
  
  data4 = null;
  String? result = data4 ?? 'world';
  print('result : $result');
}
// result : hello
// result : world
```

### 함수 선언 위치
최상위, 함수 내 함수, 클래스 내 함수 선언 가능

다트에서는 함수 오버로딩을 제공하지 않는다.

optional로 오버로딩을 대체할 수 있다.
- var, dynamic parameter 사용

```dart
void some1(var a) { // parameter -> dynamic, var 생략도 가능

}

dynamic some2() { // some2() { } 과 동일하다고 볼 수 있음.
  // return 10;
  // return true;
  return 'hello';
}

main() {
  some1(10);
  some1(true);
  some1('hello');
}
```

## 05-2. 명명된 매개 변수
함수를 호출할 때 매개 변수의 개수와 타입, 순서에 맞게 데이터를 전달해야 한다. 그렇지 않으면 오류가 발생한다.

```dart
void some(int a, String b, bool c) {

}

main() {
  some();   // error
  some('hello', true, 10);  // error
  some(10, 'hello', true);
}
```

다른 언어에서 오버로딩을 봐왔을 것이다. 오버로딩은 함수명은 같지만 매개 변수의 개수가 다른 함수들을 선언하는 방법이다. 그런데 dart에서 옵셔널(Optional)이라는 방법을 통해 오버로딩을 하지 않고 매개 변수의 개수가 다른 같은 이름의 함수를 사용할 수 있도록 한다.

#### 옵셔널
- 명명된 매개변수(named parameter) ★★★
- 옵셔널 위치 매개변수(optional positional parameter)

명명된 매개변수 예제
```dart
void some( {String? data1} ) {
  print('data1: $data1');
}

some(data1: 'world');
```
#### 명명된 매개변수 선언 규칙
- 명명된 매개변수는 중괄호{}로 묶어서 선언한다.
- 여러 매개변수를 중괄호로 묶어 명명된 매개변수를 선언할 수 있다.
- 한 함수에서 명명된 매개변수는 한 번만 선언할 수 있으며 순서상 마지막에 선언해야 한다.
- 명명된 매개변수에는 기본값을 설정할 수 있다.

```dart
void some1({String? data2, bool? data3}, int data1) {} // error
void some2(int data1, {String? data2, bool? data3}, {int? data4}) {} // error
void some3(int data1, {String? data2, bool? data3}) {} // success
```

#### 명명된 매개변수 호출 규칙
- 명명된 매개변수에 데이터를 전달하지 않을 수 있다. (생략 가능)
- 명명된 매개변수에 데이터를 전달하려면 반드시 __이름을 명시__ 해야 한다. 
- 명명된 매개변수에 데이터를 전달할 때 선언된 순서와 맞추지 않아도 된다.

#### 필수 매개변수 선언하기 - required

```dart
someFun({required int arg1}) {
  print('someFun().. arg1 : $arg1');
}
main() {
  someFun();  // error
  someFun(arg1: 10);  // success
}
```

### 옵셔널 위치 매개변수 optional positional parameter
명명된 매개변수처럼 값은 선택이므로 생략할 수 있다. but 값을 전달할 때 이름 대신 매개변수가 선언된 순서(위치)에 맞게 호출해야 한다. 즉 옵셔널 위치 매개변수로 선언된 함수는 데이터 전달은 자유지만 순서는 맞춰 호출해야 한다.

규칙
- 매개변수들을 대괄호로 묶는다.
- 함수의 마지막 매개변수에만 사용할 수 있다.
- 매개변수에 기본 인자를 설정할 수 있다.

호출 규칙
- 매개변수 이름은 생략한다.
- 매개변수가 선언된 순서에 따라 값이 할당된다.

```dart
void some(int arg1, [String arg2 = 'hello', bool arg3 = false]) {}

some(); // eror
some(10);
some(10, arg2: 'world', arg3: true);  // error
some(10, 'world', true);
some(10, true, 'world') // error
some(10, 'world');
some(10, true);  // error
```
