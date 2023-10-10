# 특정 테이블을 사용하고 있는 프로시저 조회하기

```sql
SELECT
    DISTINCT O.NAME
FROM
    SYSDEPENDS AS D
INNER JOIN
    SYSOBJECTS AS O
ON
    D.ID = O.ID
WHERE
    O.XTYPE = 'P'
    AND D.DEPID =
        (
            SELECT
                ID
            FROM
                SYSOBJECTS
            WHERE
                NAME = '테이블명'
        )
```

ref : https://devms.tistory.com/76