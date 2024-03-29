package core.enums;

import features.course_registration.CourseRegistrationController;
import features.login.LoginController;
import features.transcript.TranscriptController;
import features.weekly_schedule.WeeklyScheduleController;

public enum StudentMenu implements Menu{
    CourseRegistration, WeeklySchedule, Transcript, Logout;
    public String getItemMessage() {
        switch(this){
            case CourseRegistration:
                return ("Course Registration");
            case WeeklySchedule:
                return ("Weekly Schedule");
            case Transcript:
                return ("Transcript");
            case Logout:
                return ("Logout");
            }
        return this.name();
    }

    public void navigate(){
        switch(this){
            case CourseRegistration:
                 new CourseRegistrationController();
                break;
            case WeeklySchedule:
                 new WeeklyScheduleController();
                break;
            case Transcript:
                 new TranscriptController();
                break;
            case Logout:
                new LoginController();
                break;
        }
    }
}

