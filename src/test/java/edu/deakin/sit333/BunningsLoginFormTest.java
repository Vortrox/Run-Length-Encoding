package edu.deakin.sit333;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class BunningsLoginFormTest
{
	private static final String VALID_EMAIL = "";
	private static final String VALID_PASSWORD = "";
	private static final String INVALID_EMAIL = "a";
	private static final String INVALID_PASSWORD = "b";

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
	public void testFailIncorrectEmailAndIncorrectPassword() {
		BunningsLoginForm form = new BunningsLoginForm();
		form.login(INVALID_EMAIL, INVALID_PASSWORD);
		Assert.assertFalse(form.loginSuccessful());
		form.close();
	}

	@Test
	public void testFailIncorrectEmailAndBlankPassword() {
		BunningsLoginForm form = new BunningsLoginForm();
		form.login(INVALID_EMAIL, "");
		Assert.assertFalse(form.loginSuccessful());
		form.close();
	}

	@Test
	public void testFailIncorrectEmailAndCorrectPassword() {
		BunningsLoginForm form = new BunningsLoginForm();
		form.login(INVALID_EMAIL, VALID_PASSWORD);
		Assert.assertFalse(form.loginSuccessful());
		form.close();
	}

	@Test
	public void testFailBlankEmailAndIncorrectPassword() {
		BunningsLoginForm form = new BunningsLoginForm();
		form.login("", INVALID_PASSWORD);
		Assert.assertFalse(form.loginSuccessful());
		form.close();
	}

	@Test
	public void testFailBlankEmailAndBlankPassword() {
		BunningsLoginForm form = new BunningsLoginForm();
		form.login("", "");
		Assert.assertFalse(form.loginSuccessful());
		form.close();
	}

	@Test
	public void testFailBlankEmailAndCorrectPassword() {
		BunningsLoginForm form = new BunningsLoginForm();
		form.login("", VALID_PASSWORD);
		Assert.assertFalse(form.loginSuccessful());
		form.close();
	}

	@Test
	public void testFailCorrectEmailAndIncorrectPassword() {
		BunningsLoginForm form = new BunningsLoginForm();
		form.login(VALID_EMAIL, INVALID_PASSWORD);
		Assert.assertFalse(form.loginSuccessful());
		form.close();
	}

	@Test
	public void testFailCorrectEmailAndBlankPassword() {
		BunningsLoginForm form = new BunningsLoginForm();
		form.login(VALID_EMAIL, "");
		Assert.assertFalse(form.loginSuccessful());
		form.close();
	}

	@Test
	public void testPassCorrectEmailAndCorrectPassword() {
		BunningsLoginForm form = new BunningsLoginForm();
		form.login(VALID_EMAIL, VALID_PASSWORD);
		Assert.assertFalse(form.loginSuccessful());
		form.close();
	}
}
