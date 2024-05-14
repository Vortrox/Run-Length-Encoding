package edu.deakin.sit333;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class BodyTemperatureMonitorTest {
    /**
     * NotificationSender that intercepts the last email notification message and returns it through a getter
     */
    private static class MessageInterceptingNotificationSender implements NotificationSender {
        String lastNotificationMessage = "";

        public String getLastNotificationMessage() {
            return lastNotificationMessage;
        }

        @Override
        public void sendEmailNotification(Customer customer, String msg) {
            lastNotificationMessage = msg;
        }

        @Override
        public void sendEmailNotification(FamilyDoctor familyDoctor, String msg) {
            lastNotificationMessage = msg;
        }
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
    public void testReadTemperatureNegative() {
        // todo: make class field, instantiate before all tests?
        TemperatureSensor temperatureSensor = Mockito.mock(TemperatureSensor.class);
        NotificationSender notificationSender = Mockito.mock(NotificationSender.class);
        CloudService cloudService = Mockito.mock(CloudService.class);
        Mockito.when(temperatureSensor.readTemperatureValue()).thenReturn(-1.0);
        BodyTemperatureMonitor bodyTemperatureMonitor = new BodyTemperatureMonitor(temperatureSensor, cloudService, notificationSender);

        Assert.assertTrue(bodyTemperatureMonitor.readTemperature() < 0);
    }

    @Test
    public void testReadTemperatureZero() {
        TemperatureSensor temperatureSensor = Mockito.mock(TemperatureSensor.class);
        NotificationSender notificationSender = Mockito.mock(NotificationSender.class);
        CloudService cloudService = Mockito.mock(CloudService.class);
        Mockito.when(temperatureSensor.readTemperatureValue()).thenReturn(0.0);
        BodyTemperatureMonitor bodyTemperatureMonitor = new BodyTemperatureMonitor(temperatureSensor, cloudService, notificationSender);

        Assert.assertEquals(0.0, bodyTemperatureMonitor.readTemperature(), 0.0);
    }

    @Test
    public void testReadTemperatureNormal() {
        TemperatureSensor temperatureSensor = Mockito.mock(TemperatureSensor.class);
        NotificationSender notificationSender = Mockito.mock(NotificationSender.class);
        CloudService cloudService = Mockito.mock(CloudService.class);
        Mockito.when(temperatureSensor.readTemperatureValue()).thenReturn(36.0);
        BodyTemperatureMonitor bodyTemperatureMonitor = new BodyTemperatureMonitor(temperatureSensor, cloudService, notificationSender);

        Assert.assertEquals(36.0, bodyTemperatureMonitor.readTemperature(), 0.0);
    }

    @Test
    public void testReadTemperatureAbnormallyHigh() {
        TemperatureSensor temperatureSensor = Mockito.mock(TemperatureSensor.class);
        NotificationSender notificationSender = Mockito.mock(NotificationSender.class);
        CloudService cloudService = Mockito.mock(CloudService.class);
        Mockito.when(temperatureSensor.readTemperatureValue()).thenReturn(100.0);
        BodyTemperatureMonitor bodyTemperatureMonitor = new BodyTemperatureMonitor(temperatureSensor, cloudService, notificationSender);

        Assert.assertEquals(100.0, bodyTemperatureMonitor.readTemperature(), 0.0);
    }

	@Test
	public void testReportTemperatureReadingToCloud() {
        TemperatureSensor temperatureSensor = Mockito.mock(TemperatureSensor.class);
        NotificationSender notificationSender = Mockito.mock(NotificationSender.class);
        CloudService cloudService = Mockito.mock(CloudService.class);
        TemperatureReading temperatureReading = new TemperatureReading();
        BodyTemperatureMonitor bodyTemperatureMonitor = new BodyTemperatureMonitor(temperatureSensor, cloudService, notificationSender);

        bodyTemperatureMonitor.reportTemperatureReadingToCloud(temperatureReading);

        Mockito.verify(cloudService, Mockito.times(1)).sendTemperatureToCloud(temperatureReading);
	}


	@Test
	public void testInquireBodyStatusNormalNotification() {
        TemperatureSensor temperatureSensor = Mockito.mock(TemperatureSensor.class);
        MessageInterceptingNotificationSender notificationSender = new MessageInterceptingNotificationSender();
        CloudService cloudService = Mockito.mock(CloudService.class);
        Mockito.when(cloudService.queryCustomerBodyStatus(Mockito.any())).thenReturn("NORMAL");
        BodyTemperatureMonitor bodyTemperatureMonitor = new BodyTemperatureMonitor(temperatureSensor, cloudService, notificationSender);

        bodyTemperatureMonitor.inquireBodyStatus();
        
        Assert.assertEquals("Thumbs Up!", notificationSender.getLastNotificationMessage());
    }

	@Test
	public void testInquireBodyStatusAbnormalNotification() {
        TemperatureSensor temperatureSensor = Mockito.mock(TemperatureSensor.class);
        MessageInterceptingNotificationSender notificationSender = new MessageInterceptingNotificationSender();
        CloudService cloudService = Mockito.mock(CloudService.class);
        Mockito.when(cloudService.queryCustomerBodyStatus(Mockito.any())).thenReturn("ABNORMAL");
        BodyTemperatureMonitor bodyTemperatureMonitor = new BodyTemperatureMonitor(temperatureSensor, cloudService, notificationSender);

        bodyTemperatureMonitor.inquireBodyStatus();

        Assert.assertEquals("Emergency!", notificationSender.getLastNotificationMessage());
	}
}
