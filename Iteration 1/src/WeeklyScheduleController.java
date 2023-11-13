public class WeeklyScheduleController {
    private WeeklyScheduleView weeklyScheduleView;
    private WeeklyScheduleRepository weeklyScheduleRepository;
    // Constructor
    public WeeklyScheduleController(WeeklyScheduleView view, WeeklyScheduleRepository repository) {
        this.weeklyScheduleView = view;
        this.weeklyScheduleRepository = repository;
    }

    private  ArrayList<Course> fetchCourses() {
        return (ArrayList<Course>) weeklyScheduleRepository.getAll();
    }

    private void navigateToMenu() {
        
    }

    private void getUserInput(){

    }

    private void handleWeeklySchedule() {
        String[] daysOfTheWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    }

    }
}
