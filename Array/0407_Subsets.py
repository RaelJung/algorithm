#LeetCode 78. Subsets(Medium)

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        self.dfs(nums, [], result)
        return result
    
    def dfs(self, nums, path, result):
        result.append(path)
        for i in range(len(nums)):
            self.dfs(nums[i+1:], path+[nums[i]], result)