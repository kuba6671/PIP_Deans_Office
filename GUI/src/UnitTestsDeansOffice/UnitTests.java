package UnitTestsDeansOffice;

public class UnitTests {
    public static void main(String[] args) {
        try {
            CreateAndGetObjectTest createTest = new CreateAndGetObjectTest();
            InsertToDatabaseTest insertTest = new InsertToDatabaseTest();
            DeleteFromDatabaseTest deleteTest = new DeleteFromDatabaseTest();
            UpdateRowsInDatabaseTest updateTest = new UpdateRowsInDatabaseTest();
            createTest.createStudent();
            createTest.getStudent();
            createTest.createTeacher();
            createTest.getTeacher();
            createTest.createOffice();
            createTest.getOffice();
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
