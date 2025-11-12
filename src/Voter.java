package voterregistration;

public class Voter {

    private String voterId;   // Unique identifier
    private String name;
    private int age;
    private String address;

    public Voter(String voterId, String name, int age, String address) {
        this.voterId = voterId;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getVoterId() {
        return voterId;
    }

    @Override
    public String toString() {
        return "VoterID: " + voterId +
               ", Name: " + name +
               ", Age: " + age +
               ", Address: " + address;
    }

    // Uniqueness based only on voterId
    @Override
    public int hashCode() {
        return voterId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Voter)) return false;
        Voter other = (Voter) obj;
        return this.voterId.equals(other.voterId);
    }
}
