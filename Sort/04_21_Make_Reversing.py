#LeetCode 1460. Make Two Arrays Equal by Reversing Subarrays(Easy)

class Solution:
    def canBeEqual(self, target: List[int], arr: List[int]) -> bool:
        return Counter(arr) == Counter(target)