#LeetCode 217. Contains Duplicate(Easy)

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        return len(nums) != len(set(nums))