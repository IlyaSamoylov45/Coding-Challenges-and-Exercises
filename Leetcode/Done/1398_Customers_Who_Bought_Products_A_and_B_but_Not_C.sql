-- Table: Customers
--
-- +---------------------+---------+
-- | Column Name         | Type    |
-- +---------------------+---------+
-- | customer_id         | int     |
-- | customer_name       | varchar |
-- +---------------------+---------+
-- customer_id is the primary key for this table.
-- customer_name is the name of the customer.
--
--
-- Table: Orders
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | order_id      | int     |
-- | customer_id   | int     |
-- | product_name  | varchar |
-- +---------------+---------+
-- order_id is the primary key for this table.
-- customer_id is the id of the customer who bought the product "product_name".
--
--
-- Write an SQL query to report the customer_id and customer_name of customers who bought products "A", "B" but did not buy the product "C" since we want to recommend them buy this product.
--
-- Return the result table ordered by customer_id.
--
-- The query result format is in the following example.
--
--
--
-- Customers table:
-- +-------------+---------------+
-- | customer_id | customer_name |
-- +-------------+---------------+
-- | 1           | Daniel        |
-- | 2           | Diana         |
-- | 3           | Elizabeth     |
-- | 4           | Jhon          |
-- +-------------+---------------+
--
-- Orders table:
-- +------------+--------------+---------------+
-- | order_id   | customer_id  | product_name  |
-- +------------+--------------+---------------+
-- | 10         |     1        |     A         |
-- | 20         |     1        |     B         |
-- | 30         |     1        |     D         |
-- | 40         |     1        |     C         |
-- | 50         |     2        |     A         |
-- | 60         |     3        |     A         |
-- | 70         |     3        |     B         |
-- | 80         |     3        |     D         |
-- | 90         |     4        |     C         |
-- +------------+--------------+---------------+
--
-- Result table:
-- +-------------+---------------+
-- | customer_id | customer_name |
-- +-------------+---------------+
-- | 3           | Elizabeth     |
-- +-------------+---------------+
-- Only the customer_id with id 3 bought the product A and B but not the product C.





-- Write your MySQL query statement below
SELECT customer_id, customer_name
FROM Customers c
WHERE customer_id IN
(
    SELECT customer_id
    FROM Orders
    WHERE product_name='A'
) AND customer_id IN
(
    SELECT customer_id
    FROM Orders
    WHERE product_name='B'
) AND customer_id NOT IN
(
    SELECT customer_id
    FROM Orders
    WHERE product_name='C'
)






-- Write your MySQL query statement below
SELECT c.customer_id, c.customer_name
FROM Customers AS c
    INNER JOIN
    (SELECT customer_id,
        SUM(CASE
        WHEN product_name = 'A' THEN 1
        WHEN product_name = 'B' THEN 1
        WHEN product_name = 'C' THEN -1
        ELSE 0 END) AS tot
    FROM Orders
    GROUP BY customer_id
    HAVING tot > 1) AS o
WHERE c.customer_id = o.customer_id






-- Write your MySQL query statement below
SELECT
    C.CUSTOMER_ID,
    C.CUSTOMER_NAME
FROM
    ORDERS O
    JOIN CUSTOMERS C ON (O.CUSTOMER_ID = C.CUSTOMER_ID)
GROUP BY
    C.CUSTOMER_ID,
    C.CUSTOMER_NAME
HAVING
    SUM(CASE WHEN O.PRODUCT_NAME = 'A' THEN 1 ELSE 0 END) > 0 AND
    SUM(CASE WHEN O.PRODUCT_NAME = 'B' THEN 1 ELSE 0 END) > 0 AND
    SUM(CASE WHEN O.PRODUCT_NAME = 'C' THEN 1 ELSE 0 END) = 0
