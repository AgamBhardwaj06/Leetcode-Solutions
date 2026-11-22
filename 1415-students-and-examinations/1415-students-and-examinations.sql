# Write your MySQL query statement below
select a1.student_id,
a1.student_name,
a2.subject_name,
count(a3.student_id)as attended_exams
from Students as a1
cross join Subjects as a2
left join Examinations as a3
on a3.student_id=a1.student_id
and a2.subject_name=a3.subject_name
group by a1.student_id,a2.subject_name
order by a1.student_id,a2.subject_name asc;