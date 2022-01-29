package Office_Deans_PIP;

import java.time.LocalDateTime;

public class Exam {
    int examID;
    LocalDateTime date;
    int groupID, teacherID, subjectID;

    public Exam(LocalDateTime date, int groupID, int teacherID, int subjectID) {
        this.date = date;
        this.groupID = groupID;
        this.teacherID = teacherID;
        this.subjectID = subjectID;
    }

    public Exam(int examID, LocalDateTime date, int groupID, int teacherID, int subjectID) {
        this.examID = examID;
        this.date = date;
        this.groupID = groupID;
        this.teacherID = teacherID;
        this.subjectID = subjectID;
    }
    public Exam(){ }

    public int getExamID() {
        return examID;
    }

    public LocalDateTime getDate() {
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
