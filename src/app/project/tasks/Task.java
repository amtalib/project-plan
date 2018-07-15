package app.project.tasks;

/*
 * Created for iScale Solutions/Vlocity as programming test. 
 */
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import app.util.Util;

/**
 * @author Abdulhamid M. Talib
 * @since July 14, 2018
 * @version 1.0
 * */
public class Task implements Comparable<Task> {

	// Task ID. Required. Auto-generated.
	private Integer id;
	
	// The task. Required.
	private String task;
	
	// Duration. Required.
	private int durationInDays;
	
	// Task dependencies. Optional.
	private Set<Task> dependencies;
		
	// Start date. Calculated based on project start date, greatest dependecies end-date, and durationInDays. 
	private Date startDate;
	// End date. Calculated based on startDate and durationInDays.
	private Date endDate;
	
	public Task() {
		// Set ID.
		this.setId(Util.generateId() );
	}
	
	public Task(Date projectStartDate, int durationInDays) {
		// Set ID.
		this.setId(Util.generateId() );
		
		// Set duration.
		this.setDurationInDays(durationInDays);
		// If this task has no dependencies, then start-date is set to project-start-date.
		this.setStartDate(projectStartDate);
		// Set end-date based on start-date plus duration-days.
		this.setEndDate(Util.addDaysToDate(this.getStartDate(), durationInDays) );
	} // End constructor method.
	
	/**
	 * Calculate the start-date based on the greatest end date of this task's dependecies.
	 * @since version 1.0
	 * */
	public void calculateSchedule() {
		// If this task has no dependencies, startDate will remain the same.
		if (this.getDependencies() != null && this.getDependencies().isEmpty() == false) {
			Date startDate = null;
			
			// Find the greatest end-date from depedencies.
			for (Task t: this.getDependencies() ) {
				if (startDate == null) {
					startDate = t.getEndDate();
					continue;
				}
				
				if (startDate.compareTo(t.getEndDate() ) <= 0) {
					startDate = t.getEndDate();
				}
			} // End for-loop
			
			if (startDate != null) {
				// Update start-date.
				this.setStartDate(startDate);
				
				// Update end-date.
				this.setEndDate(Util.addDaysToDate(this.getStartDate(), durationInDays) );
			}
		}
		
	} // End method
	
	/**
	 * Add dependecy to this task.
	 * @since version 1.0
	 * */
	public void addDependency(Task dtask) {
		if (this.dependencies == null) {
			this.dependencies = new HashSet<Task>();
		}
		
		if (dtask != null) {
			// Validate to avoid recursive/circular dependency. 
			if (this.equals(dtask) ) {
				System.out.println(dtask.getTask()  + " can't depend on its own.");
				return;
			}
			
			// If d-task has dependencies.
			if (dtask.getDependencies() != null && dtask.getDependencies().isEmpty() == false) {
				// Validate to avoid recursive/circular dependency.
				if (dtask.getDependencies().contains(this) ) {
					System.out.println(dtask.getTask()  + " is dependent on " + this.getTask() + ". " +  this.getTask() + " can't be dependent to " + dtask.getTask() + ".");
					return;
				}

				// Add d-task set of dependencies to this task's set of dependencies.
				this.getDependencies().addAll(dtask.getDependencies() );
				// task.getDependencies().forEach(i -> this.addDependency(i) );
			}
			
			// Add d-task to this task dependencies set. 
			this.dependencies.add(dtask);
			
			// Calcurate start-date and end-date.
			this.calculateSchedule();
		}
	} // End of method.
	
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
	 * @return the durationInDays
	 */
	public int getDurationInDays() {
		return durationInDays;
	}

	/**
	 * @param durationInDays the durationInDays to set
	 */
	public void setDurationInDays(int durationInDays) {
		this.durationInDays = durationInDays;
	}

	/**
	 * @return the task
	 */
	public String getTask() {
		return task;
	}

	/**
	 * @param task the task to set
	 */
	public void setTask(String task) {
		this.task = task;
	}

	/**
	 * @return the dependencies
	 */
	public Set<Task> getDependencies() {
		return dependencies;
	}

	/**
	 * @param dependencies the dependencies to set
	 */
	public void setDependencies(Set<Task> dependencies) {
		this.dependencies = dependencies;
	}
	 
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
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * 
	 * For searching puposes.
	 * @since version 1.0
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * For searching puposes.
	 * @since version 1.0
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Task)) {
			return false;
		}
		Task other = (Task) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	/**
	 * Comparison based on start-date and duration. For sorting purposes.
	 * @since version 1.0
	 * */
	@Override
	public int compareTo(Task o) {
		return Comparator.comparing(Task::getStartDate)
	              .thenComparing(Task::getDurationInDays)
	              .compare(this, o);
	} // End method

}
