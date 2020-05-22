-- 部门工资前三高的所有员工

SELECT
	Department.NAME AS Department,
	e1.NAME AS Employee,
	e1.Salary AS Salary
FROM
	Employee AS e1,Department
WHERE
	e1.DepartmentId = Department.Id
	AND 3 > (SELECT  count( DISTINCT e2.Salary )
			 FROM	Employee AS e2
			 WHERE	e1.Salary < e2.Salary 	AND e1.DepartmentId = e2.DepartmentId 	)
ORDER BY Department.NAME,Salary DESC;

-- 其中: 先找出公司里前 3 高的薪水，意思是不超过三个值比这些值大
-- 设置参照e2，对于同部门 e1中的薪水小于e2的，计算此时e2的去重个数不同，e2
SELECT e1.Salary
FROM Employee AS e1
WHERE 3 >
		(SELECT  count(DISTINCT e2.Salary)
		 FROM	Employee AS e2
	 	 WHERE	e1.Salary < e2.Salary 	AND e1.DepartmentId = e2.DepartmentId) ;
