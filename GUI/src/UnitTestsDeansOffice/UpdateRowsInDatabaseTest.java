package UnitTestsDeansOffice;

import Office_Deans_PIP.packageProposal.AcceptedProposalState;
import Office_Deans_PIP.packageProposal.PendingProposalState;
import Office_Deans_PIP.packageProposal.Proposal;
import Office_Deans_PIP.packageProposal.RejectedProposalState;

import java.sql.*;

public class UpdateRowsInDatabaseTest {
    Connection con = null;
    Statement stmt = null;

    UpdateRowsInDatabaseTest(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##test", "test");
            stmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    void updateStudent(){
        try {
            stmt.executeQuery("UPDATE STUDENT SET name='updateName', surname='updateSurname' where indexNumber='9999'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    void updateStudentGroup(){
        try {
            stmt.executeQuery("UPDATE STUDENTGROUP SET name='updateName' where groupID='9999'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void updateProposalState(){
        InsertToDatabaseTest insertTest = new InsertToDatabaseTest();
        insertTest.insertSocialGrantFormProposal();
        insertTest.insertFellowShipFormProposal();
        Proposal SocialGrantForm = null;
        Proposal FellowShipForm = null;
        String sql = null;
        PreparedStatement prepStmt = null;
        PendingProposalState pendingState = new PendingProposalState();
        RejectedProposalState rejectedState = new RejectedProposalState();
        AcceptedProposalState acceptedState = new AcceptedProposalState();
        DeleteFromDatabaseTest deleteTest = new DeleteFromDatabaseTest();

        try {
            sql = "SELECT * from proposal " +
                    "JOIN student ON student.indexNumber= proposal.indexNumber " +
                    "where proposalID=?";
            prepStmt = con.prepareStatement(sql);
            prepStmt.setString(1,"9999");
            ResultSet socialProposals = prepStmt.executeQuery();
           if(socialProposals.next()) {
               SocialGrantForm = new Proposal(socialProposals.getString("ProposalName"),
                       socialProposals.getString("name"),
                       socialProposals.getString("surname"),
                       socialProposals.getString("fieldOfStudy"),
                       socialProposals.getString("indexNumber"),
                       socialProposals.getString("date"),
                       socialProposals.getInt("session"),
                       socialProposals.getInt("income"));
           }
            pendingState.updateState(SocialGrantForm);
            System.out.println("Proposal name: "+SocialGrantForm.getProposalName()+"\n"+
                    "State of the proposal after the update: "+SocialGrantForm.getDecision());
            rejectedState.updateState(SocialGrantForm);
            System.out.println("Proposal name: "+SocialGrantForm.getProposalName()+"\n"+
                    "State of the proposal after the update: "+SocialGrantForm.getDecision());
            acceptedState.updateState(SocialGrantForm);
            System.out.println("Proposal name: "+SocialGrantForm.getProposalName()+"\n"+
                    "State of the proposal after the update: "+SocialGrantForm.getDecision()+"\n");

            sql = "SELECT * from proposal " +
                    "JOIN student ON student.indexNumber= proposal.indexNumber " +
                    "where proposalID=?";
            prepStmt = con.prepareStatement(sql);
            prepStmt.setString(1,"8888");
            ResultSet fellowshipProposals = prepStmt.executeQuery();
            if(fellowshipProposals.next()) {
                FellowShipForm = new Proposal(fellowshipProposals.getString("ProposalName"),
                        fellowshipProposals.getString("name"),
                        fellowshipProposals.getString("surname"),
                        fellowshipProposals.getString("fieldOfStudy"),
                        fellowshipProposals.getString("indexNumber"),
                        fellowshipProposals.getString("date"),
                        fellowshipProposals.getInt("session"),
                        fellowshipProposals.getDouble("avg"));
            }
            pendingState.updateState(FellowShipForm);
            System.out.println("Proposal name: "+FellowShipForm.getProposalName()+"\n"+
                    "State of the proposal after the update: "+FellowShipForm.getDecision());
            rejectedState.updateState(FellowShipForm);
            System.out.println("Proposal name: "+FellowShipForm.getProposalName()+"\n"+
                    "State of the proposal after the update: "+FellowShipForm.getDecision());
            acceptedState.updateState(FellowShipForm);
            System.out.println("Proposal name: "+FellowShipForm.getProposalName()+"\n"+
                    "State of the proposal after the update: "+FellowShipForm.getDecision());

            deleteTest.deleteSocialGrantForm();
            deleteTest.deleteFellowShipForm();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
