#LeetCode 657. Robot Return to Origin(Easy)

class Solution:
    def judgeCircle(self, moves: str) -> bool:
        return moves.count('L') == moves.count('R') and moves.count('U') == moves.count('D')
    
#string.count
#string 내에 해당 문자열이 몇 번 나타나는지 알려주는 메소드