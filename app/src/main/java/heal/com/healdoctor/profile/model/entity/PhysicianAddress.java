package heal.com.healdoctor.profile.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhysicianAddress implements Parcelable {

    @SerializedName("districtName")
    @Expose
    private String districtName;
    @SerializedName("stateId")
    @Expose
    private Integer stateId;
    @SerializedName("cityId")
    @Expose
    private Integer cityId;
    @SerializedName("countryId")
    @Expose
    private Integer countryId;
    @SerializedName("districtId")
    @Expose
    private Integer districtId;
    @SerializedName("cityName")
    @Expose
    private String cityName;
    @SerializedName("stateName")
    @Expose
    private String stateName;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("stateCode")
    @Expose
    private String stateCode;
    @SerializedName("countryName")
    @Expose
    private String countryName;

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.districtName);
        dest.writeValue(this.stateId);
        dest.writeValue(this.cityId);
        dest.writeValue(this.countryId);
        dest.writeValue(this.districtId);
        dest.writeString(this.cityName);
        dest.writeString(this.stateName);
        dest.writeString(this.countryCode);
        dest.writeString(this.stateCode);
        dest.writeString(this.countryName);
    }

    public PhysicianAddress() {
    }

    protected PhysicianAddress(Parcel in) {
        this.districtName = in.readString();
        this.stateId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.cityId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.countryId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.districtId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.cityName = in.readString();
        this.stateName = in.readString();
        this.countryCode = in.readString();
        this.stateCode = in.readString();
        this.countryName = in.readString();
    }

    public static final Creator<PhysicianAddress> CREATOR = new Creator<PhysicianAddress>() {
        @Override
        public PhysicianAddress createFromParcel(Parcel source) {
            return new PhysicianAddress(source);
        }

        @Override
        public PhysicianAddress[] newArray(int size) {
            return new PhysicianAddress[size];
        }
    };
}
