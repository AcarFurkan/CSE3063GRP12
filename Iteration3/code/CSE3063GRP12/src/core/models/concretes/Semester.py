class Semester:
    def __init__(self, id, listOfCoursesTaken, creditsTaken, yano, semesterNo):
        self.id = id
        self.listOfCoursesTaken = listOfCoursesTaken  # dictionary mapping course identifier to CourseGrade
        self.credits_taken = creditsTaken
        self.yano = yano 
        self.semesterNo = semesterNo
    
    def to_dict(self):
        return {
            "id": self.id,
            "listOfCoursesTaken": {courseId: courseGrade.to_dict() if hasattr(courseGrade, 'to_dict') else courseGrade for courseId, courseGrade in self.listOfCoursesTaken.items()},
            "credits_taken": self.credits_taken,
            "yano": self.yano,
            "semesterNo": self.semesterNo
        }