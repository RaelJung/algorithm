#LeetCode 226. Invert Binary Tree

#Given the root of a binary tree, invert the tree, and return its root.

#BFS로 풀이
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        queue = collections.deque([root])

        while queue:
            node = queue.popleft()
            #부모 노드로부터 하향식 스왑
            if node:
                node.left, node.right = node.right, node.left

                queue.append(node.left)
                queue.append(node.right)

        return root

#파이썬다운 방식
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root:
            root.left, root.right = \
                self.invertTree(root.right), self.invertTree(root.left)
            return root
        return None

#DFS로도 풀 수 있음