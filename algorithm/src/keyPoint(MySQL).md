##### 테이블명, 속성은 소문자, 나머지는 모두 대문자로 작성하자

	SELECT COUNT(animal_id) AS count FROM animal_ins;


##### WHERE 조건

= : 같다.
!= : 다르다.
>,<,>=,<= : 초과, 미만, 이상, 이하

##### ORDER BY

##### 정렬 조건 여러개 사용하기

	SELECT animal_id, name, datetime FROM animal_ins ORDER BY name, datetime desc;

작성하는 순서가 정렬되는 우선순위다.

##### GROUP BY

특정 속성에 따른 그룹을 지어 출력한다

	SELECT animal_type, COUNT(animal_type) AS count FROM animal_ins WHERE animal_type='Cat' OR animal_type="Dog" GROUP BY animal_type ORDER BY animal_type;


animal_type이 같은 튜플들 끼리 그룹을 지어서 출력된다.

##### DISTINCT

GROUP BY와 같은 논리로 작동한다(중복을 제거하는 것과 같은 것끼리 그룹화 하는 건 같은 원리니까)

중복되는 데이터를 제거한 결과를 출력한다.

	SELECT COUNT(DISTINCT name) AS count FROM animal_ins WHERE name IS NOT NULL;

중복되는 name을 제외하고 카운트를 한다.

##### 출력되는 튜플의 개수 제한하기

	SELECT name FROM animal_ins ORDER BY datetime LIMIT 1;

"LIMIT 제한할 개수" 를 입력하면 된다.
