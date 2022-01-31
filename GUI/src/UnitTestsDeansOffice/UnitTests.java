package UnitTestsDeansOffice;

import Office_Deans_PIP.packagePerson.Student;

public class UnitTests {
    public static void main(String[] args) {
        try {
            CreateAndGetObjectTest createTest = new CreateAndGetObjectTest();
            InsertToDatabaseTest insertTest = new InsertToDatabaseTest();
            DeleteFromDatabaseTest deleteTest = new DeleteFromDatabaseTest();
            UpdateRowsInDatabaseTest updateTest = new UpdateRowsInDatabaseTest();
            ObjectTest objectTest = new ObjectTest();
            createTest.createStudent();
            createTest.getStudent();
            createTest.createTeacher();
            createTest.getTeacher();
            createTest.createOffice();
            createTest.getOffice();
            objectTest.studentTesting();
            objectTest.shouldThrownRuntimeExceptionWhenNameIsNull();
            objectTest.shouldThrownRuntimeExceptionWhenSurnameIsNull();
            objectTest.shouldThrownRuntimeExceptionWhenAgeIsOutOfRange();
            objectTest.shouldThrownRuntimeExceptionWhenPhoneNumberIsInvalid();
            objectTest.shouldThrownRuntimeExceptionWhenPasswordIsTooShort();
            insertTest.insertGroup();
            insertTest.insertStudent();
            insertTest.insertTeacher();
            insertTest.insertSubject();
            insertTest.insertSocialGrantFormProposal();
            insertTest.insertFellowShipFormProposal();
            deleteTest.deleteSocialGrantForm();
            deleteTest.deleteFellowShipForm();
            updateTest.updateStudent();
            updateTest.updateStudentGroup();
            updateTest.updateProposalState();
            insertTest.insertExam();
            deleteTest.deleteStudent();
            deleteTest.deleteTeacher();
            deleteTest.deleteSubject();
            deleteTest.deleteStudentGroup();

            System.out.println("\nAll tests finished correctly");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
