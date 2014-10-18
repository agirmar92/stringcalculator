package is.ru.stringcalculator;

public class NegativeNumbersException extends Exception {
	public NegativeNumbersException(String[] numbers) {
		boolean first = true;
		System.out.print("Negatives not allowed: ");
		for(String number : numbers) {
			if(first) {
			    System.out.print(number);
			    first = false;
			}
			else System.out.print("," + number);
		}
	}
}
