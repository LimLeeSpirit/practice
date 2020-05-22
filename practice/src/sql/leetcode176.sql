-- 获取 Employee 表中第二高的薪水（Salary）
-- limit y : 读取 y 条数据
-- limit x, y : 跳过 x 条数据，读取 y 条数据

select (
	select DISTINCT Salary
	from Employee
	order by Salary DESC
	limit 1,1)
as SecondHighestSalary;