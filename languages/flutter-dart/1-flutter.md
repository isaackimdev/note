## 1. flutter
플러터(flutter) 하는 이유는 쉽게 말해서 크로스 플랫폼에서 동작하는 앱을 만들기 위함이다. Android, iOS, Windows, macOS, Linux, Web, Embedded, WebApp 등 여러 플랫폼에서 동작하는 앱을 같은 코드로 개발할 수 있다.

- Flutter는 __크로스 플랫폼__ 프레임워크다.
- 플러터는 다트(Dart) 언어를 사용한다.
- 다트로 작성한 하나의 코드로 여러 플랫폼에 App으로 개발된다.
- 뛰어난 성능과 강력한 애니메이션 기법을 제공한다.
- flutter는 화면을 출력할 때 플러터 엔진에 스키아라는 그래픽 엔진을 이용해 직접 렌더링한다.
- 위 이유로 __화면 렌더링 속도가 빠르다.__
- 따라서 자연스럽고 __강력한 애니메이션을 구현할 수 있다.__
- flutter는 네이티브와 연동하지 않고 __스키아 엔진__을 이용해 플러터에서 화면을 직접 출력하고 사용자 이벤트를 처리한다. 따라서 성능이 뛰어날 뿐만 아니라 모든 플랫폼에서 똑같은 화면을 제공할 수 있다.
- 네이티브 기능과 최소한으로만 연동한다.


### flutter 개발 환경 구축하기

#### 개발 환경
- OS : windows 10, 11
- IDE : Android studio

#### 개발 환경 세팅 순서
1. Flutter SDK 설치하기
    - https://flutter.dev/ -> [Get started] -> Windows -> flutter sdk install -> 압축 해제
2. window 기준 c:/ 를 root로 위치 
3. path 설정 (환경 변수 설정) : flutter-sdk/bin 경로 설정
    - 내 PC > 우클릭 속성 > 고급 시스템 설정 > 환경 변수 > path 설정
4. IDE : Android studio 설치 후 -> 실행
    - IDE는 Android studio를 많이 사용한다.
5. Android Studio에 flutter plug-in / dart plug-in 설치하기
    - IDE 초기 화면 Flugins 탭에서 flutter, dart 플러그인을 설치한다.
6. flutter project 생성하기
    - Flutter SDK path 지정하기 
    - C:/flutter_windows_3.7.3/flutter 까지만.
    - Android language : Kotlin
    - iOS language : Swift
    - Platforms : Android, iOS
7. 프로젝트에서 가상기기(AVD : Android Virtual Device) 만들기
    - Device Manage
        - Create device
            - Pixel 2 기본값 설치 (android)
            - x86 images -> Tiramisu(23.10최신) > download
8. 에뮬레이터 구동해보기
9. Hot reload 테스트하기
    - {project root}/lib/main.dart 수정하기

#### flutter project 분석
- android : 안드로이드 앱 구성
- ios : ios 앱 구성
- lib : Dart file
    - main.dart : 앱의 메인 다트 파일
- test : Test dart file
- pubspec.yaml : 플러터 프로젝트의 메인 환경 파일
    - 빌드와 관련된 각종 설정
    - package, resource 추가 관련 설정
    - 플러터 프로젝트의 빌더 파일
      - package dependency
      - assets / resources


#### main.dart 파일 분석하기

__import 구문__ 
```dart
import 'package:flutter/material.dart';
```
import 구문은 다른 dart file을 불러올 때 사용. 플러터에서 제공하는 패키지일 수도 있고, pubspec.yaml 파일에 등록한 외부 패키지일 수도 있다. 또는 개발자가 직접 작성한 dart file 일 수 있다. 

Java랑 비슷해보인다.


__main() 함수__
```dart
void main() {
  runApp(const MyApp());
}
```
프로그램의 진입점(entry point)인 main() 함수다. main() 함수는 __다트 엔진__ 의 진입점으로서 다트 엔진이 main()을 호출하면서 앱이 실행된다. main()에서 runApp() 함수를 호출하고 이때 위젯을 지정한다. 위젯은 화면을 구성하는 클래스라고 보면 된다.


__MyApp 클래스__

```dart
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

```
위젯 클래스는 StatelessWidget, StatefulWidget 중 하나를 상속받는다. build() 함수는 위젯을 어떻게 구성할지를 명시한다. 위젯 클래스가 실행되면 자동으로 build() 함수가 호출된다. build 함수 내에 MaterialApp(플러터 제공 위젯), MyHomePage(커스텀 위젯)도 위젯 클래스다.

위젯 클래스는 화면을 구성한다. build() 함수는 꼭 출력을 해야 한다. build() 함수는 화면을 출력한다고 볼 수 있다. Widget을 return 한다는 것을 확인할 수 있다.


__MyHomePage 클래스__
```dart
class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}
```
StatefulWidget은 화면 위젯에 출력되는 데이터 등을 별도의 State 클래스에 지정하는데 _MyHomePageState 클래스가 State클래스다. StatefulWidget 클래스가 실행되면 createState() 함수가 자동으로 호출되며 이 함수에서 StatefulWidget을 위한 State 클래스의 객체를 반환한다.

Widget은 StatelessWidget, StatefulWidget 클래스를 상속 받아서 사용하게 된다. StatefulWidget을 사용하는 경우에는 StatelessWidget과 달리 State 클래스가 함께 사용된다.

___MyHomePageState 클래스__
```dart
class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const Text(
              'HelloWorld',
            ),
            Text(
              '$_counter',
              style: Theme.of(context).textTheme.headlineMedium,
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: const Icon(Icons.add),
      ),
    );
  }
}
```
State(_MyHomePageState) 클래스가 호출되면 build 메서드를 호출한다. build 메서드는 State의 setState() 메서드가 호출되었을 때마다 다시 호출한다. 따라서 데이터의 변화를 화면/위젯에 반영하기 위해선 setState()를 다시 호출한다.

Scaffold는 appBar, body, floatingActionButton 등으로 화면의 구성 요서를 묶어 주는 위젯이다.

__실행 순서__
main() -> MyApp -> MyHomePage -> _MyHomePageState

화면을 구성하는 대부분은 _MyHomePageState의 build() 함수에 작성된다.



### 외부패키지 등록
플러터 기본 제공하는 기능이 아닌 외부 패키지를 등록할 때에는 보통 pub.dev 사이트에서 외부 패키지를 받아서 사용한다.

외부 패키지는 Null safety 라고 되어 있는 것을 주로 쓰는 것이 좋다.

flutter 프로젝트에선 외부 패키지를 사용하려면 pubspec.yaml파일에 패키지 정보를 등록해야 한다.

__flutter 프로젝트에 외부 패키지 등록하기__
다음은 외부 패키지 __english_words__ 패키지를 추가했다.
```yaml
# pubspec.yaml 파일 (환경 파일, build)
 ... (생량) ...
dependencies:
  flutter:
    sdk: flutter
  cupertino_icons: ^1.0.2
  english_words: ^4.0.0 # 추가한 부분
dev_dependencies:
  flutter_test:
    sdk: flutter
... (생량) ...
```
pubspec.yaml 파일을 열면 dependencies와 dev_dependencies 항목이 보이는데 이곳에 패키지를 등록한다. dependencies는 앱이 빌드되어 플랫폼에서 실행될 때 필요한 패키지를 의미한다. 그런데 앱을 개발할 때만 이용하는 패키지는 앱을 빌드할 때 포함할 필요가 없다. 이런 패키지는 dev_dependencies에 등록한다.

패키지 등록 후에 Android studio에서 pubspec.yaml 파일 위 [__Pub get__]을 클릭해 패키지를 내려 받는다. 다운로드 받은 내용이 pubspec.lock 파일에 자동 등록된다.

플러터 명령 줄에 표시된 명령과 의미는 각각 다음과 같다.

- Pub get : 패키지 다운로드
- Pub upgrade : 패키지를 최신 버전으로 업그레이드
- Pub outdated : 오래된 패키지 종속성 식별
- Flutter doctor : 플러터 개발 환경 점검



### 외부패키지 사용하기

위에서 추가했던 english_words 외부 패키지는 다음 구문으로 추가할 수 있다.
```dart
import 'package:english_words/english_words.dart';
```
추가한 외부 패키지 english_words를 사용한 간단한 테스트 앱 코드를 작성한다. 아래 코드를 작성한 다음 Android studio에서 실행하면 랜덤 영단어를 보여주는 앱이 된다.

```dart
import 'package:flutter/material.dart';
import 'package:english_words/english_words.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final wordPair = WordPair.random();
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Test"),
        ),
        body: Center(
          child: Text('${wordPair}'),
        ),
      )
    );
  }
}
```
실습환경에서는 다음과 같은 순서로 진행하였다.
1. lib/ch2/test.dart 파일 생성 후 위 코드 작성
2. test.dart 파일 run


