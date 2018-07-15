package app.project;

/*
 * Created for iScale Solutions/Vlocity as programming test. 
 */
import app.project.tasks.Task;
import app.util.Util;

/**
 * @author Abdulhamid M. Talib
 * @since July 14, 2018
 * @version 1.0
 * */
public class ConsolePrinter {

	public static void print(Project proj) {
		if (proj == null) {
			return;
		}
		
		System.out.println();
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("# Project Plan for " + proj.getProject() );
		System.out.println("# Target Start Date: " + Util.extractDateDetails("MMM-dd", proj.getStartDate() ) );
		System.out.println("# Target Completion Date: " + Util.extractDateDetails("MMM-dd", proj.getEndDate() ) );
		System.out.println();
		System.out.println("# Project Tasks");
		
		// Print task header.
		printTaskHeader();
		
		if (proj.getTasks() != null && proj.getTasks().isEmpty() == false) {
			// Sort project tasks based on start-date.
			proj.sortTasks();	
			// Print tasks.
			proj.getTasks().forEach(t -> printTask(t) );
		}
		
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
	} // End method
	
	private static void printTaskHeader() {
		System.out.println(
				  Util.paddRightSpace(10, "Task-ID") 
				+ " " + Util.paddRightSpace(12, "Start-Date")
				+ " " + Util.paddRightSpace(12, "End-Date")
				+ " " + Util.paddRightSpace(18, "Duration(Days)")
				+ " " + Util.paddRightSpace(30, "Task")
				+ " " + Util.paddRightSpace(25, "Dependencies (Task-ID)")
			);
	
		System.out.println(
				  Util.paddRightSpace(10, "_______") 
				+ " " + Util.paddRightSpace(12, "__________")
				+ " " + Util.paddRightSpace(12, "________")
				+ " " + Util.paddRightSpace(18, "______________")
				+ " " + Util.paddRightSpace(30, "___________________________")
				+ " " + Util.paddRightSpace(25, "______________________")
			);
	} // End method
	
	private static void printTask(Task task) {
		final StringBuilder sb = new StringBuilder();
		
		if (task.getDependencies() != null && task.getDependencies().isEmpty() == false) {
			task.getDependencies().forEach(t -> {
				if (sb.length() > 0) {
					sb.append(", ");
				}
				
				sb.append(t.getId() );
			});
		}
		
		System.out.println(
				        Util.paddRightSpace(10, "" + task.getId() ) 
				+ " " + Util.paddRightSpace(12, Util.extractDateDetails("MMM-dd", task.getStartDate() ) )
				+ " " + Util.paddRightSpace(12, Util.extractDateDetails("MMM-dd", task.getEndDate() ) )
				+ " " + Util.paddRightSpace(18, "" + task.getDurationInDays() )
				+ " " + Util.paddRightSpace(30, task.getTask() )
				+ " " + sb.toString()
			);
	} // End method
	
}

