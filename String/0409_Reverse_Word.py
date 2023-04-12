#LeetCode 557.Reverse Words in a String III(Easy)

class Solution:
    def reverseWords(self, s: str) -> str:
        return ' '.join(s.split()[::-1])[::-1]
