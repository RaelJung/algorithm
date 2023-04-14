#LeetCode 804. Unique Morse Code Words(Easy)

class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        alphabet = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        ans = []
        for word in words:
            ans.append("".join(alphabet[ord(s)-ord("a")] for s in word))
        return len(set(ans))