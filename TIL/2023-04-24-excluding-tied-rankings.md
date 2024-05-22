# 동점 순위 제외 (Excluding tied rankings)

로직에 최종적으로 적용한 코드
```sql
SELECT * FROM (
    SELECT 
        *
        , CASE 
            WHEN ROW_NUMBER() OVER 
                ( 
                    PARTITION BY CMPID, INSACODE, BEDATE 
                    ORDER BY BEDATE DESC, EDDATE DESC
                ) = 1 
            THEN 'P' 
            ELSE 'N' 
        END RN 
    FROM BALRYUNGITEM
) AS A 
WHERE RN = 'P'
```



# Chat GPT한테 질문하고 답변내용 보기
Q. MSSQL에서 공동 순위인 경우 값 변경하여 출력하는 게 가능하니?

A.네, MS SQL에서 공동 순위가 있는 경우 값을 변경하여 출력하는 것이 가능합니다.

공동 순위를 처리하기 위해 ROW_NUMBER() 함수를 사용할 수 있습니다. ROW_NUMBER() 함수는 결과 집합의 각 행에 순서를 부여하는데 사용되며, PARTITION BY 절을 통해 공동 순위를 정의할 수 있습니다. 그런 다음, 결과를 변경하고자 하는 필드에 대해 CASE 문을 사용하여 값을 조작할 수 있습니다.

다음은 예시 코드입니다. your_table은 공동 순위를 가진 데이터를 포함하는 테이블이라고 가정합니다.

```sql
SELECT 
    col1,
    col2,
    CASE 
        WHEN ROW_NUMBER() OVER (PARTITION BY col1 ORDER BY col2) = 1 THEN col3
        ELSE col3 + ' (Tied Rank ' + CAST(ROW_NUMBER() OVER (PARTITION BY col1 ORDER BY col2) AS NVARCHAR(10)) + ')'
    END AS col3_with_rank
FROM 
    your_table
ORDER BY 
    col1, col2;

```
위의 예시에서는 col1을 기준으로 PARTITION BY 절을 사용하여 공동 순위를 정의하고, col2를 기준으로 순위를 부여하고 있습니다. 그리고 CASE 문을 사용하여 col3의 값을 변경하고 있습니다. 공동 순위인 경우, col3에 " (Tied Rank 순위)"를 추가하여 출력하고 있습니다. 이를 통해 공동 순위에 대한 정보를 포함한 값을 출력할 수 있습니다.