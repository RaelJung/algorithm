#LeetCode 977. Squares of a Sorted Array(Easy)

class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        return sorted([v**2 for v in nums])