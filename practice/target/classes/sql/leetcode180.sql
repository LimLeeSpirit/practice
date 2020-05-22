-- 编写一个 SQL 查询，查找 所有 至少 连续 出现 三次 的数字。

-- 注意是连续出现3次，这道题不是很严谨，他必须声明id是auto-increment 才可以用下面的解法。
-- 连续出现的意味着相同数字的 Id 是连着的，由于这题问的是至少连续出现 3 次，我们使用 Logs 并检查是否有 3 个连续的相同数字。
select distinct l1.Num as ConsecutiveNums
    from Logs l1, Logs l2, Logs l3
    where l2.id - 1 = l1.id and
          l3.id -1 = l2.id and
          l1.Num = l2.Num and
          l3.Num = l2.Num;