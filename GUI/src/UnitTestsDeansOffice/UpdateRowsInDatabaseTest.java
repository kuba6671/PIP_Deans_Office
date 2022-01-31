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
           if(SocialGrantForm.getDecision() != "Oczekujace"){
               throw new Exception("State error");
           }
            rejectedState.updateState(SocialGrantForm);
            if(SocialGrantForm.getDecision() != "Odrzucone"){
                throw new Exception("State error");
            }
            acceptedState.updateState(SocialGrantForm);
            if(SocialGrantForm.getDecision() != "Przyjete"){
                throw new Exception("State error");
            }

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
            if(FellowShipForm.getDecision() != "Oczekujace"){
                throw new Exception("State error");
            }
            rejectedState.updateState(FellowShipForm);
            if(FellowShipForm.getDecision() != "Odrzucone"){
                throw new Exception("State error");
            }
            acceptedState.updateState(FellowShipForm);
            if(FellowShipForm.getDecision() != "Przyjete"){
                throw new Exception("State error");
            }

            deleteTest.deleteSocialGrantForm();
            deleteTest.deleteFellowShipForm();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
