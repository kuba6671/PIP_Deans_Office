package Office_Deans_PIP.packageProposal;


public class RejectedProposalState implements ProposalState {
    @Override
    public void updateState(Proposal proposal) {
        proposal.setDecisionState("Odrzucone");
    }
}
