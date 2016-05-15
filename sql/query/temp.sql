SELECT
	(
		s.sellPrice - p.buyPrice
	) / p.buyPrice,
	p.*, s.*
FROM
	paybill p
LEFT JOIN sellorder s ON (
	p.stockCode = s.stockCode
	AND p.organization = s.organization
	AND p.buydate < s.sellDate
)
order BY
	p.stockCode,
	p.organization;

SELECT
	(
		s.sellPrice - p.buyPrice
	) / p.buyPrice,
	p.*, s.*
FROM
	paybill p,
	sellorder s
WHERE
		p.stockCode = s.stockCode
		AND p.organization = s.organization
		AND p.buydate < s.sellDate and 
order BY
	p.stockCode,
	p.organization;

