-- 查找与之前（昨天的）日期相比温度更高的所有日期的 Id。

-- MySQL 使用 DATEDIFF 来比较两个日期类型的值。前-后

SELECT
    weather.id AS 'Id'
FROM
    weather
        JOIN
    weather w ON DATEDIFF(weather.RecordDate, w.RecordDate) = 1
        AND weather.Temperature > w.Temperature;
