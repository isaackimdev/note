---
title : HttpServletRequest에 대하여
date: 2023-09-27 00:00:00 +/-TTTT
categories: [Java, Servlet, Spring]
tags: [java, servlet, spring, mvc, web, server]
---
## HttpServletRequest에 대하여
`oracle docs를 참고함.`

현재 담당하고 있는 Spring Project 소스 코드를 보면 Controller 메서드 파라미터로 HttpServletRequest가 자주 사용되는 것을 볼 수 있다. oracle의 docs를 보니 HttpServletRequest는 ServletRequest를 상속 받는 것으로 확인했다. ServletRequest는 어떤 처리를 할까?

### ServletRequest

ServletRequest는 서블릿에 클라이언트 요청 정보를 전달하기 위한 객체를 정의한다. 서블릿 컨테이너는 ServletRequest 객체를 생성하고 이를 서블릿의 서비스 메서드에 인수로 전달한다.

ServletRequest 객체는 매개변수 이름과 값, 속성, 입력 스트림을 포함한 데이터를 제공한다.

ServletRequest를 extend(상속, 확장)하는 interface는 추가 프로토콜별 데이터를 제공할 수 있다. (예로, HTTP 데이터는 HttpServletRequest에서 제공된다.)

### HttpServletRequest

```java
public interface HttpServletRequest extends ServletRequest
```
 HTTP 서블릿에 대한 요청 정보를 제공하기 위해 ServletRequest 인터페이스를 확장한다.

서블릿 컨테이너는 HttpServletRequest 객체를 생성하고 이를 서블릿의 서비스 메소드(doGet, doPost 등)에 인수로 전달한다.

### 사용 예시
Spring legacy 프로젝트에서 Controller 클래스를 살펴 보자. 

```java
// Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public String index(HttpServletRequest request, Map model) {
    String name = request.getAttribute("name");
    model.put("name", name);
    return "index";
}
```

http 요청 정보를 처리할 Controller 클래스의 멤버 index() 메서드를 보면 HttpServletRequest 인터페이스가 Parameter로 사용된다. http 요청에 포함된 변수명에 name이 있다면, request.getAttribute("name") 에서 해당 값이 추출된다.
