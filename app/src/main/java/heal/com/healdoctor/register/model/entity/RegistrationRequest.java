package heal.com.healdoctor.register.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationRequest implements Parcelable {

    public final static Parcelable.Creator<RegistrationRequest> CREATOR = new Creator<RegistrationRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public RegistrationRequest createFromParcel(Parcel in) {
            return new RegistrationRequest(in);
        }

        public RegistrationRequest[] newArray(int size) {
            return (new RegistrationRequest[size]);
        }

    };
    @SerializedName("emailId")
    @Expose
    private String emailId;
    @SerializedName("mobileNo")
    @Expose
    private String mobileNo;
    @SerializedName("module")
    @Expose
    private String module;
    @SerializedName("otp")
    @Expose
    private String otp;
    @SerializedName("password")
    @Expose
    private String password;

    protected RegistrationRequest(Parcel in) {
        this.emailId = ((String) in.readValue((String.class.getClassLoader())));
        this.mobileNo = ((String) in.readValue((String.class.getClassLoader())));
        this.module = ((String) in.readValue((String.class.getClassLoader())));
        this.otp = ((String) in.readValue((String.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
    }

    public RegistrationRequest() {
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(emailId);
        dest.writeValue(mobileNo);
        dest.writeValue(module);
        dest.writeValue(otp);
        dest.writeValue(password);
    }

    public int describeContents() {
        return 0;
    }

}