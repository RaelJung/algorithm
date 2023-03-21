#LeetCode 144. Binary Tree Preorder Traversal
#Given the root of a binary tree, return the preorder traversal of its nodes' values.

#<개념 노트>
#전위 순회(preorder)
#root->left->right

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        answer = []
        def traverse(root: Optional[TreeNode]) -> None:
            if root is None:
                return
            
            #root->left->right
            answer.append(root.val)
            traverse(root.left)
            traverse(root.right)

        traverse(root)
        return answer