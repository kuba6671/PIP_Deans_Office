import java.time.LocalDate;

public class Exam {
    int examID;
    LocalDate date;
    int groupID, teacherID, subjectID;

    public Exam(LocalDate date, int groupID, int teacherID, int subjectID) {
        this.date = date;
        this.groupID = groupID;
        this.teacherID = teacherID;
        this.subjectID = subjectID;
    }

    public Exam(int examID, LocalDate date, int groupID, int teacherID, int subjectID) {
        this.examID = examID;
        this.date = date;
        this.groupID = groupID;
        this.teacherID = teacherID;
        this.subjectID = subjectID;
    }

    public int getExamID() {
        return examID;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getGroupID() {
        return groupID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public int getSubjectID() {
        return subjectID;
    }

}
