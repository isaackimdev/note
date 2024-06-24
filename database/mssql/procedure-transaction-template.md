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
[CREATE|ALTER] PROCEDURE [Proc_name_example]
	-- Add the parameters for the stored procedure here
	-- <@Param1, sysname, @p1> <Datatype_For_Param1, , int> = <Default_Value_For_Param1, , 0>, 
	-- <@Param2, sysname, @p2> <Datatype_For_Param2, , int> = <Default_Value_For_Param2, , 0>
	@MSG VARCHAR(1000) OUTPUT
AS
BEGIN

-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	declare @proc_name nvarchar(200)

BEGIN TRY
BEGIN TRANSACTION
/** content start */

	-- logic
	SELECT ''

/** content end */
COMMIT TRANSACTION
END TRY
BEGIN CATCH

	-- XACT_STATE() 가 -1 이면 오류 발생 transaction rollback
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