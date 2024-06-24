# select table info
테이블 정보 조회하기 (Description 포함)

```sql
DECLARE @TABLE_NAME NVARCHAR(50) = '테이블이름';
SELECT D.COLORDER                AS COLUMN_IDX            -- Column Index
     , A.NAME                    AS TABLE_NAME            -- Table Name
     , C.VALUE                    AS TABLE_DESCRIPTION    -- Table Description
     , D.NAME                    AS COLUMN_NAME            -- Column Name
     , E.VALUE                    AS COLUMN_DESCRIPTION    -- Column Description
     , F.DATA_TYPE                AS TYPE                    -- Column Type
     , F.CHARACTER_OCTET_LENGTH    AS LENGTH                -- Column Length
     , F.IS_NULLABLE            AS IS_NULLABLE            -- Column Nullable
     , F.COLLATION_NAME            AS COLLATION_NAME        -- Column Collaction Name
  FROM SYSOBJECTS A WITH (NOLOCK)
  INNER JOIN SYSUSERS B WITH (NOLOCK)        ON A.UID = B.UID
  INNER JOIN SYSCOLUMNS D WITH (NOLOCK)        ON D.ID = A.ID
  INNER JOIN INFORMATION_SCHEMA.COLUMNS F WITH (NOLOCK)
     ON A.NAME = F.TABLE_NAME
    AND D.NAME = F.COLUMN_NAME
   LEFT OUTER JOIN SYS.EXTENDED_PROPERTIES C WITH (NOLOCK)
     ON C.MAJOR_ID = A.ID
    AND C.MINOR_ID = 0
    AND C.NAME = 'MS_Description'
   LEFT OUTER JOIN SYS.EXTENDED_PROPERTIES E WITH (NOLOCK)
     ON E.MAJOR_ID = D.ID
    AND E.MINOR_ID = D.COLID
    AND E.NAME = 'MS_Description'  
  WHERE 1=1
    AND A.TYPE = 'U'
    AND A.NAME = @TABLE_NAME
  ORDER BY D.COLORDER

```

#### REF
[Table & Column Description 가져오기](https://mirwebma.tistory.com/181)