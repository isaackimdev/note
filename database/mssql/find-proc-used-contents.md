# Find Procedure

## 특정 내용을 포함하고 있는 프로시저 찾기

```sql
SELECT OBJECT_NAME(object_id), 
 OBJECT_DEFINITION(object_id)
FROM sys.procedures
WHERE OBJECT_DEFINITION(object_id) LIKE '%찾을 내용%'
```

[출처](https://blog.sonim1.com/111)


## 특정 내용을 포함하고 있는 프로시저 찾기 2 
```sql
	SELECT Name 
	FROM   sysobjects 
	WHERE  id IN (
		  SELECT id FROM syscomments WHERE text LIKE '%contents%'
	 )
```