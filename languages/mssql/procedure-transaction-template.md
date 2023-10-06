# MS-SQL
## [T-SQL] Procedure transaction template

```sql
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		
-- Create date: 
-- Description:	
-- =============================================
/*
    DECLARE @MSG VARCHAR(1000)
    EXEC [Proc_name_example] @MSG OUTPUT
    SELECT @MSG AS MESSAGE
*/
ALTER PROCEDURE [Proc_name_example]
	@MSG VARCHAR(1000) OUTPUT
AS
BEGIN

BEGIN TRY
BEGIN TRANSACTION
/** content start */

	SELECT ''

/** content end */
COMMIT TRANSACTION
END TRY

BEGIN CATCH

IF XACT_STATE() <> 0
BEGIN
	SET @MSG = 'error'
	ROLLBACK TRANSACTION
END

END CATCH

END
GO
```

여러 DDL을 트랜잭션 내에서 사용할 때.