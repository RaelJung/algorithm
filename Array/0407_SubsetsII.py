#LeetCode 90. Subsets II(Medium)

class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        result = []
        self.dfs(sorted(nums), [], result)
        return result
    
    def dfs(self, nums, path, result):
        result.append(path)
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            self.dfs(nums[i+1:], path+[nums[i]], result)