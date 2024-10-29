-- 2022년 8월부터 2022년 10월까지 총 대여 횟수 5회 이상
select month(start_date) as month, car_id, count(*) as records
from car_rental_company_rental_history
where car_id in (select car_id
                from car_rental_company_rental_history
                where date_format(start_date, '%Y-%m') between '2022-08' and '2022-10'
                group by car_id
                having count(*) >= 5)
        and date_format(start_date, '%Y-%m') between '2022-08' and '2022-10'
group by car_id, month
order by month asc, car_id desc;