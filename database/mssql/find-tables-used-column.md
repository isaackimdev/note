# Find tables used column

특정 컬럼을 사용하고 있는 테이블들을 조회한다.

```sql
SELECT
T.name AS table_name, C.name AS column_name, c.max_length
FROM sys.tables AS T
INNER JOIN sys.columns AS C ON T.object_id = C.object_id
WHERE C.name = 'search_column_name'
```
