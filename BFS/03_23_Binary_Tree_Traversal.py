#LeetCode 102. Binary Tree Level Order Traversal
#Given the root of a binary tree, return the level order traversal of its nodes' values. 
#(i.e., from left to right, level by level).

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root):
        if not root: 
            return []

        queue, result = deque([root]), []
        
        while queue:
            level = []
            for i in range(len(queue)):
                node = queue.popleft()
                level.append(node.val)
                if node.left:  queue.append(node.left)
                if node.right: queue.append(node.right)
            result.append(level)
            
        return result

#[어려웠던 점]
#BFS 방식을 어떻게 적용할 것인가

#[해결 방안]
#BFS 코드 구조 정확히 파악 및 관련 문제 풀기