#### 알고리즘 문제 풀 때

##### 테스트케이스 예제는 손으로 직접 풀어보자

완전히 직접 풀어봐서 이해하고 설계를 시작하자

---

#### map

##### map을 굳이 쓰지 않아도 되는 경우

- 알파벳(a~z, A~Z), 숫자(0~9) 등 아스키코드 값으로 인덱스에 접근 가능한 경우
	- 배열을 사용하자
---

#### index 가지고 장난치기(the best 결과 값 제대로 안나오는 이유)

##### 배열

모듈러 연산자(%)
	
	int[] inputs = {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,6,7,8,9,0};
	int[] patterns = {1,1,2,2,3,3,4,4,5,5};
	
와 같은 패턴일 때 input과 pattern이 같은 index에서 값이 같은지 확인하기 위해서는
	
	for(int inpustI = 0; inpustI < inpustI.length; inpustI++){
	
		if(inputs[inpustI] == patterns[inpustI%pattern.length]) answer++;
	}
	
과 같이 패턴의 길이로 모듈러 연산을 해주면 input의 해당 인덱스의 값과 일치하는지 확인할 수 있다.

	

##### 문자열

substring

기준 index를 가지고 원하는 문자열 뽑아내기

- 0부터 기준 index까지

	substring(0, index+1);
	
- 기준 index부터 끝까지

	substring(index);

- 뒤에서 부터 일정 길이(str.substring(str.length()-뒤에서 원하는 만큼 길이, str.length()))
	
	String test = "0123456";

	test.substring(test.length()-3, test.length()); // return "456";