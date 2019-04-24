백준에서 입력 여러개 받을 때는 한줄 입력받을 때마다 처리하지말고

배열로 다 받은다음 처리하자

출력 값이 변수의 자료형 범위를 벗어나는지 확인하자

-------------------------------------

변수명의 길이는 8~20정도가 적당하다(너무 짧아도 별로)

----------------------

if- else if문 작성할 때 if문 또는 상위의 else if문의 조건에서 걸러진 것을 참고해서 else if의 조건문을 작성하자


--------------------------------------------------------------------------------------

StringBuffer : multi-thread에서 사용(jdk 1.5부터) (동기화 지원)

StringBuilder : single-thread에서 사용(동기화 지원X, 싱글스레드에서는 성능이 더 좋다.)

String대신 StringBuilder 사용

Scanner(System.in) : single-thread에서 사용(동기화 지원X, 싱글스레드에서는 성능이 더 좋다.)

BufferedReader(new InputStreamReader()) : multi-thread에서 사용(jdk 1.5부터) (동기화 지원)

--------------------------------------------------------------------------------------

StringTokenizer st = new StringTokenizer(String, delim);

delim을 기준으로 split한다.

st.nextToken() : 처음설정한 delim을 기준으로 나눠진 String을 return

st.nextToken(delim)을 통해 delim을 바꾸면 split의 기준이 다시 바뀐다.

StringTokenizer 객체에는 nextToken()했을때의 delim기준으로 나눠진 첫번째 String을 제외한 전체 String이 저장되어있다.

ex) 

	String temp =  "this$1is$1string";

StringTokenizer st = new StringTokenizer(temp, delim); >> delim의 default 값 : " "

1. st.nextToken() >> this    남아있는 token들 : is, string

2 - 1 : st.nextToken("$") >> 1is   남아있는  token들 : string

2 - 2 : st.nextToken("$1") >> is   남아있는  token들  : string


3 - 1 : st.nextToken() >> 1string 남아있는 String : 없음

3 - 2 : st.nextToken() >> string 남아있는 String : 없음

--------------------------------------------------------------------------------------

기본형변수(int, float, double, char...)에 대한 래퍼클래스(Integer, Float, Double, Character ...) 가 존재한다.

기본형의 경우 따로 초기화를 하지 않아도 0 또는 '' 또는 ""의 값이 초기화 되어있다.


Integer i = new Integer(10);  -> Integer i = 10; //오토박싱(autoboxing)

int i1 = i.intValue();        -> int i1 = i;        //언박싱(unboxing)

객체와 변수를 따로 변환하지 않고 쉽게 초기화 할 수 있도록 돕는다.

--------------------------------------------------------------------------------------

try문에서 선언, 초기화된 클래스, 변수는 밖에서 사용할 수 없다(try문의 로컬클래스/변수)

밖에서 선언된 전역변수를 가져와서 쓸 수 있다.

--------------------------------------------------------------------------------------

Queue선언

Queue<T> q = new LinkedList<T>();

enqueue : offer()

dequeue : poll()

search bottom element: peek()


--------------------------------------------------------------------------------------

String.replace()는 인스턴스의 값을 바꾸지 않고 대체된 String을 반환하므로

str = str.replace("a", "b");

와 같은 방식으로 써야된다.

replace랑 replaceAll 둘다 해당하는 문자열을 모두 대체시킨다.

replaceFirst, replaceLast는 하나만

--------------------------------------------------------------------------------------

배열을 ArrayList로

String[] city = {"서울","부산","대구","광주"};
List<String> al = new ArrayList<String>();
Collections.addAll(al, city);

배열이 래퍼클래스의 배열일 경우만 사용가능하다.

--------------------------------

ArrayList를 배열로

String[] result2 = result.toArray(new String[result.size()]);

배열이 래퍼클래스의 배열일 경우만 사용가능하다.

배열을 내림차순 해주는 메소드는 없으므로 List로 바꿔서 정렬하고 다시 배열로 바꿔줘야한다.

--------------------------------

List의 내림차순 정렬(람다식 사용)

List<Integer> list = new ArrayList<Integer>();

Collections.sort(list, (o1, o2)->o2-o1); // 첫 번째 인자만 넣으면 오름차순 정렬

--------------------------------

list가 아닌 


무한한 숫자를 표현할 때는 

BingInteger, BigDecimal 을 사용하자

	BigInteger a = new BigInteger(String);

	BigInteger b = new BigInteger(String);

	a = a.add(b); // a 와 b를 더한다.

--------------------------------


input.readLine할때 입력값의 끝은

length == 0 으로 조건을 하면 된다.

StringBuilder.append(String a) // a를 리턴한다.


--------------------------------

String 배열을 정렬하는 것과

int 배열을 정렬하는 것은 결과가 다르다.

11 103 132 19 102

숫자 :  [11, 19, 102, 103, 132]

문자 :  ["102", "103", "11", "132", "19"]


--------------------------------

가변 크기 2차원배열 생성하는 법


	int[][] array5 = new int[3][];

	array5[0] = new int[1];
	array5[1] = new int[2];
	array5[2] = new int[3]; 



----------------------

메타문자(+,-,*,/ 등등 정규표현식에 사용되는 문자)를 string으로 인식하게 하려면 앞에 \\를 추가해줘야 한다)

ex) 

	String[] a = b.split("\\*");


----------------------


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

----------------------
map을 key와 value로 구분해서 ArrayList에 넣는 방법

		ArrayList<Character> keys = new ArrayList<>(sortedMap.keySet());
		ArrayList<Integer> values = new ArrayList<>(sortedMap.values());

map의 key 또는 value로 정렬한 후에 위와 같이 하면 정렬한 순서대로 ArrayList에 추가된다.

----------------------

StringBuilder/StringBuffer에서 substring을 뽑아 새로운 StringBuilder/StringBuffer에 옮길 때는

CharSequence을 반환하는 subSequence(int startIndex, int lastIndex) 메소드를 사용해서 append하자
(substring을 쓰면 힙영역에 스트링이 계속 올라가니까 메모리 관리에 안좋다.)

----------------------

StringBuilder/StringBuffer가 같은지 비교할 때는 인스턴스.equals(인스턴스) 하면 안되고

인스턴스1.toString().equals(인스턴스2.toString()); 을 해야한다.

ex)

	StringBuilder str1 = new StrigBuilder("haha");
	StringBuilder str2 = new StrigBuilder("haha");

	// 같은지 확인할 때

	if(str1.toString().equals(str2.toString())) {
		System.out.println("equals");
	}

