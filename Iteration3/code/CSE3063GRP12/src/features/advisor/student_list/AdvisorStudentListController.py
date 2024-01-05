from ....core.general_providers.TerminalManager import TerminalManager
from ....core.general_providers.SessionController import SessionController
from ....core.models.concretes.Advisor import Advisor
from ....core.repositories.UserRepository import UserRepository
from ...main_menu.MenuController import MenuController
from AdvisorStudentListView import AdvisorStudentListView

class AdvisorStudentListController:
    def __init__(self):
        self.__advisorStudentListView = AdvisorStudentListView()
        self.__userRepository = UserRepository()
        self.handleStudentList()

    def navigateToMenu(self):
        MenuController()

    def getUserInput(self):
        input_value = TerminalManager.getInstance().read()
        return input_value

    def handleStudentList(self):
        advisor = SessionController.getInstance().getCurrentUser()
        if isinstance(advisor, Advisor):
            self.__advisorStudentListView.showStudentList(self.__userRepository.get_students_by_advisor(advisor))
            self.__advisorStudentListView.showQuitMessage()
            user_input = self.getUserInput()
            try:
                if user_input == "q":
                    self.navigateToMenu()
                else:
                    self.__advisorStudentListView.showErrorMessage()
            except Exception as e:
                print("Error:", str(e))
                self.handleStudentList()
