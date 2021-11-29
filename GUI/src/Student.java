public class Student extends Person {
    int indexNumber;
    public Student(String name, String surname, int age, String phoneNumber, String mail, int indexNumber) {
        super(name, surname, age, phoneNumber, mail);
        setIndexNumber(indexNumber);
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public int getIndexNumber() {
        return indexNumber;
    }
}
