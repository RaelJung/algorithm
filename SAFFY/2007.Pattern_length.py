#2007. 패턴 마디의 길이
#https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5P1kNKAl8DFAUq&categoryId=AV5P1kNKAl8DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=2&pageSize=10&pageIndex=1

T = int(input())

for test_case in range(1, T + 1):
    alpha = list(input())
    num_pattern = 0
    answer = 0
    

    #최대 열번이므로
    for j in range(1, 10):
        if alpha[0] != alpha[j] or alpha[1] != alpha[j +1]:
            num_pattern += 1
        else:
            break

    answer = num_pattern + 1
    print("#%d" %test_case, answer)