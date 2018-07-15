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
- Sample output:
	
------------------------------------------------------------------------------------------
# Project Plan for MC-Best
# Target Start Date: Jul-15
# Target Completion Date: Sep-25

# Project Tasks
Task-ID    Start-Date   End-Date     Duration(Days)     Task                           Dependencies (Task-ID)   
_______    __________   ________     ______________     ___________________________    ______________________   
102        Jul-15       Jul-20       5                  Project Initiation             
103        Jul-20       Jul-30       10                 Analysis & Requirements        102
106        Jul-30       Aug-04       5                  Prepare Test Scripts           102, 103
104        Jul-30       Aug-09       10                 Design                         102, 103
110        Aug-09       Aug-13       4                  Infra Setup                    102, 103, 104
105        Aug-09       Sep-08       30                 Programming                    102, 103, 104
107        Sep-08       Sep-16       8                  Integration and Testing        102, 103, 104, 105, 106, 110
109        Sep-16       Sep-22       6                  Users Training & Testing       102, 103, 104, 105, 106, 107
108        Sep-22       Sep-25       3                  Production Deployment          102, 103, 104, 105, 106, 107, 109

------------------------------------------------------------------------------------------
	
	
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



 
