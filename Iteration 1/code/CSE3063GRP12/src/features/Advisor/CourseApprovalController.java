package features.Advisor;

import core.general_providers.TerminalManager;
import core.repositories.CourseEnrollmentRepository;
import core.models.concretes.CourseEnrollment;
import core.exceptions.UnexpectedInputException;
import core.main_menu.MenuController;
import java.util.ArrayList;

public class CourseApprovalController {
    private CourseApprovalView courseApprovalView;
    private CourseEnrollmentRepository courseEnrollmentRepository;

    public CourseApprovalController(){
        courseEnrollmentRepository = new CourseEnrollmentRepository();
        courseApprovalView = new CourseApprovalView();

        handleApprovalController();
    }


    private ArrayList<CourseEnrollment> fetchPendingEnrollments() {
        return courseEnrollmentRepository.getPendingEnrollments();
    }

    private int getUserSelection() {
        System.out.printf("Type \"q\" to see the menu\nType Student Id to process course enrollment");
        ArrayList<CourseEnrollment> courseEnrollmentList = fetchPendingEnrollments();
        courseApprovalView.showPendingCourseEnrollments(courseEnrollmentList);
        String input = TerminalManager.getInstance().read();
        TerminalManager.getInstance().dispose();
        try{
            if(input.equals("q")){
                return -1;
            }
            else{
                for(int i = 0;i < courseEnrollmentList.size();i++){
                    courseEnrollmentList.get(i).getStudentId().equals(input);
                    return i;
                }
            }
            new UnexpectedInputException(input);
        }
        catch (UnexpectedInputException e){
            new UnexpectedInputException(input);
            return -2;
        }
    }

    private void navigateToApprovalCoursesSelected(CourseEnrollment courseEnrollment){}

    private void navigateToMenu(){
        return new MenuController();
    }

    private void handleApprovalController(){
        while(true) {
            int selection = getUserSelection();
            if(selection == -1){
                navigateToMenu();
                break;
            }
            else if(selection>=0){
                navigateToApprovalCoursesSelected(fetchPendingEnrollments().get(selection));
                break;
            }
        }
    }
}
