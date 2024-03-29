-- In facebook, there is a follow table with two columns: followee, follower.
--
-- Please write a sql query to get the amount of each follower’s follower if he/she has one.
--
-- For example:
--
-- +-------------+------------+
-- | followee    | follower   |
-- +-------------+------------+
-- |     A       |     B      |
-- |     B       |     C      |
-- |     B       |     D      |
-- |     D       |     E      |
-- +-------------+------------+
-- should output:
-- +-------------+------------+
-- | follower    | num        |
-- +-------------+------------+
-- |     B       |  2         |
-- |     D       |  1         |
-- +-------------+------------+
-- Explaination:
-- Both B and D exist in the follower list, when as a followee, B's follower is C and D, and D's follower is E. A does not exist in follower list.
--
--
--
--
-- Note:
-- Followee would not follow himself/herself in all cases.
-- Please display the result in follower's alphabet order.
--





-- Write your MySQL query statement below
SELECT followee AS follower, COUNT(DISTINCT(follower)) AS num
FROM Follow
WHERE followee IN (
    SELECT DISTINCT(follower)
    FROM Follow
)
GROUP BY followee
ORDER BY follower





SELECT f1.follower, COUNT(DISTINCT(f2.follower)) AS num
FROM Follow f1 JOIN Follow f2 ON (f1.follower = f2.followee)
GROUP BY f2.followee
ORDER BY f1.follower
