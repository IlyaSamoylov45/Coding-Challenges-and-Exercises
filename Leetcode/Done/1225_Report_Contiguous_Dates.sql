-- Table: Failed
--
-- +--------------+---------+
-- | Column Name  | Type    |
-- +--------------+---------+
-- | fail_date    | date    |
-- +--------------+---------+
-- Primary key for this table is fail_date.
-- Failed table contains the days of failed tasks.
-- Table: Succeeded
--
-- +--------------+---------+
-- | Column Name  | Type    |
-- +--------------+---------+
-- | success_date | date    |
-- +--------------+---------+
-- Primary key for this table is success_date.
-- Succeeded table contains the days of succeeded tasks.
--
--
-- A system is running one task every day. Every task is independent of the previous tasks. The tasks can fail or succeed.
--
-- Write an SQL query to generate a report of period_state for each continuous interval of days in the period from 2019-01-01 to 2019-12-31.
--
-- period_state is 'failed' if tasks in this interval failed or 'succeeded' if tasks in this interval succeeded. Interval of days are retrieved as start_date and end_date.
--
-- Order result by start_date.
--
-- The query result format is in the following example:
--
-- Failed table:
-- +-------------------+
-- | fail_date         |
-- +-------------------+
-- | 2018-12-28        |
-- | 2018-12-29        |
-- | 2019-01-04        |
-- | 2019-01-05        |
-- +-------------------+
--
-- Succeeded table:
-- +-------------------+
-- | success_date      |
-- +-------------------+
-- | 2018-12-30        |
-- | 2018-12-31        |
-- | 2019-01-01        |
-- | 2019-01-02        |
-- | 2019-01-03        |
-- | 2019-01-06        |
-- +-------------------+
--
--
-- Result table:
-- +--------------+--------------+--------------+
-- | period_state | start_date   | end_date     |
-- +--------------+--------------+--------------+
-- | succeeded    | 2019-01-01   | 2019-01-03   |
-- | failed       | 2019-01-04   | 2019-01-05   |
-- | succeeded    | 2019-01-06   | 2019-01-06   |
-- +--------------+--------------+--------------+
--
-- The report ignored the system state in 2018 as we care about the system in the period 2019-01-01 to 2019-12-31.
-- From 2019-01-01 to 2019-01-03 all tasks succeeded and the system state was "succeeded".
-- From 2019-01-04 to 2019-01-05 all tasks failed and system state was "failed".
-- From 2019-01-06 to 2019-01-06 all tasks succeeded and system state was "succeeded".






SELECT period_state,  MIN(day) AS start_date, MAX(day) AS end_date
FROM (
    SELECT day,
           period_state,
           ROW_NUMBER() OVER (ORDER BY period_state, day ASC) AS seq
    FROM (
        SELECT fail_date AS day, 'failed' AS period_state
        FROM failed

        UNION

        SELECT success_date AS day, 'succeeded' AS period_state
        FROM succeeded
    ) AS t
    WHERE day BETWEEN '2019-01-01' AND '2019-12-31'
) AS t2
GROUP BY DATE_ADD(day, INTERVAL -seq DAY), period_state
ORDER BY start_date ASC






-- Write your MySQL query statement below
SELECT stats AS period_state, MIN(day) AS start_date, MAX(day) AS end_date
FROM (
    SELECT day,
           RANK() OVER (ORDER BY day) AS overall_ranking,
           stats,
           rk,
           (RANK() OVER (ORDER BY day) - rk) AS inv
    FROM (
        SELECT fail_date AS day, 'failed' AS stats, RANK() OVER (ORDER BY fail_date) AS rk
        FROM Failed
        WHERE fail_date BETWEEN '2019-01-01' AND '2019-12-31'
        UNION
        SELECT success_date AS day, 'succeeded' AS stats, RANK() OVER (ORDER BY success_date) AS rk
        FROM Succeeded
        WHERE success_date BETWEEN '2019-01-01' AND  '2019-12-31'
     ) AS t
) c
GROUP BY inv, stats
ORDER BY start_date






WITH periods AS (
    SELECT fail_date AS day,
           'failed' AS period
    FROM failed

    UNION

    SELECT success_date AS day,
           'succeeded' AS period
    FROM succeeded
), parts AS (
    SELECT day,
           period,
           ROW_NUMBER() OVER (ORDER BY period, day ASC) AS seq
    FROM periods
    WHERE day BETWEEN '2019-01-01' AND '2019-12-31'
), diff AS (
    SELECT day,
           period,
           DATE_ADD(day, INTERVAL -seq DAY) AS seqStart
    FROM parts
)

SELECT period AS period_state, MIN(day) AS start_date, MAX(day) AS end_date
FROM diff
GROUP BY seqStart, period
ORDER BY start_date ASC







WITH periods AS (
    SELECT fail_date AS day,
           'failed' AS period
    FROM failed

    UNION

    SELECT success_date AS day,
           'succeeded' AS period
    FROM succeeded
), parts AS (
    SELECT day,
           period,
           ROW_NUMBER() OVER (ORDER BY period, day ASC) AS seq
    FROM periods
    WHERE day BETWEEN '2019-01-01' AND '2019-12-31'
)

SELECT period AS period_state, MIN(day) AS start_date, MAX(day) AS end_date
FROM parts
GROUP BY DATE_ADD(day, INTERVAL -seq DAY), period
ORDER BY start_date ASC
