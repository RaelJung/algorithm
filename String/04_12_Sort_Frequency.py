#LeetCode 451. Sort Characters By Frequency(Medium)

from collections import Counter

class Solution:
    def frequencySort(self, s: str) -> str:
        return ''.join(c*fre for c, fre in Counter(s).most_common())