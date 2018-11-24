package heal.com.healdoctor.profile.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PatientAddress implements Parcelable {

    @SerializedName("districtName")
    private String districtName;
    @SerializedName("stateId")
    private int stateId;
    @SerializedName("cityId")
    private int cityId;
    @SerializedName("countryId")
    private int countryId;
    @SerializedName("districtId")
    private int districtId;
    @SerializedName("cityName")
    private String cityName;
    @SerializedName("stateName")
    private String stateName;
    @SerializedName("countryCode")
    private String countryCode;
    @SerializedName("stateCode")
    private String stateCode;
    @SerializedName("countryName")
    private String countryName;

    public PatientAddress() {
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
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
        dest.writeInt(this.stateId);
        dest.writeInt(this.cityId);
        dest.writeInt(this.countryId);
        dest.writeInt(this.districtId);
        dest.writeString(this.cityName);
        dest.writeString(this.stateName);
        dest.writeString(this.countryCode);
        dest.writeString(this.stateCode);
        dest.writeString(this.countryName);
    }

    protected PatientAddress(Parcel in) {
        this.districtName = in.readString();
        this.stateId = in.readInt();
        this.cityId = in.readInt();
        this.countryId = in.readInt();
        this.districtId = in.readInt();
        this.cityName = in.readString();
        this.stateName = in.readString();
        this.countryCode = in.readString();
        this.stateCode = in.readString();
        this.countryName = in.readString();
    }

    public static final Creator<PatientAddress> CREATOR = new Creator<PatientAddress>() {
        @Override
        public PatientAddress createFromParcel(Parcel source) {
            return new PatientAddress(source);
        }

        @Override
        public PatientAddress[] newArray(int size) {
            return new PatientAddress[size];
        }
    };
}