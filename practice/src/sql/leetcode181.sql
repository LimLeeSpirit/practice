-- Employee 表包含所有员工，他们的经理也属于员工。每个员工都有一个 Id，此外还有一列对应员工的经理的 Id。

-- 法1。  算是简单的，自己就写出来了，不就是比较自己的Salary和他经理的Salary嘛。
select name as Employee from Employee a
        where a.Salary > (select Salary from Employee b where a.ManagerId = b.Id);

-- 法2，  用内连接的方式更快
SELECT m.Name as Employee
    FROM employee as e
    INNER JOIN employee as m
    ON e.id = m.managerid
    WHERE e.salary < m.salary