'''
본 문제는 python 의 빠른 기초 학습을 위해 설계된 문제로서 python 코드 제출을 기준으로 설명되어 있습니다. 
------

2개의 정수값이 입력될 때,
그 불 값(True/False) 이 서로 같을 때에만 True 를 출력하는 프로그램을 작성해보자.
'''
a,b = input().split()
c = bool(int(a))
d = bool(int(b))
print( (c and d) or ((not c) and (not d)) )
# 쉬운 방법
# print( c == d )