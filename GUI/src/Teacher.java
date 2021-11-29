public class Teacher extends Person {
    int teacherID;

    public Teacher(String name, String surname, int age, String phoneNumber, String mail, int teacherID) {
        super(name, surname, age, phoneNumber, mail);
        setTeacherID(teacherID);
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public int getTeacherID() {
        return teacherID;
    }
}
