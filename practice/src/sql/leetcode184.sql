-- 找出每个部门工资最高的员工
-- Employee 表包含所有员工信息，每个员工有其对应的 Id, salary 和 department Id。
-- Department 表包含公司所有部门的信息。

-- 关键是先找出每个部门的最高工资，将部门和最高工资建一个表
select c.Name Department, a.Name Employee,a.Salary Salary
from Employee a
left join
    (select DepartmentId,max(Salary) max_Salary from Employee group by DepartmentId) b
on a.DepartmentId=b.DepartmentId

left join
Department c
on a.DepartmentId=c.Id

where a.Salary = max_Salary
and c.Name is not null;