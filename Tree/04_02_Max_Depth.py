#LeetCode 104. Maximum Depth of Binary Tree

#책 389 BFS 방식 -> 왜 정답이 맞지 않는지?

#DFS 풀이
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        def dfs(root, depth):
            if not root: return depth
            return max(dfs(root.left, depth + 1), dfs(root.right, depth + 1))
                       
        return dfs(root, 0)


