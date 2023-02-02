package feiWoSCun.sql.删除重复的电子邮箱196;

/**
 * @Description：懂的人自然懂
 * @Author: feiWoSCun
 * @Email: 2825097536@qq.com
 * @Date: 2022-1-24
 * TODO: 2023/1/24  mysql 中的删除不可以用别名 然后字句一定要起别名
 */
public class Solution {

    /**
     *
     *
     时间553 ms击败95.73%
     delete
     from Person
     where Person.Id in(select  n.id from (select distinct p.Id
     from Person p
     left join Person p2 on p.Id > p2.Id and p.Email = p2.Email
     where p2.Id is not null)n);
     */
}
