##### 문제 풀 때

출력할 속성명, 정렬방식을 꼭 확인하고 쿼리문을 작성하자


##### 테이블명, 속성은 소문자, 나머지는 모두 대문자로 작성하자

	SELECT COUNT(animal_id) AS count FROM animal_ins;


##### ★★★★★ JOIN ★★★★★

JOIN 할 때는 외래키를 조건으로 해야 한다.

	a JOIN b ON a.기본키=b.외래키

JOIN을 해야하는 문제는 JOIN으로 만들어지는 테이블을 SELECT로 확인 해보고

쿼리에 살을 붙이는 방식으로 풀자

###### LEFT JOIN

a LEFT JOIN b ON 조건

조건에 맞는 a 와 b의 튜플을 합쳐 새로운 테이블을 만든다.

합쳐진 튜플 중 공통되지 않는 b의 속성은 NULL값이 된다.

	SELECT outs.animal_id, outs.name FROM animal_outs outs LEFT JOIN animal_ins ins ON outs.animal_id=ins.animal_id WHERE ins.animal_id IS NULL ORDER BY outs.animal_id;

즉, out.animal에는 있는 id지만 ins.animal에는 없는 id를 가지는 ins의 속성이 모두 NULL이 된다.

a는 그대로 나오고 b에서 a와 공통되지 않는 속성이 null로 반환된다.


###### RIGHT JOIN

a RIGHT JOIN b ON 조건 = b LEFT JOIN a ON 조건

###### INNER JOIN

a INNER JOIN b ON 조건

a 와 b의 속성이 모두 일치하는 튜플만 반환한다.(NULL 값이 나올 수 있는 튜플은 반환하지 않는다.) 

	SELECT ins.animal_id, ins.name FROM animal_ins ins INNER JOIN animal_outs outs ON ins.animal_id = outs.animal_id WHERE ins.animal_id=outs.animal_id AND ins.datetime > outs.datetime ORDER BY ins.datetime;


##### WHERE 조건

= : 같다.
!= : 다르다.
>,<,>=,<= : 초과, 미만, 이상, 이하

id == NULL / id != NULL  (X)

id IS NULL / id IS NOT NULL(O)

##### ORDER BY

##### 정렬 조건 여러개 사용하기

	SELECT animal_id, name, datetime FROM animal_ins ORDER BY name, datetime desc;

작성하는 순서가 정렬되는 우선순위다.

	ORDER BY outs.datetime - ins.datetime

기간을 계산해 정렬기준으로 삼을 수도 있다.

##### GROUP BY

특정 속성에 따른 그룹을 지어 출력한다

	SELECT animal_type, COUNT(animal_type) AS count FROM animal_ins WHERE animal_type='Cat' OR animal_type="Dog" GROUP BY animal_type ORDER BY animal_type;


animal_type이 같은 튜플들 끼리 그룹을 지어서 출력된다.

##### HAVING

GROUP BY groupName 의 조건을 추가해 원하는 튜플만 출력되도록 한다.

	SELECT name, COUNT(name) AS "COUNT" FROM animal_ins GROUP BY name HAVING COUNT(name) > 1 ORDER BY name;

출력되는 튜플 중 name의 count가 2이상인 튜플만 출력한다.

##### DISTINCT

GROUP BY와 같은 논리로 작동한다(중복을 제거하는 것과 같은 것끼리 그룹화 하는 건 같은 원리니까)

중복되는 데이터를 제거한 결과를 출력한다.

	SELECT COUNT(DISTINCT name) AS count FROM animal_ins WHERE name IS NOT NULL;

중복되는 name을 제외하고 카운트를 한다.

##### 출력되는 튜플의 개수 제한하기

	SELECT name FROM animal_ins ORDER BY datetime LIMIT 1;

"LIMIT 제한할 개수" 를 입력하면 된다.


#### 함수

##### 집계 함수

COUNT/SUM/AVG/MAX/MIN(속성명) : 개수, 합계, 평균, 최댓값, 최솟값


###### COUNT(속성명)의 경우 

NULL값이면 COUNT하지 않는다.

##### 논리관련 함수

IF(논리식,참일 때 값,거짓일 때 값) : 논리식이 참이면 참일 때 값을 출력하고 논리식이 거짓이면 거짓일 때 출력한다.
	SELECT animal_id, name, IF(sex_upon_intake LIKE '%Intact%', 'X', 'O') AS '중성화' FROM animal_ins ORDER BY animal_id;

IFNULL(값1,값2) : 값1이 NULL 이면 값2로 대치하고 그렇지 않으면 값1을 출력

	SELECT animal_type, IFNULL(name, 'No name'), sex_upon_intake FROM animal_ins ORDER BY animal_id;

IN

WHERE id IN(레코드1, 레코드2,...,레코드N)

id가 해당 레코드 중에 일치하는 값이 있는 튜플만 반환한다.

WHERE id NOT IN(레코드1, 레코드2,...,레코드N)

id가 해당 레코드에 포함되지 않는 튜플만 반환한다.

##### LIKE

yoo를 포함하는 id

	WHERE id LIKE '%yoo%'

yoo로 시작하는 id

	WHERE id LIKE 'yoo%'

yoo로 끝나는 id

	WHERE id LIKE '%yoo'

##### 문자관련 함수

LEFT('문자열',개수)  문자열 중 왼쪽에서 개수만큼을 추출

RIGHT('문자열',개수)  문자열 중 오른쪽에서 개수만큼을 추출

MID('문자열',시작위치,개수)  문자열 중 시작위치부터 개수만큼 출력

SUBSTRING('문자열',시작위치,개수)  문자열 중 시작위치부터 개수만큼 출력


##### 날짜관련 함수

YEAR(날짜)  날짜의 연도 출력

MONTH(날짜)  날짜의 월 출력

##### 시간관련 함수

DATE_FORMAT

날짜를 원하는 형식으로 출력할 수 있다.

	select DATE_FORMAT('1997-10-04 22:23:00', '%H %k %I %r %T %S %w'); 

%M (달 이름), %W (요일 이름), %Y (YYYY 형식의 년도), %y (YY 형식의 년도)

, %a (요일 이름의 약자), %d (DD 형식의 날짜), %e (D 형식의 날짜), %m (MM 형식의 날짜)

, %c (M 형식의 날짜), %H (HH 형식의 시간, 24시간 형식), %k (H 형식의 시간, 24시간 형식)

, %h (HH 형식의 시간, 12시간 형식), %i (MM 형식의 분), %p (AM 또는 PM)


DAYOFWEEK(date) : 해당 날짜의 요일을 숫자로 반환한다. 일요일은 1, 토요일은 7 이다.

WEEKDAY(date) : 해당 날짜에 대한 요일을 반환한다. 월요일은 0, 일요일은 6 이다.

DAYOFYEAR(date) : 해당 날짜의 1월 1일부터의 날수를 반환한다. 결과값은 1에서 366 까지이다.

YEAR(date) : 해당 날짜의 년을 반환한다.

MONTH(date) : 해당 날짜의 월을 반환한다.

DAYOFMONTH(date) : 해당 날짜의 일을 반환한다. 결과값은 1 에서 31 까지이다.

HOUR(time) : 해당날짜의 시간을 반환한다. 결과값은 0 에서 23 이다.

MINUTE(time) : 해당날짜의 분을 반환한다. 결과값은 0 에서 59 이다.

SECOND(time) : 해당날짜의 초를 반환한다. 결과값은 0 에서 59 이다.

DAYNAME(date) : 해당 날짜의 요일 이름을 반환한다. 일요일은 'Sunday' 이다.

MONTHNAME(date) : 해당 날짜의 월 이름을 반환한다. 2월은 'February' 이다.




