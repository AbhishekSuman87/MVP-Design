package heal.com.healdoctor.profile.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhysicianId implements Parcelable {


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
    @SerializedName("physicianId")
    @Expose
    private Integer physicianId;
    @SerializedName("experience")
    @Expose
    private Integer experience;
    @SerializedName("educationCode")
    @Expose
    private Integer educationCode;

    public PhysicianId(Parcel in) {
        this.physicianId  = ((Integer) in.readValue((Integer.class.getClassLoader())));;
        this.experience = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.educationCode = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Integer getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(Integer physicianId) {
        this.physicianId = physicianId;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getEducationCode() {
        return educationCode;
    }

    public void setEducationCode(Integer educationCode) {
        this.educationCode = educationCode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(physicianId);
        dest.writeValue(experience);
        dest.writeValue(educationCode);
    }
}
