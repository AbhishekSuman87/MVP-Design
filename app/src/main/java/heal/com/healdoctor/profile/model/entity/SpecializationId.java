package heal.com.healdoctor.profile.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpecializationId implements Parcelable {

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
    @SerializedName("specializationId")
    @Expose
    private Integer specializationId;
    @SerializedName("specializationName")
    @Expose
    private String specializationName;
    @SerializedName("specializationDesc")
    @Expose
    private String specializationDesc;

    public SpecializationId(Parcel in) {
        this.validFlag = ((String) in.readValue((String.class.getClassLoader())));;;
        this.createdBy = ((String) in.readValue((String.class.getClassLoader())));;;
        this.specializationId = (Integer) in.readValue((Integer.class.getClassLoader()));;;
        this.specializationName = ((String) in.readValue((String.class.getClassLoader())));;;
        this.specializationDesc = ((String) in.readValue((String.class.getClassLoader())));;;
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

    public Integer getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Integer specializationId) {
        this.specializationId = specializationId;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

    public String getSpecializationDesc() {
        return specializationDesc;
    }

    public void setSpecializationDesc(String specializationDesc) {
        this.specializationDesc = specializationDesc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(validFlag);
        dest.writeValue(createdBy);
        dest.writeValue(specializationId);
        dest.writeValue(specializationName);
        dest.writeValue(specializationDesc);

    }
}
