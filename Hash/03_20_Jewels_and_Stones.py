#LeetCode 771. Jewels and Stones
#You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. 
#Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

#Letters are case sensitive, so "a" is considered a different type of stone from "A".

class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        freqs = {}
        cnt = 0

        #돌(S)의 빈도 수 계산
        for char in stones:
            if char not in freqs:
                freqs[char] = 1
            else:
                freqs[char] += 1
        
        #보석(J)의 빈도수 합산
        for char in jewels:
            if char in freqs:
                cnt += freqs[char]

        return cnt

#아래는 파이썬다운 방식이다.
#return sum(s in jewels for s in stone)