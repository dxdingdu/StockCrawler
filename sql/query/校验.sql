select stockcode, date, count(*) from topbill GROUP BY stockCode, date order by count(*) desc, date desc;
select stockcode, date, count(*) from topbill GROUP BY stockCode, date order by date desc, count(*) desc;

select date, count(*) from topbill GROUP BY date ORDER BY date desc;

select count(*) from topbill;

select *, count(*) from topbill where buyAmount>100 and organization!='机构专用' group by stockCode, date, organization, buyAmount ORDER BY count(*) desc;
select *, count(*) from topbill where buyAmount>100 and organization!='机构专用' group by stockCode, date, organization ORDER BY count(*) desc;