package Office_Deans_PIP;

import java.sql.Connection;
import java.sql.Statement;

public class AcceptedProposalState implements ProposalState {
    @Override
    public void updateState(Proposal proposal) {
        proposal.setDecisionState("Przyjete");
    }

}
