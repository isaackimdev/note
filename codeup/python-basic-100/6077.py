'''

본 문제는 python 의 빠른 기초 학습을 위해 설계된 문제로서 python 코드 제출을 기준으로 설명되어 있습니다. 
------

정수(1 ~ 100) 1개를 입력받아 1부터 그 수까지 짝수의 합을 구해보자.

예시
#다음 코드는 홀 수만 더해 출력한다.
n = int(input())
s = 0
for i in range(1, n+1) :
  if i%2==1 :
    s += i

print(s)

참고
while 이나 for 반복실행구조를 이용할 수 있다.
다른 방법이나 while 반복실행구조를 이용해서도 성공시켜 보자.

'''

n=int(input())
s = 0
for i in range(n+1) : 
  if i % 2 == 0 :
    s += i
print(s)