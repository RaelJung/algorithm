#2050. 알파벳을 숫자로 변환
#https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&contestProbId=AV5QLGxKAzQDFAUq&categoryId=AV5QLGxKAzQDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=1&pageSize=10&pageIndex=1

Alpha = input()

for a in Alpha:
    print(str(ord(a)-64), end=' ')


#python에서 알파벳을 숫자로 변환하기: ord() 사용