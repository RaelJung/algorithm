#LeetCode 821. Shortest Distance to a Character(Easy)

class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        target_idx = []
        for i, char in enumerate(s):
            if char == c:
                target_idx.append(i)

        result = []
        for i in range(len(s)):
            result.append(min([abs(t - i)for t in target_idx]))
        return result



