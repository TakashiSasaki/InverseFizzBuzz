import org.junit.*;
import static org.junit.Assert.*;

public class RationalTest {
	@Test
	public void test2ArgRationalConstructor() {
		Rational r = new Rational(2, 5);

		// 確かに自動的にゲッターが定義されているようだ
		assertTrue(r.numerator() == 2);
		assertTrue(r.denominator() == 5);
	}

	@Test
	public void test1ArgRationalConstructor() {
		Rational r = new Rational(5);

		assertTrue(r.numerator() == 0);
		assertTrue(r.denominator() == 1);
		// 1 because of gcd() invocation during construction;
		// 0-over-5 is the same as 0-over-1
	}

	@Test
	public void testAddRationals() {
		Rational r1 = new Rational(2, 5);
		Rational r2 = new Rational(1, 3);

		Rational r3 = (Rational) reflectInvoke(r1, "$plus", r2); // r1.$plus(r2);

		assertTrue(r3.numerator() == 11);
		assertTrue(r3.denominator() == 15);
	}// testAddRationals

	// 可変引数はJava 1.5から導入された。あまり使うこと無いなぁ。
	private Object reflectInvoke(Object thiss, String name, Object... params) {
		try {
			Class type = thiss.getClass();

			Class[] paramTypes = new Class[params.length];
			for (int i = 0; i < params.length; i++)
				paramTypes[i] = params[i].getClass();

			java.lang.reflect.Method method = type.getMethod(name, paramTypes);

			return method.invoke(thiss, params);
		} catch (Exception ex) {
			throw new junit.framework.AssertionFailedError(
					"Assertion failed due to bad Reflection invocation: "
							+ ex.getMessage());
		}// try
	}// reflectInvoke
}// rationalTest
