#LeetCode 46. Permutations
#Given an array nums of distinct integers, return all the possible permutations. 
#You can return the answer in any order.

#itertools.permutations
#permutations(iterable, r=None)
#iterable에서 원소 개수가 r개인 순열 뽑기
#default값인 r=None으로 지정할 경우, 최대 길이의 순열이 리턴된다.

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []
        prev_elements = []

        def dfs(elements):
            #리프 노드일 때 결과 추가
            if len(elements) == 0:
                result.append(prev_elements[:])
            
            #순열 생성 재귀 호출
            for e in elements:
                next_elements = elements[:]
                next_elements.remove(e)

                prev_elements.append(e)
                dfs(next_elements)
                prev_elements.pop()

        dfs(nums)
        return result

    #파이썬 풀이
    #return list(map(list, itertools.permutations(nums)))