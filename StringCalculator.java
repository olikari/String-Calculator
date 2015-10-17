public class StringCalculator{

	public static int add(String input){

		if(input.isEmpty()){
			return 0;
		}
		else if(input.charAt(0) == '/'){
			String newString = input.substring(4);	
			String[] token = newString.split("[;]");
			int returnValue = 0;

			for(int i = 0; i < token.length; i++){
				returnValue += Integer.parseInt(token[i]);
			}
			return returnValue;
		}
		else if(input.contains(",")){
			String[] token = input.split("[,\n]");
			int returnValue = 0;

			for(int i = 0; i < token.length; i++){
				returnValue += Integer.parseInt(token[i]);
			}
			return returnValue;
		}
		else{
			return Integer.parseInt(input);
		}		
	}

	public static void main(String[] args){
		StringCalculator myCalc = new StringCalculator();

		int add = myCalc.add("11,22,10,10,10");
		System.out.println("Hér á að prentast 63");
		System.out.println(add);

		int add1 = myCalc.add("50");
		System.out.println("\nHér á að prentast 50");
		System.out.println(add1);

		int add2 = myCalc.add("");
		System.out.println("\nHér á að prentast 0");
		System.out.println(add2);

		int add3 = myCalc.add("1\n2,3,10,10\n10\n10");
		System.out.println("\nHér á að prentast 46");
		System.out.println(add3);

		int add4 = myCalc.add("//;\n1;2;10;10");
		System.out.println("\nHér á að prentast 23");
		System.out.println(add4);
	}
}
