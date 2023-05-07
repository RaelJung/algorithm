-- LeetCode 584. Find Customer Referee(Easy)

select name
from Customer
where referee_id != 2 or referee_id is null;