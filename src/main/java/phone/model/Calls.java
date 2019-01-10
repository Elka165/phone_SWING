package phone.model;

import java.util.Date;
import java.util.Objects;

public class Calls {
    String claim;
    String topic;
    String subcategory;
    String whoCalls;
    String surnameAndName;
    Date dateOfCall;

    public Calls(String claim, String topic, String subcategory, String whoCalls, String surnameAndName, Date dateOfCall) {
        this.claim = claim;
        this.topic = topic;
        this.subcategory = subcategory;
        this.whoCalls = whoCalls;
        this.surnameAndName = surnameAndName;
        this.dateOfCall = dateOfCall;
    }

    public String getClaim() {
        return claim;
    }

    public void setClaim(String claim) {
        this.claim = claim;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getWhoCalls() {
        return whoCalls;
    }

    public void setWhoCalls(String whoCalls) {
        this.whoCalls = whoCalls;
    }

    public String getSurnameAndName() {
        return surnameAndName;
    }

    public void setSurnameAndName(String surnameAndName) {
        this.surnameAndName = surnameAndName;
    }

    public Date getDateOfCall() {
        return dateOfCall;
    }

    public void setDateOfCall(Date dateOfCall) {
        this.dateOfCall = dateOfCall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Calls)) return false;
        Calls calls = (Calls) o;
        return Objects.equals(claim, calls.claim) &&
                Objects.equals(topic, calls.topic) &&
                Objects.equals(subcategory, calls.subcategory) &&
                Objects.equals(whoCalls, calls.whoCalls) &&
                Objects.equals(surnameAndName, calls.surnameAndName) &&
                Objects.equals(dateOfCall, calls.dateOfCall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(claim, topic, subcategory, whoCalls, surnameAndName, dateOfCall);
    }

    @Override
    public String toString() {
        return "Calls{" +
                "claim='" + claim + '\'' +
                ", topic='" + topic + '\'' +
                ", subcategory='" + subcategory + '\'' +
                ", whoCalls='" + whoCalls + '\'' +
                ", surnameAndName='" + surnameAndName + '\'' +
                ", dateOfCall=" + dateOfCall +
                '}';
    }
}