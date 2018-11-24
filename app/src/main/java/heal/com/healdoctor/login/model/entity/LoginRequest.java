package heal.com.healdoctor.login.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest implements Parcelable {

    public final static Creator<LoginRequest> CREATOR = new Creator<LoginRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LoginRequest createFromParcel(Parcel in) {
            return new LoginRequest(in);
        }

        public LoginRequest[] newArray(int size) {
            return (new LoginRequest[size]);
        }

    };

    @SerializedName("accountId")
    @Expose
    private Integer account;
    @SerializedName("email")
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
    @SerializedName("username")
    @Expose
    private String username;

    protected LoginRequest(Parcel in) {
        this.account=((Integer) in.readValue((Integer.class.getClassLoader())));
        this.emailId = ((String) in.readValue((String.class.getClassLoader())));
        this.mobileNo = ((String) in.readValue((String.class.getClassLoader())));
        this.module = ((String) in.readValue((String.class.getClassLoader())));
        this.otp = ((String) in.readValue((String.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
        this.username=((String) in.readValue((String.class.getClassLoader())));
    }

    public LoginRequest() {
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


    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(emailId);
        dest.writeValue(mobileNo);
        dest.writeValue(module);
        dest.writeValue(otp);
        dest.writeValue(password);
        dest.writeValue(account);
        dest.writeValue(username);
    }

    public int describeContents() {
        return 0;
    }

}