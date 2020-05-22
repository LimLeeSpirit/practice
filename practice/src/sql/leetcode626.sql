--  有一张 seat 座位表，平时用来储存学生名字和与他们相对应的座位 id。
--  其中纵列的 id 是连续递增的

-- 改变相邻俩学生的座位。1 2 3 4 5 改变为 2 1 4 3 5
-- 转换思路为修改id， 然后将id升序排列

-- 法1 双层嵌套 if 查询
select
    if(mod(id, 2)= 0, id-1, if(id=( select max(id) from seat), id, id+1))
as id, student
     -- id为偶数则-1，为奇数且不是最大值则+1
from seat
order by id


-- 法2 类似的用 case when 的方式查询
select
    case when id%2=0 then id-1 else (
         case when id=(select max(id) from seat) then id else id+1 end
    ) end
as id, student
from seat order by id;
