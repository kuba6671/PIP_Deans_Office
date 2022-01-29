package Office_Deans_PIP;

public class Teacher extends Person {
    int teacherID;

    public Teacher(String name, String surname, int age, String phoneNumber, String mail, int teacherID,String password) {
        super(name, surname, age, phoneNumber, mail,password);
        setTeacherID(teacherID);
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public int getTeacherID() {
        return teacherID;
    }
}
