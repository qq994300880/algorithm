SELECT
       *
FROM cinema
WHERE
      description NOT IN ('boring')
  AND
      id%2=1
ORDER BY rating
DESC