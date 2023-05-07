-- LeetCode 182. Duplicate Emails(Easy)

select email
from Person
group by email
having count(*) > 1