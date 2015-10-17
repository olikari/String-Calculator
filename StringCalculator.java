public class StringCalculator{

	public static int add(String input){
		if(input.isEmpty()){
			return 0;
		}
		else if(input.contains(",")){
			String[] token = input.split(",");
			return Integer.parseInt(token[0]) + Integer.parseInt(token[1]);
		}
		else{
			return Integer.parseInt(input);
		}		
	}

	public static void main(String[] args){
		StringCalculator myCalc = new StringCalculator();

		int add = myCalc.add("11,22");
		System.out.println("Hér á að prentast 33");
		System.out.println(add);

		int add1 = myCalc.add("50");
		System.out.println("\nHér á að prentast 50");
		System.out.println(add1);

		int add2 = myCalc.add("");
		System.out.println("\nHér á að prentast 0");
		System.out.println(add2);
	}
}
