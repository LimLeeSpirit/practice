
-- 查出 2013年10月1日 至 2013年10月3日 期间非禁止用户的取消率

-- 针对两个表的综合查询，

select a.day, round(sum(a.cancel)/count(a.cancel),2) 'Cancellation Rate'
from (select t1.request_at day, if(t1.status != 'completed',1,0) cancel
from trips t1 inner join users t2 on t1.client_id = t2.users_id
where request_at between '2013-10-01' and '2013-10-03'
and t2.banned = 'no') a
group by a.day


-- 法2 更方便理解点
SELECT
	a.Request_at AS DAY,
	ROUND( sum( CASE WHEN a.STATUS != "completed" THEN 1 ELSE 0 END ) / count( a.id ), 2 ) AS "Cancellation Rate"
FROM
	Trips a
	LEFT JOIN Users b ON a.client_id = b.users_id
WHERE
	b.Banned = "No"
	AND a.Request_at BETWEEN "2013-10-01"
	AND "2013-10-03"
GROUP BY
	a.Request_at