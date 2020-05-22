-- 给定一个 salary 表，有 m = 男性 和 f = 女性 的值。
-- 交换所有的 f 和 m 值（例如，将所有 f 值更改为 m，反之亦然

-- 终于学会了 if(条件， 结果1， 结果2)的写法了
-- if (condition, exp1, exp2)
-- condition==true: 返回exp1， 否则返回exp2。

update salary set sex = ( if(sex='m', 'f', 'm'));

-- case when condition1 then exp1
--      when condition2 then exp2
--      ...
--      else exp3
--      end
update salary set sex = ( case when sex='m' then 'f'
                               when sex='f' then 'm' end);