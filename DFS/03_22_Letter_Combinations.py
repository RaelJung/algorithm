#LeetCode 17. LetterCombinations of a Phone Number
#Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
#Return the answer in any order.
#A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        def dfs(index, path):
            #끝까지 탐색하면 백트래킹
            if len(path) == len(digits):
                result.append(path)
                return
            
            #입력값 자릿수 단위 반복
            for i in range(index, len(digits)):
                #숫자에 해당하는 모든 문자열 반복
                for j in dic[digits[i]]:
                    dfs(i+1, path+j)
            
        #예외처리
        if not digits:
            return []
            
        dic = {"2": "abc", "3": "def", "4": "ghi", "5": "jkl", 
                "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"}
            
        result = []
        dfs(0, "")

        return result