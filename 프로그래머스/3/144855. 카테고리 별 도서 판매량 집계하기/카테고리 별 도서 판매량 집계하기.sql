-- 코드를 입력하세요
SELECT b.category,
       sum(case when bs.sales_date like '2022-01%' then bs.sales else 0 end) as total_sales
from book b
left join book_sales bs on b.book_id = bs.book_id
group by b.category
order by b.category;