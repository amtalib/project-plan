package app.project;

/*
 * Created for iScale Solutions/Vlocity as programming test. 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import app.project.tasks.Task;
import app.util.Util;

/**
 * @author Abdulhamid M. Talib
 * @since July 14, 2018
 * @version 1.0
 * */
public class Project {

	private Integer id;
	private String project;
	private Date startDate;
	
	private List<Task> tasks;
	
	public Project() {
		// Initialize ID.
		this.setId(Util.generateId() );
	} // End constructor method.
	
	/**
	 * Sort project tasks.
	 * @since version 1.0
	 * */
	public void sortTasks() {
		// Sort project tasks based on start-date.
		if (this.getTasks() != null) {
			Collections.sort(this.getTasks() );
		}
	} // End method
	
	/**
	 * Add task to the project.
	 * @since version 1.0
	 * */
	public void addTask(Task task) {
		if (this.tasks == null) {
			// Initialize tasks-list if not yet initialized.
			this.tasks = new ArrayList<Task>();
		}
		
		if (task != null) {
			// Add task to the project.
			this.tasks.add(task);
		}
	} // End method
	
	/**
	 * Calculates project end/completion date based on start-date and tasks greatest end-date.
	 * @since version 1.0
	 * */
	public Date getEndDate() {
		Date endDate = startDate;
		
		if (this.getTasks() != null) {
			for (Task t: this.getTasks() ) {
				if (endDate.compareTo(t.getEndDate() ) <= 0) {
					endDate = t.getEndDate();
				}
			}
		}
		
		return endDate;
	} // End method

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * @return the tasks
	 */
	public List<Task> getTasks() {
		return tasks;
	}

	/**
	 * @param tasks the tasks to set
	 */
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
}
