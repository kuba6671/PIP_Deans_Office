package Office_Deans_PIP.packageProposal;


public class AcceptedProposalState implements ProposalState {
    @Override
    public void updateState(Proposal proposal) {
        proposal.setDecisionState("Przyjete");
    }

}
