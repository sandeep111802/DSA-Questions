# Write your MySQL query statement below
SELECT p.firstName , 
      p.lastName,
      a.city,
      a.state
From person as p
LEFT JOIN Address as a ON p.personId = a.personId      
