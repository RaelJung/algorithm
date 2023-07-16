T = int(input())
for _ in range(T):
    n, m = map(int, input().split())
    li = [list(map(int, input().split())) for i in range(n)]
 
    di = [-1, 1, 0, 0]
    dj = [0, 0, -1, 1]
    ti = [-1, 1, -1, 1]
    tj = [-1, 1, 1, -1]
 
    total = 0
    answer = 0
    for i in range(n):
        for j in range(n):
            cnt1 = li[i][j]
            cnt2 = li[i][j]
            for k in range(4):
                for l in range(1, m):
                    a = i + di[k] * l
                    b = j + dj[k] * l
                    c = i + ti[k] * l
                    d = j + tj[k] * l

                    if -1 < a < n and -1 < b < n:
                        cnt1 += li[a][b]
 
                    if -1 < c < n and -1 < d < n:
                        cnt2 += li[c][d]
 
            total = max(cnt1, cnt2)
            if answer < total:
                answer = total
 
    print(f"#{_ + 1}", answer)