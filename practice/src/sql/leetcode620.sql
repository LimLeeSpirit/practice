-- 找出所有影片描述为非 boring (不无聊) 的并且 id 为奇数 的影片，结果请按等级 rating 排列。

-- <> 等价于 !=;       mod(n, 2) 等价于 n%2     desc降序  默认升序（ASC）
select * from cinema where description <> 'boring' and id%2=1 order by rating desc;