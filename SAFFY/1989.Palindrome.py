#1989. 초심자의 회문 검사
#https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PyTLqAf4DFAUq&categoryId=AV5PyTLqAf4DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=2&pageSize=10&pageIndex=1

T = int(input())

for T in range(1, T+1):
    text = input().replace(" ", "")

    flag = 0
    if text == text[::-1]:
        flag = 1

    print('#'+str(T)+' '+str(flag))