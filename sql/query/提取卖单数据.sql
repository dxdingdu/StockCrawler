INSERT INTO sellorder (
	stockCode,
	stockName,
	organization,
	sellDate,
	sellPrice,
	sellAmount
) SELECT
	stockCode,
	stockName,
	organization,
	date,
	closingPrice,
	sellAmount
FROM
	topbill
WHERE
	sellAmount > 100
AND organization != '机构专用'
GROUP BY
	stockCode,
	date,
	organization
ORDER BY
	count(*) DESC;

