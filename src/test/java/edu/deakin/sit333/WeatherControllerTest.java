package edu.deakin.sit333;

import edu.deakin.sit333.WeatherController;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WeatherControllerTest {
    private WeatherController wController;

    @Before
    public void setup() {
        wController = WeatherController.getInstance();
    }

    @After
    public void tearDown() {
        wController.close();
    }

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
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");

        // Retrieve all the hours temperatures recorded as for today
        int nHours = wController.getTotalHours();
        double minTemperature = 1000;
        for (int i=0; i<nHours; i++) {
            // Hour range: 1 to nHours
            double temperatureVal = wController.getTemperatureForHour(i+1);
            if (minTemperature > temperatureVal) {
                minTemperature = temperatureVal;
            }
        }

        // Should be equal to the min value that is cached in the controller.
        Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");

        // Retrieve all the hours temperatures recorded as for today
        int nHours = wController.getTotalHours();
        double maxTemperature = -1;
        for (int i=0; i<nHours; i++) {
            // Hour range: 1 to nHours
            double temperatureVal = wController.getTemperatureForHour(i+1);
            if (maxTemperature < temperatureVal) {
                maxTemperature = temperatureVal;
            }
        }

        // Should be equal to the min value that is cached in the controller.
        Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        // Retrieve all the hours temperatures recorded as for today
        int nHours = wController.getTotalHours();
        double sumTemp = 0;
        for (int i=0; i<nHours; i++) {
            // Hour range: 1 to nHours
            double temperatureVal = wController.getTemperatureForHour(i+1);
            sumTemp += temperatureVal;
        }
        double averageTemp = sumTemp / nHours;

        // Should be equal to the min value that is cached in the controller.
        Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
    }

    @Test
    public void testTemperaturePersist() {
        /*
         * Remove below comments ONLY for 5.3C task.
         */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
    }
}
