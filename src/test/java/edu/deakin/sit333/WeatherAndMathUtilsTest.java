package edu.deakin.sit333;

import edu.deakin.sit333.WeatherAndMathUtils;
import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

	@Test
	public void testStudentIdentity() {
		String studentId = null;
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = null;
		Assert.assertNotNull("Student name is null", studentName);
	}

    @Test
    public void testTrue2IsEven() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(2));
    }

	@Test
	public void testFalse3IsEven() {
		Assert.assertFalse(WeatherAndMathUtils.isEven(3));
	}

	@Test
	public void testCancelWeatherAdvice() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
	}

    @Test
    public void testWarnWeatherAdvice() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(45.1, 0.0));
    }

    @Test
    public void testAllClearWeatherAdvice() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(0.0, 0.0));
    }

    @Test
    public void testFalse1IsPrime() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(1));
    }

    @Test
    public void testTrue2IsPrime() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(2));
    }

    @Test
    public void testFalse8IsPrime() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(8));
    }
}
