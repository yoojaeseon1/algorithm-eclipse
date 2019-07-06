���ؿ��� �Է� ������ ���� ���� ���� �Է¹��� ������ ó����������(�ʱ�ȭ�� �ϰ� ������ ���߿� ���ڴ� �ǹ�)

�迭�� �� �������� ó������(�ʱ�ȭ��)

��� ���� ������ �ڷ��� ������ ������� Ȯ������

---

�������� ���̴� 8~20������ �����ϴ�(�ʹ� ª�Ƶ� ����)

---

#### Ž������

��ü������ Ž���ؾ� �ϴ� ����(ex) list.contains() �޼��� ����ؾ� �ϴ� ���� )��  list ��� map�� ����ϸ� �ð��ʰ��� �߻����� ���� �� �ִ�.

���ĺ� �ϳ��� �����ϴ��� Ž���ؾ� �ϴ� ���

	boolean[] alphabet = new boolean[26];
	alphabet[alpha-'A'] = true;
	if(alphabet[alpha-'A']) {
		executed statement
	}

���� ���� �迭�� �ε����� �ƽ�Ű�ڵ� ������ ��������.

�ƽ�Ű�ڵ�

���ĺ� �빮��(A~Z) : 65 ~ 90
���ĺ� �ҹ���(a~z) : 97 ~ 122

---

#### BFS/DFS ���� ���ϴ� ����

0 : enqueue/push ���� �ʰ� �湮���� ���� ����

1 : enqueue/push ������ �湮���� ���� ����

2 : �湮 �� ���� 

field�� ���� ���� ���� �ʱ�ȭ �ϰ�

dequeue(queue.poll())/pop �� �� : 2�� �ʱ�ȭ(�湮)�� �湮�� ������ count

���� ������ enqueue(add(e) or offer(e))/push �� �� : 1�� �ʱ�ȭ

##### Queue ����/�޼ҵ�

Queue<Integer> queue = new LinkedList<>();

queue.add() // enqueue(include exception)

queue.offer() // enqueue(exclude exception)

queue.poll() // dequeue

---

�迭�� list�߿��� �迭�� ����ص� �����ϴٸ� �迭�� ����ϴ°��� ����ð��� ���� ���´�.(���� �� ��, ���� 1/3 ����)

�迭 : Arrays.sort(array);

list : Collections.sort(list);

---
#### �ƽ�Ű�ڵ� ���� ���� �͵�

����(0~9) : 48~57

���ĺ��빮��(A~Z) : 65~90

���ĺ� �ҹ���(a~z) : 97~122

A~B(B>A) ���� ���� ���� : �Ѵ� �����ϸ� (B-A)+1, �ϳ��� �����ϸ� B-A, �Ѵ� ���� ���ϸ� (B-A)-1

---

StringBuffer : multi-thread���� ���(jdk 1.5����) (����ȭ ����)

StringBuilder : single-thread���� ���(����ȭ ����X, �̱۽����忡���� ������ �� ����.)

String��� StringBuilder ���

Scanner(System.in) : single-thread���� ���(����ȭ ����X, �̱۽����忡���� ������ �� ����.)

BufferedReader(new InputStreamReader()) : multi-thread���� ���(jdk 1.5����) (����ȭ ����)

---

StringTokenizer st = new StringTokenizer(String, delim);

delim�� �������� split�Ѵ�.(delimeter : ���б�ȣ)

st.nextToken() : ó�������� delim�� �������� ������ String�� return

st.nextToken(delim)�� ���� delim�� �ٲٸ� split�� ������ �ٽ� �ٲ��.

StringTokenizer ��ü���� nextToken()�������� delim�������� ������ ù��° String�� ������ ��ü String�� ����Ǿ��ִ�.

ex) 

	String temp =  "this$1is$1string";

StringTokenizer st = new StringTokenizer(temp, delim); >> delim�� default �� : " "

delim�� ������ ���� �� ���� ���� ������ ��� �� delim���� ����� token�� �����ȴ�.
(�ν��Ͻ� ������ ��, st.nextToken(String delim)�� �� ��� ��������)

nextToken(delim)���� �� �����ִ� ���ڿ��� ���ۿ��� �ش� delim�� �� �տ� ���ԵǾ��ִ�.

	String temp = "$1is$1string$1shaha";
		
		StringTokenizer st = new StringTokenizer(temp, "$");
		
		System.out.println(st.nextToken());  // ��ȯ�� :"1is", �����ִ� ���ڿ� : "$1string$1shaha"
		System.out.println(st.nextToken("s")); // ��ȯ�� : "$1", �����ִ� ���ڿ� : "string$1shaha"
		System.out.println(st.nextToken()); // ��ȯ�� : tring$1, �����ִ� ���ڿ� : "shaha"
		System.out.println(st.nextToken()); // delim�� "s"�� ����Ǽ� haha�� ����Ѵ�.
		
�ϳ��� delim���� ��� nextToken�� ��ȯ ��ų ���� ũ�� �Ű� �� �ʿ���� �ش� delim���� ���ڿ��� ������ token�� �ȴٰ� ��������.

---

�⺻������(int, float, double, char, boolean...)�� ���� ����Ŭ����(Integer, Float, Double, Character, Boolean...) �� �����Ѵ�.

�⺻���� ��� ���� �ʱ�ȭ�� ���� �ʾƵ� 0 �Ǵ� ''�Ǵ� "" �Ǵ� false �� ���� �ʱ�ȭ �Ǿ��ִ�.

Integer wrapper = new Integer(10);  -> Integer wrapper = 10; //����ڽ�(autoboxing)

int primitive = wrapper.intValue();  -> int primitive = wrapper;        //��ڽ�(unboxing)

��ü�� ������ ���� ��ȯ���� �ʰ� ���� �ʱ�ȭ �� �� �ֵ��� ���´�.

---

try������ ����, �ʱ�ȭ�� Ŭ����, ������ �ۿ��� ����� �� ����(try���� ����Ŭ����/����)

�ۿ��� ����� ���������� �����ͼ� �� �� �ִ�.

---

Queue����

Queue<T> q = new LinkedList<T>();

enqueue : offer()

dequeue : poll()

search bottom element: peek()


---

String.replace()�� �ν��Ͻ��� ���� �ٲ��� �ʰ� ��ü�� String�� ��ȯ�ϹǷ�

str = str.replace("a", "b");

�� ���� ������� ��ߵȴ�.

replace�� replaceAll �Ѵ� �ش��ϴ� ���ڿ��� ��� ��ü��Ų��.

replaceFirst, replaceLast�� �ϳ���

---

#### �迭�� ArrayList��

	String[] city = {"����","�λ�","�뱸","����"};
	List<String> list = new ArrayList<String>();
	Collections.addAll(list, city);

�迭�� ����Ŭ������ �迭�� ��츸 ��밡���ϴ�.

---

#### ArrayList�� �迭��

String[] result2 = result.toArray(new String[result.size()]);

�迭�� ����Ŭ������ �迭�� ��츸 ��밡���ϴ�.

---

�迭�� list�߿��� �迭�� ����ص� �����ϴٸ� �迭�� ����ϴ°��� ����ð��� ���� ���´�.(���� �� ��, ���� 1/3 ����)


#### 2���� �迭�� ����

##### �迭

ex) ù ��° �ε��� �������� -> ������ �� ��° �ε��� �������� 

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

Integer.compare(o1,o2); // ��������(���� ���� ���� 1��)
Integer.compare(o2,o1); // ��������(���� ū ���� 1��)

##### list

���� Ŭ������ �迭�� �޾Ƽ� Collections.sort���ָ� �����ϰ� ���ĵȴ�.

#### Comparator �������̽�

Comparator �������̽��� compare(Object o1, Object o2){} �� �����Ͽ� ����Ѵ�.

�迭�� list�� ���Ŀ��� ��� ����� �� �ִ�.

�ܼ��� ��������, ���������� �ƴ϶� �����ϴ� ������ ������ ���� ��� ����ϸ� �ȴ�.

1ȸ������ ����� ��쿡�� �͸� Ŭ������ �ٷ� ���ڿ� �־ ����ϸ� �ȴ�.

compare(Object o1, Object o2)������ ���� ��

	// ��������

	if(o1 > o2) return 1 ;
	else if(o1 == o2) return 0;
	else return -1;
	
	// ��������

	if(o1 > o2) return -1;
	else if(o1 == o2) return 0;
	else return -1;
	
String�� ��� ������, ���ڿ��� ����, ���������� ������ ũ��� �����ϴ� ��ó�� �پ��ϰ� ������ �� �ִ�.

- list�� �������� ���� ����(Collections.sort ��� Arrays.sort�� ����Ѵ�.)

�ܼ��� ���������� ���� ���� 

	String a = "haha";
	String b = "hoho";

	// ���� ������
	
	o1.compareTo(o1); ��������
	o2.compareTo(o2); ��������
	

##### ��������

�⺻������ ��� �޼ҵ��� default�� ���������̴�. ���������� ��쿡�� �Ű� ���ָ� �ȴ�.

##### ��������

Comparator �������̽��� ���� �� ��쿡�� �⺻���� �ƴ� ����Ŭ������ �迭�� ����ؾ� �Ѵ�.(�� ���� ����� ��� �͸�Ŭ������ �ٷ� Arrays.sort�Լ��� ���ڷ� ������ �ȴ�.)

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

���� �޼ҵ�	
	
	Integer arr = {1,3,6,4,3,2}; // Comparator �������̽����� �⺻�� Ÿ�����δ� ������ �ȵǹǷ� ����Ŭ������ �ν��Ͻ��� �����ؾ��Ѵ�.

	Arrays.sort(arr, new Descending());
	
	// �Ǵ�
	
	Arrays.sort(arr, new Comparator<Integer>(){
		
		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1>o2)return -1;
			else if (o1==o2) return 1;
			else return 1;
	});

	// �Ǵ�

	Arrays.sort(arr, Collections.reverseOrder()); 
	// �ӵ� ���̴� ���� ������ �̰� ���°� �ξ� �����ϴ�.(�⺻ �ڷ��� �迭�� ����, Comparator�������̽��� ������ ���� �ƴϴϱ�)
	
	// �Ǵ�
	
		Arrays.sort(arr, new Comparator<Integer>(){
		
		@Override
		public int compare(Integer o1, Integer o2) {
			
			return Integer.compare(o2,o1); // ���ڿ� int������ ���� �˾Ƽ� ����ڽ����ش�.(�޼ҵ��� ���ڴ� ���� int���̴�.)
	});
	

#### List��  ����(���ٽ� ���)

##### ��������

��� �޼����� default�� ���������̹Ƿ� ���������� ��츸 �Ű澲�� �ȴ�.

##### ��������

	List<Integer> list = new ArrayList<Integer>();

	Collections.sort(list, (o1, o2)->o2-o1); // ù ��° ���ڸ� ������ �������� ����

	
	// ���ڿ� ����

	Collections.sort(nList, (o1,o2)->Integer.parseInt(o1)-Integer.parseInt(o2)); // ���ڿ��� ���� �������  �������� ����
	
	Collections.sort(nList, (o1,o2)->Integer.parseInt(o2)-Integer.parseInt(o1)); // ���ڿ��� ���� �������  �������� ����
	
	Collections.sort(nList, (o1,o2)->o1.compareTo(o2)); // ���� ������� �������� ���� (ex)123 > 1000 : ���� ������θ� �ι� ° �ε����� ���� ���� 123�� �� ũ�ϱ�)
	
	Collections.sort(nList, (o1,o2)->o2.compareTo(o1)); // ���� ������� �������� ���� (ex)123 > 1000 : ���� ������θ� �ι� ° �ε����� ���� ���� 123�� �� ũ�ϱ�)
	
Collections.reverse(list)�� ������ �ƴ϶� �ε����� �ݴ�� �� �迭 ���ش�.

---

#### String �迭�� �����ϴ� �Ͱ�

int �迭�� �����ϴ� ���� ����� �ٸ���.

11 103 132 19 102

���� :  [11, 19, 102, 103, 132]

���� :  ["102", "103", "11", "132", "19"]

---

#### �ν��Ͻ��� �迭�� copy

##### �ν��Ͻ��� copy

###### shallow copy

�ν��Ͻ��� copy �� ��� shallow copy�� �Ǿ� ������ ����� �� �ν��Ͻ��� �ʵ� ���� �ٲ�� ������ �ν��Ͻ��� �ʵ� ���� �ٲ��.

ex)

	Test a = new Test();
	a.setName("yoo");
	Test b = new Test();
	b = a;
	
	System.out.println(b.name); // output : yoo
	a.setName("changed name");
	System.out.println(b.name); // output : changed name
	
###### deep copy

������ String�� ������ ����Ŭ������ �ν��Ͻ��� �⺻�� ������ deep copy�� �ȴ�.

ex)

	String a = "name";
	String b = a;
	
	System.out.println(b); // output : name
	a = "changed name";
	System.out.println(b); // output : name
 
---

##### �迭�� copy

deep copy (System.arraycopy()�� ���� ���ϸ� ���̴� ���� �����Ƿ� )
- �Է¹��� �迭�� ������ ���� ���� ��� 
- source array�� copy ���Ŀ� ������� ���� ��

shallow copy
- source array�� copy ���Ŀ� ������ ���� ���� ���(destination array�� ���� �����Ǵ� ���� �����ϱ� ����)

###### shallow copy

	int[] original = {1,2,3,4,5};
	int[] coiped = original // shallow copy�� �Ǿ� original�� ���� �����Ǹ� ���� �ε����� copied�� ���� �ٲ��.
								 // copied�� ���� �����Ǿ original�� ���� �ٲ��.(���� �ּҰ��� ����ϱ� ������)
								 
	Stack<int[]> testStack = new Stack<>();
		
	int[] test = new int[2];
		
	test[0] = 1;
	test[1] = 2;
		
	int[] test2 = test;
		
	testStack.push(test);
		
	test2[0] = 5;
		
	System.out.println(testStack.pop()[0]); // push�� �� shallow copy�Ǽ� ���� ������ push�� �迭�� ������ �޴´�.
	
���ڷ� ���� ��� ��쿡  shallow copy�ȴ�.

		boolean[] source = new boolean[26];
		
		DeepCopy test = new DeepCopy(1, source);
		
		System.out.println(test.getVisited()[5]);
		
		source[5] = true;
		
		System.out.println(test.getVisited()[5]); // output : 5
		
�����ؼ� ����Ϸ��� �ʵ带 ����� �����ڿ��� System.arrayCopy()�޼ҵ带 ����ؾ� �Ѵ�.
	
###### deep copy

	int[] original = {1,2,3,4,5};
	int[] copied = new int[original.length];
	
	System.arraycopy(original,0,copied,0,original.length); 
	
	// deep copy�� �Ǿ� original�� ���� �����Ǿ copied�� ������ �ƹ��� ������ ����.
	
###### 2���� �迭 deep copy

������ ���Ÿ� �̷��� ���� ���� �ƴϸ� main���� �Ȱ��� �ۼ�����

	static int[][] copyArray(int[][] original) {

		int[][] copied = new int[original.length][original[0].length];

		for (int i = 0; i < original.length; i++) {
			System.arraycopy(original[i], 0, copied[i], 0, original[i].length);
		}

		return copied;

	}
 
---
	// list�� �ƴ� 


#### ������ ���ڸ� ǥ���� ���� 

BingInteger, BigDecimal �� �������

	BigInteger a = new BigInteger(String);

	BigInteger b = new BigInteger(String);

	a = a.add(b); // a �� b�� ���Ѵ�.


---


input.readLine�Ҷ� �Է°��� ����

length == 0 ���� ������ �ϸ� �ȴ�.

StringBuilder.append(String a) // a�� �����Ѵ�.


---

#### ���� ũ�� 2�����迭 �����ϴ� ��


	int[][] array5 = new int[3][];

	array5[0] = new int[1];
	array5[1] = new int[2];
	array5[2] = new int[3]; 



---

#### ��Ÿ����(+,-,*,/ ��� ����ǥ���Ŀ� ���Ǵ� ����)�� string���� �ν��ϰ� �Ϸ��� �տ� \\�� �߰������ �Ѵ�)

ex) 

	String[] a = b.split("\\*");
	
�׳� "+"�� ���ڷ� ������ PatternSyntaxException�� ��ȯ�Ѵ�.

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

			if (map.get(o1) >= map.get(o2)) {  // map.get(o1) <= map.get(o2) �� ��� ������������
				return -1;
			} else {
				return 1;
			}
		}

	}

---
#### map�� key�� value�� �����ؼ� ArrayList�� �ִ� ���

		ArrayList<Character> keys = new ArrayList<>(sortedMap.keySet());
		ArrayList<Integer> values = new ArrayList<>(sortedMap.values());

map�� key �Ǵ� value�� ������ �Ŀ� ���� ���� �ϸ� ������ ������� ArrayList�� �߰��ȴ�.

---

#### StringBuilder/StringBuffer���� substring�� �̾� ���ο� StringBuilder/StringBuffer�� �ű� ����

CharSequence�� ��ȯ�ϴ� subSequence(int startIndex, int lastIndex) �޼ҵ带 ����ؼ� append����
(substring�� ���� �������� ��Ʈ���� ��� �ö󰡴ϱ� �޸� ������ ������.)

StringBuilder.append�� char�� ������ ���ڷ� ���� �� �ִ�.(�ȵǴ� �� �˾Ҵµ�..)

---

#### StringBuilder/StringBuffer�� ������ ���� ���� �ν��Ͻ�.equals(�ν��Ͻ�) �ϸ� �ȵǰ�

�ν��Ͻ�1.toString().equals(�ν��Ͻ�2.toString()); �� �ؾ��Ѵ�.

�ν��Ͻ�1.equals(�ν��Ͻ�2); �δ� StringBuilder/StringBuffer �� ����ִ� ���� ������ Ȯ�� �� �� ����.

ex)

	StringBuilder str1 = new StrigBuilder("haha");
	StringBuilder str2 = new StrigBuilder("haha");

	// ������ Ȯ���� ��

	if(str1.toString().equals(str2.toString())) {
		System.out.println("equals");
	}

---
#### StringBuilder/StringBuffer���� �ְ� String���� ���� �޼ҵ�

.reverse(); : �ش� ���ڿ��� �ε����� �Ųٷ� �� ���ڿ��� �����.


#### String���� �ְ�  StringBuilder/StringBuffer���� ���� �޼ҵ�

.split() : ���ڷ� �Է��� ����ǥ���Ŀ� ���� ���ڿ��� �и��ؼ� String[]�� ��ȯ�Ѵ�.

---

#### StringBuilder/StringBuffer.insert(index)

�ش� index�� �߰��ϰ� �� �ڷ� ���� ���ڿ��� ��ĭ�� �о��ش�.(�ش� �ε����� ��ü ���ִ� ���� �ƴϴ�.)

String�� insert�� ����� �ϴ� �޼ҵ尡 ����.(����/���ڿ��� �����ؼ� ��ü ���ִ� replace�޼ҵ尡 �ִ�.(replace�� StringBuilder/StringBuffer�� �ִ�.))

---

#### String�� Char�� �� ���ڿ�/������ �ʱ�ȭ

String�� �� ���ڿ��� �ʱ�ȭ �� �� ������

Char�� �� ���ڸ� �ʱ�ȭ �� �� ����.

�� ���ڸ� ����ؾ� �� ���� String�� ����ϴ� ���� ���ϴ�.

ex)

	String initString = ""; // ����
	
	Char initChar = '' // ���� �߻�


---

#### list�� �ߺ��� ���� ����

	List<String> wordsList = new ArrayList<>();
	
	Set<String> wordsSet = new Hashset<>(strList); // ���ڷ� �迭�� Arrays.asList(�迭)�� �Է��ص� �ȴ�.
	
	wordsList = new ArrayList<>(wordsSet);
	
---

#### main�� �ȿ����� �ʱ�ȭ

- �⺻�� ������ �迭�� �ڵ����� �ʱ�ȭ�� �ȴ�.(0,false ��)

- �⺻�� ������ �ʱ�ȭ�� ����� �ȴ�.

---

#### map���� key�̾� �ݺ��� ������ ���

		Set<Character> keySet = nameMap.keySet();

		Iterator keyIter = keySet.iterator();
		
		while (keyIter.hasNext()) {
			// key�� �ڷ��� �Ǵ� Ŭ������ casting���ָ� �ȴ�.(next() �޼ҵ�� Object ��ü�� ��ȯ�Ѵ�.)
			char key = (char) keyIter.next();  
			
			if (nameMap.get(key) >= 5) {
				entryList.add(key);
			}
		}
		
#### map���� key�� value�� ���ÿ� �̾� �ݺ��� ������ ���

	Set<Character> entrySet = nameMap.entrySet();

	Iterator entryIter = entrySet.iterator();

	while(iterator.hasNext()){
	
	  Map.Entry entry = (Map.Entry)entryIter.next();
	
	  String key = (String)entry.getKey();
	
	  String value = (String)entry.getValue();
	
	  System.out.println("hashMap Key : " + key);
	
	  System.out.println("hashMap Value : " + value);
	
	}
	
#### Object Ÿ�� �迭�� Ȱ�� ��� 

Object�迭���ٴ� �ش� �ڷ���,�ν��Ͻ��� �ʵ�� ������ Ŭ������ ����� �� �ν��Ͻ��� �־��ִ� ���� �� ���ϴ�.(���� �� ĳ���� �� �ʿ�X)

����

���� Ÿ���� �ڷ���, �ν��Ͻ��� �ѹ��� push, enqueue(add, offer <-> poll) �� �� ����� �� �ִ�.

    Stack<Object[]> boardStack = new Stack<>();

	Object[] curPosition = new Object[3];
	StringBuilder movedRoute = new StringBuilder();
	movedRoute.append(board[0][0]);
	curPosition[0] = 0;
	curPosition[1] = 0;
	curPosition[2] = movedRoute;
	boardStack.push(curPosition);
	
	// ���� �ٿ�ĳ���� �ؾ� �ش� �ν��Ͻ��� �޼ҵ带 ����� �� �ִ�.(���ϸ� overriding���� ���� Ojbect Ÿ����  �޼ҵ常 ��밡��)
	
	curPosition = boardStack.pop();
	curX = (int) curPosition[0];
	curY = (int) curPosition[1];
	movedRoute = (StringBuilder) curPosition[2];
