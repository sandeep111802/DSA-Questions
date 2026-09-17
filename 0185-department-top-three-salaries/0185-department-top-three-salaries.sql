# Write your MySQL query statement below
WITH TOPTHREESALRIES AS(
    SELECT d.name AS Department,e.name AS Employee,e.salary AS Salary,
    DENSE_RANK() OVER(
        PARTITION BY d.name
        ORDER BY e.salary DESC
    ) AS rnk
    FROM Employee AS e
    LEFT JOIN Department AS d
    ON e.departmentID = d.id
)

SELECT Department,Employee, Salary
From TOPTHREESALRIES
WHERE rnk <=3;