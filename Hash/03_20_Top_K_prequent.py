#LeetCode 347. Top K Frequent Elements
#Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        #파이썬 다운 방식으로 작성
        return list(zip(*collections.Counter(nums).most_common(k)))[0]