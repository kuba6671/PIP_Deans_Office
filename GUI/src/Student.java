public class Student extends Person {
    int indexNumber, groupID;
    String fieldOfStudy;
    public Student(String name, String surname, int age, String phoneNumber, String mail, int indexNumber, String password) {
        super(name, surname, age, phoneNumber, mail, password);
        setIndexNumber(indexNumber);
    }

    public Student(int indexNumber, String name, String surname, int age, String phoneNumber, String mail,
                   int groupID, String fieldOfStudy) {
        super(name, surname, age, phoneNumber, mail);
        this.indexNumber = indexNumber;
        this.groupID = groupID;
        this.fieldOfStudy = fieldOfStudy;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }
    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }
    public int getIndexNumber() {
        return indexNumber;
    }
    
    public int getGroupID() {
        return groupID;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }
}
