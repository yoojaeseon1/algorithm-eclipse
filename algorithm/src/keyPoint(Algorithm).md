#### 문제 풀 때

1. 문제 설명을 집중해서 읽고 이해한 다음 예제의 입력 값, 출력 값을 확인해서 설명을 정확히 이해했는지 확인하자

2. 작성한 알고리즘에 문제가 있을 경우 예시 입력 값을 직접 손으로 계산해보자



---

#### DFS,BFS

- 전부 탐색할 때는 방문한 노드, 푸시/인큐된 노드를 따로 체크를 해줘야 한다.
: 방문하지 않았지만 푸시/인큐 되었다면 푸시/인큐 하면 안되기 때문에

- 방문여부 체크, 답인지 체크는 pop/enqueue한 현재 위치에서 확인하자.

			curPosition = fieldQueue.poll();
			
			if (curPosition == g || curPosition == g) {
				isUsableElev = true;
				break;
			}

---

#### Backtraking

핵심 : 탐색하지 않는 조건을 만들어서 탐색 횟수를 줄이는 것

조건에 맞는 깊이로 탐색을 진행한다 > 마지막 레벨까지 탐색 > 탐색한 값 출력 > 끝

백트래킹은 DFS를 사용 했을 때 해당 노드의 단말노드까지 들어갔다가 새로운 형제의 노드로 돌아와서 탐색하는 과정이다.

DFS가 아니어도 구현 가능하지만 DFS에서 Stack을 사용하는 논리와 가장 유사하다.

비 재귀로 구현할 경우 백트래킹 되는 지점에서 DFS되었던 모든 노드에 대한
방문기록 삭제

	visited[y][x] = false;

를 해야한다.

재귀로 구현할 경우 재귀로 실행되는 메소드 아래에 해당 노드의 방문을 삭제하는 코드를 작성하면 백트래킹 되면서 순서대로 방문취소가 된다.

			if(x+dx[i] >= 0 && x+dx[i] < c && y+dy[i] >= 0 && y+dy[i] < r) {
				if(!visited[board[y+dy[i]][x+dx[i]] - 'A']) {
					visited[board[y+dy[i]][x+dx[i]] - 'A'] = true;
					dfs(x+dx[i],y+dy[i], count+1,visited);
					visited[board[y+dy[i]][x+dx[i]] - 'A'] = false; // 백트래킹 되면서 실행되었던 노드가 실행순서 반대로 방문취소된다.
				}
			}
			
static 변수 중에서 자주 초기화되는 변수를 함수의 인자로 넣어야 할지 그냥 static으로 써야 할지 고민해보자
(static 변수는 자주 초기화되지 않는 경우에 쓰는 것이 좋다.(method영역에 올라가서 시스템이 종료 될 때 까지 지워지지 않으니까)) 

---

#### 그리디 알고리즘(greedy algorithm)

현재 상황에서 할 수 있는 최선의 선택을 하는 것(전체적으로 봤을 때 최적의 결과 값이 나오지 않을 수도 있다.)

ex) 회의실 배정 문제 : 현재 상황에서 가장 빨리 배정할 수 있는 회의를 배정한다.

		int earlist = 0; // 현재 가장 빨리 배정 가능한 시간
		int selected = 0;
		for(int i = 0; i < schedule.length; i++) { // schedule 배열은 오름차순정렬(1순위 : 종료시간, 2순위 : 시작시간)
			startTime = schedule[i][0];
			endTime = schedule[i][1];
			if(earlist <= startTime) {
				earlist = endTime;
				selected++;
			}
		}
		
---

#### sorting


---

##### Arrays.sort() 메소드보다 QuickSort를 구현해서 정렬하는 것이 더 빠르다.

ex) K번째 수 문제

---

#### Floyd WarShall

그래프에서 모든 꼭지점 사이의 최단 경로를 찾는 알고리즘

초기화 하는 배열에는 startStop과 endStop사이의 경로가 없을 경우(값이 0일 경우)에 경로 값으로 나올 수 있는 최대 값을 넣어준다.(최소 비용을 구하기 때문에)

그리고 출력할 때는 최대 비용이면 0으로 출력하도록 조건을 넣어 출력한다.

		for (int throughStop = 1; throughStop < feesOfRoute.length; throughStop++) {

			for (int startStop = 1; startStop < feesOfRoute.length; startStop++) {

				for (int endStop = 1; endStop < feesOfRoute[startStop].length; endStop++) {
					if (startStop != endStop)
						feesOfRoute[startStop][endStop] = Math.min(feesOfRoute[startStop][endStop],
								feesOfRoute[startStop][throughStop] + feesOfRoute[throughStop][endStop]);
				}
			}
		}
		
ex) 1->4 사이의 최단 경로
	
	feesOfRoute[startStop][throughStop] + feesOfRoute[throughStop][endStop]


startStop -> throughStop -> endStop의 경로에서 최단 경로(최소 비용)을 찾는 것이다.

startStop -> throughStop은 각각 startStop-> endStop(throughStop)

	feesOfRoute[startStop][throughStop] + feesOfRoute[throughStop][endStop]

throughStop -> endStop은 각각 startStop(throughStop) -> endStop

	feesOfRoute[startStop][throughStop] + feesOfRoute[throughStop][endStop]

 으로 루프 내에서 최단 경로가 구해진 값을 더하기 때문에 두 값
 
	feesOfRoute[startStop][throughStop] + feesOfRoute[throughStop][endStop] 
 
 만 더해주면 된다.