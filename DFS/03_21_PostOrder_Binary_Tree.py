#LeetCode 145. Binary Tree Postorder Traversal
#Given the root of a binary tree, return the postorder traversal of its nodes' values.

#후위 순회(postorder)
#left->right->root

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        answer = []

        def traverse(root: Optional[TreeNode]) -> None:
            if root is None:
                return 
            
            #left->right->root
            traverse(root.left)
            traverse(root.right)
            answer.append(root.val)
        
        traverse(root)
        return answer