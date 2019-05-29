백준에서 입력 여러개 받을 때는 한줄 입력받을 때마다 처리하지말고(초기화는 하고 연산을 나중에 하자는 의미)

배열로 다 받은다음 처리하자(초기화만)

출력 값이 변수의 자료형 범위를 벗어나는지 확인하자

---

변수명의 길이는 8~20정도가 적당하다(너무 짧아도 별로)

---

if- else if문 작성할 때 if문 또는 상위의 else if문의 조건에서 걸러진 것을 참고해서 else if의 조건문을 작성하자

---

#### 탐색문제

전체적으로 탐색해야 하는 문제(ex) list.contains() 메서드 사용해야 하는 문제 )는  list 대신 map을 사용하면 시간초과가 발생하지 않을 수 있다.

알파벳 하나를 포함하는지 탐색해야 하는 경우

	boolean[] alphabet = new boolean[26];
	alphabet[alpha-'A'] = true;
	if(alphabet[alpha-'A']) {
		executed statement
	}

위와 같이 배열의 인덱스를 아스키코드 값으로 접근하자.

아스키코드

알파벳 대문자(A~Z) : 65 ~ 90
알파벳 소문자(a~z) : 97 ~ 122

---

#### BFS/DFS 영역 구하는 문제

1 : enqueue/push 되지 않고 방문하지 않은 영역

2 : enqueue/push 했지만 방문하진 않은 영역

3 : 방문 한 영역 

field의 값을 위와 같이 초기화 하고

dequeue(queue.poll())/pop 할 때 : 3으로 초기화(방문)와 방문한 영역의 count

주위 영역을 enqueue(add(e) or offer(e))/push 할 때 : 2로 초기화

##### Queue 선언/메소드

Queue<Integer> queue = new LinkedList<>();

queue.add() // enqueue(include exception)

queue.offer() // enqueue(except exception)

queue.poll() // dequeue

---

배열과 list중에서 배열을 사용해도 무관하다면 배열을 사용하는것이 수행시간이 적게 나온다.(정렬 할 때, 거의 1/3 수준)

배열 : Arrays.sort(array);

list : Collections.sort(list);

---
#### 아스키코드 자주 쓰는 것들

숫자(0~9) : 48~57

알파벳대문자(A~Z) : 65~90

알파벳 소문자(a~z) : 97~122

A~B(B>A) 범위 안의 개수 : 둘다 포함하면 (B-A)+1, 하나만 포함하면 B-A, 둘다 포함 안하면 (B-A)-1

---

StringBuffer : multi-thread에서 사용(jdk 1.5부터) (동기화 지원)

StringBuilder : single-thread에서 사용(동기화 지원X, 싱글스레드에서는 성능이 더 좋다.)

String대신 StringBuilder 사용

Scanner(System.in) : single-thread에서 사용(동기화 지원X, 싱글스레드에서는 성능이 더 좋다.)

BufferedReader(new InputStreamReader()) : multi-thread에서 사용(jdk 1.5부터) (동기화 지원)

---

StringTokenizer st = new StringTokenizer(String, delim);

delim을 기준으로 split한다.(delimeter : 구분기호)

st.nextToken() : 처음설정한 delim을 기준으로 나눠진 String을 return

st.nextToken(delim)을 통해 delim을 바꾸면 split의 기준이 다시 바뀐다.

StringTokenizer 객체에는 nextToken()했을때의 delim기준으로 나눠진 첫번째 String을 제외한 전체 String이 저장되어있다.

ex) 

	String temp =  "this$1is$1string";

StringTokenizer st = new StringTokenizer(temp, delim); >> delim의 default 값 : " "

delim을 설정한 이후 재 설정 하지 않으면 계속 그 delim으로 적용돼 token이 생성된다.
(인스턴스 생성할 때, st.nextToken(String delim)할 때 모두 마찬가지)

nextToken(delim)실행 시 남아있는 문자열의 시작에는 해당 delim이 맨 앞에 포함되어있다.

	String temp = "$1is$1string$1shaha";
		
		StringTokenizer st = new StringTokenizer(temp, "$");
		
		System.out.println(st.nextToken());  // 반환값 :"1is", 남아있는 문자열 : "$1string$1shaha"
		System.out.println(st.nextToken("s")); // 반환값 : "$1", 남아있는 문자열 : "string$1shaha"
		System.out.println(st.nextToken()); // 반환값 : tring$1, 남아있는 문자열 : "shaha"
		System.out.println(st.nextToken()); // delim이 "s"로 적용되서 haha를 출력한다.
		
하나의 delim으로 계속 nextToken을 반환 시킬 때는 크게 신경 쓸 필요없이 해당 delim으로 문자열이 나워져 token이 된다고 생각하자.

---

기본형변수(int, float, double, char, boolean...)에 대한 래퍼클래스(Integer, Float, Double, Character, Boolean...) 가 존재한다.

기본형의 경우 따로 초기화를 하지 않아도 0 또는 ''또는 "" 또는 false 의 값이 초기화 되어있다.

Integer wrapper = new Integer(10);  -> Integer wrapper = 10; //오토박싱(autoboxing)

int primitive = wrapper.intValue();  -> int primitive = wrapper;        //언박싱(unboxing)

객체와 변수를 따로 변환하지 않고 쉽게 초기화 할 수 있도록 돕는다.

---

try문에서 선언, 초기화된 클래스, 변수는 밖에서 사용할 수 없다(try문의 로컬클래스/변수)

밖에서 선언된 전역변수를 가져와서 쓸 수 있다.

---

Queue선언

Queue<T> q = new LinkedList<T>();

enqueue : offer()

dequeue : poll()

search bottom element: peek()


---

String.replace()는 인스턴스의 값을 바꾸지 않고 대체된 String을 반환하므로

str = str.replace("a", "b");

와 같은 방식으로 써야된다.

replace랑 replaceAll 둘다 해당하는 문자열을 모두 대체시킨다.

replaceFirst, replaceLast는 하나만

---

#### 배열을 ArrayList로

	String[] city = {"서울","부산","대구","광주"};
	List<String> list = new ArrayList<String>();
	Collections.addAll(list, city);

배열이 래퍼클래스의 배열일 경우만 사용가능하다.

---

#### ArrayList를 배열로

String[] result2 = result.toArray(new String[result.size()]);

배열이 래퍼클래스의 배열일 경우만 사용가능하다.

---

배열과 list중에서 배열을 사용해도 무관하다면 배열을 사용하는것이 수행시간이 적게 나온다.(정렬 할 때, 거의 1/3 수준)


#### 2차원 배열의 정렬

##### 배열

ex) 첫 번째 인덱스 오름차순 -> 같으면 두 번째 인덱스 오름차순 

		Arrays.sort(coordiArr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[0] > o2[0]) return 1;
				else if(o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				} else
					return -1;
			}
		});

Integer.compare(o1,o2); // 오름차순(가장 작은 것이 1등)
Integer.compare(o2,o1); // 내림차순(가장 큰 것이 1등)

##### list

래퍼 클래스의 배열로 받아서 Collections.sort해주면 동일하게 정렬된다.

#### Comparator 인터페이스

Comparator 인터페이스의 compare(Object o1, Object o2){} 를 구현하여 사용한다.

배열과 list의 정렬에서 모두 사용할 수 있다.

단순히 오름차순, 내림차순이 아니라 정렬하는 기준이 정해져 있을 경우 사용하면 된다.

1회성으로 사용할 경우에는 익명 클래스로 바로 인자에 넣어서 사용하면 된다.

compare(Object o1, Object o2)에서의 리턴 값

	// 오름차순

	if(o1 > o2) return 1 ;
	else if(o1 == o2) return 0;
	else return -1;
	
	// 내림차순

	if(o1 > o2) return -1;
	else if(o1 == o2) return 0;
	else return -1;
	
String의 경우 사전순, 문자열의 길이, 문자이지만 숫자의 크기로 정렬하는 것처럼 다양하게 구현할 수 있다.

- list의 내림차순 정렬 참고(Collections.sort 대신 Arrays.sort를 사용한다.)

단순히 사전순으로 비교할 때는 

	String a = "haha";
	String b = "hoho";

	// 리턴 값으로
	
	o1.compareTo(o1); 오름차순
	o2.compareTo(o2); 내림차순
	

##### 오름차순

기본적으로 모든 메소드의 default가 오름차순이다. 내림차순일 경우에만 신경 써주면 된다.

##### 내림차순

Comparator 인터페이스를 구현 할 경우에는 기본형이 아닌 래퍼클래스의 배열을 사용해야 한다.(한 번만 사용할 경우 익명클래스로 바로 Arrays.sort함수에 인자로 넣으면 된다.)

	class Descending implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			
			if(o1 > o2) {
				return -1;
			} else if(o1 == o2) {
				return 0;
			} else {
				return 1;
			}
		}
	}

메인 메소드	
	
	Integer arr = {1,3,6,4,3,2}; // Comparator 인터페이스에서 기본형 타입으로는 정렬이 안되므로 래퍼클래스의 인스턴스를 생성해야한다.

	Arrays.sort(arr, new Descending());
	
	// 또는
	
	Arrays.sort(arr, new Comparator<Integer>(){
		
		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1>o2)return -1;
			else if (o1==o2) return 1;
			else return 1;
	});

	// 또는

	Arrays.sort(arr, Collections.reverseOrder()); 
	// 속도 차이는 거의 없으니 이거 쓰는게 훨씬 간편하다.(기본 자료형 배열도 가능, Comparator인터페이스를 구현한 것이 아니니까)
	
	// 또는
	
		Arrays.sort(arr, new Comparator<Integer>(){
		
		@Override
		public int compare(Integer o1, Integer o2) {
			
			return Integer.compare(o2,o1); // 인자에 int형으로 들어가도 알아서 오토박싱해준다.(메소드의 인자는 원래 int형이다.)
	});
	

#### List의  정렬(람다식 사용)

##### 오름차순

모든 메서드의 default가 오름차순이므로 내림차순일 경우만 신경쓰면 된다.

##### 내림차순

	List<Integer> list = new ArrayList<Integer>();

	Collections.sort(list, (o1, o2)->o2-o1); // 첫 번째 인자만 넣으면 오름차순 정렬

	
	// 문자열 정렬

	Collections.sort(nList, (o1,o2)->Integer.parseInt(o1)-Integer.parseInt(o2)); // 문자열을 숫자 순서대로  오름차순 정렬
	
	Collections.sort(nList, (o1,o2)->Integer.parseInt(o2)-Integer.parseInt(o1)); // 문자열을 숫자 순서대로  내림차순 정렬
	
	Collections.sort(nList, (o1,o2)->o1.compareTo(o2)); // 사전 순서대로 오름차순 정렬 (ex)123 > 1000 : 문자 순서대로면 두번 째 인덱스에 오는 수가 123이 더 크니까)
	
	Collections.sort(nList, (o1,o2)->o2.compareTo(o1)); // 사전 순서대로 내림차순 정렬 (ex)123 > 1000 : 문자 순서대로면 두번 째 인덱스에 오는 수가 123이 더 크니까)
	
Collections.reverse(list)는 정렬이 아니라 인덱스를 반대로 재 배열 해준다.

---

#### String 배열을 정렬하는 것과

int 배열을 정렬하는 것은 결과가 다르다.

11 103 132 19 102

숫자 :  [11, 19, 102, 103, 132]

문자 :  ["102", "103", "11", "132", "19"]

---

#### 인스턴스와 배열의 copy

##### 인스턴스의 copy

###### deep copy

인스턴스를 copy 할 경우 deep copy가 되어 복사의 대상이 된 인스턴스의 필드 값이 바뀌면 복사한 인스턴스의 필드 값도 바뀐다.

ex)

	Test a = new Test();
	a.setName("yoo");
	Test b = new Test();
	b = a;
	
	System.out.println(b.name); // output : yoo
	a.setName("changed name");
	System.out.println(b.name); // output : changed name
	
###### shallow copy

하지만 String을 포함한 래퍼클래스의 인스턴스와 기본형 변수는 shallow copy가 된다.

ex)

	String a = "name";
	String b = a;
	
	System.out.println(b); // output : name
	a = "changed name";
	System.out.println(b); // output : name
 
---

##### 배열의 copy

deep copy (System.arraycopy()로 인한 부하를 줄이는 것이 좋으므로 )
- 입력받은 배열을 수정할 일이 없을 경우 
- source array를 copy 이후에 사용하지 않을 때

shallow copy
- source array를 copy 이후에 수정할 일이 있을 경우(destination array도 같이 수정되는 것을 방지하기 위해)

###### deep copy

	int[] original = {1,2,3,4,5};
	int[] coiped = original // deep copy가 되어 original의 값이 수정되면 같은 인덱스의 copied의 값도 바뀐다.
								 // copied의 값이 수정되어도 original의 값이 바뀐다.(같은 주소값을 사용하기 때문에)
								 
	Stack<int[]> testStack = new Stack<>();
		
	int[] test = new int[2];
		
	test[0] = 1;
	test[1] = 2;
		
	int[] test2 = test;
		
	testStack.push(test);
		
	test2[0] = 5;
		
	System.out.println(testStack.pop()[0]); // push될 때 deep copy되서 들어가기 때문에 push된 배열도 영향을 받는다.
	
인자로 들어가는 모든 경우에 deep copy된다.

		boolean[] source = new boolean[26];
		
		DeepCopy test = new DeepCopy(1, source);
		
		System.out.println(test.getVisited()[5]);
		
		source[5] = true;
		
		System.out.println(test.getVisited()[5]); // output : 5
		
복사해서 사용하려면 필드를 사용한 생성자에서 System.arrayCopy()메소드를 사용해야 한다.
	
###### shallow copy

	int[] original = {1,2,3,4,5};
	int[] copied = new int[original.length];
	
	System.arraycopy(original,0,copied,0,original.length); 
	
	// shallow copy가 되어 original의 값이 수정되어도 copied의 값에는 아무런 영향이 없다.
	
###### 2차원 배열 shallow copy

여러번 쓸거면 이렇게 만들어서 쓰고 아니면 main문에 똑같이 작성하자

	static int[][] copyArray(int[][] original) {

		int[][] copied = new int[original.length][original[0].length];

		for (int i = 0; i < original.length; i++) {
			System.arraycopy(original[i], 0, copied[i], 0, original[i].length);
		}

		return copied;

	}
 
---
	// list가 아닌 


#### 무한한 숫자를 표현할 때는 

BingInteger, BigDecimal 을 사용하자

	BigInteger a = new BigInteger(String);

	BigInteger b = new BigInteger(String);

	a = a.add(b); // a 와 b를 더한다.


---


input.readLine할때 입력값의 끝은

length == 0 으로 조건을 하면 된다.

StringBuilder.append(String a) // a를 리턴한다.


---

#### 가변 크기 2차원배열 생성하는 법


	int[][] array5 = new int[3][];

	array5[0] = new int[1];
	array5[1] = new int[2];
	array5[2] = new int[3]; 



---

#### 메타문자(+,-,*,/ 등등 정규표현식에 사용되는 문자)를 string으로 인식하게 하려면 앞에 \\를 추가해줘야 한다)

ex) 

	String[] a = b.split("\\*");
	
그냥 "+"만 인자로 넣으면 PatternSyntaxException을 반환한다.

---


	Map<Character, Integer> charMap = new HashMap<>();
	ValueComparator vc = new ValueComparator(charMap);
	Map<Character, Integer> sortedMap = new TreeMap<>(vc);
	sortedMap.putAll(charMap);


	class ValueComparator implements Comparator<Character> {

		Map<Character, Integer> map;

		public ValueComparator(Map<Character, Integer> map) {

			this.map = map;

		}

		@Override
		public int compare(Character o1, Character o2) {

			if (map.get(o1) >= map.get(o2)) {  // map.get(o1) <= map.get(o2) 일 경우 오름차순정렬
				return -1;
			} else {
				return 1;
			}
		}

	}

---
#### map을 key와 value로 구분해서 ArrayList에 넣는 방법

		ArrayList<Character> keys = new ArrayList<>(sortedMap.keySet());
		ArrayList<Integer> values = new ArrayList<>(sortedMap.values());

map의 key 또는 value로 정렬한 후에 위와 같이 하면 정렬한 순서대로 ArrayList에 추가된다.

---

#### StringBuilder/StringBuffer에서 substring을 뽑아 새로운 StringBuilder/StringBuffer에 옮길 때는

CharSequence을 반환하는 subSequence(int startIndex, int lastIndex) 메소드를 사용해서 append하자
(substring을 쓰면 힙영역에 스트링이 계속 올라가니까 메모리 관리에 안좋다.)

StringBuilder.append에 char형 변수를 인자로 넣을 수 있다.(안되는 줄 알았는데..)

---

#### StringBuilder/StringBuffer가 같은지 비교할 때는 인스턴스.equals(인스턴스) 하면 안되고

인스턴스1.toString().equals(인스턴스2.toString()); 을 해야한다.

인스턴스1.equals(인스턴스2); 로는 StringBuilder/StringBuffer 에 들어있는 값이 같은지 확인 할 수 없다.

ex)

	StringBuilder str1 = new StrigBuilder("haha");
	StringBuilder str2 = new StrigBuilder("haha");

	// 같은지 확인할 때

	if(str1.toString().equals(str2.toString())) {
		System.out.println("equals");
	}

---
#### StringBuilder/StringBuffer 엔 있고 String에는 없는 메소드

.reverse(); : 해당 문자열의 인덱스를 거꾸로 한 문자열로 만든다.



---

#### list의 중복된 원소 제거

	List<String> wordsList = new ArrayList<>();
	
	Set<String> wordsSet = new Hashset<>(strList); // 인자로 배열을 Arrays.asList(배열)로 입력해도 된다.
	
	wordsList = new ArrayList<>(wordsSet);
	
---

#### main문 안에서의 초기화

- 기본형 변수의 배열은 자동으로 초기화가 된다.(0,false 등)

- 기본형 변수는 초기화를 해줘야 된다.

---

#### map에서 key뽑아 반복문 돌리는 방법

		Set<Character> keySet = nameMap.keySet();

		Iterator keyIter = keySet.iterator();
		
		while (keyIter.hasNext()) {
			// key의 자료형 또는 클래스로 casting해주면 된다.(next() 메소드는 Object 객체를 반환한다.)
			char key = (char) keyIter.next();  
			
			if (nameMap.get(key) >= 5) {
				entryList.add(key);
			}
		}
		
#### map에서 key와 value를 동시에 뽑아 반복문 돌리는 방법

	Set<Character> entrySet = nameMap.entrySet();

	Iterator entryIter = entrySet.iterator();

	while(iterator.hasNext()){
	
	  Map.Entry entry = (Map.Entry)entryIter.next();
	
	  String key = (String)entry.getKey();
	
	  String value = (String)entry.getValue();
	
	  System.out.println("hashMap Key : " + key);
	
	  System.out.println("hashMap Value : " + value);
	
	}
	
#### Object 타입 배열의 활용 방법 

여러 타입의 자료형, 인스턴스를 한번에 push, enqueue(add, offer <-> poll) 할 때 사용할 수 있다.

    Stack<Object[]> boardStack = new Stack<>();

	Object[] curPosition = new Object[3];
	StringBuilder movedRoute = new StringBuilder();
	movedRoute.append(board[0][0]);
	curPosition[0] = 0;
	curPosition[1] = 0;
	curPosition[2] = movedRoute;
	boardStack.push(curPosition);
	
	// 각각 다운캐스팅 해야 해당 인스턴스의 메소드를 사용할 수 있다.(안하면 overriding되지 않은 Ojbect 타입의  메소드만 사용가능)
	
	curPosition = boardStack.pop();
	curX = (int) curPosition[0];
	curY = (int) curPosition[1];
	movedRoute = (StringBuilder) curPosition[2];
	
