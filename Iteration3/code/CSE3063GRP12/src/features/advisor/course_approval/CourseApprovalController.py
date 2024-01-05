from ....core.general_providers.TerminalManager import TerminalManager
from ....core.repositories.CourseEnrollmentRepository import CourseEnrollmentRepository
from ....core.exceptions.UnexpectedInputException import UnexpectedInputException
from ..approval_courses_selected.ApprovalCoursesSelectedController import ApprovalCoursesSelectedController
from CourseApprovalView import CourseApprovalView
from ...main_menu.MenuController import MenuController

class CourseApprovalController:
    def __init__(self):
        self.__courseEnrollmentRepository = CourseEnrollmentRepository()
        self.__courseApprovalView = CourseApprovalView()

        try:
            self.handleApprovalController()
        except UnexpectedInputException as e:
            self.__courseApprovalView.showErrorMessage(e)
            CourseApprovalController()

    def fetchPendingEnrollments(self):
        return self.__courseEnrollmentRepository.get_pending_enrollments()

    def navigateToApprovalCoursesSelected(self, course_enrollment):
        ApprovalCoursesSelectedController(course_enrollment)

    def navigateToMenu(self):
        MenuController()

    def getUserInput(self):
        input_value = TerminalManager.getInstance().read()
        return input_value

    def handleApprovalController(self):
        pending_enrollments = self.fetchPendingEnrollments()
        self.__courseApprovalView.showPendingCourseEnrollments(pending_enrollments)

        self.__courseApprovalView.showPromptMessage()
        selection = self.getUserInput()
        if not selection.isdigit() and selection != "q":
            raise UnexpectedInputException()
        elif selection == "q":
            self.navigateToMenu()
        else:
            index = int(selection)
            if index > len(self.__courseEnrollmentRepository.get_pending_enrollments()) or index < 0:
                raise UnexpectedInputException()
            else:
                self.navigateToApprovalCoursesSelected(self.__courseEnrollmentRepository.get_pending_enrollments()[index - 1])
