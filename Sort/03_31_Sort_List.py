#LeetCode 148. Sort List

#Given the head of a linked list, return the list after sorting it in ascending order.

class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        #연결리스트 -> 파이썬 리스트
        p = head
        lst: List = []
        while p:
            lst.append(p.val)
            p = p.next

        #정렬
        lst.sort()

        #파이썬 리스트 -> 연결 리스트
        p=head
        for i in range(len(lst)):
            p.val = lst[i]
            p = p.next
        return head