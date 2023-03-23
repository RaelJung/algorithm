#LeetCode 101. Symmetric Tree
#Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def isMirror(left, right) -> bool:
            #리프(말단) 노드일 경우
            if not left and not right:
                return True
            #
            if left and right and left.val == right.val:
                return isMirror(left.left, right.right) and isMirror(left.right, right.left)
            return False
        
        return isMirror(root, root)

#[어려웠던 점]
#1. 재귀의 종료 조건
#2. 두 노드의 비교 방식

#[해결 방안]
#1. 재귀했을 경우, 언제 어떤 조건으로 끝나야 하는 지 먼저 생각하기
#2. 마찬가지로 미리 작성하여 알고리즘 고려하기 