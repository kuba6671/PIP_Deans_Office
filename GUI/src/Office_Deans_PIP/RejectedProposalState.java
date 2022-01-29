package Office_Deans_PIP;

public class RejectedProposalState implements ProposalState {
    @Override
    public void updateState(Proposal proposal) {
        proposal.setDecisionState("Odrzucone");
    }
}
