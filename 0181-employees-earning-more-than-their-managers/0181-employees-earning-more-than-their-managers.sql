# Write your MySQL query statement below
SELECT
    e.name AS Employee
FROM Employee AS e
JOIN Employee  AS m
ON e.managerid = m.id
WHERE e.salary > m.salary;
