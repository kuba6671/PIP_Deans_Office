package Office_Deans_PIP;

import java.time.LocalDateTime;

public class ProjectDefense extends Exam {
    public ProjectDefense(LocalDateTime date, int groupID, int teacherID, int subjectID) {
        super(date, groupID, teacherID, subjectID);
        setType();
    }
    @Override
    public Exam clone() {
        ProjectDefense project = new ProjectDefense(this.date, this.groupID, this.teacherID, this.subjectID);
        return project;
    }
    @Override
    public void setType(){
        this.type = "Obrona projektu";
    }
}
