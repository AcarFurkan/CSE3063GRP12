import java.util.ArrayList;

// Represents a view for displaying a weekly schedule of courses
public class WeeklyScheduleView {

    // Constants for formatting the schedule display
    private final int DAYS_IN_WEEK = 7;
    private final int HOURS_IN_DAY = 24;
    private final int CELL_WIDTH = 12;

    // Displays the weekly schedule based on the provided list of courses
    public void showWeeklySchedule(ArrayList<Course> courses) {
        // Create a 2D array to represent the weekly schedule grid
        String[][] scheduleGrid = new String[HOURS_IN_DAY][DAYS_IN_WEEK];

        // Initialize the schedule grid with empty strings
        for (int i = 0; i < HOURS_IN_DAY; i++) {
            for (int j = 0; j < DAYS_IN_WEEK; j++) {
                scheduleGrid[i][j] = "";
            }
        }
// Review this part -> ENUM types to be used later
        // Populate the schedule grid with course information
        for (Course course : courses) {
            int dayIndex = course.getDayOfWeek().ordinal();
            int startHour = course.getStartTime().getHour();
            int endHour = course.getEndTime().getHour();

            // Display the course name in the corresponding time slots
            for (int hour = startHour; hour < endHour; hour++) {
                scheduleGrid[hour][dayIndex] = course.getName();
            }
        }

        // Print the weekly schedule
        printScheduleHeader();
        printScheduleBody(scheduleGrid);
    }
// New Method ==========> Not in uml
    // Prints the header of the weekly schedule, including time labels and day names
    private void printScheduleHeader() {
        // Empty cell for time labels
        System.out.printf("%-" + CELL_WIDTH + "s", ""); 

        // Display day labels
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.printf("%-" + CELL_WIDTH + "s", day.toString());
        }
        System.out.println();
    }
// New Method ==========> Not in uml
    // Prints the body of the weekly schedule, including time labels and course names
    private void printScheduleBody(String[][] scheduleGrid) {
        for (int hour = 0; hour < HOURS_IN_DAY; hour++) {
            // Display time labels
            System.out.printf("%-" + CELL_WIDTH + "s", hour + ":00");

            // Display course names for each day
            for (int day = 0; day < DAYS_IN_WEEK; day++) {
                System.out.printf("%-" + CELL_WIDTH + "s", scheduleGrid[hour][day]);
            }
            System.out.println();
        }
    }

    // later ... 
}
