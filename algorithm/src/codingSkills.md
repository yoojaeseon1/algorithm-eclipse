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


#### 반복문을 돌면서 사용하고 있는 자료구조의 사이즈를 줄일 경우

- 반복문의 조건이 계속 줄어들어 원하지 않은 결과가 나온다.

		
		 
		 for (int removedI = 0; removedI < removedIndices.length()-1; removedI++)  {
		 
		
			 removedIndices.deleteCharAt(0);
			 System.out.println("removedI : " + removedI);
			 System.out.println("removedIndices : " + removedIndices);

			 for (int candidatesI = 0; candidatesI < candidates.size();candidatesI++) {

			 	if (candidates.get(candidatesI).contains(removedIndices.toString())){
			 		return;
				 }
		
			}
		}

removedIndicesLength를 처음에 따로 생성해두지 않으면 for문의 조건인 removedI < removedIndices.length()-1에서

removedIndices.length()가 deleteCharAt(0)이 되면서 1씩 줄어들기 때문에 for문의 조건도 1씩 줄어들어 결과적으론

remove증가 + removedIndices.length()감소로 인해 반복문이 절반만 돌게 된다.

	int removedIndicesLength = removedIndices.length();

을 생성하고 removedIndices.length()대신 넣어주면 조건이 변하지 않고 원하는 만큼 반복문을 돌 수 있다.


#### 조합할 수 있는 경우의 수는 combination 알고리즘으로 찾아야한다.

- 단순 반복문으로는 모든 조합을 찾을 수 없다.
	
	 System.out.println("to front");
	
	 int removedIndicesLength = removedIndices.length();

	 for (int removedI = 0; removedI < removedIndicesLength-1; removedI++)
	 {
	
		 removedIndices.deleteCharAt(0);
	 	System.out.println("removedI : " + removedI);
	 	System.out.println("removedIndices : " + removedIndices);
	 	for (int candidatesI = 0; candidatesI < candidates.size();candidatesI++) {
	
	 		if (candidates.get(candidatesI).contains(removedIndices.toString()))
	 		 return;
		}
	}


	System.out.println("to end");

	for(int removedI = removedIndices.length() - 1;removedI>=0;removedI--){

			removedIndices.deleteCharAt(removedI);
			removedIndices.deleteCharAt(removedI);
			System.out.println("removedIndices : " + removedIndices);
		for (int candidatesI = 0; candidatesI < candidates.size(); candidatesI++) {

		if (candidates.get(candidatesI).contains(removedIndices.toString())) {
				System.out.println("duplicated : ");
				return;
			}

		}
	}

위 두 반복문으로는 모든 조합을 찾을 수 없다.

deleteCharAt을 인덱스 순서대로 진행하기 때문에

(1,3) 또는 (2,5)와 같은 조합은 찾을 수 없다.