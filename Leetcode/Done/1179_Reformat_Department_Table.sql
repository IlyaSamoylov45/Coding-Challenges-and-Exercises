-- Table: Department
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | id            | int     |
-- | revenue       | int     |
-- | month         | varchar |
-- +---------------+---------+
-- (id, month) is the primary key of this table.
-- The table has information about the revenue of each department per month.
-- The month has values in ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"].
--
--
-- Write an SQL query to reformat the table such that there is a department id column and a revenue column for each month.
--
-- The query result format is in the following example:
--
-- Department table:
-- +------+---------+-------+
-- | id   | revenue | month |
-- +------+---------+-------+
-- | 1    | 8000    | Jan   |
-- | 2    | 9000    | Jan   |
-- | 3    | 10000   | Feb   |
-- | 1    | 7000    | Feb   |
-- | 1    | 6000    | Mar   |
-- +------+---------+-------+
--
-- Result table:
-- +------+-------------+-------------+-------------+-----+-------------+
-- | id   | Jan_Revenue | Feb_Revenue | Mar_Revenue | ... | Dec_Revenue |
-- +------+-------------+-------------+-------------+-----+-------------+
-- | 1    | 8000        | 7000        | 6000        | ... | null        |
-- | 2    | 9000        | null        | null        | ... | null        |
-- | 3    | null        | 10000       | null        | ... | null        |
-- +------+-------------+-------------+-------------+-----+-------------+
--
-- Note that the result table has 13 columns (1 for the department id + 12 for the months).






# Write your MySQL query statement below
select id, SUM(CASE when month = "Jan" THEN revenue ELSE null END) AS Jan_Revenue,
SUM(CASE when month = "Feb" THEN revenue ELSE null END) AS Feb_Revenue,
SUM(CASE when month = "Mar" THEN revenue ELSE null END) AS Mar_Revenue,
SUM(CASE when month = "Apr" THEN revenue ELSE null END) AS Apr_Revenue,
SUM(CASE when month = "May" THEN revenue ELSE null END) AS May_Revenue,
SUM(CASE when month = "Jun" THEN revenue ELSE null END) AS Jun_Revenue,
SUM(CASE when month = "Jul" THEN revenue ELSE null END) AS Jul_Revenue,
SUM(CASE when month = "Aug" THEN revenue ELSE null END) AS Aug_Revenue,
SUM(CASE when month = "Sep" THEN revenue ELSE null END) AS Sep_Revenue,
SUM(CASE when month = "Oct" THEN revenue ELSE null END) AS Oct_Revenue,
SUM(CASE when month = "Nov" THEN revenue ELSE null END) AS Nov_Revenue,
SUM(CASE when month = "Dec" THEN revenue ELSE null END) AS Dec_Revenue
from Department
group by id
