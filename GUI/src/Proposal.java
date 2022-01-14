import java.time.LocalDate;

public class Proposal {
    String proposalName, name, surname, subject, id;
    LocalDate date;
    int session, income;
    Double avg;

    public Proposal(String proposalName, String name, String surname,
                    String fieldOfStudy, String id, LocalDate date, int session, int income) {
        this.proposalName = proposalName;
        this.name = name;
        this.surname = surname;
        this.subject = fieldOfStudy;
        this.id = id;
        this.date = date;
        this.session = session;
        this.income = income;
    }

    public Proposal(String proposalName, String name, String surname,
                    String fieldOfStudy, String id, LocalDate date, int session, Double avg) {
        this.proposalName = proposalName;
        this.name = name;
        this.surname = surname;
        this.subject = fieldOfStudy;
        this.id = id;
        this.date = date;
        this.session = session;
        this.avg = avg;
    }

    public String getProposalName() {
        return proposalName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getfieldOfStudy() {
        return subject;
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getSession() {
        return session;
    }

    public int getIncome() {
        return income;
    }

    public Double getAvg() {
        return avg;
    }
}
