package com.tests.pageobjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://todomvc.com/examples/vue/")
@At(urls = { "#HOST/examples/vue/" })
public class ToDoMVCHomePage extends PageObject {

	@FindBy(xpath = "//input[@class='new-todo']")
	WebElementFacade todoInputBox;

	@FindBy(xpath = "//label[@for='toggle-all']")
	WebElementFacade toggleAll;

	By todoList = By.xpath("//li[@class='todo']//label");
	By todoCompleteList = By.xpath("//li[@class='todo completed']//label");

	public void add_reminder(String reminder) {
		todoInputBox.sendKeys(reminder + Keys.RETURN);
	}

	public List<String> get_todo_reminders() {
		return findAll(todoList).stream().map(WebElementFacade::getText).collect(Collectors.toList());
	}

	public List<String> get_todo_completed_reminders() {
		return findAll(todoCompleteList).stream().map(WebElementFacade::getText).collect(Collectors.toList());
	}

	public void toggleAllReminders() {
		clickOn(toggleAll);
	}

	@WhenPageOpens
	public void waitForReminderBoxToAppear() {
		element(todoInputBox).waitUntilVisible();
	}
}
