create  table sc (
    name varchar(20) not null,
    courseId varchar(20) not null ,
    grade int
)
insert into sc values('lzz', 1, 90);
insert into sc values('lxx', 1, 89);
insert into sc values('lll', 1, 32);

insert into sc values('lzz', 3, 23);
insert into sc values('lxx', 2, 34);
insert into sc values('lll', 3, 45);

insert into sc values('lzz', 2, 45);
insert into sc values('lxx', 3, 90);
insert into sc values('lll', 2, 65);

select * from sc order by courseId, grade;
--  写个博客

--1 查询每个学生的总成绩
select name, sum(grade) as total from sc group by name order by total desc;

--2 查询每个学生的平均成绩
select name, avg(grade) as average from sc group by name order by average desc;

--3 查询每门课最高分的成绩
select max(grade) from sc group by courseId s2;

select distinct s1.* from sc s1,
(select max(grade)  maxGrade from sc group by courseId) s2
where s1.grade = s2.maxGrade order by courseId;

--4 查询每个学生最高分的成绩与对应课程
-- 首先查出每个学生对应最高分
select A.name, A.courseId, A.grade from sc A inner join
    (select name, max(grade) max_grade from sc group by name) B
    on A.name = B.name AND A.grade = B.max_grade order by A.name;



-- 分组 TopK 查询

--5  分组取 每组最大值
-- 查询每门课最高分及其对应学生姓名： name, courseId, grade
select * from sc a where a.grade = (
    select max(b.grade) from sc b where b.courseId = a.courseId
);  -- 相关子查询问题

--6  分组取 每组最小值
-- 查询每门课最低分及其对应学生姓名： name, courseId, grade
select * from sc a where a.grade = (
    select min(b.grade) from sc b where b.courseId = a.courseId
);  -- 相关子查询问题

--7 查询每门课成绩前2名的记录
-- 问题划分：求课程1前两名的记录：
select * from sc where courseId = '1' order by grade desc limit 0,2;
-- 然后将3个课程的查询情况联合起来 union代表合并两个或多个 SELECT 语句的结果集，且结果集要求有相同的列和数据类型
--                           union会去重，若要保存重复值，可以用union all
(select * from sc where courseId = '1' order by grade desc limit 0,2)
union all
(select * from sc where courseId = '2' order by grade desc limit 0,2)
union all
(select * from sc where courseId = '1' order by grade desc limit 0,2);

-- 牛逼的写法！
-- 使用自连接查询，前2名，前一个表的某行记录分数小于后一表的行分数 的 个数 不超过2，即第一个表的前一行分数肯定是前2的
SELECT s1.* FROM sc s1 WHERE
    ( SELECT COUNT(*) FROM sc s2 WHERE s1.courseId=s2.courseId AND s2.grade>=s1.grade)<3
ORDER BY s1.courseId,s1.grade DESC;

--8 查询出 所有课程中 的第二名的信息
(select * from sc where courseId = '1' order by grade desc limit 1,1)
union all
(select * from sc where courseId = '2' order by grade desc limit 1,1)
union all
(select * from sc where courseId = '1' order by grade desc limit 1,1);


SELECT s1.* FROM sc s1 WHERE
    ( SELECT COUNT(*) FROM sc s2 WHERE s1.courseId=s2.courseId AND s2.grade>s1.grade)=1
    order by s1.courseId, s1.grade;

--9 查询出 courseId=1 的第二名的信息。
select * from sc where courseId = '1' order by grade desc limit 1,1;

SELECT s1.* FROM sc s1 WHERE
    ( SELECT COUNT(*) FROM sc s2 WHERE s1.courseId=s2.courseId AND s2.grade>s1.grade)=1
    and s1.courseId=1;

--10 查询出 courseId=1 的2-3名的信息
select * from sc where courseId = '1' order by grade desc limit 1,3;

select s1.* from sc s1 where
    ((select count(*) from sc s2 where s1.courseId=s2.courseId and s2.grade > s1.grade)=1 or
    (select count(*) from sc s2 where s1.courseId=s2.courseId and s2.grade > s1.grade)=2)
    and s1.courseId=1;

-- 不就是要让叉出来的结果在一个区间嘛，那就用 between a and b.
select s1.* from sc s1 where
    ((select count(*) from sc s2 where s1.courseId=s2.courseId and s2.grade > s1.grade) between 1 and 2)
    and s1.courseId=1 order by s1.grade desc;

-- 多表联合查询
-- 11 查询出每门课的及格人数和不及格人数  考车case when 或者 if(condition，exp1，exp2)
select coureId, sum(case when grade >= 60 then 1 else 0 end) as 及格,
                sum(case when grade < 60 then 1 else 0 end) as 不及格,
                from sc group by courseId;

-- 12 查询每个同学的及格科目数和不及格科目数
select name, sum(case when grade >= 60 then 1 else 0 end) as 及格数,
             sum(case when grade < 60 then 1 else 0 end) as 不及格数,
             from sc group by name;

-- 13 使用分数段统计[100-85], [85-70], [70-60], 60以下 来统计各科成绩，分别统计：课程id、各分段人数
select courseId, sum(case when grade between 85 and 100 then 1 else 0 end) as '100-85',
                 sum(case when grade between 70 and 84 then 1 else 0 end) as '85-70',
                 sum(case when grade between 60 and 69 then 1 else 0 end) as '70-60',
                 sum(case when grade < 60 then 1 else 0 end) as '不及格'
                 from sc group by courseId;

-- 行列反转
-- 14 输出为 name 课程1 课程2 课程3 行值分别就是一个同学的每个课程的分数
select a.name,
    (select grade from sc b where courseId = 1 and a.name = b.name) as '课程1',
    (select grade from sc b where courseId = 2 and a.name = b.name) as '课程2',
    (select grade from sc b where courseId = 3 and a.name = b.name) as '课程3'
    from sc a group by a.name;

-- 15 输出为 name, courseId, grade, mark 最后一行代表pass/fail
select name, courseId, grade, if (grade >= 60, 'pass', 'fail') as 'mark'
    from sc;

-- 条件查询、子查询、分组查询、分组条件查询、联合查询、联合条件查询
-- 行列反转输出、增加行显示输出