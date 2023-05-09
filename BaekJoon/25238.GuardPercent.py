#25238. 가희와 방어율 무시
#https://www.acmicpc.net/problem/25238

monster, guard = input().split()

total = int(monster) - int(monster)*int(guard)/100

if total < 100:
    print('1')
else:
    print('0')