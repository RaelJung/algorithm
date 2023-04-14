#LeetCode 944. Delete Columns to Make Sorted(Easy)

class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        return sum(col != sorted(col) for col in map(list, zip(*strs)))
            

#sorted와 form을 맞춰주기 위해서 map(list, zip(*strs))사용
