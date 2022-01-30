package Office_Deans_PIP;

import java.time.LocalDateTime;

public class FinalTest extends Exam{
    public FinalTest(LocalDateTime date, int groupID, int teacherID, int subjectID) {
        super(date, groupID, teacherID, subjectID);
        setType();
    }
    @Override
    public Exam clone() {
       FinalTest finaltest = new FinalTest(this.date, this.groupID, this.teacherID, this.subjectID);
       return finaltest;
   }
    @Override
    public void setType(){
        this.type = "Egzamin";
    }
}
