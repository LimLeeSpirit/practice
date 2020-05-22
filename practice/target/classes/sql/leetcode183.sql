-- 某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。

select Customers.Name as Customers from Customers where id not in
    ( select CustomerId from Orders);