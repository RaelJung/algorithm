for i in range(1,int(input())+1):
  num1,num2 = map(int,input().split())
  a = list(map(int,input().split()))
  b = list(map(int,input().split()))

  if len(a) > len(b) :
        a, b = b, a

  li = []
  for k in range(len(b)-len(a)+1):
    sum = 0
    for j in range(len(a)):
      sum += a[j]*b[j+k]
    li.append(sum)

  print("#{} {}".format(i,max(li)))