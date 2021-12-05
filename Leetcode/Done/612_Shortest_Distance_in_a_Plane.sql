-- Table point_2d holds the coordinates (x,y) of some unique points (more than two) in a plane.
--
--
-- Write a query to find the shortest distance between these points rounded to 2 decimals.
--
--
-- | x  | y  |
-- |----|----|
-- | -1 | -1 |
-- | 0  | 0  |
-- | -1 | -2 |
--
--
-- The shortest distance is 1.00 from point (-1,-1) to (-1,2). So the output should be:
--
--
-- | shortest |
-- |----------|
-- | 1.00     |
--
--
-- Note: The longest distance among all the points are less than 10000.
--





-- Write your MySQL query statement below
SELECT MIN(ROUND(SQRT(POW(t1.x - t2.x, 2) + POW(t1.y - t2.y, 2)), 2)) AS shortest
FROM point_2d t1 JOIN point_2d t2 ON (t1.x <= t2.x AND t1.y < t2.y)
        OR (t1.x <= t2.x AND t1.y > t2.y)
        OR (t1.x < t2.x AND t1.y = t2.y)
