#2001. 파리 퇴치
#https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PzOCKAigDFAUq&categoryId=AV5PzOCKAigDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=2&pageSize=10&pageIndex=1

T = int(input())

for a in range(T):
    N, M = map(int, input().split())
    arr = [list(map(int, input().split())) for i in range(N)]

    kills = []
    # 파리채를 내려칠 곳 탐색
    for i in range(N-M+1):
        for j in range(N-M+1):
            fly = 0
            # 해당 위치를 타격했을 때 잡을 수 있는 파리의 수 탐색 
            for k in range(M):
                for l in range(M):
                    fly += arr[i+k][j+l]
            kills.append(fly)

	# 배열 범위 안에서 가능한 경우의 수 중에서 가장 많은 파리를 잡을 때의 수 출력
    print("#"+str(a+1), max(kills))