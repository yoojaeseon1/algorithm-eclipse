#### if문 안에 조건 넣을 때

- 변하지 않고 고정되어 있는 조건을 먼저 쓰자

ex)

	if(A > arr[i] && A < arr2[i]) System.out.println("correct!!");

#### 적당한 변수의 길이
변수 이름의 길이가 평균적으로 10~16일 때 프로그램을 디버깅하기 위해서 들이는 노력을 최소화 할 수 있고

변수의 평균 길이가 8~20인 프로그램은 디버깅하기가 쉽다.

결론 : 길이가 8~20 이면 적절하다.

##### 너무 긴 이름 
numberOfPeopleOnTheUsOlympicTeam 
numberOfSeatsInTheStadium 
maximunNumberOfPointsInMordernOlympics

##### 너무 짧은 이름 
n, np, ntm 
n, ns, nsisd 
m, mp, max, points

##### 적당한 이름 
numTeamMembers, teamMemberCount 
numSeatsInStadium, seatCount 
teamPointsMax, pointsRecord 

	
#### 변수명 작명법 확인하자.

##### 상수는 대문자로

ex) int N = 5; // 앞으로 수정할 일이 없을 경우

