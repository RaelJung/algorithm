#LeetCode 922. Sort Array By Parity II(Easy)

class Solution:
    def sortArrayByParityII(self, nums: List[int]) -> List[int]:
        even, odd = [], []
        res = []
        for i in nums:
            if i%2 == 0:
                even.append(i)
            else:
                odd.append(i)
        
        for x,y in zip(odd, even):
            res.append(y)
            res.append(x)

        return res