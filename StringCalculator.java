package calculator;

public class Calculator{

	public static int add(String text){
		if(text.isEmpty()){
			return 0;
		}
		else if(input.contains(",")){
			String[] tokens = input.split(",");
			return Integer.parseInt(token[0]) + Integer.parseInt(token[1]);
		}
		else{
			return Integer.parseInt(input);
		}		
	}	
}
