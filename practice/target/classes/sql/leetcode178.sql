-- 分数排名

-- 法1  645ms
-- 感觉是自连接的意思，很聪明
-- 对于a表中的每一个分数score，找出b表中有多少个大于或等于该分数的不同的分数，然后按降序排列
select
    a.Score as score ,
    (select count(distinct b.Score) from Scores b where b.Score >= a.Score) as rank
    from Scores a order by Score DESC;


--法2   225ms
select Score,
       (select count(*)+1 from (select distinct(Score) from scores) as uniqueScore
       where Score > sc.score) as Rank from Scores as sc order by Score desc;