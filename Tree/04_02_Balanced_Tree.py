#LeetCode 110. Balanced Binary Tree

#Given a binary tree, determine if it is height-balanced

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def check(root):
            if not root:
                return 0

            left = check(root.left)
            right = check(root.right)

            #높이 차가 존재하는 경우 -1, 이외에는 높이에 따라 1증가
            if left  == -1 or \
                right == -1 or \
                    abs(left - right)>1:
                return -1
            return max(left, right) + 1
        
        return check(root) != -1
    
#높이 균형(height-balanced)란?
#모든 노드의 서브 트리 높이 차이가 1 이하인 것을 말한다.