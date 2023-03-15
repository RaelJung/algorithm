# LeetCode 20. Valid Parentheses

# Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
# An input string is valid if:
# Open brackets must be closed by the same type of brackets.
# Open brackets must be closed in the correct order.
# Every close bracket has a corresponding open bracket of the same type.

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        table = {
            ')' : '(',
            '}' : '{',
            ']' : '[',
        }

        #스택 이용 예외 처리 및 일치 여부 판별
        for c in s:
            if c not in table:
                stack.append(c)
            elif not stack or table[c] != stack.pop():
                return False
        return len(stack) == 0