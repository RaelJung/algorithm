import sys
input = sys.stdin.readline

def makelist():
    tae = n + 1 #태수 순위

    if n == p and rank[-1] >= t:
        return -1
    
    for i in range(1, n+1):
        if rank[i] <= t:
            tae = i
            break

    return tae

#t: 태수 새 점수, p: 리스트에 올라갈 수 있는 점수의 개수
n, t, p = map(int, input().split())
if n == 0:
    print(1)
else:
    rank = [0] + list(map(int, input().split()))
    print(makelist())