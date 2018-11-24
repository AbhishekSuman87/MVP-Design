package heal.com.healdoctor.register.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Map implements Parcelable {

    public final static Parcelable.Creator<Map> CREATOR = new Creator<Map>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Map createFromParcel(Parcel in) {
            return new Map(in);
        }

        public Map[] newArray(int size) {
            return (new Map[size]);
        }

    };
    @SerializedName("patientId")
    private int patientId;
    @SerializedName("validFlag")
    private String validFlag;
    @SerializedName("viewState")
    private String viewState;
    @SerializedName("personId")
    private int personId;
    @SerializedName("mobileNo")
    private String mobileNo;
    @SerializedName("email")
    private String email;
    @SerializedName("status")
    private String status;

    protected Map(Parcel in) {
        this.patientId = ((int) in.readValue((int.class.getClassLoader())));
        this.validFlag = ((String) in.readValue((String.class.getClassLoader())));
        this.viewState = ((String) in.readValue((String.class.getClassLoader())));
        this.personId = ((int) in.readValue((int.class.getClassLoader())));
        this.mobileNo = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Map() {
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getViewState() {
        return viewState;
    }

    public void setViewState(String viewState) {
        this.viewState = viewState;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(patientId);
        dest.writeValue(validFlag);
        dest.writeValue(viewState);
        dest.writeValue(personId);
        dest.writeValue(mobileNo);
        dest.writeValue(email);
        dest.writeValue(status);
    }

    public int describeContents() {
        return 0;
    }

}