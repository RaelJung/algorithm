#LeetCode 1636. Sort Array by Increasing Frequency(Easy)

from collections import Counter

class Solution:
	def frequencySort(self, nums: List[int]) -> List[int]:
		dic = Counter(nums)
		def check(x):
			return dic[x]

		nums.sort(reverse=True)
		nums.sort(key=check)
		return nums