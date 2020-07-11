package backjoon;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	
	
	public static void main(String[] args){
		
		Map<String,String> map = new TreeMap<>(Collections.reverseOrder());
		
        map.put("a", "A");
        map.put("b", "B");
        map.put("1", "one");
        map.put("2", "two");
        map.put("°¡", "¤¡");
        map.put("³ª", "¤¤");
        map.put("A", "a");
        map.put("B", "b");
		
		Iterator<String> iter = map.keySet().iterator();
		
		while(iter.hasNext()) {		
			System.out.println(iter.next());
		}
		
		
	}

	

}