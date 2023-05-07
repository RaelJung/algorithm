#2058. 자릿수 더하기
#https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&contestProbId=AV5QPRjqA10DFAUq&categoryId=AV5QPRjqA10DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=1&pageSize=10&pageIndex=1

num = input()

num_sum = 0
for idx in range(0, len(num)):
    num_sum += int(num[idx])
    
print(num_sum)