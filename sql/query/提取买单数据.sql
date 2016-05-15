INSERT INTO paybill (
	stockCode,
	stockName,
	organization,
	buyDate,
	buyPrice,
	buyAmount
) SELECT
	stockCode,
	stockName,
	organization,
	date,
	closingPrice,
	buyAmount
FROM
	topbill
WHERE
	buyAmount > 100
AND organization != '机构专用'
GROUP BY
	stockCode,
	date,
	organization
ORDER BY
	count(*) DESC;

