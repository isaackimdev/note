'''
본 문제는 python 의 빠른 기초 학습을 위해 설계된 문제로서 python 코드 제출을 기준으로 설명되어 있습니다. 
------

정수 2개(a, b)를 입력받아 a에서 b를 뺀 차를 출력하는 프로그램을 작성해보자.

예시
...
c = a - b
print(c)

참고
수 - 수는 차(subtraction)가 계산된다.
'''
a, b = input().split()
a=int(a)
b=int(b)
d = a - b 
print(d)