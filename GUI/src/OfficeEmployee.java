public class OfficeEmployee extends Person {
    int OfficeEmployeeID;

    public OfficeEmployee(String name, String surname, int age, String phoneNumber, String mail, int OfficeEmployeeID) {
        super(name, surname, age, phoneNumber, mail);
        setOfficeEmployeeID(OfficeEmployeeID);
    }

    public void setOfficeEmployeeID(int officeEmployeeID) {
        OfficeEmployeeID = officeEmployeeID;
    }

    public int getOfficeEmployeeID() {
        return OfficeEmployeeID;
    }
}
