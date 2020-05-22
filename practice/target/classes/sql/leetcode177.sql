-- 获取 Employee 表中第 n 高的薪水（Salary）。
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  declare count int default N-1;
  if (count < 0) then
    return null;
  else
  RETURN (
      # Write your MySQL query statement below.
        SELECT IFNULL(
            (
               SELECT DISTINCT Salary
                FROM Employee
                ORDER BY Salary DESC
                LIMIT count, 1
            ), NULL
        ) AS SecondHighestSalary
    );
    END IF;
END