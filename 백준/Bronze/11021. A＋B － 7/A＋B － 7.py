num = int(input())

for i in range(1, num+1):
    a,b = input().split()
    print('Case #'+str(i)+': '+str(int(a)+int(b)))