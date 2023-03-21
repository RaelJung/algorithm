#LeetCode 94. Binary Tree Inorder Traversal
#Given the root of a binary tree, return the inorder traversal of its nodes' values.

#<개념 노트>
#중위 순회(inorder)
#left->root->right 순으로 노드 출력

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        answer = []
        
        def traverse(root: Optional[TreeNode]) -> None:
            if root is None:
                return
        
            #inorder left->root->right
            traverse(root.left)
            answer.append(root.val)
            traverse(root.right)

        traverse(root)
        return answer
