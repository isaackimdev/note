# 3. User Interface

## 08-1, 2 위젯, 위젯 트리

플러터의 위젯은 화면과 관련된 모든 것을 말하며 위젯은 불변이다.

- 선언형 UI 프로그래밍

객체 선언에 정보만 전달해준다.

플러터에서는 위젯 트리를 갖는다. 계층 구조로 layout이 짜인다고 볼 수 있다. 그리고 내부적으로는 3개의 트리를 갖는다.

위젯 트리 -> 엘리먼트 트리 -> 렌더 트리

위젯 트리 : 개발자가 선언한 것

엘리먼트 트리 : 화면을 보이기 위한 객체 트리

렌더 트리 : 실제 화면으로 보이게 하는 트리, 위젯 개수와 다를 수 있다.


## 08-3. 위젯 종류

Widget
- StatelessWidget
- StatefulWidget
- 상속 위젯

보통 Stateless, Stateful을 사용하는데 Stateful은 상태(data)가 변화하는 것을 re-rendering해줄 때 사용한다.
개발할 때 무조건 statefulWidget만 사용하지 않는다.

### Stateless Example
```dart
// main.dart
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Test"),
        ),
        body: Center(
          child: Column(
            children: [
              ElevatedButton(
                  onPressed: () {},
                  child: Text("사진 찍기(카메라)"),
              ),
              ElevatedButton(
                  onPressed: () {},
                  child: Text("사진 선택(앨범)"),
              )
            ],
          ),
        ),
      ),
    );
  }
}
```

#### StatefulWidget
statefulWidget은 state 클래스를 갖는다. setState라는 함수로 re-rendering할 수 있도록 한다.

위젯은 불변하다. 그래서 다시 생성할 수 있는 구조로 관리된다. 변하는 값에 대해서는 메모리에 저장 시켜두고 변한 값만 확인해서 메모리에서 값만 변경시키기 위해 따로 클래스를 뺀 것이다. 그게 state 클래스고 거기서만 변경이 이루어지도록 한다. setState() 함수를 사용해서 re-rendering 하도록 한다.

## 08-4.정적 화면, 동적 화면 예제 점검
## 08-5. 상태의 생명 주기 (State Class)

![Alt text](./imgs/state-life-cycle.png)

주로 재 정의 되는 함수
- build() : 화면 rendering 때문에 필수★
- initState() : 자주 사용, 객체 생성되자 마자 가장 먼저 최초 한번 호출, 자신들의 상태값 초기화, 초기값 세팅, 이벤트(이벤트 리스너-핸들러) 등록
- setState() : State의 상태(data)를 변경할 때 호출하는 함수
- Clean : state에 의해 화면이 출력되고 있는 정상 상태
- Dirty : 화면에 반영되지 않은 상태, State 화면을 다시 빌드해야 하는 상태
- didChangeDependencies() : 상위 위젯에서 하위 위젯으로 변경된 상태를 전달할 때 호출된다.
- didUpdateWidget() : 상태가 변화될 때를 감지할 때 호출한다. 여기서 build()를 호출한다고 한다.
- dispose() : 자주 사용, 객체가 메모리에서 소멸될 때 마지막으로 실행되는 함수



## BuildContext

Widget은 BuildContext를 갖는다. BuildContext는 __위젯 객체의 정보__ 를 갖고 있으며 상위 위젯에도 접근을 할 수가 있다. 그렇지만 이것은 좋은 방법은 아님.

Widget은 Key를 가질 수 있다. stateless에는 크게 상관이 없을 수도 있다. stateful에도 서로 다른 클래스를 사용하면 상관없을수 있다. 하지만 목록형에 stateful을 쓸 때 서로 다른 객체임을 알리려면 __키(Key)__ 를 부여해야 한다.


## 09-1. asset

image, text 등의 파일 resources

pubspec.yaml 파일에 flutter.aseets 에 리소스 경로들, assets 경로들을 설정한다.

폴더 경로 지정 예시

assets 경로(Path)는 플러터 프로젝트의 루트부터 시작한다. `lib` directory와 같은 레벨에 위치한다.

```yaml
# pubspec.yaml
flutter:
    assets:
        - resources/images/
        - resources/images/icon/
        - resources/assets/text/
```

예제 소스
```dart
// test.dart
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MyApp());
}
class MyApp extends StatelessWidget {
  // 미래 발생할 타입 : Futrue
  Future<String> useRootBundle() async {
    return await rootBundle.loadString('resources/assets/text/my_text.txt');
  }
  Future<String> useDefaultAssetBundle(BuildContext context) async {
    return await DefaultAssetBundle.of(context).loadString("resources/assets/text/my_text.txt");
  }
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("test"),
        ),
        body: Column(
          children: [
            Image.asset("resources/images/icon.jpg"),
            Image.asset("resources/images/icon/user.png"),
            FutureBuilder(
                future: useRootBundle(),
                builder: (context, snapshot ) {
                  return Text("rootBundle : ${snapshot.data}");
                }
            ),
            FutureBuilder(
                future: useDefaultAssetBundle(context),
                builder: (context, snapshot ) {
                  return Text("DefaultAssetBundle : ${snapshot.data}");
                }
            )
          ],
        ),
      ),
    );
  }
}
```

## 09-2. Text Widget

문자열을 출력하는 위젯

텍스트 위젯 생성자
```dart
Text(String data, { ... (생략) ... })
Text.rich(InlineSpan textSpan, { ... (생략) ... })
```

#### 텍스트 정렬하기 - textAlign

문자열 정렬 textAlign 속성

TextAlign 클래스가 클래스가 제공하는 상수로 가로 방향 정렬 방법을 지정한다.

상수는 start, end, center, left, right 등을 제공한다.

텍스트 정렬하기
```dart
Text('Hello World'),
Text(
  'Hello World',
  textAlign: TextAlign.center,
),
```

#### 텍스트 스타일 지정하기 - TextStyle

텍스트 스타일 지정하기

#### 줄 수 제한하기 - maxLines

텍스트에 긴 문자열을 출력하면 자동으로 줄 바꿈해서 여러 줄로 출력

줄임표시 같은 게 가능하다.

텍스트 위젯 예제
```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  String longTxt = "가나다라마바사 가나다라마바사 가나다라마바사 가나다라마바사 가나다라마바사 가나다라마바사12 가나다라마바사 가나다라마바사 가나다라마바사 가나다라마바사 가나다라마바사 가나다라마바사 ";
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text("test"),),
        body: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Text(
              'Hello World',
              style: TextStyle(
                fontWeight: FontWeight.bold,
                fontStyle: FontStyle.italic,
                color: Colors.red,
                fontSize: 20,
                height: 2,
                backgroundColor: Colors.yellow,
                decoration: TextDecoration.underline,
                decorationColor: Colors.red,
                decorationStyle: TextDecorationStyle.wavy
              ),
            ),
            Text(
              longTxt,
              style: TextStyle(
                fontSize: 20,
              ),
              maxLines: 2,
              overflow: TextOverflow.fade,
            ),
            RichText(
                text: TextSpan(
                  text: "HE",
                  style: TextStyle(fontSize: 20, color: Colors.black),
                  children: [
                    TextSpan(
                      text: "L",
                      style: TextStyle(fontStyle: FontStyle.italic),
                      children: [
                        TextSpan(text: 'KO'),
                        TextSpan(
                          text: "WO",
                          style: TextStyle(color: Colors.red),
                        ),
                      ]
                    ),
                    TextSpan(
                      text: 'RLD',
                      style: TextStyle(fontWeight: FontWeight.bold)
                    )
                  ]
                )
            )
          ],
        ),
      ),
    );
  }
}
```


## 09-3. 이미지 위젯

이미지를 출력할 때는 image 위젯을 사용. 그런데 Image 위젯으로 출력할 데이터는 ImageProvider로 가져와야 한다.

ImageProvider는 추상 클래스이며 이 클래스를 상속받은 다음의 클래스를 이용한다.

- AssetImage : 에셋 이미지
- FileImage : 파일 이미지
- MemoryImage : 메모리의 데이터 이미지
- NetworkImage : 네트워크의 이미지
- ResizeImage : 이미지 크기 변경

에셋 이미지를 AssetImage로 가져와 Image 위젯으로 출력하는 코드는 다음처럼 작성한다.

```dart
Image(image: AssetImage('images/icon/user.png'),),
```

ResizeImage는 이미지 크기를 변경
```dart
Image(image: ResizeImage(AssetImage('images/icon/user.png'), width: 70, height: 80)),
```

이미지 위젯에 이미지를 채우는 방식 BoxFit 클래스 사용.

이미지 위젯 사용 예제
```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text('Test'),),
        body: Column(
          children: [
            Image(image: NetworkImage('https://picsum.photos/250?image=9')),
            Container(
              color: Colors.red,
              child: Image.asset(
                'resources/images/big.jpeg',
                width: 200,
                height: 200,
                fit: BoxFit.fill,
              ),
            )
          ],
        ),
      ),
    );
  }
}
```

## 09-4. icon & icon button

플러터에서 아이콘을 대부분 지원한다.

```dart
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';

void main() {
  runApp(MyApp());
}
class MyApp extends StatelessWidget {
  onPressed() {
    print('icon button click...');
  }
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text('test'),),
        body: Column(
          children: [
            Icon(
              Icons.alarm,
              size: 100,
              color: Colors.red,
            ),
            FaIcon(
              FontAwesomeIcons.bell,
              size: 100,
            ),
            IconButton(onPressed: onPressed, icon: Icon(Icons.alarm, size: 100,))
          ],
        ),
      ),
    );
  }
}
```

## 09-5 Gesture Detector & Elevate Button

JestureDetector example
```dart
GestureDetector (
  child: Image.asset('images/icon/user.png'),
  onTap: () {
    print('image click..');
  },
)
```
#### 엘리베이트 버튼 -ElevateButton

보통 버튼에서 많이 사용하는 위젯

```dart
ElevateButton(
  onPressed : () {
    print('ElevatedButton click..');
  },
  child : Text('Click Me'),
)
```

## 09-6. 컨테이너와 센터 위젯

#### Container

Container는 화면 영역을 표현하는 위젯이다. 자체 화면 갖지 않고 child로 Container 영역에 표시할 위젯을 지정할 수 있다. 특정 영역의 margin, border, padding 등 지정할 수 있고 배경 색상, 배경 이미지 등 다양하게 꾸미는 방법을 제공한다.

#### 가운데 정렬하는 센터 - Center

대부분 특정 영역에 가운데에 배치하는 경우에 Center를 많이 사용한다.


## 10-1. 방향 설정하기

가로 배치 Row

세로 배치 Column

방향의 기본축, 교차축이 존재한다.
main, cross

#### Row, Column 기본 사이즈 
- main 축 사이즈 최대 지정
- crss 축 사이즈 최소 지정

메인축 사이즈

MainAxisSize
- min, max

배치 설정하기 - alignment
- MainAxisAlignment
- CrosAxisAlignment


### stack

add된 순서대로 겹쳐져 나오는 것

여러 위젯을 겹쳐서 나오도록 하는 것

### indexedStack

위젯 스택 중에서 특정 인덱스 위젯만 나오도록 함.

## 10-2. 위치 설정하기

Row, Column을 이용해 위젯을 배치하면 순서대로 가로, 세로 방향으로 배치된다. Stack은 특정 위치를 설정해야 할 때가 많다. 이 때 Align과 Positioned 위젯을 사용한다. Align은 Stack뿐만 아니라 독립적으로 사용할 수 있지만, Positioned는 Stack에서만 사용할 수 있다.

`특정 위치에 배치 - Align`

다음 코드는 Align 위젯에 alingment값을 Alignment.topRight로 설정하여 위젯이 화면의 오른쪽 윗부분에 위치하는 코드다. Align 위젯은 독립적으로 사용해도 되고 Stack과 함께 사용해도 된다.

```dart
Align(
  alignment: Alignment.topRight,
  child: Container(
    color: Colors.red,
    width: 100,
    height: 100,
  ),
)
```
Alignment 클래스에 정의된 center, bottomRight 등의 상수로 위젯의 위치를 설정할 수 있지만, Alignment 생성자의 매개변수에 숫자를 넘겨 위치를 설정할 수도 있다.
```dart
// Alignment 생성자
Alignment(double x, double y)
```
x, y에는 -1.0~1.0 까지 값을 설정할 수 있고 0.0은 사각형의 중앙이다. -1.0은 X축 왼쪽 Y축 위를 의미하며, 1.0은 X축 오른쪽 Y축 아래를 의미한다.


### 왼쪽 위를 기준으로 배치하기 - FractionalOffset

```dart
Align(
  alignment: FractionalOffset(0.5, 0.5), // 중앙값
)
```

### 상대 위칫값으로 배치하기 - Positioned

부모 위젯 기준에서 left, top 등의 속성 값으로 배치한다.
```dart
Positioned(
  left: 40.0,
  top: 40.0,
  child: Container(
    width: 150,
    height: 150,
    color: Colors.pink,
  )
)
```

## 10-3. 사이즈 설정

위젯은 각각 사이즈를 설정할 수 있다. 

### 똑같은 크기로 배치하기 - IntrinsicWidth, IntrinsicHeight
IntrinsicWidth, IntrinsicHeight는 Row나 Column에 추가한 여러 위젯의 크기를 똑같이 설정할 때 사용한다. Intrinsic을 사용하면 크기가 가장 큰 것을 기준으로 모두 통일할 수 있다.

### 최소, 최대 범위로 배치하기 - ConstrainedBox
위젯의 최소, 최대 범위 지정하여 사이즈 정한다.

```dart
// 최대로 확장
ConstrainedBox(
  constraints: BoxConstraints.expand()
)
```

```dart
// 마지노선 설정
ConstrainedBox(
  constraints: BoxConstraints(
    minWidth: 300,
    maxHeight: 50
  ),
  child: Container(color: Colors.red, width: 150, height: 150.0),
)
```


## 10-4. 기타 배치와 관련된 위젯

비율로 배치하기 - Expended

Expended를 사용하면 각 위젯 사이즈가 무시된다. 위젯 크기가 비율로 계산된다.

비율값은 flex 속성값으로 설정할 수 있다.

★ 빈 공간 넣기 - Spacer : 인스타 화면처럼 공간 부여 가능하다.
Row에 공간 부여할 떄 사용. 빈 공간 넣기.


스크롤 제공하기 - SingleChildScrollView : 하위 하나만 갖는다.

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text('Test'),),
        body: SingleChildScrollView(
          scrollDirection: Axis.vertical,
          child: Column(
            children: [
              Container(
                height: 300,
                child: Row(
                  children: [
                    Container(
                      color: Colors.red,
                      width: 100,
                    ),
                    Expanded(
                        flex: 1,
                        child: Container(
                          color: Colors.amber,
                        )
                    ),
                    Expanded(
                        flex: 1,
                        child: Container(
                          color: Colors.yellow,
                        )
                    )
                  ],
                ),
              ),
              Container(
                color: Colors.green,
                height:300,
                child: Row(
                  children: [
                    Image.asset("resources/images/lab_instagram_icon_1.jpg"),
                    Image.asset("resources/images/lab_instagram_icon_2.jpg"),
                    Image.asset("resources/images/lab_instagram_icon_3.jpg"),
                    Spacer(),
                    Image.asset("resources/images/lab_instagram_icon_4.jpg"),
                  ],
                ),
              ),
              Container(
                color: Colors.blue,
                height: 300,
              )
            ],
          ),
        ),
      ),
    );
  }
}
```

## 11-1. 사용자 입력 처리 위젯

input

텍스트 필드 : TextField

입력된 데이터 얻기 : TextEditingController

텍스트 필드에 controller를 지정만 하면 자동저장된다.

### 꾸미기 - InputDecoration

### 액션 버튼 - textInputAction
우측 하단 키를 무엇으로 쓸 것인지 지정할 수 있음.

### 키보드 유형 - keyboardType

### 텍스트 감추기 - obscureText

### 여러 줄 입력 - maxLines, minLines



## 11-2. checkbox, radio button, slider, switch

checkbox, radio button, slider, switch 이 모두 사용자에게 데이터를 입력받는 위젯.

example

### Checkbox
```dart
Row(
  children: [
    Checkbox(
      value: isChecked,
      onChangd: (bool? value) {
        setState(() {
          isChecked = value;
        });
      }
    ),
    Text('checkbox value is $isChecked')
  ],
)
```

### Radio button
```dart
Row(
  children: [
    Radio(
      value: 'android',
      groupValue: selectPlatform, // 
      onChanged: (String? value) {
        setState(() {
          selectPlatform = value;
        });
      }
    )
  ]
),
Row(
  children: [
    Radio(
      value: 'ios',
      groupValue: selectPlatform, //
      onChanged: (String? value) {
        setState(() {
          selectPlatform = value;
        });
      }
    )
  ]
)
```

### Slider

slider 위젯은 min, max 속성으로 값을 설정하며 사용자가 막대를 왼쪽, 오른쪽으로 밀면 그 사이 값이 onchanged에 지정한 함수의 매개변수에 전달된다.

```dart
// 슬라이더 출력
Slider(
  value: selectValue,
  min: 0,
  max: 10,
  onChanged: (double value) {
    setState(() {
      selectValue = value;
    });
  }
),
```

### Switch
true / false 를 입력받는 위젯 : 주로 활성/비활성 상태를 선택받을 때 사용한다.

```dart
Switch(
  value: selectValue,
  onChanged: (bool value) {
    setState(() {
      selectValue = value;
    });
  }
),
```

## 11-3 Form 이용하기

입력에 있어서 유효성 검증이 필요하다. 유효성 검증은 개발자 알고리즘
- 유효한지 아닌지 검증
- 유효성에 따른 메시지 뿌리기 등

Form Widget을 이용하면 어느정도 도움을 받을 수 있다.

Form 위젯 그리고 하위의 `FormField<TextField>`를 사용한다.

```
Form
- FormField<TextField>
```

또는 위 클래스를 추상화한 TextFormField를 사용할 수 있다.

Form을 사용할 때 키를 선언해야 한다. 그리고 key를 맵핑한다.
- Form -> key -> State

form field를 사용할 때 유효성 검증 속성을 사용한다.
- validator 속성

Form.validate() 함수를 호출하면 Form 하위의 FormField 속성에 선언된 validator에 등록된 개발자 함수들이 전체 실행된다.

validator 속성에서 return null; 은 유요하다고 본다. 문자열을 return 하면 유효하지 않다고 본다.

- 검증 통과는 null return
- 검증 무효는 문자열 -> 에러메시지 return
- validator 모두가 null 을 return 하면, validate() 가 true를 뱉고, 그렇지 않으면 false를 뱉는다.
- validate() -> true -> save()
- save() 함수가 호출되면 모든 개별 Field의 onSaved : 개발자 함수가 수행된다.

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Test'),
        ),
        body: TestScreen(),
      ),
    );
  }
}
class TestScreen extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return MyFormState();
  }
}
class MyFormState extends State<TestScreen> {
  final _formKey = GlobalKey<FormState>();
  String? firstName;
  String? lastName;
  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Text("Form Test"),
        Form(
          key: _formKey,
          child: Column(
            children: [
              TextFormField(
                decoration: InputDecoration(
                  labelText: 'FirstName',
                ),
                validator: (value) {
                  if(value?.isEmpty ?? false) {
                    return "Please enter first name";
                  }
                  return null;
                },
                onSaved: (String? value) {
                  firstName = value;
                },
              ),
              TextFormField(
                decoration: InputDecoration(
                  labelText: 'LastName',
                ),
                validator: (value) {
                  if(value?.isEmpty ?? false) {
                    return "Please enter last name";
                  }
                  return null;
                },
                onSaved: (String? value) {
                  lastName = value;
                },
              )
            ],
          ),
        ),
        ElevatedButton(
            onPressed: () {
              if(_formKey.currentState?.validate() ?? false) {
                _formKey.currentState?.save();
                print('firstName : $firstName, lastName : $lastName');
              }
            },
            child: Text("submit")
        )
      ],
    );
  }
}
```

## 12-1. List View

리스트 뷰
- 여러 위젯을 세로나 가로로 나열하면서 화면을 벗어날 때 스크롤을 지원하고자 사용하고, 일반 목록 화면처럼 항목을 나열하고자 사용한다. 
- 리스트 뷰는 화면 스크롤을 지원한다.

가로 스크롤을 적용하려면 아래 속성을 적용한다.

`scrollDirection: Axis.horizontal,` 

### 목록 구성하기

ListView(), ListView.builder()를 이용해도 된다. 다만, ListView() 생성자 사용할 시 항목이 많아지는 것은 주의해야 한다.

스크롤할 때 보이지 않던 항목을 준비해서 나오게 하면 효율적이다.


#### 항목을 스크롤에 따라 불러오기 - ListView.builder()
ListView.builder() 생성자에는 itemCount와 itemBuilder라는 속성을 설정한다. 
- itemCount : 리스트 뷰에 출력할 항목 수
- itemBuilder : 항목을 구성하는 위젯을 만들어 주는 함수

*itemCount에 100을 설정하여도 itemBuilder에 지정한 항목 위젯을 만드는 함수가 처음부터 100번 호출되지는 않는다. 처음 화면에 나올 개수만큼만 호출되며 이후 스크롤이 발생해 항목이 더 필요해지면 그때 다시 호출된다.


#### 항목 구분자 설정하기 - ListView.seperated()
ListView.seperated() 생성자는 itemCount와 itemBuilder를 이용해 항목의 개수와 항목을 구성하는 위젯을 지정한다는 면에서 ListVuew.builder()와 같다. but ListVuew.builder()는 항목 구분자를 나타내는 별도의 속성을 제공하지 않는다. 물론 itemBuilder에 지정하는 함수에서 구분자 역할을 하는 위젯을 따로 준비해도 되지만, ListView.seperatred() 생성자를 이용하면 항목 구분자를 조금 더 쉽게 지정할 수 있다.

ListView.seperated() 생성자의 seperatorBuilder 속성 지정하는 함수에서 구분자로 사용할 위젯을 반환하면 된다. 
- Divider 위젯 주로 사용 (가로선)


#### 항목 구성 - ListTile
리스트에서 여러 위젯을 사용할 수 있지만 복잡한 것을 구성할 때 ListTile위젯을 사용하면 편리하다.

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}
class User {
  String name;
  String phone;
  String email;
  User(this.name, this.phone, this.email);
}
class MyApp extends StatelessWidget {
  List<User> users = [
    User('홍길동', '01001', 'a@a.com'),
    User('김길동', '01001', 'a@a.com'),
    User('고길동', '01001', 'a@a.com'),
    User('이길동', '01001', 'a@a.com'),
    User('박길동', '01001', 'a@a.com'),
    User('지길동', '01001', 'a@a.com'),
    User('하길동', '01001', 'a@a.com'),
    User('최길동', '01001', 'a@a.com'),
    User('주길동', '01001', 'a@a.com'),
  ];

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text('Test'),),
        body: ListView.separated(
          itemBuilder: (context, index) {
            return ListTile(
              leading: CircleAvatar(
                radius: 25,
                backgroundImage: AssetImage('resources/images/big.jpeg'),
              ),
              title: Text(users[index].name),
              subtitle: Text(users[index].phone),
              trailing: Icon(Icons.more_vert),
              onTap: () {
                print(users[index].name);
              },
            );
          },
          separatorBuilder: (context, index) {
            return Divider(height: 2, color: Colors.black, );
          },
          itemCount: users.length
        ),
      ),
    );
  }
}
```

## 12-2. 그리드 뷰

그리드 뷰 GridView.builder() 생성자를 제공하며 이 생성자의 itemCount, itemBuilder 속성을 이용해 항목의 개수와 위젯을 지정한다. GridView.builder()에는 꼭 gridDelegate 속성을 설정해야 한다. 이 속성에 SliverGridDelegateWithFixedCrossAxisCount 객체를 지정해 주면 되는데, 이 객체의 crossAxisCount값이 한 줄에 함께 나와야 하는 항목의 개수이다.

그리드 뷰에 방향을 지정하지 않으면 항목을 세로로 나열하며, 이때 crossAxisCount는 가로를 가리킨다. 만약 항목을 가로로 나열하면 scrollDirection 속성에 Axis.horizontal 이라고 설정하며 이때 crossAxisCount는 세로 방향을 가리킨다.


## 12-3 페이지 뷰
PageView와 children에 지정한 여러 위젯이 스와이프 이벤트가 발생할 때 순서대로 출력된다.

페이지 뷰를 이용할 때 PageController 객체에 맨 처음 보일 페이지를 설정할 수 있다.

첫 페이지 번호와 왼쪽 오른쪽에 있는 페이지를 현재 화면에서 어느 정도 보이게 할 것인지도 설정할 수 있다.


## 12-4 다이얼로그 띄우기

pubspec.yaml
- intl: ^0.17.0

다양한 다이얼로그 창을 띄울 수 있다.
- 알림창
- 알림창 + 입력
- Bottom Sheet
- DataPickerDialog
- TimePickerDialog

## 12-5 탭바 뷰

탭 컨트롤러로 지정
- TabBar : 버튼
- TabBarView : Tab 화면

탭 화면을 쉽게 구성할 수 있다.

## 13-1 머터리얼 디자인

여태 실습 코드 시작 위젯이 MaterialApp 이었다. 필수는 아니지만 권장사항이다.

Material Design 철학을 적용하기 위한 위젯

테마, 라우팅 정보 등을 설정할 수 있도록 도와준다.

디버그 배너 보이기 - debugShowCheckedModeBanner
- debugShowCheckedModeBanner: false 주면 된다.


## 13-2 쿠퍼티노 디자인

ios 스타일로도 만들고 싶다? 쿠퍼티노 디자인 사용

flatform API를 사용해서 UI 디자인을 다르게 적용할 수 있다.
- 안드로이드 : material
- ios : cupertino

## 13-3 기기 모양에 대처하기

SafeArea 위젯을 이용해서 노치나 스피커 등으로 내용이 가려지지 않게 디바이스에 맞게 나오도록 한다.

## 13-4 스캐폴드 위젯

대부분의 앱에 사용된다. 스캐폴드 위젯

스캐폴드 위젯은 전형적인 틀을 제공한다.

### appBar
- leading : 왼쪽 출력 위젯
- titls : 타이틀 위젯
- actions : 오른쪽에 사용자 이벤트를 위한 위젯들
- bottoms : 앱바 하단을 구성하기 위한 위젯
- flexibleSpace : 앱바 상단과 하단 사이의 여백을 구성하기 위한 위젯

### bottomNavigationBar
하단 내비바를 나타낼 수 있다. 탭 버튼처럼 구성할 수도 있다.

### 드로어 - drawer
왼쪽에서 안보이다가 끌려 나오는 것

Drawer
- DrawerHeader
- ListTile



## 13-5 커스텀 스크롤 뷰와 슬리버 앱바

앞 절에서 스캐폴드의 앱바를 이용해 화면 상단을 다양하게 꾸밀 수 있다.
그런데 앱바의 세로 크기를 크게 하면 본문 크기가 줄어드는 문제가 있다.
따라서 화면 상단이 커지면 본문이 스크롤될 때 함께 스크롤되어 접혔다가 다시 나오게 해야 한다.

이처럼 화면 한 영역에서 scroll이 발생할 때 다른 영역도 함께 scroll되게 하려면
CustomScrollView를 이용한다. CustomScrollView에 함께 스크롤할 위젯을 배치해야 한다.
즉, 화면 상단을 구성하는 위젯과 스크롤이 발생할 위젯을 모두 CustomScrollView 하위에 추가해야 한다.
모든 위젯이 스크롤 되는 것은 아니고 하위에서 스크롤 정보를 공유할 수 있는 위젯이어야 한다.

## 14-1 내비게이션 사용 :라우터

화면 전환을 제공하기 위해서 Route와 Navigator를 사용한다.

Route는 화면을 지칭하는 객체다. 화면은 위젯 클래스로 만들어야 하지만,
그 위젯 클래스를 포함해 화면을 구성하는 다양한 정보를 Route 객체에 설정하여 화면을 표현한다.
그리고 Navigator 위젯은 Route 객체로 화면을 전환해 준다. 
Navigator는 화면이 전환되면서 생성된 Route들을 스택 구조로 관리하는데, 화면 전환뿐만 아니라 이전 화면으로 되돌아가거나 화면 전환 애니메이션 효과 등 다양한 기법을 제공한다.

### 라우트 이름으로 화면 전환하기

Navigator.push() 함수로 화면을 전환하는 방법은 화면이
많아지고 화면과 화면이 복잡하게 연결되는 구조에서는
비효율적일 수 있다. 이때 MaterialApp의 routes 속성을 
이용하면 앱의 화면을 등록하고 이 정보를 바탕으로 화면을
전환할 수 있다.

- 단순한 화면 구조에서 Navigator 화면 전환
- 복잡한 화면 구조에선 routes 속성 화면 전환


## 14-1. 내비게이션 사용: arguments, onGenerateRoute

화면 전환할 때 데이터 전달

push(), pushNamed(), pop() 함수로 화면을 전환할 때 어떤 함수 쓰냐에 따라 다름.

### push() 함수로 화면 전환할 때 데이터 전달
Navigator.push() 함수로 화면을 전환하려면 push() 함수의 두 번째  매개변수에
라우트를 직접 준비해야 하며 라우트에서 전환할 위젯 객체를 생성해야 한다.
따라서 다음 화면에 전달할 데이터는 생성자의 매개변수로 전달한다.

```dart
// 데이터 전달하기 "hello"
// Page: One -> Two
Navigator.push(
  context,
  MaterialPageRoute(builder: (context) => TwoScreen("hello"))
);
```

### pushNamed() 함수로 화면 전환할 때 데이터 전달
Navigator.pushNamed() 함수로 화면을 전환할 때 데이터를 전달하려면 arguments라는 매개변수를 이용한다.

```dart
// arguments 속성에 10을 지정하여 라우트 이름이 /three인 화면에 10을 전달하는 예
ElevatedButton(
  onPressed: () {
    Navigator.pushNamed(
      context,
      '/three',
      arguments: 10
    );
  },
  child: Text('Go Three Screen'),
),
```

전달한 데이터는 다음 방식으로 얻을 수 있다.
```dart
int arg = ModalRoute.of(context)?.settings.arguments as int;
```


만약 여러 개의 데이터를 전달하려면 JSON으로 데이터를 구성한다.
```dart
// JSON 타입으로 데이터 여러 개 전달하기
Navigator.pushNamed(
  context,
  '/three',
  arguments: {
    "arg1" : 10,
    "arg2" : "hello"
  }
);
```

그러면 데이터를 받는 곳에서는 JSON 타입의 데이터를 Map 객체로 얻어서 이용하면 된다.
```dart
// JSON 타입의 데이터 받기
Map<String, Object> args = ModalRoute.of(context)?.settings.arguments as Map<String, Object>;
```

arguments 속성으로 전달할 데이터는 String, int뿐만 아니라 개발자가 만든 클래스의 객체도 가능하다.
```dart
// 사용자 정의 객체 전달하기
Navigator.pushNamed(
  context,
  '/three',
  arguments: {
    "arg1" : 10,
    "arg2" : "hello",
    "arg3" : User('kim','seoul')
  }
);
```

### pop() 함수로 화면 전환할 때 데이터 전달

Navigator.pop() 함수를 이용해 이전 화면으로 되돌아갈 때 데이터를 전달하려면 pop() 함수의 두 번째 매개변수를 이용한다. 

```dart
// 이전 화면으로 되돌아갈 때 'world' 문자열을 전달하는 예시
ElevatedButton(
  onPressed: () {
    Navigator.pop(context, 'world');
  },
  child: Text('Go Back')
),
```

pop() 함수로 전달한 데이터는 화면을 전환할 때 사용했던 push()나 pushNamed() 함수의 반환값으로 받을 수 있다.

```dart
// 데이터 얻기
onPressed: () async {
  final result = await Navigator.push(
    context,
    MaterialPageRoute(builder: (context) => TwoScreen("hello"))
  );
  print('result: ${result}');
},
```

pop() 함수로 데이터를 전달할 때 문자열이나 숫자뿐만 아니라 개발자가 만든 클래스의 객체도 가능하다.
다음은 User 클래스의 객체를 전달하는 예다.

```dart
// 사용자 정의 객체 전달하기
ElevatedButton (
  onPressed: () {
    Navigator.pop(context, User("kim", "seoul"));
  },
  child: Text('Go Back')
),
```

이렇게 전달한 사용자 정의 객체는 다음처럼 얻을 수 있다.
```dart
// 사용자 정의 객체 얻기
onPressed: () async {
  final result = await Navigator.pushNamed(
    context,
    '/three'
  );
  print('result:${(result as User).name}');
},
```

### 동적 라우트 등록 방법 - onGenerateRoute
앞에서 MaterialApp의 routes 속성에 라우트 이름을 등록하고 이 이름으로 화면을 전환하는 방법을 알아보았다. but MaterialApp에 라우트를 등록할 때 onGenerateRoute 속성을 이용하는 방법도 있다.
routes와 onGenerateRoute 속성의 차이점을 보자.

다음처럼 routes 속성에 라우트를 등록하면 '/two' 이름으로 화면을 전환할 때 항상 TwoScreen이 실행된다.
```dart
// 정적 라우트 등록
routes: {
  ... (생략) ...
  '/two' : (context) => TwoScreen(),
}
```

때로는 같은 라우트 이름으로 화면을 전환하더라도 상황에 따라
다른 화면이 나와야 할 수 있다. 
또한 화면 전환할 때 전달된 데이터를 분석해 데이터를 추가하거나 제거할 수 있다.

```dart
// routes와 onGenerateRoute 속성에 똑같은 라우트 이름 등록
return MaterialApp(
  initialRoute: '/',
  routes: {
    '/': (context) => OneScreen(),
    '/two' : (context) => TwoScreen(),
    '/three' : (context) => ThreeScreen()
  },
  onGenerateRoute : (settings) {
    if (settings.name == '/two') {
      return MaterialPageRoute(
        builder: (context) => ThreeScreen(),
        settings: settings
      );
    } else if (settings.name == '/four') {
      return MaterialPageRoute(
        builder: (context) => ThreeScreen(),
        settings: settings
      );
    }
  }
)
```


## 14-1. 내비게이터 스택 제어하기

내비게이터 스크린은 기본적으로 스택구조로 되어 있음.

스크린은 싱글톤으로 관리되지 않는다. 같은 화면 객체가 계속 쌓일 수 있다.

기본 화면 구조는 Stack

### mybePop()과 canPop() 함수

mybePop은 화면이 스택에 하나만 남았을 때 앱 종료하지 않고 남긴다.

혹은 canPop으로 체크한 다음에 pop을 실행할 수 있다. 결과적으로 mybePop과 동일한 결과를 보일 수 있다.

### pushReplacementNamed(), popAndPushNamed() 함수

pushReplacementNamed(), popAndPushNamed()는 현재 위젯을 대체하거나 제거한 후 새로운 위젯을 실행하는 함수다.

로그인 화면 같이 임시로 나올 화면을 호출할 때 사용한다.

### PushNamedAndRemoveUntil()
세번째 매개 변수에 true면 일반 push랑 동일하다.
그런데 false가 return 되면 전체 스택을 날린다.
혹은 특정 화면의 이름이 지정되었다면 특정 위치 이전까지 다 날린다.

### popUntil() 함수
몇개의 화면이 쌓였든지, 지정된 화면까지 스택에서 모두 날린다.


## 14-2 내비게이션 2.0

### 내비게이션 2.0 기본 구조
- page 출력할 화면 정보
- Router 페이지 정보를 스택 구조로 가지는 위젯
- RouteInformationParser 라우팅 요청 분석
- RouterDelegate 다양한 상황에 맞는 라우팅 처리

딥링크 : 화면의 중간 화면만 뿌릴 수 있는 구조.

딥링크는 스택에 쌓기 나름이다.

딥링크 예시: 카톡 
- 알림>채팅창>채팅 목록이 나오는 케이스


### 라우터 델리게이트와 정보 분석기
화면 구성이 복잡할 때 라우터 델리게이트(RouterDelegate)와
 라우트 정보 분석기(RouteInformationParser)를 이용할 수도 있다. 
 라우트 정보 분석기는 화면을 전환하는 라우트 정보를 분석해 경로(RoutePath)에 담아 준다.
 라우터 델리게이트는 라우팅 대리자로서 정보 분석기가 분석한 경로를 받아 내비게이터를 만들어 준다.
 따라서 라우터 델리게이트를 이용하면 RouterDelegate가 라우팅을 담당한다.

#### 라우트 경로 클래스 작성하기
라우트 경로는 라우팅을 위한 정보를 담는 개발자 클래스다. 이 클래스를 작성하는 규칙은 특별히 없으며
앱의 라우팅 설계에 맞게 작성하면 된다.

다음 예시를 보자. 라우팅 정보로 상세 보기 화면에 전달할 id값을 속성으로 선언한다. 
이 id값이 없으면 홈 화면을 출력하고, 있으면 상세 보기 화면을 출력하면서 id값을 전달한다.
그리고 이 객체를 쉽게 생성할 수 있도록 생성자를 2개 선언한다.

```dart
// 라우트 경로 클래스
class MyRoutePath {
  String? id;

  MyRoutePath.home() : this.id = null;
  MyRoutePath.detail(this.id);
}
```

#### 라우트 정보 분석기 작성하기
라우트 정보 분석기는 RouteInformationParser를 상속받아 작성하는 개발자 클래스다.
이 클래스에서 이용할 라우트 경로 객체를 제네릭 타입으로 지정해 준다.

```dart
// 라우트 정보 분석기
class MyRouteInformationParser extends RouteInformationParser<MyRoutePath> {
  ... (생략) ...
}
```
RouteInformationParser는 2가지 작업을 하는 클래스다.
- 앱의 라우팅 정보 분석 : 플랫폼이 앱을 처음 실행하거나 라우팅될 때 정보를 분석한다.
- 앱의 라우팅 정보 저장 : 라우팅이 결정된 후 현재 라우팅 상태를 저장한다.

앱의 라우팅 분석은 parseRouteInformation() 함수에 구현하며 저장은 restoreRouteInformation() 함수에 구현한다.
parseRouteInformation() 함수는 꼭 재정의해야 하며 restoreRouteInformation() 함수는 선택이다.


```dart
// parseRouteInformation() 함수를 구현한 예
@override
Future<MyRoutePath> parseRouteInformation(RouteInformation routeInfomation) async {
  final uri = Uri.parse(routeInformation.location ?? '/');
  print('routeInformation.location : ${routeInformation.location}');
  if (uri.pathSegments.length >= 2) {
    var remaining = uri.pathSegments[1];
    return MyRoutePath.detail(remaining);
  } else {
    return MyRoutePath.home();
  }
}

```
parseRouteInformation() 함수의 매개변수가 RouteInformation 객체이며 플랫폼에서 앱에 전달한 라우팅 정보이다.
RouteInformation.location값은 문자열이며 일종의 앱이 실행되기 위한 URL이라고 보면 된다.
안드로이드, iOS 앱으로 빌드해서 실행하면 대부분 null 이다. 즉, 앱을 실행하기 위한 특별한 URL 조건이 없다는 의미이다.

그런데 웹 앱으로 빌드해서 실행하면 특정 URL 문자열이 전달될 수 있다. 만약 앱의 URL을 http://localhost:54603/#/ 으로
가정하면 RouteInformaion.location값은 null이다. 그런데 앱의 URL을 http://localhost:54603/#/detail/world/10 으로
가정하면 RouteInformation.location값은 /hello/world/10이다. 결국 앱이 실행되었을 때 이런 URL 등의 정보를 매개변수로
받아 어떤 정보로 실행된 것인지를 분석해 그 결과를 라우트 경로에 담아서 반환해 주면 된다.

restoreRouteInformation() 함수는 앱의 현재 라우팅 상태를 저장한다. 이 함수는 앱이 실행되면서 여러 번 호출될 수 있다.
라우터 델리게이트에서 특정 화면으로 이동이 결정되면 자동으로 호출된다. 따라서 매개변수는 라우트 경로이며 반환값은 저장할 
정보를 담고 있는 RouteInformation 객체다.

```dart
// restoreRouteInformation() 함수 구현
@override
RouteInformation restoreRouteInformation(MyRoutePath configureation) {
  print('restoreRouteInformation.. id : ${configureation.id}');
  if (configureation.id != null) 
    return RouteInformaion(location: '/detail/${configureation.id}');
  else
    return RouteInformaion(location: '/');
}
```

#### 라우트 델리게이트 작성하기
라우터 델리데이트는 라우트 경로를 분석해 적절하게 라우팅하는 내비게이터를 만들어 준다. 
라우터 델리게이트는 RouterDelegate를 상속받아 작성해야 하며, with로 ChangeNotifier와 PopNavigatorDelegateMixin을 등록해야 한다.

```dart
// 라우트 델리게이트
class MyRouterDelegate extends RouterDelegate<MyRouterPath> with ChangeNotifier, PopNavigatorRouterDelegateMixin<MyRoutePath> {
  ... (생략) ...
}
```

라우터 델리게이트는 라우팅 정보에 맞는 화면을 구성에 라우팅되게 하는 역할이므로 build() 함수에서 상황에 맞는 페이지를 포함하는 내비게이터를 반환해야 하며, 이 내비게이터 구성대로 화면이 출력한다.

```dart
// 내비게이터 구현하기
final GlobalKey<NavigatorState> navigatorKey = GlobalKey<NavigatorState>();

@override
Widget build(BuildContext context) {
  return Navigator( // -> widget
    key: navigatorKey,
    pages: [
      MaterialPage(child: HomeScreen(_handleOnPressed)),
      if(selectId != null) MaterialPage(child: DetailScreen(selectId))
    ],
    onPopPage: (route, result) {
      ... (생략) ...
    },
  );
}
```

RouteDelegate 클래스에는 currentConfiguration() 함수를 등록할 수도 있다.
필수는 아니지만 currentConfiguration() 함수를 등록하면 build() 함수 호출 직전에 자동으로 호출된다.
이 함수에서 만드는 라우트 경로가 정보 분석기의 restoreRouteInformation() 함수에 전달되어 앱의 라우팅 상태로 저장된다.
결국 라우팅 때마다 호출되는 currentConfiguration() 함수에서 만든 정보가 앱의 라우팅 정보로 저장된다.
```dart
@override
MyRoutePath get currentConfiguration {
  if (selectId != null) {
    return MyRoutePath.detail(selectId);
  } else {
    return MyRoutePath.home();
  }
}
```

setNewRoutePath() 함수는 꼭 재정의해야 하며 라우터 델리게이트가 초기화될 때 한 번만 호출된다.
setNewRoutePath() 함수의 매개변수로 전달되는 라우트 경로는 정보 분석기의 parseRouteInformation() 
함수에서 반환한 값이다. 즉, 정보 분석기에서 처음에 앱의 라우팅 정보를 분석하고 그 결과를 델리게이트의
setNewRoutePath()에 전달해 초기 라우팅 정보를 만든다.

```dart
@override
Future<void> setNewRoutePath(MyRoutePath configuration) async {
  print('MyRouterDelegate... setNewRoutePath ... id : ${configuration.id}');
  if(configuration.id != null) {
    selectId = configuration.id;
  }
}
```

라우터 델리게이트와 정보 분석기를 이용하면 화면이 나오기까지 여러 함수가 호출되는데 이를 그림으로 보면 다음과 같다. 처음 라우팅되는 순간의 흐름이다.

![Alt text](./imgs/router-delegate.png)

앱에서 버튼을 누를 때 화면을 전환하려면 라우터 델리게이트의 notifyListeners() 함수를 호출한다.
다음 코드는 사용자가 버튼을 누를 때 호출할 함수이다.
함수에서 적절한 이벤트를 처리한 후 notifyListeners() 함수를 호출해 화면을 전환한다.

```dart
void _handleOnPressed(String id) {
  selectId = id;
  print('MyRouterDelegate... notifylistener call..');
  notifyListeners();
}
```

앱의 화면이 전환될 때 라우터 델리게이터와 정보 분석기의 함수 호출 흐름은 다음 그림과 같다.

![Alt text](./imgs/router-delegate2.png)

#### 라우터 델리게이트와 정보 분석기 등록하기
라우터 델리게이트와 정보 분석기를 만들었으면 이제 MaterialApp에 다음처럼 등록한다.

```dart
class _MainAppState extends State<MainApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp.router(
      routerDelegate: MyRouterDelegate(),
      routeInformationParser: MyRouteInformationParser(),
    );
  }
}
```

