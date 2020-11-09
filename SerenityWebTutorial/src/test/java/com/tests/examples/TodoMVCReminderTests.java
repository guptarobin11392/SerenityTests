package com.tests.examples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import serenitywebproject.SerenityWebTutorial.steps.ReminderManager;

@RunWith(SerenityRunner.class)
public class TodoMVCReminderTests {

	@Managed
	WebDriver driver;

	@Steps
	ReminderManager robin;

	@Test
	public void whenITryToAddAReminder() {
		robin.navigateToToDoMvcHomePage();
		robin.addsAReminder("Reminder 1");
		robin.validateReminderPresent("Reminder 1");
	}

	@Test
	public void whenITryToCompeleteAllReminders() {
		robin.navigateToToDoMvcHomePage();
		robin.addsAReminder("Reminder 1");
		robin.validateReminderPresent("Reminder 1");
		robin.addsAReminder("Reminder 2");
		robin.validateReminderPresent("Reminder 2");
		robin.clicksOnToggle();
		robin.validateReminderIsCompleted("Reminder 1");
		robin.validateReminderIsCompleted("Reminder 2");
	}

}
