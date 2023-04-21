#LeetCode 1365. How Many Numbers Are Smaller Than the Current Number(Easy)

class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        return [sorted(nums).index(a) for a in nums]