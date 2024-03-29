-- The Employee table holds all employees. The employee table has three columns: Employee Id, Company Name, and Salary.
--
-- +-----+------------+--------+
-- |Id   | Company    | Salary |
-- +-----+------------+--------+
-- |1    | A          | 2341   |
-- |2    | A          | 341    |
-- |3    | A          | 15     |
-- |4    | A          | 15314  |
-- |5    | A          | 451    |
-- |6    | A          | 513    |
-- |7    | B          | 15     |
-- |8    | B          | 13     |
-- |9    | B          | 1154   |
-- |10   | B          | 1345   |
-- |11   | B          | 1221   |
-- |12   | B          | 234    |
-- |13   | C          | 2345   |
-- |14   | C          | 2645   |
-- |15   | C          | 2645   |
-- |16   | C          | 2652   |
-- |17   | C          | 65     |
-- +-----+------------+--------+
-- Write a SQL query to find the median salary of each company. Bonus points if you can solve it without using any built-in SQL functions.
--
-- +-----+------------+--------+
-- |Id   | Company    | Salary |
-- +-----+------------+--------+
-- |5    | A          | 451    |
-- |6    | A          | 513    |
-- |12   | B          | 234    |
-- |9    | B          | 1154   |
-- |14   | C          | 2645   |
-- +-----+------------+--------+





-- Write your MySQL query statement below
SELECT Id, Company, Salary
FROM (
SELECT *, ROW_NUMBER() OVER(PARTITION BY COMPANY ORDER BY Salary ASC, Id ASC) AS RN_ASC,
ROW_NUMBER() OVER(PARTITION BY COMPANY ORDER BY Salary DESC, Id DESC) AS RN_DESC
FROM Employee) AS temp
WHERE RN_ASC BETWEEN RN_DESC - 1 AND RN_DESC + 1
ORDER BY Company, Salary;





-- Write your MySQL query statement below
SELECT Id, Company, Salary
FROM (SELECT id, company, salary,
			 ROW_NUMBER() OVER(PARTITION BY company ORDER BY salary) salaryrank,
			 COUNT(*) OVER(PARTITION BY company) tte
	  FROM employee) as foo
WHERE salaryrank >= tte/2 AND salaryrank <= tte/2+1





-- Write your MySQL query statement below
WITH table1 AS
(
    SELECT *,
    ROW_NUMBER() OVER (PARTITION BY Company ORDER BY Salary, Id) AS num,
    ROW_NUMBER() OVER (PARTITION BY Company ORDER BY Salary DESC, Id DESC) AS reverse_num
    FROM Employee
)

SELECT Id, Company, Salary
FROM table1
WHERE reverse_num = num
UNION ALL
SELECT Id, Company, Salary
FROM table1
WHERE reverse_num = num + 1
OR reverse_num = num - 1
ORDER BY Company, Id
