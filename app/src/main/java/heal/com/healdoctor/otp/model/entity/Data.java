package heal.com.healdoctor.otp.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Parcelable {

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
    @SerializedName("OTPRESPONSE")
    @Expose
    private String oTPRESPONSE;
    @SerializedName("message")
    @Expose
    private String message;

    protected Data(Parcel in) {
        this.oTPRESPONSE = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Data() {
    }

    public String getOTPRESPONSE() {
        return oTPRESPONSE;
    }

    public void setOTPRESPONSE(String oTPRESPONSE) {
        this.oTPRESPONSE = oTPRESPONSE;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(oTPRESPONSE);
        dest.writeValue(message);
    }

    public int describeContents() {
        return 0;
    }

}