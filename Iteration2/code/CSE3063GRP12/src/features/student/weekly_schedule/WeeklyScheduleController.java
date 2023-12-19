package features.student.weekly_schedule;

import java.io.IOException;
import java.util.ArrayList;

import core.models.concretes.Course;
import core.models.concretes.CourseEnrollment;
import core.repositories.CourseRepository;

import core.general_providers.SessionController;
import core.general_providers.TerminalManager;
import features.main_menu.MenuController;
import features.student.course_registration.CourseRegistrationController;
import core.models.concretes.Student;

public class WeeklyScheduleController {

    private WeeklyScheduleView weeklyScheduleView;
    private CourseRepository courseRepository;
    private CourseEnrollment courseEnrollment;
    private CourseRegistrationController courseRegistrationController;

    public WeeklyScheduleController() {
        this.weeklyScheduleView = new WeeklyScheduleView();
        this.courseRepository = new CourseRepository();
        this.courseRegistrationController = new CourseRegistrationController();
        handleWeeklySchedule();
    }

    private ArrayList<Course> fetchCourses(CourseRegistrationController courseRegistrationController) throws IOException {
        // UNCOMMENT:
        Student currentStudent = (Student) (SessionController.getInstance().getCurrentUser());
        int currentSemester = currentStudent.getTranscript().getCurrentSemester();
        return courseRepository.getCoursesBySemester(currentSemester);

    }

    private void navigateToMenu() {
        new MenuController();
    }

    private String getUserInput() {
        weeklyScheduleView.showQuitMessage();
        return TerminalManager.getInstance().read();
    }

    private void handleWeeklySchedule() {
        try {
            ArrayList<Course> currentCourses = fetchCourses(courseRegistrationController);
            weeklyScheduleView.showWeeklySchedule(currentCourses);
            while (true) {
                String userInput = getUserInput();
                if ("q".equals(userInput)) {
                    navigateToMenu();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'q'.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
