import java.math.BigDecimal;
import java.math.MathContext;

public class Pi {
	private static final BigDecimal ONE = BigDecimal.ONE;
	private static final BigDecimal TWO = new BigDecimal(2);
	private static final BigDecimal FOUR = new BigDecimal(4);
	private static final BigDecimal FIVE = new BigDecimal(5);
	private static final BigDecimal SIX = new BigDecimal(6);
	private static final BigDecimal EIGHT = new BigDecimal(8);
	private static final BigDecimal SIXTEEN = new BigDecimal(16);

	public static void main(String[] args) {
		int decimalPlaces = 3000;
		MathContext mc = new MathContext(decimalPlaces);
		
		BigDecimal result = BigDecimal.ZERO;
		BigDecimal eightTimesI = EIGHT.negate();
		BigDecimal sixteenToTheMinusI = SIXTEEN;
		for (int i = 0; i < decimalPlaces; i++) {
			eightTimesI = eightTimesI.add(EIGHT);
			sixteenToTheMinusI = sixteenToTheMinusI.divide(SIXTEEN, mc);
			
			result = result.add(
				sixteenToTheMinusI.multiply(
					(FOUR.divide(eightTimesI.add(ONE), mc)
					.subtract(TWO.divide(eightTimesI.add(FOUR), mc))
					.subtract(ONE.divide(eightTimesI.add(FIVE), mc))
					.subtract(ONE.divide(eightTimesI.add(SIX), mc)))
				));
		}

		System.out.println(result);
		System.out.println(result.toString().startsWith(
				"3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359"));
	}
}