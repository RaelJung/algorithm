#LeetCod 70. Climbing Stairs(Easy)

class Solution:
    def climbStairs(self, n: int) -> int:
        #Top-Down 방식
        def climb(n):
            if n in step:
                return step[n]
            else:
                step[n] = climb(n-1) + climb(n-2)
                return step[n]
        step = {1: 1, 2: 2}  # base cases
        return climb(n)
    
#Top-Down 방식
#큰 문제 정의 뒤, 세부 문제들로 나누어 설계하는 과정
#특징: 메모리제이션 - 한 번 구한 결과를 메모리 공간에 메모해두고, 같은 식을 다시 호출하면 메모한 결과를 그대로 가져오는 기법 의미.
#장점: 메모리제이션 활용으로 빠른 처리 가능
#단점: 메모리 공간 차지, 구조 변경 시 치명적

#Bottom-Up 방식
#모듈(전체를 이루기 위한 하나의 단위)을 만들어 조합
#특징: DP 테이블 활용
#장점: 변화에 유연, 메모리 공간 절약
#단점: 다른 요소가 꼭 필요한 경우(순차적으로 일을 진행해야 하는 경우)