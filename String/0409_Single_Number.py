#LeetCode 136. Single Number(Easy)

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        return 2*sum(set(nums))-sum(nums)
    
        
    def otherSolution(self, nums: List[int]) -> int:
        res = 0
        for num in nums:
            res ^= num
        return res