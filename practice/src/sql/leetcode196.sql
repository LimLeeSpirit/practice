-- 删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小 的那个。

-- 法1：delete + 自连接
DELETE P1
FROM Person P1, Person P2
WHERE P1.Email = P2.Email   -- 利用where进行自连接
AND P1.Id > P2.Id   -- 选择Id较大的行

-- 法2：delete + 子查询
delete from Person
    where Id not in (
        select Id from (
            select min(id) as ID from Person
            group by Email
        ) as tmp;
    );
