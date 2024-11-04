# ENCRYPTBYPASSPHRASE
MS-SQL 자체 내장 암호화 함수

```sql
DECLARE @result varbinary(1000)
DECLARE @fromText VARCHAR(100) = 'TEST'
SELECT @result =  ENCRYPTBYPASSPHRASE('SHA2_256',@fromText)
RETURN @result
```