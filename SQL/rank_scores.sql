--LeetCode 178. Rank Scores(Medium)

select score, dense_rank() over (order by score desc) as "rank"
from Scores;