#LeetCode 748. Shortest Completing Word(Easy)

class Solution:
    def shortestCompletingWord(self, licensePlate: str, words: List[str]) -> str:
        pc = Counter(filter(lambda x : x.isalpha(), licensePlate.lower()))
        return min([w for w in words if Counter(w) & pc == pc], key=len) #key를 기준으로 최대, 최솟값을 찾는다.
    
#[파이썬 내장함수 filter()]
#여러 개의 데이터로 부터 일부의 데이터만 추려낼 때 사용.
#list나 tuple을 대상으로 주로 사용.
#fliter(조건 함수, 순회 가능한 데이터)

#[lambda 형식]
#lambda 매개변수 : 표현식
#Ex) map(함수, 리스트)
#map(lambda x: x**2, range(5))
#--> [0, 1, 4, 9, 16]