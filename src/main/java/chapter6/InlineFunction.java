package chapter6;

public class InlineFunction {

	public int rating(Driver aDriver) {
		return moreThanFiveLateDelivers(aDriver) ? 2 : 1;
	}

	private boolean moreThanFiveLateDelivers(Driver aDriver) {
		return aDriver.numberOfLateDelivers() > 5;
	}

	public static void main(String[] args) {
		InlineFunction inlineFunction = new InlineFunction();
		System.out.println(inlineFunction.rating(new Driver(3)));;
	}
}
