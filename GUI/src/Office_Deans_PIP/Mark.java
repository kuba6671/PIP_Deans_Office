package Office_Deans_PIP;

public class Mark {
    int markID;
    float value;
    int indexNumber, teacherID, subjectID;

    public Mark(int markID, float value, int indexNumber, int teacherID, int subjectID) {
        this.markID = markID;
        this.value = value;
        this.indexNumber = indexNumber;
        this.teacherID = teacherID;
        this.subjectID = subjectID;
    }
}
