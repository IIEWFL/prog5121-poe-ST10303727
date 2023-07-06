package poe.part.pkg3;

import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TaskManager {

    public static void main(String[] args) {
        String[] developer = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        String[] task_names = {"Create Login", "Create Add Features", "Add Arrays", "Create Reports"};
        int[] task_id = {1, 2, 4, 5};
        int[] task_duration = {5, 8, 11, 6};
        String[] task_status = {"To Do", "Doing", "To Do", "Done"};

        // a. Display the Developer, Task Names and Task Duration for all tasks with the status of done.
        for (int i = 0; i < task_status.length; i++) {
            if (task_status[i].equals("Done")) {
                System.out.println("Developer: " + developer[i] + ", Task Name: " + task_names[i] + ", Task Duration: " + task_duration[i]);
            }
        }

        // b. Display the Developer and Duration of the class with the longest duration.
        int max_duration = Arrays.stream(task_duration).max().getAsInt();
        int max_index = IntStream.range(0, task_duration.length).filter(i -> task_duration[i] == max_duration).findFirst().getAsInt();
        System.out.println("Developer: " + developer[max_index] + ", Duration: " + max_duration);

        // c. Search for a task with a Task Name and display the Task Name, Developer and Task Status.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the task name: ");
        String task_name = scanner.nextLine();
        for (int i = 0; i < task_names.length; i++) {
            if (task_names[i].equals(task_name)) {
                System.out.println("Task Name: " + task_names[i] + ", Developer: " + developer[i] + ", Task Status: " + task_status[i]);
                break;
            }
            if (i == task_names.length - 1) {
                System.out.println("Task not found.");
            }
        }

        // d. Search for all tasks assigned to a developer and display the Task Name and Task Status.
        System.out.print("Enter the developer name: ");
        String dev_name = scanner.nextLine();
        boolean foundDev = false;
        for (int i = 0; i < developer.length; i++) {
            if (developer[i].equals(dev_name)) {
                System.out.println("Task Name: " + task_names[i] + ", Task Status: " + task_status[i]);
                foundDev = true;
            }
            if (i == developer.length - 1 && !foundDev) {
                System.out.println("Developer not found.");
            }
        }

        // e. Delete a task using the Task Name.
        System.out.print("Enter the task name to delete: ");
        String delete_task_name = scanner.nextLine();
        boolean foundTaskToDelete = false;
        for (int i = 0; i < task_names.length; i++) {
            if (task_names[i].equals(delete_task_name)) {
                developer = ArrayUtils.remove(developer, i);
                task_names = ArrayUtils.remove(task_names, i);
                task_id = ArrayUtils.remove(task_id, i);
                task_duration = ArrayUtils.remove(task_duration, i);
                task_status = ArrayUtils.remove(task_status, i);
                foundTaskToDelete = true;
            }
            if (i == task_names.length - 1 && !foundTaskToDelete) {
                System.out.println("Task not found.");
            }
        }

        // f. Display a report that lists the full details of all captured tasks.
        for (int i = 0; i < task_names.length; i++) {
            System.out.println("Task ID: " + task_id[i] + ", Developer: " + developer[i] + ", Task Name: " + task_names[i] +
                    ", Task Duration: " + task_duration[i] + ", Task Status: " + task_status[i]);
        }

        // g. Unit Test
        assert Arrays.asList(task_names).contains("Create Reports");
        
    }
}
