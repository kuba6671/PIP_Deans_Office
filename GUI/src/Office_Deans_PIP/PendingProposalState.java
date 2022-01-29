package Office_Deans_PIP;

public class PendingProposalState implements ProposalState {
    @Override
    public void updateState(Proposal proposal) {
        proposal.setDecisionState("Oczekujace");
    }
}
