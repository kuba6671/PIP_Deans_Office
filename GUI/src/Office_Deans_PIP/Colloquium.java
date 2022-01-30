package Office_Deans_PIP;

import java.time.LocalDateTime;

public class Colloquium extends Exam {
    public Colloquium(LocalDateTime date, int groupID, int teacherID, int subjectID) {
        super(date, groupID, teacherID, subjectID);
        setType();
    }
    @Override
    public Exam clone() {
        Colloquium coll = new Colloquium(this.date, this.groupID, this.teacherID, this.subjectID);
        return coll;
    }
    @Override
    public void setType(){
        this.type = "Kolokwium";
    }
}
