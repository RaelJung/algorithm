monster, guard = input().split()
total = int(monster) - int(monster)*int(guard)/100
if total < 100:
    print('1')
else:
    print('0')