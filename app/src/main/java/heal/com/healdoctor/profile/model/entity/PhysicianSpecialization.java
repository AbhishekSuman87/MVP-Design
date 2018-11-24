package heal.com.healdoctor.profile.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhysicianSpecialization implements Parcelable {

    @SerializedName("physicianSpecializationId")
    @Expose
    private Integer physicianSpecializationId;
    @SerializedName("specializationDesc")
    @Expose
    private String specializationDesc;
    @SerializedName("validFlag")
    @Expose
    private String validFlag;
    @SerializedName("specializationName")
    @Expose
    private String specializationName;
    @SerializedName("StatusName")
    @Expose
    private String statusName;

    public Integer getPhysicianSpecializationId() {
        return physicianSpecializationId;
    }

    public void setPhysicianSpecializationId(Integer physicianSpecializationId) {
        this.physicianSpecializationId = physicianSpecializationId;
    }

    public String getSpecializationDesc() {
        return specializationDesc;
    }

    public void setSpecializationDesc(String specializationDesc) {
        this.specializationDesc = specializationDesc;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.physicianSpecializationId);
        dest.writeString(this.specializationDesc);
        dest.writeString(this.validFlag);
        dest.writeString(this.specializationName);
        dest.writeString(this.statusName);
    }

    protected PhysicianSpecialization(Parcel in) {
        this.physicianSpecializationId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.specializationDesc = in.readString();
        this.validFlag = in.readString();
        this.specializationName = in.readString();
        this.statusName = in.readString();
    }

    public static final Creator<PhysicianSpecialization> CREATOR = new Creator<PhysicianSpecialization>() {
        @Override
        public PhysicianSpecialization createFromParcel(Parcel source) {
            return new PhysicianSpecialization(source);
        }

        @Override
        public PhysicianSpecialization[] newArray(int size) {
            return new PhysicianSpecialization[size];
        }
    };
}
