package is.ru.stringcalculator;

import java.util.regex.*;

public class Calculator {

	public static int add(String text) throws Exception {
		if(text.equals("")){
			return 0;
		}
		else if(text.contains("//")){
			String delimeter = text.substring(2, text.indexOf('\n'));
			if(delimeter.length() > 1)
				delimeter = delimeter.substring(1, delimeter.length() - 1);
			String restOfNumbers = text.substring(text.indexOf('\n') + 1);
			return sum(restOfNumbers.split(Pattern.quote(delimeter)));
		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else if(toInt(text) <= 1000) {
			if(toInt(text) < 0) throw new NegativeNumbersException(text);
			return toInt(text);
		}
		else return 0;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		return numbers.split("[,\n]");
	}
      
    	private static int sum(String[] numbers) throws Exception {
 		int total = 0;
        	for(String number : numbers){
			int currNumber = toInt(number);
			if(currNumber < 0) throw new  NegativeNumbersException(numbers);
			if(currNumber <= 1000) total += toInt(number);
		}
		return total;
    	}
}
