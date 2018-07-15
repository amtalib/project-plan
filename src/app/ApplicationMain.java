package app;

/*
 * Created for iScale Solutions/Vlocity as programming test.
 * 
 * Requirements:
 * 1. We need to calculate calendar schedules for project plans.
 * 
 * 2. Each project plan consists of tasks. Every task has a certain duration. 
 * 
 * 3. A task can depend on zero or more other tasks. 
 *    If a task depends on some other tasks, it can only be started after these tasks are completed.
 *    
 * 4. So, for a set of tasks (with durations and dependencies), 
 *    the solution for the challenge should generate a schedule, 
 *    i.e. assign Start and End Dates for every task.
 *    
 * 5. It is ok to have a console app
 * 6. The solution should be pushed to GitHub
 */
import app.project.ConsolePrinter;
import app.project.Project;
import app.project.tasks.Task;
import app.util.Util;

/**
 * @author Abdulhamid M. Talib
 * @since July 14, 2018
 * @version 1.0
 * */
public class ApplicationMain {

	public static void main(String[] args) {
		// Initialize project.
		Project proj = new Project();
		proj.setProject("MC-Best");
		proj.setStartDate(Util.getCurrentDate() );
		
		// Initialize tasks.
		Task t1 = new Task(proj.getStartDate(), 5); // with 5 days duration and no dependencies.
		t1.setTask("Project Initiation");
		proj.addTask(t1);
		
		Task t2 = new Task(proj.getStartDate(), 10); // with 10 days duration.
		t2.setTask("Analysis & Requirements");
		t2.addDependency(t1); // dependent to t1.
		proj.addTask(t2);
		
		Task t6 = new Task(proj.getStartDate(), 10); // with 10 days duration.
		t6.setTask("Design");
		t6.addDependency(t2); // dependent to t2.
		proj.addTask(t6);
		
		Task t3 = new Task(proj.getStartDate(), 30); // with 30 days duration.
		t3.setTask("Programming");
		t3.addDependency(t6); // dependent to t6.
		proj.addTask(t3);
		
		Task t5 = new Task(proj.getStartDate(), 5); // with 5 days duration.
		t5.setTask("Prepare Test Scripts");
		t5.addDependency(t2);  // dependent to t2.
		proj.addTask(t5);

		Task t4 = new Task(proj.getStartDate(), 8); // with 8 days duration.
		t4.setTask("Integration and Testing");
		t4.addDependency(t3); // dependent to t3.
		t4.addDependency(t5); // dependent to t5.
		proj.addTask(t4);
		
		Task t7 = new Task(proj.getStartDate(), 3); // with 3 days duration.
		t7.setTask("Production Deployment");
		t7.addDependency(t4); // dependent to t4.
		proj.addTask(t7);
		
		Task t8 = new Task(proj.getStartDate(), 6); // with 3 days duration.
		t8.setTask("Users Training & Testing");
		t8.addDependency(t4); // dependent to t4.
		proj.addTask(t8);
		
		// Add depedency to t7.
		t7.addDependency(t8); // Production Deployment is dependent to t8.
		
		Task t9 = new Task(proj.getStartDate(), 4); // with 3 days duration.
		t9.setTask("Infra Setup");
		t9.addDependency(t6); // dependent to t6.
		proj.addTask(t9);
		
		// Add depedency to t4.
		t4.addDependency(t9); // dependent to t9.
		
		// Print to console.
		ConsolePrinter.print(proj);
	} // End method
	
}
