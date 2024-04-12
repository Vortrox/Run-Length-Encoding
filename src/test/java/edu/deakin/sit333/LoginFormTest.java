package edu.deakin.sit333;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest
{
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
	public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
	{
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertFalse(status.isLoginSuccess());
	}

	/*
	 * Write more test functions below.
	 */

    @Test
    public void testFailEmptyUsernameAndIncorrectPasswordAndDontCareValCode()
    {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailEmptyUsernameAndCorrectPasswordAndDontCareValCode()
    {
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailIncorrectUsernameAndEmptyPasswordAndDontCareValCode()
    {
        LoginStatus status = LoginForm.login("abc", null);
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailIncorrectUsernameAndIncorrectPasswordAndDontCareValCode()
    {
        LoginStatus status = LoginForm.login("abc", "abc");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailIncorrectUsernameAndCorrectPasswordAndDontCareValCode()
    {
        LoginStatus status = LoginForm.login("abc", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailCorrectUsernameAndEmptyPasswordAndDontCareValCode()
    {
        LoginStatus status = LoginForm.login("ahsan", null);
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailCorrectUsernameAndIncorrectPasswordAndDontCareValCode()
    {
        LoginStatus status = LoginForm.login("ahsan", "abc");
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailCorrectUsernameAndCorrectPasswordAndEmptyValCode()
    {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());

        boolean isValidCode = LoginForm.validateCode(null);
        Assert.assertFalse(isValidCode);
    }

    @Test
    public void testFailCorrectUsernameAndCorrectPasswordAndIncorrectValCode()
    {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());

        boolean isValidCode = LoginForm.validateCode("abc");
        Assert.assertFalse(isValidCode);
    }

    @Test
    public void testFailCorrectUsernameAndCorrectPasswordAndCorrectValCode()
    {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());

        boolean isValidCode = LoginForm.validateCode("123456");
        Assert.assertTrue(isValidCode);
    }
}
