---
title: Spring Framework & Spring Boot & RESTful API
date: 2023-05-29 00:00:00 +0000
categories: [Spring, Spring Boot]
tags: [spring, framework, spring boot, restful api]
author: isaac
comments: true
---

# Spring framework & Spring Boot

## Spring

Spring의 역사

- EJB를 주 프레임워크로 사용할 때 불편했던 점들을 해소
- 2002년 로드 존슨이 출판한 도서 Expert One-on-One J2EE Design and Development 에 선보인 코드가 Spring의 근간이 됨
- 이 도서를 읽은 개발자들이 "코드가 책으로만 존재하기에는 너무 아깝다"라고 하며 로드 존슨의 허가를 받은 뒤 프레임워크로 발전시킴
- 2003년 6월 Apache 2.0 License로 공개됨

[spring](https://spring.io) 버전 약력
- 1.0 : 2004년 3월
- 2.0 : 2006년 10월
- 2.5 : 2007년 11월
- 3.0 : 2009년 12월
- 3.1 : 2011년 12월
- 4.0 : 2013년 12월
- 5.0 : 2017년

## Spring Framework Overview

Spring Framework 란?

Java 엔터프라이즈 개발을 편하게 해주는 Open Source __경량급 애플리케이션 프레임워크__ 

- 애플리케이션 프레임워크
    - 특정 계층/기술/업무 분야에 국한되지 않고 애플리케이션의 전 영역을 포괄하는 범용적인 프레임워크를 말한다.
- 경량급 프레임워크
    - 단순한 웹 컨테이너에서도 엔터프라이즈 개발의 고급기술을 대부분 사용할 수 있다.
- 엔터프라이즈 개발 용이
    - 개발자가 복잡하고 실수하기 쉬운 Low Level에 많이 신경 쓰지 않으면서 Business Logic 개발에 전념할 수 있도록 해줌
- 오픈소스
    - Spring은 OpenSource의 장점을 충분히 취하면서 동시에 OpenSource 제품의 단점과 한계를 잘 극복함

## Features of Spring Framework
1. Spring 컨테이너 역할  
- Spring 컨테이너는 Java 객체의 Life Cycle을 관리하며, Spring 컨테이너로부터 필요한 객체를 가져와 사용할 수 있음
- Spring Core = Spring Container : spring링에 로드된 빈(bean), Component의 Life Cycle을 자동으로 관리함.
2. DI(Dependency Injection) 지원
- Spring은 설정 파일이나 어노테이션을 통해서 객체 간의 의존관계를 설정할 수 있도록 하고 있음
3. AOP(Aspect Oriented Programming) 지원
- Spring은 트랜잭션이나 로깅, 보안과 같이 공통적으로 필요로 하는 모듈들을 실제 핵심 모듈에서 분리해서 적용할 수 있음
4. POJO(Plain Old Java Object) 지원
- Spring 컨테이너에 저장되는 Java객체는 특정한 인터페이스를 구현하거나, 특정 클래스를 상속받지 않아도 됨
5. Transaction 처리를 위한 일관된 방법을 지원
- JDBC, JTA 등 어떤 트랜잭션을 사용하던 설정을 통해 정보를
관리하므로 트랜잭션 구현에 상관없이 동일한 코드 사용 가능
6. 영속성(Persistence)과 관련된 다양한 API 지원
- Spring은 MyBatis, Hibernate 등 데이터베이스 처리를 위한
ORM(Object Relational Mapping) 프레임워크들과의 연동 지원

## Spring & Maven

Spring의 시작
- Spring을 사용하기 위해 Maven Build가 필요함

Maven
- Spring의 의존 라이브러리를 간편하게 추가할 수 있도록 의존성 주입을 제공
- 그 외 Open source library도 Maven Repository에 업로드 함으로써 대부분의 Library를 자동으로 추가 가능함
- 프로젝트의 구조를 자동으로 구성함
- Build를 통해 배포를 위한 파일을 생성함
- 3rd party depency 관리
- gradle도 본질적으로 같다고 봐도 무방함.

### 정리
__스프링은 오픈소스 경량형 엔터프라이즈 급 프레임워크이고, 자바 서비스 개발에서의 사실상 표준 프레임워크이다.__


## Spring Boot
Spring Boot - 차세대 Spring Framework
- Spring 기반 production-ready application 개발
- Convertion over Configuration을 따름 (Convertion is spring best practice)
- Tomcat이 내장되어 단독으로 실행 가능
- 설정을 최대한 줄이고 XML 설정파일 필요 없음

create spring boot project (scaffolding)
- https://start.spring.io


Entry Point / Start point : 프로젝트 시작, 진입점
- example-path : project/src/main/java/com/spring/app/__Application.java__

```java
@SpringBootApplication  // 컴포넌트 구성과 자동 구성
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
```
Spring Boot Annotation으로 기본적인 설정을 마치고 시작할 수 있음. 

- @SpringBootApplication
    - @Configuration
    - @ComponentScan
    - @EnableAutoConfiguration  

### 추가 설정 파일
Spring boot settings file
- application.properties or application.yml
    - 선태적인 파일 (사용하지 않아도 됨)
    - 명시적으로 요청하는 부분이 없음
    - Spring boot 가 로드되면 자동으로 이 파일을 로드
- 기존의 XML 설정파일도 가져올 수 있음
    - Application.java 파일에 아래 어노테이션 추가
    - @ImportResource("classpath:spring/root-context.xml)

### 기본적으로 많이 사용하는 dependency
Spring Boot developer tool
- dependency : spring-boot-devtools
- spring boot 개발모드 지원
    - thymeleaf 등 템플릿에 대한 개발 캐싱을 비활성화 처리
    - 소스 변경 시 boot restart 하여 반영


Spring Boot test
- dependency : spring-boot-starter-test
- test 의존성은 spring boot project 생성 시 자동 추가 됨
- example-path : project/src/test/java/com/spring/app/ApplicationTests.java


```java
@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

}
```

### 정리
- spring 5, spring boot 2.x는 java 8 필요
- spring boot 는 best practice에 따라 자동으로 설정을 수행한다.


## RESTful
Web service : http 통신으로 데이터를 주고 받는 서비스
- SOAP : XML 중심으로 데이터 교환 중심
- REST : JSON 중심, 사실상 표준으로 사용하는 방식
- HTTP 전송 규약으로 사용
    - HTTP : 인터넷 상에서 데이터를 주고 받기 위한 server/client 구조의 프로토콜
- HTTP request/response 모델
    - client > request > web server
    - client < response < web server

- HTTP 프로토콜은 Header, Body로 구성되어 있음
    - Header : Start Line / Header / Blank Line / Body
    - Body : Header Feild Name [ Method / blank / URL ] etc

- Header에는 meta-data, Body에는 Data 를 담음.
- HTTP Methods : Cilent Request Type - Server는 Method를 확인하여 적당한 Response
- REST는 HTTP Method를 사용한다.

|Method|Description|
|-|-|
|__GET__|자원 요청|
|__POST__|Entity를 포함한 자원 요청|
|HEAD|HTTP Header 정보만 수신|
|TRACE|Request의 루프백 테스트|
|__PUT__|URL에 자원을 생성
|__DELETE__|URL의 자원을 삭제|
|OPTIONS|응답 가능한 HTTP 메소드를 요청|
|CONNECT|터널링의 목적으로 연결 요청 (프록시에서 사용함)|

- Web Browser developer tool 에서 HTTP 메시지 전송에 대한 정보를 제공함. Network Tab

- URL 식별자로 사용, 컨텐츠에 접근하기 위한 위치 정보 (end-point)
    - example : https://abc.com/index.html
        - https:// -> protocol
        - abc.com -> server
        - index.html -> resource

- Server와 Client 서로 간 의존성이 줄어 듦
- RESTful API가 필요한 이유
    - Application의 분리 및 통합
    - 다양한 client의 등장
    - 최근 server program은 다양한 browser와 android, mac과 같은 mobile device에서도 통신할 수 있어야 하기 때문이다.

## RESTful 기반 웹 서비스
Roy Fielding 박사학위 논문에서 제안 (2000년도)

웹 아키텍처가 웹의 본래 설계의 우수성을 활용하지 못하므로 웹의 장점을 최대한 활용할 수 있는 네트워크 기반의 아키텍처를 제안

Data가 중요해지면서 REST 작업이 표준이 되고 있음.

소프트웨어는 대체되어도 수년간 쌓인 데이터는 대체할 수 없다. 
- SOAP는 동작과 프로세싱에 집중 (application에 부담)
- REST는 데이터 처리 집중

스프링 3.0부터 REST 작업에 대한 최고 수준의 지원을 제공

RESTful 웹 서비스 (Representational State Transfer, 2000년)
- HTTP 프로토콜로 데이터를 전달하는 framework
- 핵심은 web에 개발된 resource 이용

REST 아키텍처 스타일에 따라 정의되고 이용됨
- REST API : 소유자의 자원에 접근할 수 있는 API
- RESTful : REST API를 제공하는 웹 서비스

### 정리
- REST는 웹 서비스의 사실상 표준이다.
- Spring, Spring Boot는 REST를 적극적으로 지원한다.



## REST란 무엇인가?
- 2000년에 HTTP 프로토콜 저자 중 한명인 Roy Fielding 박사 논문에 소개
- 기존 웹 서비스들이 HTTP를 적극적으로 활용하지 못한 문제를 해결하기 위해 제안됨
- HTTP를 보다 HTTP 답게 만들기 위한 __방법론__ 으로 볼 수 있음
- 철저히 Resource 중심적 설계를 중요시하고 (데이터 중심적)
    - Create - POST
    - Read - GET
    - Update - PUT
    - Delete - DELETE와 같이 HTTP 4가지 메소드를 용도에 맞게 사용
- 오늘날 Google, Amazon, Flickr와 같은 Open Source 업체들이 주도 하에 적극 적용되어, De-facto Standard로 자리잡음

## REST 원리 및 원칙 (제약조건)
- 확장성 있는 웹 서비스를 위한 Software 아키텍처 적인 접근
- Client - Server
    - 서로 간 의존성 낮음
- Stateless
    - Client의 상태를 서버에 저장하지 않음 (확장성)
- Cacheable : 같은 요청이면 같은 응답, 캐시 처리 기능
    - 캐싱 기능을 사용하면 응답시간, 성능, 서버의 자원 이용률을 향상시킬 수 있음.
- Layered system architecture
- Code on demand (optional) : 최근엔 거의 사용되지 않는다.
- Uniform interface
    - REST의 코어인 리소스는 URI에 의해 식별됨
    - 데이터 구조(data representation)는 강제하지 않음 (주로 XML 또는 JSON)

### Client - Server
Client를 Server로부터 분리
- View와 Data를 분리
- Portability(이동성)를 향상
- REST Server는 Resource를 관리하는 API를 제공
    - Client는 사용자 인증이나 Context(Session, Login 정보) 직접 관리
    - Server는 UI, User State에 상관없이 Server 기능에 집중 (단순화, 확장성)

server 
- Stateless Server
- [API][Resources]

### Stateless
Server가 상태를 갖지 않는다. Session 정보와 같은 context를 저장할 필요가 없다.

pure function, 함수형 programming

Client는 자신을 구분하기 위해 Server에게 충분한 정보를 전달해야 한다.
- API Key 또는 Token

    Stateless
    - No session
    - No login and has no basket
    - Static content

    Stateful
    - session
    - Logged in or has a basket
    - Dynamic content

Cacheable
- Http 프로토콜의 Caching 기능을 적용할 수 있음
    - 웹 서비스의 60~80%가 GET 방식의 요청
    - 구현은 HTTP 프로토콜 표준인 "Last-Modified" 태그나 E-Tag를 이용

<!-- ![Cach](https://i-sak.github.io/assets/img/stateless-server-cacheable.png) -->

### Layered System Architecture
시스템 스케일링을 위해 Gateway, Proxy Server, Firewall 과 같은 또 다른 Layer들을 수용할 수 있음

### Code on Demand (optional)
서버는 실행 가능한 코드를 클라이언트에게 전송
- Client의 기능을 일시적으로 확장하거나 커스터마이징 가능
- Java Applet, JavaScript가 대표적 예
- Client에서 Server로 부터 code를 받아서 실행하는 구조

### Uniform Interface
- REST 디자인 constraints에서 가장 기본적인 제약
- 통일된 인터페이스를 통해 기술과 플랫폼에 상관없이 사용 가능
- Uniform Interface는 다음 4가지로 설명할 수 있음.
    - __Resource Identifier : URI__
    - __Resource Representations__
    - __Self-Descriptive Message__
    - __HATEOAS (Hypermedia As The Engine Of Application State)__

__Resource Identifier - URI__
- Uniform Interface는 URI, URL을 어떤 요청의 End-point로 쓰겠다는 것
- Resource는 서비스나 정보를 제공하는 모든 것들이 될 수 있음
    - 주문, 송장, DB의 레코드, 검색 결과 등
    - 웹 상에서 주소를 통해 접근 될 수 있음
        - 즉, 리소스는 URI를 반드시 갖는다.
    - URI 정의는 동사형이 아닌 명사형으로 정의하도록 권장됨



```
URI example : http://www.google.co.kr:80/hakawati/uri.php?url=urn#Rnfwoa

위(▲) URI 에 대한 설명
- http : protocol
- www : sub domain
- google : domain
- co : ccTLD (Country Code Top Level Domain)
- kr : TLD (Top Level Domain)
- 80 : port
- hakawati : path
- uri : page
- php : extension
- url=urn : parameter
- #Rnfwoa : Anchor
- google.co.kr:80/hakawati/uri.php?url=urn : URN
- www.google.co.kr:80/hakawati/ : URL
- URL + URN = URI
```



__Resource Representations__
- Representation? Resource 는 Unique ID로 하나 이상의 URI 뿐만 아니라, 다양한 방법으로 설명(대표)되는 Representation을 가질 수 있음
    - Representation에 대한 접근을 위한 URL을 가지고
    - HTTP 4가지 메서드(POST/GET/PUT/DELETE)를 통해 CRUD 할 수 있음
    - 같은 URL 요청이지만 Method에 따라 다른 response를 취한다. 또 다른 resource의 표현으로 representation 이라고 한다.
    - 서버가 보내준 것은 Resource가 아니라 Representation
    - REST (REpresentation State Transfer)
    - 요청 Negotation 우선순위에 따라 리소스를 달리 표현하여 representation이라 한다.

```
URL
    Resource
        Representation
            URL
                - GET
                - POST 
                - PUT
                - DELETE
```


<!-- ![Representation](https://i-sak.github.io/assets/img/representation.png) -->



GET Method 정의
```
The GET method requests transfer of a current selected representation for the target resource.
```
- Target resource에 대한 현재의 선택된 representation 하나를 반환함
- 리소스는 HTTP 요청의 대상이지만, 리소스의 개념을 제한하지 않음

- Representation 이란?
    - 어떤 리소스의 특정 시점의 상태를 반영하고 있는 정보
    - 다음 두 가지로 구성됨
        - Representation data
        - Representation metadata


__Representation 사례__

영어 사용자와 한국어 사용자를 위한 representation

```
Content-Type: text/plain
Content-Language: en

hello
```

```
Content-Type: text/plain
Content-Language: ko

안녕하세요
```

```
Content-Type: text/html; charset=UTF-8
Content-Language: en

<html><body>hello</body></html>
```

```
Content-Type: text/html; charset=UTF-8
Content-Language: ko

<html><body>안녕하세요</body></html>
```

- Client와 server 간의 내용 협상(Content negotiation)을 통해 선택 됨
- 일반적으로 사전 협상(proactive negotiation)에 의해 서버가 선택
- 적절한 representation이 존재하지 않는다면 406 Not Acceptable로 응답
- URI 가 동일하다면 같은 리소스임
- 하나의 resource를 다양하게 표현할 수도 있음, 확장성을 고려할 수 있음


__Self-Descriptive Message__

REST는 Stateless
- Client - Server 간 충분한 설명적인 메시지가 필요
    - HTTP method
    - HTTP state code
    - HTTP Header


```
Self-descriptive messages

Request
    GET /articles/1234 HTTP/1.1
    Host: test.host.com
    User-Agent: Mozilla/5.0
    Accept: application/json
    Connection: close
    (empty line)

Server Response
    HTTP/1.1 200 OK
    Date: Web, 16 Mar 2016 11:20:59 GMT
    Server: Apache
    Content-Language: ru
    Content-Type: application/json;
    charset=utf-8
    Content-Length: 1234
    Connection: close
    (empty line)
    (json representation)
```



__HATEOAS (Hypermedia As The Engine Of Application State)__

- HATEOAS 메시지를 보내는 것은 어플리케이션의 상태를 변화시킴
- HTTP 응답에 다음 Action이나 관계되는 resource에 대한 HTTP Link를 함께 리턴
    - 페이지 처리의 경우 리턴 시, 전후 페이지에 대한 링크를 제공
    - 연관된 리소스에 대한 디테일한 링크를 표시
- 실제 오늘 날에는 HATEOAS를 구현하거나 적용하지 않는 경우가 많다고 함.
- 실제 요청한 것에 대해서 representation을 보내주는 것을 뜻함
- 기계를 위한 것일 수 있음. 관련 링크를 같이 보내주는 것 등

### 정리
- REST는 HTTP를 보다 HTTP답게 만들기 위한 방법론으로 볼 수 있다.
- 철저히 Resource 중심적 설계를 중요시 하고 POST, GET, PUT, DELETE 4가지 메소드를 용도에 맞게 사용한다.

## RESTful API 설계 규칙
URI는 정보의 자원을 표현해야 한다.

1. 동사보다는 __명사__, 대문자보다는 __소문자__ 사용
2. document는 단수 명사
3. 컬렉션 이름은 __복수 명사__
4. 스토어 이름은 __복수 명사__

- document는 객체 인스턴스나 DB record와 유사한 개념
- collection은 server에서 관리하는 directory라는 resource
- store는 client에서 관리하는 resource 저장소



```
규칙
GET /members            [o]
GET /members/1          [o]
POST /members           [o]

GET /members/show/1     [x]
GET /members/insert/2   [x]
POST /members/insert/2  [x]

/*
URI는 resource에 대해서 표현을 하고,
동작은 HTTP methods로 파악할 수 있도록 설계
*/
```


URL 규칙 유의사항
- URI 마지막 문자로 슬래시(/)를 포함하지 않는다.
- 밑줄(_)은 URI에 사용하지 않는다.
- 파일 확장자를 URI에 포함하지 않는다.

리소스 간 연관 관계가 있는 경우
- ex: /users/{userid}/devices, 일반적으로 소유 __'has'__ 의 관계를 표현할 때 


RESTful API는 성능 향상이 아니라 __일관적인 컨벤션을 통한 API의 이해도 및 호환성을 높이는 것이 주 동기__ 이니, 성능이 중요한 상황에서 굳이 구현할 필요는 없다.


## Spring MVC RESTful, Layerd Architecture

- Spring-Web MVC의 RESTful 지원
    - Spring은 Layered Architecture를 지원한다.
    - Layered Architecture 기반의 개발 구성으로 제약을 두고 있다.
    - Client 요청을 가장 먼저 처리하는 Spring MVC
    - @Controller : 가장 먼저 Client의 요청을 받아 들이는 부분 (Spring MVC에서 C, Controller)
    - @RequestMapping(value="url", method=POST/GET/DELETE/PUT),
    - @ResponseBody 사용


```java
@Controller // Component로 만들어 주는 Annotation
public class IndexController {
    @RequestMapping(value="/", method=RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "Hello, Boot";
    }
}
```

Component라는 것은 Spring Container에 객체로 올려지는 객체를 말한다. Component는 Spring Container에 의해 관리된다. Controller는 단순 클래스로 작성된다. 일반 클래스로 작성되는 것을 POJO라고 할 수 있다.
Controller내에 메소드를 선언할 수 있고, 메소드 이름 보다는 요청을 받는 URL 부분이 중요하다. 실제 url에 매치되는 요청의 메서드를 실행한다.
url 요청에 맞는 method 가 같이 작성되어야 한다. 
- @RequestMapping(value="/", method=RequestMethod.GET)

@ResponseBody 어노테이션은 return 하는 코드가 사실상 클라이언트에게 응답하는 내용이 되는데, 별도의 가공을 하지 않고 응답 내용 자체를 바로 return 하라는 것이다. 내부적으로는 text/plain 컨텐츠로 반환한다.

@Controller는 HTTP 요청을 내부적으로 해석하여 응답해주는 역할을 한다.

## Spring Boot의 RESTful 지원
@RestController와 @X-Mapping 사용


```java
@RestController // REST API의 최적화된 Annotation
public class IndexController {

    @GetMapping("/")
    public String index() {
        retrun "Hello, Boot";
    }
}
```

@RestController
- @Controller
- @ResponseBody

@RestController는 기존의 @Controller와 @ResponseBody가 합쳐진 형태이다. RESTful API 서비스는 응답되는 내용이 대부분 데이터만 응답을 하고, 데이터가 주로 JSON 형태가 된다. @RestController는 RESTful API에 최적화된 Controller이다. 단순히 String을 return 할 때는 JSON으로 return 하지는 않지만 java object로 return 하면 자동으로 JSON화하여 return 한다.

@GetMapping
- @RequestMapping(value="/", method=RequestMethod.GET)


__Layerd Architecture 특징__

계층과 아키텍처
- 효율적인 개발과 유지보수를 위해 계층화하여 개발
- 대부분의 중/대규모 application에서 적용
- 각 layer는 독립된 R&R을 가짐

0. client
1. __Presentation Layer__ : Contoller
2. __Business Login Layer__ : Service
3. __Data Access Layer__ : Dao, repository
4. Database

MVC pattern을 이용했다고 볼 수 있다.

1. Presentation Layer
    - 사용자와 상호작용을 담당
    - 사용자의 요청을 분석/응답
2. Business Login Layer
    - 기능을 수행
    - 트랜잭션 수행
3. Data Access Layer
    - 데이터의 저장과 조회를 담당
    - 주로 데이터베이스와 연동하여 작업


## 컴포넌트 자동등록
※ 컴포넌트는 스프링 컨테이너 위에 로딩되는 객체를 말한다. 스프링 코어가 빈들의 Life Cycle을 관리한다. (스프링 컨테이너 = 스프링 코어)

어노테이션(Annotation) 사용
- @Component와 하위 어노테이션 사용

```
@Component
ㄴ @Controller  : Presentation
ㄴ @Service     : Service
ㄴ @Repository  : Persistence/DAO
```

@Autowired : DI(Dependency Injection)
- Component 간의 의존관계는 Autowired라는 Annotation으로 적용


### 정리
- Layerd Architecture는 인접한 layer 간의 통신만 허용하고 반드시 layer를 거쳐서 통신하는 구조를 가진다.
- @Controller, @Service, @Repository Anntation을 포함하는 클래스는 모두 컴포넌트로 등록되어 스프링 컨테이너에 의해 관리되어 진다.
- @Autowired 어노테이션은 DI 기능으로 자동으로 의존관계를 맺어준다.


## REST 구현

### HTTP Method

|Operation|HTTP method|
|-|-|
|Create|POST|
|Read|GET|
|Update|PUT|
|Delete|DELETE|


## CRUD 설계

### UserController 생성 : /users
- GET
    - public Map<String, Object> getAllUsers();
    - public Map<String, Object> getUser(@PathVariable("userid") Integer userid);
- POST
    - public Map<Sting, Object> createUser();
- PUT
    - public Map<Sting, Object> updateUser();
- DELETE
    - public Map<Sting, Object> deleteUser();

url 설계가 중요하고, 일반적으로 복수형을 사용한다.

### Data Transfer Object 디자인 패턴
Data를 각 server/client 간 전달하기 위한 목적으로 만든 객체
- java.io.Serializable 인터페이스 구현 - 객체직렬화 지원
- Immutable 객체로 만듦 - setter 포함하지 않음
- 도메인(모델) 객체를 래핑(wrapping)

```java
public class User {
    private Integer userid;
    private String username;
    public User(Integer userid, String username) {
        this.userid = userid;
        this.username = username;
    }
    // getter and setter mothods
}
```

### JSON
RESTful 웹서비스와 JSON/XML

JSON : Javascript Object Notation

JSON은 JAVA object로 변환 해준다.

JSON(JavaScript Object Notation)이란?
- http://www.json.org
- JSON은 경량(lightweight)의 Data 교환 형식
- Javascript에서 객체를 만들 때 사용하는 표현식을 의미함
- JSON 표현식은 사람과 기계 모두 이해하기 쉬우며 용량이 작아서, 최근에는 JSON이 XML을 대체해서 데이터 전송 등에 많이 사용함
- 특정 언어에 종속되지 않으며, 대부분의 프로그래밍 언어에서 JSON 포맷의 데이터를 핸들링 할 수 있는 라이브러리를 제공하고 있음


1. JSON은 name-value 혹은 key-value 형식의 쌍(pair)으로 구성된다.
    - 여러 가지 언어들에서 object, hashtable, struct로 실현되었다.
2. 값들의 순서화된 리스트 형식
    - 여러 가지 언어들에서 array, list로 실현되었다.


example
```javascript
{
    "firstName" : "Brett",
    "lastName" : "McLaughlin",
    "email" : "brett@newInstance.com"
    "hobby" : ["puzzles", "swimming"]
}
```

### JSON Library - Jackson
- http://jackson.codehaus.org
- High-Performance JSON Processor!
- Jackson은 JSON 형태를 Java 객체로, Java 객체를 JSON 형태로 변환해주는 Java 용 JSON 라이브러리임
- 가장 많이 사용하는 JSON 라이브러리.
- Spring Boot에 내장되어서 바로 사용할 수 있음
- Jackson library는 Spring boot에 내장되어 있다.

[JSON(Browser)] <-> Jackson <-> [Java objects(Backend) <-> MyBatis] <-> [Relational(Storage)]

## API 응답 포맷
요청에 대한 응답의 결과를 상태와 데이터로 구분 (example)


```javascript
{
    "status" : "OK",
    "data" : {...}  // java에서 Map으로 반환
}
```


Error 메시지
```javascript
{
    "status" : "ERROR",
    "data" : null,
    "error" : {
        "errorCode" : 999,
        "description" : "Email address is invalid"
    }
}
```


페이징 처리
```javascript
{
    "status" : "OK",
    "data" : [...],
    "error" : null,
    "pageNumber" : 1,
    "nextPage" : "http://localhost:8080/users?page=2",
    "total" : 13
}
```

Jackson 라이브러리를 통해
- JSON <-> Java object


### UserController : getAllUsers() 구현


UserService
```java
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAlluers() {
        return this.users; 
    }
    // Dummy users
    public static List<User> users;
    public UserServiceImpl() {
        users = new ArrayList<User>();
        users.add(new User(100, "kim"));
        users.add(new User(200, "lee"));
        users.add(new User(300, "park"));
    }
}
```



UserController
```java
@Autowired
UserService userService;

@GetMapping("")
public List<User> getAllusers() {
    return userService.getAllUsers();
}
```

### UserController : getUser() 구현


UserService
```java
@Override
public User getUser(Integer userid) {
    return users.stream()
        .filter(x -> x.getUserid() == userid)
        .findAny()
        .orElse(new User(0, "Not Available"));
}
```



UserController
```java
@GetMapping("/{userid}")
public User getUser(@PathVariable("userid") Integer userid) {
    return userService.getUser(userid);
}
```


### @PathVariable
요청 URL을 파라미터로 사용 (경로 변수)
- 요청 URL : /users/{userid}
- 파라미터로 처리 : @PathVariable("userid") String userid

```java
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userid}")
    public User getUser(@PathVariable("userid") String userid) {
        return userService.getUser(userid);
    }
}
```

### UserController : createUser() 구현

UserService
```java
@Override
public void createUser(Integer userid, String username) {
    User user = new User(userid, username);
    this.users.add(user);
}
```


UserController
```java
@PostMapping("")
public Map<String, Object> createUser(
    @RequestParam(value="userid") Integer userid,
    @RequestParam(value="username") String username) {
    
    Map<String, Object> map = new HashMap<String, Object>();
    userService.createUser(userid, username);
    map.put("result", "added");
    return map;
}
```


### UserController : updateUser() 구현

UserService
```java
@Override
public void updateUser(Integer userid, String username) {
    users.stream()
        .filter(x -> x.getUserid() == userid)
        .findAny()
        .orElseThrow(() -> new RuntimeException("Item not found"))
        .setUsername(username);
}
```


UserController
```java
@PutMapping("")
public Map<String, Object> updateUser(
    @RequestParam(value="userid") Integer userid,
    @RequestParam(value="username") String username) {
    
    Map<String, Object> map = new HashMap<String, Object>();
    userService.updateUser(userid, username);
    map.put("result", "updated");
    return map;
}
```




### UserController : deleteUser() 구현

UserService
```java
@Override
public void deleteUser(Integer userid) {
    users.removeIf((User u) -> u.getUserid() == userid);
}
```


UserController
```java
@DeleteMapping("/{userid}")
public Map<String, Object> deleteUser(
    @PathVariable("userid") Integer userid) {
    
    Map<String, Object> map = new HashMap<String, Object>();
    userService.deleteUser(userid);
    map.put("result", "deleted");
    return map;
}
```




### @RequestBody
- @RequestBody : Client에서 JSON 으로 데이터 요청
- Model Class : Client 폼이나 파라미터로 데이터 요청
- Server에서 JSON body를 받는다.






### 정리
- Spring을 이용한 web service 개발은 Layered Architecture 를 활용하여 개발하고, 데이터는 model class를 작성하여 처리한다.
- HTTP의 GET, POST, PUT, DELETE를 주로 활용하여 data의 CRUD를 구현한다.
- web service test는 REST client 툴을 통해서 가능함.
- Spring REST Application은 Layered Architecture 로 작성되고, @Controller 가 최초로 응답을 받고 @Service를 통해 기능을 수행합니다.
- 각 레이어는 각각의 R&R을 가지며 Controller 단은 Client의 request를 분석해서 Service 단으로 넘겨주는 역할을 수행합니다.


## API Security and JWT

### Spring Security
Spring Security란?
- 강력한 인증과 권한 관련 Framework
- REST API 를 인증되고 권한이 있는 요청에만 허락해줌

JWT
- JWT : JSON web token
- 보안(인증과 권한)에 많이 사용됨
- JWT 토큰 형태로 사용됨
    - URL-safe, 웹브라우저 호환, SSO 지원
- 표준
- 보안에 최근 많이 사용되고 있음.


### 주요 인증 방식
로그인 기반 인증 (크레덴셜 기반 인증)
- Credential-based authentication
- token 기반 인증

인증정보를 다른 어플리케이션으로 전달
- 제 3자가 인증을 처리하는 방식
- OAuth2
- Facebook/Google 같은 소설 계정들을 이용하여 로그인

2단계 인증
- Two-factor authentication
- 이메일, 휴대폰 문자 인증

하드웨어 인증
- Hardware authentication


### 서버 기반 인증 시스템 문제점
세션
- 유저가 인증할 때 이 기록을 서버에 저장 (login -> 서버 메모리에 저장)
- 메모리에 저장 혹은 데이터베이스 시스템에 저장
- 유저의 수(동시 접속)가 많으면 서버나 DB에 부하
- 세션을 사용할 경우 여러 대의 서버에 각각의 세션 정보가 복제 되어야 한다. 그런 기술이 필요.

확장성
- 클러스터링 구성 시 세션 정보도 같이 공유해야 함
- 서버 구성이 복잡해짐 (세션 복제 필요)

CORS
- 쿠키를 여러 도메인에서 관리하는 것이 번거로움

### 토큰 기반 인증 시스템 작동 원리
작동원리
- 유저가 ID, PW로 Login 수행
- Server에서 해당 정보 검증
- 계정정보가 정확하다면 서버측에서 유저에서 signed token을 발급
- Client에서는 Token을 저장해 두고 요청마다 token을 서버에 함께 전달
- Server에서 token을 검증하고 요청에 응답
- __Token은 HTTP 헤더에 포함시켜서 전달__


### Token 기반 인증 시스템 - token의 장점
1. 무상태(Stateless)이며 확장성(Scalability)이 있음
2. 보안성
    - 쿠키를 사용하지 않음
    - 토큰환경에서도 취약점은 존재함, 토큰이 탈취될 수도 있음(스니핑) (100% 보안은 없음)
    - https로 보안화하면 탈취되어도 알기는 쉽지 않음
3. Extensibility
    - Server 확장이 아닌 기능 확장 가능
4. 여러 플랫폼 및 도메인
    - CORS - 아무 도메인에서나 토큰만 유효하면 요청이 정상적으로 처리됨
5. 웹 표준 기반
    - JWT - 토큰기반 인증 시스템 구현체 (RFC 7519)


### JSON Web Token
JWT 특징
- JSON을 사용, JSON은 String, Web에 적합, 프로그래밍 언어와는 독립적임 
- 웹표준으로 다양한 프로그래밍 언어에서 지원(C, Java, Python, C++, R, JS, GO, Swift ..)
- Self-contained : 필요한 모든 정보를 자체적으로 가지고 있음
- 웹 서버의 경우 HTTP 헤더에 넣어서 전달 또는 URL 파라미터로 전달 가능

JWT 사용되는 상황
- 회원인증
- 정보 교환

### JWT 구조
JWT는 dot(.)을 구분자로 3가지 문자열로 구성되어 있음


```
aaaaaa.bbbbbb.cccccc

aaaaaa: 헤더(Header)
bbbbbb: 내용(payload)
cccccc: 서명(signature)
```


헤더(Header) : 두 가지 정보를 포함한다.
- typ : token의 타입을 지정 (JWT)
- alg : 해싱 알고리즘 지정 (HMAC SHA256, RSA ...)

```javascript
{
    "typ" : "JWT"
    "alg" : "HS256"
}
```


내용(payload) / 정보
- token에 담을 정보가 포함 (클레임이라고 함, name/value 쌍으로 구성)
- 클레임(claim)은 다음 세 분류로 나뉨
    - 등록된 (registered) 클레임 - iss, sub, aud, exp, nbf, sat, jti
    - __공개 (public) 클레임__ - 충돌 방지 이름이 필요 (주로 URI 형식으로 네이밍) / 주로 정보를 담음
    - 비공개 (private) 클레임 - Client와 Server 간의 합의 하에 사용되는 클레임 이름들

```javascript
{
    "iss" : "example.com",
    "exp" : "1485270000000",
    "https://example.com/jwt_claims/is_admin" : true,
    "userId" : "11028373727102",
    "username" : "kim"
}
```

서명(signature)
- 헤더의 인코딩 값과 정보의 인코딩 값을 합친 후 주어진 비밀키로 해쉬하여 생성
- https://jwt.io/


### JWT dependency
- javax.xml.bind.jaxb-api 2.3.1
- io.jsonwebtoken.jjwt 0.9.1



## JWT token 구현

token을 발행하고 token을 해석하는 기능을 구현해야 한다.
- token 생성 요청 > 암호화 > 빌드 패턴으로 토큰 생성 > 발행
- 토큰 파싱

### token 생성

SecurityService
```java
public interface SecurityService {
    String createToken(String subject, long ttlMillis);
    String getSubject(String token);
}
```


SecurityServiceImple
```java
public static final String secretKey = "4C8kum4LxyKWYLM78sKdXrzbBjDCFyfX";

@Override
public String createToken(String subject, long ttlMillis) {
    if (ttlMillis <= 0) {
        throw new RuntimeException("Expiry time must be greater than Zero.["+ttlMillis+"]");
    }
    // The JWT signature algorithm we will be using to sign the token
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

    JwtBuilder builder = Jwts.builder()
            .setSubject(subject)
            .signWith(signatureAlgorithm, signingKey);

    long nowMillis = System.currentTimeMillis();
    builder.setExpiration(new Date(nowMillis + ttlMillis));
    return builder.compact();
}
```


IndexController
```java
@GetMapping("/security/generate/token")
public Map<String, Object> generateToken(@RequestParam(value = "subject") String subject) {
    String token = jwtService.createToken(subject, 1000 * 60 * 60 * 24);
    Map<String, Object> map = new HashMap<>();
    map.put("subject", subject);
    map.put("token", token);
    return map;
}
```


### JWT token에서 내용(subject) 추출

SecurityServiceImpl
```java
@Override
public String getSubject(String token) {
    Claims claims = Jwts.parser()
            .setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
            .parseClaimsJws(token).getBody();

    return claims.getSubject();
}
```


IndexController
```java
@GetMapping("/security/get/subject")
public String getSubject(@RequestParam("token") String token) {
    return jwtService.getSubject(token);
}
```




### 정리
- Application 보안은 인증과 인가(권한)로 구분되며, Spring Security에서 지원한다.
- JWT 웹 토큰 방식은 인증을 토큰이라는 클라이언트에게 할당되는 String을 사용하는 것이며, 웹 표준으로 많은 서비스에서 사용이 늘어나고 있다.



## JUnit 
Spring 에서는 TDD(Test Driven Development)를 옹호하며, TDD 개발 기반을 설정하고 있다.

JUnit : Java에서 독립된 단위테스트(Unit Test)를 지원해주는 framework

단위테스트(Unit Test)란?
- source code의 특정 module이 의도된 대로 정확히 작동하는지 검증하는 절차, 즉 모든 함수와 메소드에 대한 테스트 케이스(Test case)를 작성하는 절차
- jUnit은 보이지 않고 숨겨진 단위 테스트를 끌어내어 정형화시켜 단위테스트를 쉽게 해주는 테스트 지원 framework

- Service, Dao 모든 method에 대해서 테스트 케이스를 작성한다.

- main의 Directory, Package 구조를 똑같이 갖는다.

- 필요한 Anntation : @SprinbBootTest, @Test

- Test Method는 public void 이다. 파라미터는 없음.

- Naming 컨벤션
    - class: UserServiceTests, UserRepositoryTests
    - method: testGetAllUsers, testGetUserByUserid

- Test case를 작성할 때에는 정상인 경우를 먼저 작성

- 테스트로 검증하는 클래스 도구 Assert, method: assertXXX

### 정리
- Spring에서 기본적으로 사용하는 build tool인 maven은 설계시 부터 test를 중요하게 생각하고 설계되었다.
- JUnit을 사용하여 단위테스트를 수행하고 Spring-test library를 사용하여 자동으로 Spring Container를 로딩하고 @Autowwired를 사용하여 빈을 테스트 할 수 있다.


## AOP - Aspect Oriented Programming
AOP의 개요와 용어

AOP는 Spring에서 핵심기능

핵심기능과 부가기능
- 업무(Biz) 로직을 포함하는 기능을 __핵심기능(Core Concerns)__
- 핵심기능을 도와주는 부가적인 기능(로깅, 보안 등)
    - __부가기능(Cross-cutting Concerns)__
- 핵심기능에서 부가기능을 분리해서 모듈화하는 프로그래밍 기법 : AOP

핵심기능
- 계좌이체 
- 대출승인 
- 이자계산 

부가기능
- 로깅
- 보안
- 트랜잭션

핵심기능 전체에 부가기능을 끼워 실행한다.

|부가기능|핵심기능1|핵심기능2|핵심기능3|
|-|-|-|-|
|로깅|//|//|//|
|보안|//|//|//|
|-|계좌이체|대출승인|이자계산|
|트랜잭션|//|//|//|

핵심 기능의 앞뒤로 동일한 기능을 앞뒤로 끼워 넣는다고 볼 수 있다.

Example
|BoardService|UserService|XXXService|
|-|-|-|
|Before()|Before()|Before()|
|__getBoards()__|__getUsers()__|__getXXXs()__|
|After()|After()|After()|
- 핵심기능 : BoardService.getBoards(), UserService.getUsers(), XXXService.getXXXs()
- 부가기능 : Before(), After()

### AOP 용어정리

---

__&lt;기존&gt;__

Application [ Primary Concern, Cross-Cutting Concern ]

---

__&lt;AOP&gt;__

Code [ Primary Concern ]

▲ weaving

Aspect [ Point-Cut < advice < Coss-Cutting Concern ]


- Primary Concern : Business logic을 구현한 부분
- Coss-Cutting Concern :보안, 인증, 로그 등의 부가 기능 시스템 전반에 산재되어 사용하는 기능
- Advice : Coss-Cutting Concern 을 지칭하는 말이기도 함
- Point-Cut : 어디에 끼워넣는 것인가? 하는 문법
- Coss-Cutting Concern + Point-Cut = Aspect (Spring에선 Advisor)
- Advice + Point-Cut = Aspect
- weaving : run time 시에 끼워 넣는 행위를 weaving 이라고 함.

---


## Spring Boot AOP 설정

1. dependency : Spring boot AOP Starter Library 설정
    - spring-boot-starter-aop
2. @EnableAspectAutoProxy 적용, Application 클래스, main 메서드에 적용
```java
@EnableAspectJAutoProxy
@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}
}
```

3. 공통기능 정의와 사용될 시점 정의 (Advice or Aspect)

```java
@Aspect    // 컴포넌트와 함께 Aspect setting
@Component // server 로드 시 컴포넌트가 같이 세팅되어 적용됨
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    // UserService의 모든 메서드 @Around는 메소드 이전, 이후 실행
    @Around("execution(* com.exmaple.demo.service.UserService.*(..))") // point-cut 문법, weaving할 위치, 메소드 호출에만 weaving 할 수 있음.
    // advice 그리고, point-cut + advice 를 aspect 라고 한다.
    // @Around는 메소드 실행 전, 후 실행을 얘기한다.
    public Object setLog(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("start : " + pjp.getSignature().getDeclaringTypeName() + "/" + pjp.getSignature().getName());

        Object result = pjp.proceed();

        logger.info("finished : " + pjp.getSignature().getDeclaringTypeName() + "/" + pjp.getSignature().getName());
        return result;  // return하면 Around Aspect가 실행된다.
    }
}
```
1. @commponent 등록
2. @Aspect 등록



### @Before 포인트 컷
Execution 으로 @Before 포인트 컷 사용

```java
@Aspect
@Component
public class TokenRequiredAspect {
    @Before("execution(* com.test.restapp.HomeController.testAOPExcecution())")
    public void tokenRequiredWithoutAnnotation() throws Throwable {
        System.out.println("Before tokenRequiredWithoutAnnotation")
    }
}
```

```java
@ResponseBody
@RequestMapping("/test/aop/with/execution")
public Map<String, Object> testAOPExecution() {
    Map<String,  Object> map = new HashMap<String, Object>();
    map.put("result", "Aloha");
    return map;
}
```

### Advice 종류
- @Before
    - Advice 타깃 메소드가 호출되기 전에 Advice 기능을 수행
- @After
    - 타깃 Method의 결과에 관계없이(즉 성공, 예외 관계없이) 타깃 메소드가 완료되면 advice 기능을 수행
- @AfterReturning (정상적 반환 이후)
    - 타깃 메소드가 성공적으로 결과값을 반환 후에 Advice 기능을 수행
- @AfterThrowing (예외 발생 이후)
    - 타깃 메소드가 수행 중 예뢰를 던지게 되면 어드바이스 기능을 수행
    - 내부적으로 @AfterThrowing 을 사용해서 예외처리를 실행하고 있기도 함.
- @Around (메소드 실행 전후)
    - Advice가 타깃 메소드를 감싸서 타깃 메소드 호출 전과 후에 Advice 기능을 수행
    
### Spring AOP 구조

```java
@Before("point cut 표현식")
public void adviceMethod() {
    ...
}

// 포인트 컷 문법 설명
// example
// @Aound("execution(* com.test.board.BoardService.getBoard(..))")
/*
    @Around : advice
    execution : Point-cut 지정자
    * (괄호 열고 첫 번째 *) : 모든 return type 가능
    com.test.board.BoardService.getBoard() : *타깃 메소드 지정*
    (..) : 인자(argument) 타입, 현재 모든 타입 인자 허용

*/

```


### Annotation을 이용한 AOP

어노테이션 작성 (커스텀 어노테이션 만들기)
```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTiME)
@Target(ElementType.METHOD)
public @interface TokenRequired {
}
```

토큰을 이용한 어드바이스
```java
@Aspect
@Component
public class TokenRequiredAspect {
    // old method (with execution)
    @Before("@annotation(tokenRequired)")
    public void tokenRequiredWithAnnotation(TokenRequired tokenRequired) throws Throwable {
        System.out.println("Before tokenRequiredWithAnnotation");
    }
}

/*
    @Before("@annotation(tokenRequired)") 에 인자로 선언된 
    tokenRequired와 tokenRequiredWithAnnotation 메서드의
    인자 tokenRequired 변수명을 일치시켜주면, 커스텀 어노테이션을
    적용하면 해당 Advice가 실행된다.
 */
```




어노테이션을 이용한 Advice 적용
```java
@ResponseBody
@RequestMapping("/test/aop/with/annotation")
@TokenRequired
public Map<String, Object> testAOPAnnotation() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("result", "Aloha");
    return map;
}
```

### JWT 인증을 AOP로 적용하기

Advice
```java
@Before("@annotation(tokenRequired)")
public void tokenRequiredWithAnnotation(TokenRequired tokenRequired) throws Throwable {
    ServletRequestAttributes reqAttributes = 
        (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    HttpServletRequest request = reqAttributes.getRequest();

    // checks for token in request header
    String tokenInHeader = request.getHeader("token");
    if (StringUtils.isEmpty(tokenInHeader)) {
        throw new IllegalArgumentException("Empty token");
    }
    Claims claims = Jwts.parser().setSigningKey(
        DatatypeConverter
        .parseBase64Binary(SecurityServiceImpl.secretKey))
        .parseClaimsJws(tokenInHeader).getBody();
    if (claims == null || claims.getSubject() == null) {
        throw new IllegalArgumentException("Token Error : Claim is null");
    }
    if (!claims.getSubject().equalsIgnoreCase("kim")) {
        throw new IllegalArgumentException("Subject doesn't match in the token");
    }
}
```

UserController
```java
@ResponseBody
@TokenRequired
@RequestMapping(value="", method=RequestMethod.DELETE)
public Map<String, Object> deleteUser(
    @RequestParam(value="userid") Integer userid
) {
    Map<String, Object> map = new HashMap<String, Object>();
    userService.deleteUser(userid);
    map.put("result", deleted);
    return map;
}
```

### 정리
- AOP는 핵심기능 (Core Concerns)과 부가기능 (Cross Cutting Concerns)을 분리하여 개발할 수 있게 해준다.
- 부가기능에 해당하는 코드인 어드바이스와 적용한 위치를 문법적으로 표현한 포인트컷을 합친 개념이 에스팩트이다.
- 스프링 AOP는 메소드 조인 포인트만 지원하여 간단하게 쉽게 AOP를 구현할 수 있다.
- 포인트컷의 문법을 이용하여 원하는 위치에 부가기능 어드바이스를 추가할 수 있다.
- Advice는 타깃 객체 이전과 이후 그리고 이전/이후 모두에 적용 가능하다.


## Log & 예외처리
### Spring boot Logging system
Spring Boot에는 Logging system이 설정되어 있다.

Spring에 과거에는 Log4j를 내장하고 있었으나 성능 문제로 Logback을 사용하는 경우가 많다. Spring boot에서는 Logback을 default로 사용한다.

Logback framework 사용

Logging Level
1. TRACE
2. DEBUG - 일반적으로 개발자 level
3. INFO - 운영상에서 많이 선택 됨
4. WARN
5. ERROR

로그 레벨 설정(application.properties)
```properties
# log는 package 별로 설정할 수 있다.

# spring framework logging
logging.level.org.springframework = ERROR

# local application logging
logging.level.com.example.test = INFO
```


### Logger 사용

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HomeController {
    private static final Logger logger = 
        LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public Map<String, Object> test() {
        Map<String, Object> map = new HashMap<>();
        map.put("result", "Aloha");
        logger.trace("{test} trace");
        logger.debug("{test} debug");
        logger.info("{test} info");
        logger.warn("{test} warn");
        logger.error("{test} error");
        return map;
    }
}

```


### REST Application 예외처리
스프링 예외처리 방법
- 전역처리 GLobal level - @ControllerAdvice (가장 유력한 방법)
    - Controller 앞 단에서 처리하는 예외처리
    - 어떤 error 라도 처리하게 되어 있다.
    - 하나만 존재하도록 해서 처리해도 된다.
- Controller 단에서 처리 Controller level - @ExceptionHandler
- 메소드 단위 처리 Method level - try/catch (low level)

예외는 어디에서나 발생할 수 있다. 하지만 예외를 client에게 직접적으로 노출 시켜서는 안된다. 예외가 발생하면 그 예외를 잡아서 처리해주어야 한다. 


### 전역처리 Global ExceptionHandler
@ControllerAdvice는 Spring Application의 모든 예외를 처리
    - @RestController는 컨트롤러
    - @ExceptionHandler 어노테이션을 사용하여 예외를 처리할 클래스를 정의

```java
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    
    // 위에서 아래로 Exception type을 check 한다.
    // 마지막에 Exception.class 타입으로 설정하면 error는 무조건 catch한다.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BaseException.class) // 예외 type
    public String handlerBaseException(BaseException e) {
        return e.getMessage();
    }

    @ExceptionHandler(value = Exception.class) // 예외 type
    public String handlerException(Exception e) {
        return e.getMessage();
    }
}
```

### @ExceptionHandler를 사용한 Controller 단 예외처리
HomeController.java 파일 내에 다음 코드가 있으면, 해당 컨트롤러의 모든 NumberFormatException을 잡아서 처리한다.

```java
@ExceptionHandler(value = NumberFormatException.class)
public String nfeHandler(NumberFormatException e) {
    return e.getMessage();
}
```


### 비즈니스 예외 예제
명시적 예외처리가 필요 없는 RuntimeException 타입으로 작성
비즈니스 예외(커스텀 예외), 시스템 예외를 커스텀하여 랩핑한다.

```java
public class ClientException extends RuntimeException {
    private final int errorCode;
    private final String errorDescription;

    public ClientException(ApiError error) {
        super(error.getErrorCode() + " : " + error.getDescription());
        this.errorCode = error.getErrorCode();
        this.errorDescription = error.getDescription();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
```

### 정리
- 로깅 시스템은 여러가지로 사용 가능하지만 SLF4J를 로깅 인터페이스로 해서 Logback 을 스프링5(스프링부트2)의 구현체로 많이 사용한다.
- 스프링에서의 예외처리는 주로 컨트롤러 단에서 처리되며, @ControllerAdvice에서 글로벌 하게 처리될 수 있다.
- @ControllerAdvice는 컨트롤러처럼 동작하며, 모든 예외를 처리할 수 있는 컨트롤러이다.


---
전체 예제 소스 코드는
[spring-boot-exmaple-restapp](https://github.com/i-sak/spring-boot-examples/tree/main/2.x/spring-boot-restapp)
에서 참고할 수 있다.
