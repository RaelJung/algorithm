SELECT BOOK_ID, date_format(PUBLISHED_DATE, '%Y-%m-%d')
FROM book
WHERE published_date LIKE '2021-%' and category = '인문'
ORDER BY published_date asc;