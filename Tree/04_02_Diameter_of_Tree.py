#LeetCode 543. Diameter of Binary Tree

#Given the root of a binary tree, return the length of the diameter of the tree.
#The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
#This path may or may not pass through the root.

#The length of a path between two nodes is represented by the number of edges between them.

#DFS로 풀이
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.ans = 0
        
        def depth(p):
            if not p: return 0
            left, right = depth(p.left), depth(p.right)
            self.ans = max(self.ans, left+right)
            return 1 + max(left, right)
            
        depth(root)
        return self.ans