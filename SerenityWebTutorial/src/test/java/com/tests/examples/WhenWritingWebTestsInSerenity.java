package com.tests.examples;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;

@RunWith(SerenityRunner.class)
public class WhenWritingWebTestsInSerenity {

	@Managed
	WebDriver driver;

	@Test
	public void shouldInstantiateAWebDriverInstanceForAWebTest() {
		driver.get("http://www.google.com");

		driver.findElement(By.name("q")).sendKeys("firefly", Keys.ENTER);

		new WebDriverWait(driver, 5).until(titleContains("firefly - Google"));

		assertThat(driver.getTitle()).contains("firefly - Google");
	}

}