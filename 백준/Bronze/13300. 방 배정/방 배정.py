given = input()
given = given.split(' ')
n = int(given[0])
k = int(given[1])

#남/여 학생 리스트 만들기
stud_m = [0 for i in range(6)]
stud_f = [0 for i in range(6)]

for i in range(n):
  given = input()
  #남자
  if int(given[0]) == 0:
    stud_m[int(given[2])-1] += 1
  #여자
  else:
    stud_f[int(given[2])-1] += 1

#방 개수 헤아리기
#같은 학년끼리 묶어야함
cnt = 0

for i in range(6):
  cnt += stud_m[i] // k
  cnt += stud_f[i] // k
  if stud_m[i] % k != 0:
    cnt += 1
  if stud_f[i] % k != 0:
    cnt += 1

print(cnt)