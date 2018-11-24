package heal.com.healdoctor.profile.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Value implements Parcelable {

    public final static Creator<Data> CREATOR = new Creator<Data>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    };
    @SerializedName("imageName")
    @Expose
    private String imageName;
    @SerializedName("validFlag")
    @Expose
    private String validFlag;
    @SerializedName("physicianContactNo1")
    @Expose
    private String physicianContactNo1;
    @SerializedName("physicianContactNo2")
    @Expose
    private String physicianContactNo2;
    @SerializedName("physicianGender")
    @Expose
    private String physicianGender;
    @SerializedName("physicianMiddleName")
    @Expose
    private String physicianMiddleName;
    @SerializedName("isEmailVerified")
    @Expose
    private String isEmailVerified;
    @SerializedName("physicianSpecialization")
    @Expose
    private List<PhysicianSpecialization> physicianSpecialization = null;
    @SerializedName("physicianId")
    @Expose
    private Integer physicianId;
    @SerializedName("physicianLastName")
    @Expose
    private String physicianLastName;
    @SerializedName("physicianDescription")
    @Expose
    private String physicianDescription;
    @SerializedName("physicianEducation")
    @Expose
    private String physicianEducation;
    @SerializedName("physicianStatus")
    @Expose
    private String physicianStatus;
    @SerializedName("viewState")
    @Expose
    private String viewState;
    @SerializedName("personId")
    @Expose
    private Integer personId;
    @SerializedName("physicianFirstName")
    @Expose
    private String physicianFirstName;
    @SerializedName("physicianEmailId")
    @Expose
    private String physicianEmailId;
    @SerializedName("isMobileVerified")
    @Expose
    private String isMobileVerified;
    @SerializedName("physicianAddress")
    @Expose
    private PhysicianAddress physicianAddress;

    public Value(Parcel in) {
        this.imageName = (String) in.readValue((Value.class.getClassLoader()));
        this.validFlag = (String) in.readValue((Value.class.getClassLoader()));
        this.physicianContactNo1 = (String) in.readValue((Value.class.getClassLoader()));
        this.physicianContactNo2 = (String) in.readValue((Value.class.getClassLoader()));
        this.physicianGender = (String) in.readValue((Value.class.getClassLoader()));
        this.physicianMiddleName = (String) in.readValue((Value.class.getClassLoader()));
        this.isEmailVerified = (String) in.readValue((Value.class.getClassLoader()));
        this.physicianSpecialization = (List<PhysicianSpecialization>) in.readValue((PhysicianSpecialization.class.getClassLoader()));
        this.physicianId = (Integer) in.readValue((Integer.class.getClassLoader()));
        this.physicianLastName = (String) in.readValue((Value.class.getClassLoader()));
        this.physicianDescription = (String) in.readValue((Value.class.getClassLoader()));
        this.physicianEducation = (String) in.readValue((Value.class.getClassLoader()));
        this.physicianStatus = (String) in.readValue((Value.class.getClassLoader()));
        this.viewState = (String) in.readValue((Value.class.getClassLoader()));
        this.personId = (Integer) in.readValue((Integer.class.getClassLoader()));
        this.physicianFirstName = (String) in.readValue((Value.class.getClassLoader()));
        this.physicianEmailId = (String) in.readValue((Value.class.getClassLoader()));
        this.isMobileVerified = (String) in.readValue((Value.class.getClassLoader()));
        this.physicianAddress = (PhysicianAddress) in.readValue((PhysicianAddress.class.getClassLoader()));
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getPhysicianContactNo1() {
        return physicianContactNo1;
    }

    public void setPhysicianContactNo1(String physicianContactNo1) {
        this.physicianContactNo1 = physicianContactNo1;
    }

    public String getPhysicianContactNo2() {
        return physicianContactNo2;
    }

    public void setPhysicianContactNo2(String physicianContactNo2) {
        this.physicianContactNo2 = physicianContactNo2;
    }

    public String getPhysicianGender() {
        return physicianGender;
    }

    public void setPhysicianGender(String physicianGender) {
        this.physicianGender = physicianGender;
    }

    public String getPhysicianMiddleName() {
        return physicianMiddleName;
    }

    public void setPhysicianMiddleName(String physicianMiddleName) {
        this.physicianMiddleName = physicianMiddleName;
    }

    public String getIsEmailVerified() {
        return isEmailVerified;
    }

    public void setIsEmailVerified(String isEmailVerified) {
        this.isEmailVerified = isEmailVerified;
    }

    public List<PhysicianSpecialization> getPhysicianSpecialization() {
        return physicianSpecialization;
    }

    public void setPhysicianSpecialization(List<PhysicianSpecialization> physicianSpecialization) {
        this.physicianSpecialization = physicianSpecialization;
    }

    public Integer getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(Integer physicianId) {
        this.physicianId = physicianId;
    }

    public String getPhysicianLastName() {
        return physicianLastName;
    }

    public void setPhysicianLastName(String physicianLastName) {
        this.physicianLastName = physicianLastName;
    }

    public String getPhysicianDescription() {
        return physicianDescription;
    }

    public void setPhysicianDescription(String physicianDescription) {
        this.physicianDescription = physicianDescription;
    }

    public String getPhysicianEducation() {
        return physicianEducation;
    }

    public void setPhysicianEducation(String physicianEducation) {
        this.physicianEducation = physicianEducation;
    }

    public String getPhysicianStatus() {
        return physicianStatus;
    }

    public void setPhysicianStatus(String physicianStatus) {
        this.physicianStatus = physicianStatus;
    }

    public String getViewState() {
        return viewState;
    }

    public void setViewState(String viewState) {
        this.viewState = viewState;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPhysicianFirstName() {
        return physicianFirstName;
    }

    public void setPhysicianFirstName(String physicianFirstName) {
        this.physicianFirstName = physicianFirstName;
    }

    public String getPhysicianEmailId() {
        return physicianEmailId;
    }

    public void setPhysicianEmailId(String physicianEmailId) {
        this.physicianEmailId = physicianEmailId;
    }

    public String getIsMobileVerified() {
        return isMobileVerified;
    }

    public void setIsMobileVerified(String isMobileVerified) {
        this.isMobileVerified = isMobileVerified;
    }

    public PhysicianAddress getPhysicianAddress() {
        return physicianAddress;
    }

    public void setPhysicianAddress(PhysicianAddress physicianAddress) {
        this.physicianAddress = physicianAddress;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(imageName);
        dest.writeValue(validFlag);
        dest.writeValue(physicianContactNo1);
        dest.writeValue(physicianContactNo2);
        dest.writeValue(physicianGender);
        dest.writeValue(physicianMiddleName);
        dest.writeValue(isEmailVerified);
        dest.writeValue(physicianSpecialization);
        dest.writeValue(physicianId);
        dest.writeValue(physicianLastName);
        dest.writeValue(physicianDescription);
        dest.writeValue(physicianEducation);
        dest.writeValue(physicianStatus);
        dest.writeValue(viewState);
        dest.writeValue(personId);
        dest.writeValue(physicianFirstName);
        dest.writeValue(physicianEmailId);
        dest.writeValue(isMobileVerified);
        dest.writeValue(physicianAddress);

    }

    public int describeContents() {
        return 0;
    }
}
