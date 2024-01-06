
public class RomanNumber { //Translate from number to Roman Numerals

	private int value;
	private String number;
	
	
	public RomanNumber(int value) throws IllegalArgumentException{
		if (value < 1 || value > 300000) throw new IllegalArgumentException("Invalid input!"); //invalid inputs
		this.value = value;
		this.number = parseNumber(value);
	}
	
	public RomanNumber(String number) throws IllegalArgumentException{
		char[] letterList = {'\u2160', '\u2164', '\u2169', '\u216C', '\u216D', '\u216E', '\u216F', '\u2181', '\u2182', '\u2187', '\u2188'}; //unicode representations of roman numerals
		boolean check = false;
		
		if (number.length() > 3) { //so it checks if number is greater than 300000 (3 100000's and then anything after)
			if (number.charAt(2) == '\u2188') { //checks for 3 100000's together (300000)
				throw new IllegalArgumentException("Invalid input!");
			}	
		}
		
		//(MAYBE CHANGE TO CHECKS ONLY BEING HERE IF I CAN VERIFY IT'S NOT NEEDED ANYWHERE ELSE)
		for (int i = 0; i < number.length(); i++) { //check for invalid inputs (only done here and in the parseNumber command)
			for (int j = 0; j < letterList.length; j++) {
				if (number.charAt(i) == letterList[j]) {
					check = true;
				}
			}
			
			if (check == false) throw new IllegalArgumentException("Invalid input!");
			else check = false;
		}
		
		this.number = number;
		this.value = parseValue(number);
	}
	
	
	public int getValue() {
		return this.value;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	
	public static int parseValue(String number) throws IllegalArgumentException{
		
		int[] numberList = {1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000};
		char[] letterList = {'\u2160', '\u2164', '\u2169', '\u216C', '\u216D', '\u216E', '\u216F', '\u2181', '\u2182', '\u2187', '\u2188'};
		boolean check = false; //Checks for invalid inputs
		for (int i = 0; i < number.length(); i++) {
			for (int j = 0; j < letterList.length; j++) {
				if (number.charAt(i) == letterList[j]) {
					check = true;
				}
			}
			
			if (check == false) throw new IllegalArgumentException("Invalid input!");
			else check = false;
		}
		
		if (number.length() > 3) { //so it checks if number is greater than 300000
			if (number.charAt(2) == '\u2188') { //checks for 3 100000's together
				throw new IllegalArgumentException("Invalid input!");
			}	
		}
		
		int[] numberConvert = new int[number.length()]; //to hold numbers
		
		for (int i = 0; i < number.length(); i++) { //to get numbers
			for (int j = 0; j < letterList.length; j++) {
				if (number.charAt(i) == letterList[j]) {
					numberConvert[i] = numberList[j];
				}
			}
		}
		
		int value = 0;
		for (int i = 0; i < numberConvert.length; i++) { //to add/subtract numbers together
			if (i == numberConvert.length - 1) {
				value += numberConvert[i];
			}
			else {
				if (numberConvert[i] < numberConvert[i+1]) {
					value -= numberConvert[i];
				}
				else {
					value += numberConvert[i];
				}
			}
		}
		
		return value;
	}
	
	public static String parseNumber(int value) throws IllegalArgumentException{
		//for safekeeping (use to convert)
		int[] numberList = {1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000};
		char[] letterList = {'\u2160', '\u2164', '\u2169', '\u216C', '\u216D', '\u216E', '\u216F', '\u2181', '\u2182', '\u2187', '\u2188'};
		
		String number = "";
		
		if (value < 1 || value > 300000) { //invalid inputs
			throw new IllegalArgumentException("Invalid input!");
		}
		
		int k = numberList.length - 1; //using k to not get confused
		int counter = 0; //checking each letter amount
		boolean stay = true;
		
		while(stay) {
			if (value - numberList[k] >= 0) { //to get one number at a time
				value-= numberList[k];
				counter++;
			}
			else {
				if (counter < 4) {
					for (int i = 0; i < counter; i++) {
						number = number + letterList[k];
					}
				}
				else if (counter == 4) {
					number = number + letterList[k] + letterList[k+1];
				}
				else if (counter > 4 && counter < 9) {
					number = number + letterList[k+1];
					counter -= 5;
					for (int i = 0; i < counter; i++) {
						number = number + letterList[k];
					}
				}
				else if (counter == 9) {
					number = number + letterList[k] + letterList[k+2];
				}
				else {
					return ""; //should not happen so something's wrong
				}
				
				if (k == 0) { //check if at 0
					stay = false;
				}
				else { //go to next digit (not counting 5's to make it easier
					k-=2;
				}
				counter = 0; //reset counter for next digit	
			}
		}
		return number;
	}
	
	public boolean equals(String number) {
		return this.getNumber().equals(number); //compare Strings
	}
	
	public boolean equals(int value) {
		return this.getValue() == value; //compare integers
	}
	
	
	public String add(String num) throws IllegalArgumentException{
		if (parseValue(this.getNumber()) + parseValue(num) > 300000) { //no need to check 0 as negatives are impossible so can't add up to 0
			throw new IllegalArgumentException("Invalid input!");
		}
		this.number = parseNumber(parseValue(this.getNumber()) + parseValue(num));
		return this.number;
	}
	
	public String subtract(String num) throws IllegalArgumentException{
		if (parseValue(this.getNumber()) - parseValue(num) < 0) { //no need to check 300000 as negatives are impossible so can't subtract to 300000
			throw new IllegalArgumentException("Invalid input!");
		}
		this.number = parseNumber(parseValue(this.getNumber()) - parseValue(num));
		return this.number;
	}
	
	public String multiply(String num) throws IllegalArgumentException{
		if (parseValue(this.getNumber()) * parseValue(num) > 300000) { //no need to check 0 as 0 and below are impossible so can't multiply to < 0
			throw new IllegalArgumentException("Invalid input!");
		}
		this.number = parseNumber(parseValue(this.getNumber()) * parseValue(num));
		return this.number;
	}
	
	public String divide(String num) throws IllegalArgumentException{
		if (parseValue(this.getNumber()) / parseValue(num) <= 0) { //in case someone divides by larger number over lower number (using int division so could be 0)
			throw new IllegalArgumentException("Invalid input!");
		}
		this.number = parseNumber(parseValue(this.getNumber()) / parseValue(num));
		return this.number;
	}
	
	
	public String min(String num) {
		if (parseValue(this.getNumber()) <= parseValue(num)) { //if both are same then either can be printed
			return this.getNumber();
		}
		else {
			return num;
		}
	}
	
	public String max(String num) {
		if (parseValue(this.getNumber()) >= parseValue(num)) { //same rules as above function
			return this.getNumber();
		}
		else {
			return num;
		}
	}
	
	public static String calculate(String num) throws IllegalArgumentException{
		int[] numberList = {1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000};
		char[] letterList = {'\u2160', '\u2164', '\u2169', '\u216C', '\u216D', '\u216E', '\u216F', '\u2181', '\u2182', '\u2187', '\u2188'};
		char[] operands = {'+', '-', '*', 'x', '/'}; //giving the option of '*' or 'x' for multiplication because why not
		String romanOne = "";
		String romanTwo = "";
		String operand = "";
		int skip = 0; //value to skip in string later on (is operand)
		
		for (int i = 0; i < num.length(); i++) {
			for (int j = 0; j < operands.length; j++) {
				if (num.charAt(i) == operands[j] && operand == "") {
					operand += num.charAt(i);
					skip = i;
				}
				else if(num.charAt(i) == operands[j] && operand != "") { //if multiple operands are present in the string
					throw new IllegalArgumentException("Invalid input!");
				}
			}
		}
		
		for (int i = 0; i < num.length(); i++) {
			boolean good = false;
			if (i == skip || num.charAt(i) == ' ') { //operand character or spaces are okay to skip over
				good = true;
			}
			else { //didn't need to do this loop if in above category, but if not, then check this way
				for (int j = 0; j < letterList.length; j++) {
					if (num.charAt(i) == letterList[j] && i <= skip) { //checks if part of first Roman Numeral
						romanOne += num.charAt(i);
						good = true;
					}
					else if (num.charAt(i) == letterList[j] && i > skip) { //checks if part of second Roman Numeral
						romanTwo += num.charAt(i);
						good = true;
					}
				}
			}
			if (good == false) { //checks if character has been validated by numerous checks
				throw new IllegalArgumentException("Invalid input!"); //invalid characters in string input
			}
		}
		
		RomanNumber operate = new RomanNumber(romanOne);
		switch(operand) {
		case "+":
			return operate.add(romanTwo);
		case "-":
			return operate.subtract(romanTwo);
		case "*":
			return operate.multiply(romanTwo);
		case "x":
			return operate.multiply(romanTwo);
		case "/":
			return operate.divide(romanTwo);
		default:
			return "";
		}
	}
	
	public static void main(String[] args) {
		/*System.out.println(parseNumber(3924));
		System.out.println();
		System.out.println(parseNumber(3672));
		System.out.println();
		System.out.println(parseValue("MMMCMXXIV"));
		System.out.println();
		System.out.println(parseValue("MMMDCLXXII"));
		System.out.println(parseValue("XVI"));
		System.out.println();
		
		
		RomanNumber test = new RomanNumber(16);
		System.out.println(test.getNumber());
		System.out.println(test.getValue());
		System.out.println();
		System.out.println("test 1:" + test.equals(16));
		System.out.println("test 1:" + test.equals("XVI"));
		System.out.println();
		
		RomanNumber tests = new RomanNumber("MMM");
		System.out.println(tests.getValue());
		System.out.println();
		System.out.println("test 2:" + tests.equals(3000));
		System.out.println("test 2:" + tests.equals("MMM"));
		System.out.println();
		
		RomanNumber testss = new RomanNumber(20);
		System.out.println(testss.getValue());
		System.out.println();
		System.out.println("test 3:" + testss.equals(20));
		System.out.println("test 3:" + testss.equals("XX"));
		System.out.println("test 3:" + testss.equals(parseValue("XX")));
		System.out.println("test 3:" + testss.equals(parseNumber(20)));
		System.out.println();
		System.out.println(parseValue("XX"));
		System.out.println();*/
		
		RomanNumber newTest = new RomanNumber("ↈↈↈ");
		//RomanNumber newTests = new RomanNumber("ↈↈↈI"); //Shouldn't work
		
		//RomanNumber testsss = new RomanNumber("MXI");
		//System.out.println(testsss.add("XIV"));
		//System.out.println(testsss.subtract("XIV"));
		//System.out.println(testsss.subtract("XI"));
		//System.out.println(calculate("MXI+XIV"));
		//calculate("MXI + XIV"); //should work even with spaces
		//calculate("MXIa +XIV"); //shouldn't work because of 'a'
		
		
		//GO UP TO 300,000 AND NOT 4,000 (maybe make a specific case for when it's exactly 300,000 bc the way the code is now doesn't allow for that easily)
		//USE UNICODE CHARS FROM WIKI
		//WHEN NUMBER IS UPDATED, UPDATE STRING TOO
		
		//ASK IF ONLY HAVING ONE AND JUST REGRABBING IT EACH TIME IS OKAY
		//constructor doesn't have both, but it can get both
		//ACTUALLY just make them get the other with the one it's given (if num, get num and string)
		//MAKE SURE 300000
	}
	
}
