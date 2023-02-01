Create table If Not Exists Weather
(
    id          int,
    recordDate  date,
    temperature int
);
Truncate table Weather;
insert into Weather (id, recordDate, temperature)
values ('1', '2015-01-01', '10');
insert into Weather (id, recordDate, temperature)
values ('2', '2015-01-02', '25');
insert into Weather (id, recordDate, temperature)
values ('3', '2015-01-03', '20');
insert into Weather (id, recordDate, temperature)
values ('4', '2015-01-04', '30');



/*------------------------------*/
# Write your MySQL query statement below
select w2.id
from Weather w1,
     Weather w2
/*时间函数，不可以直接加一*/
where date_add(w1.recordDate, interval 1 day) = w2.recordDate
  and w1.Temperature < w2.Temperature

