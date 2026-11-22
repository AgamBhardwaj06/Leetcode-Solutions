# Write your MySQL query statement below
select a1.name 
from Employee as a1
inner join Employee as a2
on a1.id=a2.managerId
group by a1.id,a1.name
having count(a2.id)>=5;
