package feiWoSCun.从不订购的客户183;

/**
 * @Description：懂的人自然懂
 * @Author: feiWoSCun
 * @Email: 2825097536@qq.com
 * @Date: 2023.1.13
 */

/**
 * 183. 从不订购的客户
 * 简单
 * 410
 * 相关企业
 * SQL Schema
 * 某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。
 *
 * Customers 表：
 *
 * +----+-------+
 * | Id | Name  |
 * +----+-------+
 * | 1  | Joe   |
 * | 2  | Henry |
 * | 3  | Sam   |
 * | 4  | Max   |
 * +----+-------+
 * Orders 表：
 *
 * +----+------------+
 * | Id | CustomerId |
 * +----+------------+
 * | 1  | 3          |
 * | 2  | 1          |
 * +----+------------+
 * 例如给定上述表格，你的查询应返回：
 *
 * +-----------+
 * | Customers |
 * +-----------+
 * | Henry     |
 * | Max       |
 * +-----------+
 */
public class Solution {
    /**
     *  select c.Name Customers from Customers c where c.Id not in
     * (select o.CustomerId from Orders o)
     */

}
