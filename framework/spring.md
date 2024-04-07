Spring bean

speing bean과 의존 관계

1. 빈(Bean)
    - java에서 bean은 일반적으로 재사용 가능한 sw 구성요소를 의미
    - java based f/w container에서 객체를 가리킬 때 사용
    - Xml file이나 Java Configuration 파일에 Bean 설정 정보 작성
    - 의존성 주입을 통해 Bean과 상호작용 -> 느슨한 결합

2. 의존성 주입(Dependency Injection)
    - 직접 의존하는 객체를 생성하지 않고, 외부에서 의존 객체를 주입받아 사용
    - 내부에서 직접 생성하는 것이 아닌, 의존 객체를 매개변수로 전달받아 주입
    - xml, java configuration file에서 관련 빈들의 의존관계 설정
    - spring IoC container는 설정 정보를 기반으로 필요한 빈을 생성하고 의존하는 빈들을 주입하여, 객체간의 관계를 자동으로 관리
    - 객체간의 결합도를 낮춰주기에 확장성있고 유연한 설계가 가능

3. IoC(Inversion of Control)
    - 제어의 권한이 역전 되었다 하여 "제어의 역전"
    - 객체의 제어 권한을 개발자가 갖는 것이 아닌 f/w나 컨테이너에 위임
    - f/w가 대신 처리하여 객체를 제공하고 관리
    - IoC를 구현하는 방법중 하나가 바로 DI
    - IoC와 DI는 서로 연결된 개념

4.  DIP
    - 상위레벨의 모듈은 하위레벨의 모듈에 의존하지 않는다. 둘다 추상화에 의존해야한다.


5. spring bean & spring IoC Container
    - 스프링 빈 : Spring IoC Container가 관리하는 객체
    - 스프링 IoC 컨테이너
        - 빈을 관리하는 객체
        - 객체의 lifecycle 관리
        - DI를 통해 객체들 간의 관계 관리
        - 빈으로 등록된 객체 생성, 필요한 곳에서 사용될 수 있도록 제공