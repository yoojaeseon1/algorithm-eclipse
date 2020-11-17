package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static int maxCalculatedValue;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		String equation = br.readLine();
		
		List<Integer> numbers = new ArrayList<>();
		List<Character> operators = new ArrayList<>();
		
		for(int equationI = 0; equationI < equation.length(); equationI++) {
			
			char currentChar = equation.charAt(equationI);
			
			if(currentChar >= 48 && currentChar <=57)
				numbers.add(Integer.parseInt(Character.toString(currentChar)));
			else
				operators.add(currentChar);
			
		}
		
		maxCalculatedValue = 0;
				
		selectBracket(numbers, operators, 1);
		
		System.out.println(maxCalculatedValue);

	}
	
	
	public static void selectBracket(List<Integer> numbers, List<Character> operators, int startIndex) {
		
		int currentCalculatedValue = numbers.get(0);
		
		for(int operI = 0; operI < operators.size(); operI++) {
			
			currentCalculatedValue = calculateEquation(currentCalculatedValue, numbers.get(operI+1), operators.get(operI));
			
		}
		
		maxCalculatedValue = Math.max(maxCalculatedValue, currentCalculatedValue);
		
		for(int operI = startIndex; operI < operators.size(); operI++) {
			int beforeNumber1 = numbers.get(operI);
			int beforeNumber2 = numbers.get(operI+1);
			char beforeOperator = operators.get(operI);
			int calculatedValue = calculateEquation(beforeNumber1, beforeNumber2, beforeOperator);
			
			numbers.set(operI, calculatedValue);
			numbers.remove(operI+1);
			operators.remove(operI);
			
			selectBracket(numbers, operators, operI+1);
			
			numbers.set(operI, beforeNumber1);
			numbers.add(operI+1, beforeNumber2);
			operators.add(operI, beforeOperator);
			
		}
		
		
		
	}

	public static int calculateEquation(int number1, int number2, char operator) {


		switch (operator) {
		case '+':
			return number1 + number2;
		case '-':
			return number1 - number2;
		case '*':
			return number1 * number2;
		}
		
		return 0;

	}

}
