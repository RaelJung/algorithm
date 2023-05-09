hour, min = map(int, input().split())
time = int(input())
min += time
while min-60 >= 0:
    hour=hour+1
    min =min-60
if hour > 23:
    hour = hour - 24
print(str(hour)+' '+str(min))