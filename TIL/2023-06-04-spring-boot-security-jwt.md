spring boot data jpa + hibernate 개발 환경에서
resource 폴더 하위에 data.sql 파일을 두면 해당 sql이 자동 실행된다.
어떤 글에서 스프링 2.4.x 버전과 2.5.x 에서 data.sql 동작 방식이 변경되었다고 한다.

발생했던 에러 메시지는 다음과 같다.

```
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'dataSourceScriptDatabaseInitializer' defined in class path resource [org/springframework/boot/autoconfigure/sql/init/DataSourceInitializationConfiguration.class]: Invocation of init method failed; nested exception is org.springframework.jdbc.datasource.init.ScriptStatementFailedException: Failed to execute SQL script statement #1 of URL
```

application.yml 파일에 다음 구문을 입력 후 spring boot 프로젝트를 실행하면
jpa create 후 data.sql 파일에 있는 초기 데이터 세팅 sql이 오류 없이 실행된다.

# setting for data.sql
spring.jpa.defer-datasource-initialization: true

spring security + jwt project에서 hs512 알고리즘을 사용할 때 secret key는 64Byte 이상 되어야 한다고 한다.
why?

secret key 값은 특정 문자열을 base64로 인코딩한 문자열 값을 사용함.
