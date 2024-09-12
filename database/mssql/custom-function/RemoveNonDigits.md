# RemoveNonDigits
mssql에서 정규식이 먹히지 않아서 커스텀 함수로 비숫자를 제거하는 함수를 만들어 사용.

```sql
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		isaac
-- Create date: 2024.09.06
-- Description:	비숫자 제거 함수
-- =============================================
CREATE FUNCTION RemoveNonDigits
(
	@input NVARCHAR(MAX)
)
RETURNS NVARCHAR(MAX)
AS
BEGIN
	DECLARE @result NVARCHAR(MAX) = ''
	DECLARE @i INT = 1
	WHILE @i <= LEN(@input)
	BEGIN
		IF SUBSTRING(@input, @i, 1) LIKE '[0-9]'
		BEGIN
			SET @result = @result + SUBSTRING(@input, @i, 1)
		END
		SET @i = @i + 1
	END
	RETURN @result;
END
GO
```