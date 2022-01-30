package Office_Deans_PIP;

import java.time.LocalDateTime;

public abstract class Exam implements Cloneable {
    int examID;
    LocalDateTime date;
    int groupID, teacherID, subjectID;
    String type;

    public Exam(LocalDateTime date, int groupID, int teacherID, int subjectID) {
        this.date = date;
        this.groupID = groupID;
        this.teacherID = teacherID;
        this.subjectID = subjectID;
    }

    public abstract Exam clone();

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

    public void setType() {
        this.type = null;
    }

    public String getType() {
        return type;
    }

}
