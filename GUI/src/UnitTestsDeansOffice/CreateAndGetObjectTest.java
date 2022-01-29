package UnitTestsDeansOffice;

import Office_Deans_PIP.OfficeEmployee;
import Office_Deans_PIP.Student;
import Office_Deans_PIP.Teacher;

public class CreateAndGetObjectTest {
    int testID, age, groupID;
    String password, name,  surname, phoneNumber, mail, fieldOfStudy;
    Student testStudent;
    Teacher testTeacher;
    OfficeEmployee testOffice;
    CreateAndGetObjectTest(){
        testID = 9999;
        groupID = 8888;
        password = "pass";
        name = "testName";
        surname = "testSurname";
        phoneNumber = "123456789";
        mail = "asd@gmail.com";
        fieldOfStudy = "TestFos";
    }
    void createStudent(){
        testStudent = new Student(testID,password,name,surname,age,phoneNumber,mail,groupID,fieldOfStudy);
    }
    void getStudent(){
        if(testStudent == null) {
            throw new NullPointerException();
        }
            else{
                if (testID != testStudent.getIndexNumber()) {
                    throw new IllegalArgumentException("getStudent");
                }
                else if(password != testStudent.getPassword()){
                    throw new IllegalArgumentException("getStudent");
                }
                else if(name != testStudent.getName()){
                    throw new IllegalArgumentException("getStudent");
                }
                else if(surname != testStudent.getSurname()){
                    throw new IllegalArgumentException("getStudent");
                }
                else if(age != testStudent.getAge()){
                    throw new IllegalArgumentException("getStudent");
                }
                else if(phoneNumber != testStudent.getPhoneNumber()){
                    throw new IllegalArgumentException("getStudent");
                }
                else if(mail != testStudent.getMail()){
                    throw new IllegalArgumentException("getStudent");
                }
                else if(groupID != testStudent.getGroupID()){
                    throw new IllegalArgumentException("getStudent");
                }
                else if(fieldOfStudy != testStudent.getFieldOfStudy()){
                    throw new IllegalArgumentException("getStudent");
                }
            }
    }
    void createTeacher(){
        testTeacher = new Teacher(name,surname,age,phoneNumber,mail,testID,password);
    }
    void getTeacher(){
        if(testTeacher == null) {
            throw new NullPointerException();
        }
        else{
            if (testID != testTeacher.getTeacherID()) {
                throw new IllegalArgumentException("getStudent");
            }
            else if(password != testTeacher.getPassword()){
                throw new IllegalArgumentException("getStudent");
            }
            else if(name != testTeacher.getName()){
                throw new IllegalArgumentException("getStudent");
            }
            else if(surname != testTeacher.getSurname()){
                throw new IllegalArgumentException("getStudent");
            }
            else if(age != testTeacher.getAge()){
                throw new IllegalArgumentException("getStudent");
            }
            else if(phoneNumber != testTeacher.getPhoneNumber()){
                throw new IllegalArgumentException("getStudent");
            }
            else if(mail != testTeacher.getMail()){
                throw new IllegalArgumentException("getStudent");
            }
        }
    }
    void createOffice(){
        testOffice = new OfficeEmployee(name,surname,age,phoneNumber,mail,testID,password);
    }
    void getOffice(){
        if(testOffice == null) {
            throw new NullPointerException();
        }
        else{
            if (testID != testOffice.getOfficeEmployeeID()) {
                throw new IllegalArgumentException("getStudent");
            }
            else if(password != testOffice.getPassword()){
                throw new IllegalArgumentException("getStudent");
            }
            else if(name != testOffice.getName()){
                throw new IllegalArgumentException("getStudent");
            }
            else if(surname != testOffice.getSurname()){
                throw new IllegalArgumentException("getStudent");
            }
            else if(age != testOffice.getAge()){
                throw new IllegalArgumentException("getStudent");
            }
            else if(phoneNumber != testOffice.getPhoneNumber()){
                throw new IllegalArgumentException("getStudent");
            }
            else if(mail != testOffice.getMail()){
                throw new IllegalArgumentException("getStudent");
            }
        }
    }
}
