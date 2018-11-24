package heal.com.healdoctor.profile.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum implements Parcelable
{

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
    @SerializedName("validFlag")
    @Expose
    private String validFlag;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("viewState")
    @Expose
    private String viewState;
    @SerializedName("statusName")
    @Expose
    private String statusName;
    @SerializedName("physicianSpecializationId")
    @Expose
    private Integer physicianSpecializationId;
    @SerializedName("specializationId")
    @Expose
    private SpecializationId specializationId;
    @SerializedName("physicianId")
    @Expose
    private PhysicianId physicianId;

    public Datum(Parcel in) {
        this.validFlag = ((String) in.readValue((String.class.getClassLoader())));;
        this.createdBy = ((String) in.readValue((String.class.getClassLoader())));;
        this.viewState = ((String) in.readValue((String.class.getClassLoader())));;
        this.statusName = ((String) in.readValue((String.class.getClassLoader())));;
        this.physicianSpecializationId = ((Integer) in.readValue((Integer.class.getClassLoader())));;
        this.specializationId = ((SpecializationId) in.readValue((SpecializationId.class.getClassLoader())));;
        this.physicianId = ((PhysicianId) in.readValue((PhysicianId.class.getClassLoader())));;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getViewState() {
        return viewState;
    }

    public void setViewState(String viewState) {
        this.viewState = viewState;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getPhysicianSpecializationId() {
        return physicianSpecializationId;
    }

    public void setPhysicianSpecializationId(Integer physicianSpecializationId) {
        this.physicianSpecializationId = physicianSpecializationId;
    }

    public SpecializationId getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(SpecializationId specializationId) {
        this.specializationId = specializationId;
    }

    public PhysicianId getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(PhysicianId physicianId) {
        this.physicianId = physicianId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeValue(validFlag);
        dest.writeValue(createdBy);
        dest.writeValue(validFlag);
        dest.writeValue(viewState);
        dest.writeValue(statusName);
        dest.writeValue(physicianSpecializationId);
        dest.writeValue(specializationId);
        dest.writeValue(physicianId);
    }
}
