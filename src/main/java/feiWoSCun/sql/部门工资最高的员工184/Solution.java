package feiWoSCun.sql.部门工资最高的员工184;

/**
 * @Description：懂的人自然懂
 * @Author: feiWoSCun
 * @Email: 2825097536@qq.com
 * @Date: 2023.1.17
 *
 *时间 637 ms 击败  80.70%
 *
 * answer:
 *
 * select e.name Employee,
 * D.name Department,
 * e.salary Salary
 * from Employee e
 * left join Department D on e.departmentId = D.id
 * where (departmentId, salary) in (select any_value(departmentId), max(salary) from Employee e group by e.departmentId);
 *
 *
 */
public class Solution {





/*编写SQL查询以查找每个部门中薪资最高的员工。
按 任意顺序 返回结果表。*/
/*表： Employee、
+--------------+---------+
| 列名          | 类型    |
+--------------+---------+
| id           | int     |
| name         | varchar |
| salary       | int     |
| departmentId | int     |
+--------------+---------+
id是此表的主键列。
departmentId是Department表中ID的外键。
此表的每一行都表示员工的ID、姓名和工资。它还包含他们所在部门的ID。
表： Department
+-------------+---------+
| 列名         | 类型    |
+-------------+---------+
| id          | int     |
| name        | varchar |
+-------------+---------+
id是此表的主键列。
此表的每一行都表示一个部门的ID及其名称。



查询结果格式如下例所示。
示例 1:输入：
Employee 表:
+----+-------+--------+--------------+
| id | name  | salary | departmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Jim   | 90000  | 1            |
| 3  | Henry | 80000  | 2            |
| 4  | Sam   | 60000  | 2            |
| 5  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
Department 表:
+----+-------+
| id | name  |
+----+-------+
| 1  | IT    |
| 2  | Sales |
+----+-------+
输出：
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Jim      | 90000  |
| Sales      | Henry    | 80000  |
| IT         | Max      | 90000  |
+------------+----------+--------+
解释：Max 和 Jim 在 IT 部门的工资都是最高的，Henry 在销售部的工资最高。*/


    /**
     * SELECT
     *     d.Name AS 'Department', e1.Name AS 'Employee', e1.Salary
     * FROM
     *     Employee e1
     *         JOIN
     *     Department d ON e1.DepartmentId = d.Id
     * WHERE
     *     3 > (SELECT
     *             COUNT(DISTINCT e2.Salary)
     *         FROM
     *             Employee e2
     *         WHERE
     *             e2.Salary > e1.Salary
     *                 AND e1.DepartmentId = e2.DepartmentId
     */



}
