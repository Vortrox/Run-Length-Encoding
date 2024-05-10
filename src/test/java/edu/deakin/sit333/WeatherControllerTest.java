package edu.deakin.sit333;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

public class WeatherControllerTest {

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
    public void testTemperaturePersist() {
		System.out.println("+++ testTemperaturePersist +++");

		// Initialise controller
		WeatherController wController = WeatherController.getInstance();

        Clock clock = Clock.fixed(Instant.parse("2024-05-08T00:00:00Z"), ZoneId.systemDefault());
        wController.setClock(clock);
		String persistTime = wController.persistTemperature(10, 19.5);
		String now = new SimpleDateFormat("H:m:s").format(Date.from(clock.instant()));
		System.out.println("Persist time: " + persistTime + ", now: " + now);

		Assert.assertTrue(persistTime.equals(now));

		wController.close();
    }
}
