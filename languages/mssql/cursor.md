# cursor 문법

```sql
-- mssql

-- 커서 내부에서 조회한 값들을 담을 변수를 선언한다.
declare @name varchar(20), @age smallint
-- cur 이라느 이름의 커서를 선언한다.
declare cur cursor for
-- table을 조회한다.
select name, age from ex_user
-- cursor를 open 한다.
-- 조회한 table 결괏값에 cursor 포인트가 있다고 보자.
open cur
-- table 결괏값의 첫 행 데이터를 갖고와서 @name, @age 변수에 할당한다.
fetch next from cur into @name, @age

-- 반복한다. 갖고 오는 값에 데이터가 있고, 정상인 상태면 @@fetch_status은 0을 반환한다.
-- 갖고 올 값이 있으면 @@FETCH_STATUS는 0을 반환함으로 while 조건이 true가 되어 반복한다.
while @@FETCH_STATUS = 0
begin

    -- 원래 나이에 2살 더하기
    update ex_user 
    set age = @age + 2 
    where name = @name

    -- 아까 위에서 조회(select)한 테이블 결괏값에서 다음 행의 값을 @name, @age 변수에 담는다.
    fetch next from cur into @name, @age
end

-- cursor를 닫는다.
close cur
-- cursor 초기화한다.
deallocate cur
```

해당 내용은 내 블로그에 작성해둔 내용이다.

https://lifere.tistory.com/entry/MSSQL-%EC%BB%A4%EC%84%9CCursor-%EC%82%AC%EC%9A%A9%EB%B2%95-%EB%B0%8F-%EC%98%88%EC%A0%9C