package Office_Deans_PIP;

public class Group {
    int GroupID;
    String name;

    public Group(int groupID, String name) {
        GroupID = groupID;
        this.name = name;
    }

    public int getGroupID() {
        return GroupID;
    }

    public String getName() {
        return name;
    }
}
