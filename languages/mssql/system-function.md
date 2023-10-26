# SQL Server / MSSQL - System Function

자주 사용하는 함수

__EOMONTH : 날짜의 해당월의 말일을 구하는 함수__
```SQL
SELECT CONVERT(VARCHAR(8),EOMONTH('20231001'),112) -- 20231031
```


#### REF
- [MS / SQL server ver16](https://learn.microsoft.com/ko-kr/sql/t-sql/functions/system-functions-transact-sql?view=sql-server-ver16)
- [MSSQL 시스템 함수 정리된 블로그 ](https://featur.tistory.com/136)