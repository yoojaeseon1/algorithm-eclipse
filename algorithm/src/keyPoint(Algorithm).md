#### DFS,BFS

- 전부 탐색할 때는 방문한 노드, 푸시/인큐된 노드를 따로 체크를 해줘야 한다.
: 방문하지 않았지만 푸시/인큐 되었다면 푸시/인큐 하면 안되기 때문에



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
		




#### sorting

##### Arrays.sort() 메소드보다 QuickSort를 구현해서 정렬하는 것이 더 빠르다.

ex) K번째 수 문제