-- 体育馆，每日人流量信息被记录在这三列信息中：序号 (id)、日期 (visit_date)、 人流量 (people)
-- 找出人流量的高峰期。高峰期时，至少连续三行记录中的人流量不少于100.

-- 法1：三表内联，注意是以s1为基准的
select distinct s1.* from
    stadium s1, stadium s2, stadium s3
    where (
        (s1.id +1 = s2.id and s2.id+1 = s3.id ) or -- s1, s2, s3  s1最小值
        (s2.id +1 = s1.id and s1.id+1 = s3.id ) or -- s2, s1, s3  s1中间值
        (s2.id +1 = s3.id and s3.id+1 = s1.id )    -- s2, s3, s1  s1最大值
    ) and s1.people>=100 and s2.people>=100 and s3.people>=100
    order by id;

-- 法2，，，仍然是3表内联，咋这个效率这么高呢。发现在将条件增强后，比如下面的将三个条件都写出来，要比上面的两个条件的写法更快

select distinct t1.*
from stadium t1, stadium t2, stadium t3
where t1.people >= 100 and t2.people >= 100 and t3.people >= 100
and
(
	(t1.id - t2.id = 1 and t1.id - t3.id = 2 and t2.id - t3.id =1)  -- t1, t2, t3  t1最大
    or
    (t2.id - t1.id = 1 and t2.id - t3.id = 2 and t1.id - t3.id =1) -- t2, t1, t3   t1中间
    or
    (t3.id - t2.id = 1 and t2.id - t1.id =1 and t3.id - t1.id = 2) -- t3, t2, t1   t1最小
)
order by t1.id
;