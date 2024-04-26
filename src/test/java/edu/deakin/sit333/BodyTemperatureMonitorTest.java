package edu.deakin.sit333;

import org.junit.Assert;
import org.junit.Test;

public class BodyTemperatureMonitorTest {

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
    public void testReadTemperatureNegative() {
        Assert.assertTrue("Not tested", false);
    }

    @Test
    public void testReadTemperatureZero() {
        Assert.assertTrue("Not tested", false);
    }

    @Test
    public void testReadTemperatureNormal() {
        Assert.assertTrue("Not tested", false);
    }

    @Test
    public void testReadTemperatureAbnormallyHigh() {
        Assert.assertTrue("Not tested", false);
    }

    /*
     * CREDIT or above level students, Remove comments.
     */
//	@Test
//	public void testReportTemperatureReadingToCloud() {
//		// Mock reportTemperatureReadingToCloud() calls cloudService.sendTemperatureToCloud()
//		
//		Assert.assertTrue("Not tested", false);
//	}


    /*
     * CREDIT or above level students, Remove comments.
     */
//	@Test
//	public void testInquireBodyStatusNormalNotification() {
//		Assert.assertTrue("Not tested", false);
//	}

    /*
     * CREDIT or above level students, Remove comments.
     */
//	@Test
//	public void testInquireBodyStatusAbnormalNotification() {
//		Assert.assertTrue("Not tested", false);
//	}
}
