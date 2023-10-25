# mssql trigger

- INSERT, UPDATE 동작에서는 inserted 테이블에 접근해서 insert, update된 데이터에 대해서 작업을 수행한다.

- DELETE 동작에서는 deleted 테이블에 접근해서 delete된 데이터에 대해서 작업을 수행한다.


```sql
-- MSSQL
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE TRIGGER <Schema_Name, sysname, Schema_Name>.<Trigger_Name, sysname, Trigger_Name> 
   ON  <Schema_Name, sysname, Schema_Name>.<Table_Name, sysname, Table_Name> 
   AFTER <Data_Modification_Statements, , INSERT,DELETE,UPDATE>
AS 
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for trigger here

END
GO
```