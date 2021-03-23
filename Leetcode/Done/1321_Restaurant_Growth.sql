-- Table: Customer
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | customer_id   | int     |
-- | name          | varchar |
-- | visited_on    | date    |
-- | amount        | int     |
-- +---------------+---------+
-- (customer_id, visited_on) is the primary key for this table.
-- This table contains data about customer transactions in a restaurant.
-- visited_on is the date on which the customer with ID (customer_id) have visited the restaurant.
-- amount is the total paid by a customer.
--
--
-- You are the restaurant owner and you want to analyze a possible expansion (there will be at least one customer every day).
--
-- Write an SQL query to compute moving average of how much customer paid in a 7 days window (current day + 6 days before) .
--
-- The query result format is in the following example:
--
-- Return result table ordered by visited_on.
--
-- average_amount should be rounded to 2 decimal places, all dates are in the format ('YYYY-MM-DD').
--
--
--
-- Customer table:
-- +-------------+--------------+--------------+-------------+
-- | customer_id | name         | visited_on   | amount      |
-- +-------------+--------------+--------------+-------------+
-- | 1           | Jhon         | 2019-01-01   | 100         |
-- | 2           | Daniel       | 2019-01-02   | 110         |
-- | 3           | Jade         | 2019-01-03   | 120         |
-- | 4           | Khaled       | 2019-01-04   | 130         |
-- | 5           | Winston      | 2019-01-05   | 110         |
-- | 6           | Elvis        | 2019-01-06   | 140         |
-- | 7           | Anna         | 2019-01-07   | 150         |
-- | 8           | Maria        | 2019-01-08   | 80          |
-- | 9           | Jaze         | 2019-01-09   | 110         |
-- | 1           | Jhon         | 2019-01-10   | 130         |
-- | 3           | Jade         | 2019-01-10   | 150         |
-- +-------------+--------------+--------------+-------------+
--
-- Result table:
-- +--------------+--------------+----------------+
-- | visited_on   | amount       | average_amount |
-- +--------------+--------------+----------------+
-- | 2019-01-07   | 860          | 122.86         |
-- | 2019-01-08   | 840          | 120            |
-- | 2019-01-09   | 840          | 120            |
-- | 2019-01-10   | 1000         | 142.86         |
-- +--------------+--------------+----------------+
--
-- 1st moving average from 2019-01-01 to 2019-01-07 has an average_amount of (100 + 110 + 120 + 130 + 110 + 140 + 150)/7 = 122.86
-- 2nd moving average from 2019-01-02 to 2019-01-08 has an average_amount of (110 + 120 + 130 + 110 + 140 + 150 + 80)/7 = 120
-- 3rd moving average from 2019-01-03 to 2019-01-09 has an average_amount of (120 + 130 + 110 + 140 + 150 + 80 + 110)/7 = 120
-- 4th moving average from 2019-01-04 to 2019-01-10 has an average_amount of (130 + 110 + 140 + 150 + 80 + 110 + 130 + 150)/7 = 142.86






-- Write your MySQL query statement below
SELECT b.visited_on, SUM(c.amount) AS amount, ROUND(SUM(c.amount)/7, 2) AS average_amount
FROM Customer c, (SELECT DISTINCT visited_on FROM Customer) b
WHERE DATEDIFF(b.visited_on, c.visited_on) BETWEEN 0 AND 6
GROUP BY b.visited_on
HAVING COUNT(DISTINCT c.visited_on)=7







SELECT a.visited_on AS visited_on, SUM(b.day_sum) AS amount,
       ROUND(AVG(b.day_sum), 2) AS average_amount
FROM
  (SELECT visited_on, SUM(amount) AS day_sum FROM Customer GROUP BY visited_on ) a,
  (SELECT visited_on, SUM(amount) AS day_sum FROM Customer GROUP BY visited_on ) b
WHERE DATEDIFF(a.visited_on, b.visited_on) BETWEEN 0 AND 6
GROUP BY a.visited_on
HAVING COUNT(b.visited_on) = 7







SELECT t1.visited_on AS visited_on
      ,SUM(amount) AS amount
      ,ROUND(SUM(amount) / 7, 2) AS average_amount
FROM (SELECT DISTINCT(visited_on) AS visited_on
      FROM Customer
      WHERE DATE_SUB(visited_on, INTERVAL 6 DAY) IN (SELECT DISTINCT(visited_on)
                                                     FROM Customer)) AS t1
LEFT JOIN Customer AS t2
ON t2.visited_on BETWEEN DATE_SUB(t1.visited_on, INTERVAL 6 DAY) AND t1.visited_on
GROUP BY t1.visited_on