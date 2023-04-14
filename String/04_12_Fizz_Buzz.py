#LeetCode 412. Fizz Buzz(Easy)

class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        return ["Fizz"*(i%3==0)+"Buzz"*(i%5==0) or f"{i}" for i in range(1,n+1)]
    

#파이썬 f-string 포매팅
#파이썬 ver 3.6부터 사용할 수 있는 기능
#f'문자열 {변수} 문자열'
#C처럼 어떤 변수든 string형 문자열 내에 출력할 수 있다!