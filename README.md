# Author: Abdulhamid M. Talib

# Project Title: Project-Plan

# Project Description
	
Project-Plan is console application written in Java SE created as programming test given by iScale Solutions and Vlocity.

- The application calculates calendar schedules for a project plans.
- Each project plan consists of tasks. Every task has a certain duration.
- A task can depend on zero or more other tasks. If a task depends on some other tasks, it can only be started after these tasks are completed.
- Following validations were added when adding a dependency to a task to prevent circular/recursive dependency.
	* task != dependency task
	* dependency task is not dependent to task
- The application prints the calculated project plan with task schedules (start and end), and dependencies.
	
	
# Programming Test Requirements (Given by Albert Factor of iScale Solutions)
	1. We need to calculate calendar schedules for project plans.
	2. Each project plan consists of tasks. Every task has a certain duration. 
	3. A task can depend on zero or more other tasks. 
	   If a task depends on some other tasks, it can only be started after these tasks are completed.
	4. So, for a set of tasks (with durations and dependencies), 
	   the solution for the challenge should generate a schedule, i.e. assign Start and End Dates for every task.
	5. It is ok to have a console app.
	6. The solution should be pushed to GitHub.

# How to run the program:
	- Download the source code to your local repository.
	- Import to Eclipse IDE.
	- Run the main method inside ApplicationMain.java

# This program requires Java-SE 1.8



 
