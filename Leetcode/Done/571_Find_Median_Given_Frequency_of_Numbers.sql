-- The Numbers table keeps the value of number and its frequency.
--
-- +----------+-------------+
-- |  Number  |  Frequency  |
-- +----------+-------------|
-- |  0       |  7          |
-- |  1       |  1          |
-- |  2       |  3          |
-- |  3       |  1          |
-- +----------+-------------+
-- In this table, the numbers are 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 3, so the median is (0 + 0) / 2 = 0.
--
-- +--------+
-- | median |
-- +--------|
-- | 0.0000 |
-- +--------+
-- Write a query to find the median of all numbers and name the result as median.






-- Write your MySQL query statement below
SELECT AVG(number) AS median
FROM Numbers n
WHERE frequency >= ABS((SELECT SUM(Frequency) FROM Numbers WHERE Number<=n.Number) -
                         (SELECT SUM(Frequency) FROM Numbers WHERE Number>=n.Number))





WITH tmp AS (
  SELECT Number,
         Frequency,
         SUM(Frequency) OVER (ORDER BY Number ASC) rk1,
         SUM(Frequency) OVER (ORDER BY Number DESC) rk2
  FROM Numbers)

SELECT AVG(Number) AS median
FROM tmp
WHERE ABS(rk1-rk2)<=Frequency
