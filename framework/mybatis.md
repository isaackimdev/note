# Mybatis

#### xml파일에서 부등호 사용
Mybatis를 사용할 때 xml 파일에서 부등호를 사용하기 위해 CDATA, 다음과 같은 표현식을 사용한다.

```
<![CDATA[`<>`]]>
<![CDATA[`<=`]]>
<![CDATA[`>=`]]>
```

#### if, equals
if 구문과 비교 함수 equals() 사용하기
```xml
<select id="test" parameterType="hashmap" resultType="Map">
    <!-- 설명 : var1이라는 변수의 값이 'test'와 같으면 1을 조회한다. -->
    <if test="var1.equals('test')">
        SELECT 1 AS TEST
    </if>
</select>
```
