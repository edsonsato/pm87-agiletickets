package br.sato;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookTest {
	@Test
	public void usuarioInvalido() {
		FirefoxDriver browser = new FirefoxDriver();
		browser.get("http://facebook.com");
		browser.findElement(By.id("email")).sendKeys("abc@abc.com.br");
		browser.findElement(By.id("pass")).sendKeys("abc@abc.com.br");
		browser.findElement(By.id("login_form")).submit();
		String text = browser.findElement(By.className("fsl")).getText();
		Assert.assertEquals("Please re-enter your password",text);
		browser.close();
	}
}
