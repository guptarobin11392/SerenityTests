package serenitywebproject.SerenityWebTutorial.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.tests.pageobjects.ToDoMVCHomePage;

import net.thucydides.core.annotations.Step;

public class ReminderManager {

	String actor;
	ToDoMVCHomePage mvcHomePage;

	@Step("#actor adds a new reminder {0}")
	public void addsAReminder(String reminderName) {
		mvcHomePage.add_reminder(reminderName);
	}

	@Step("#actor validates that {0} is visible in to do list")
	public void validateReminderPresent(String reminderName) {
		assertThat(mvcHomePage.get_todo_reminders().stream()).anyMatch(reminderName::equalsIgnoreCase);
	}

	@Step("#actor clicks on toggle all")
	public void clicksOnToggle() {
		mvcHomePage.toggleAllReminders();
	}

	@Step("#actor validates that {0} is completed")
	public void validateReminderIsCompleted(String reminderName) {
		assertThat(mvcHomePage.get_todo_completed_reminders().stream()).anyMatch(reminderName::equalsIgnoreCase);
	}

	public void navigateToToDoMvcHomePage() {
		mvcHomePage.open();
	}

}
