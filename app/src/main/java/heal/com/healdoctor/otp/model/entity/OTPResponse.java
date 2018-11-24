package heal.com.healdoctor.otp.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class OTPResponse implements Parcelable {

    public final static Creator<OTPResponse> CREATOR = new Creator<OTPResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public OTPResponse createFromParcel(Parcel in) {
            return new OTPResponse(in);
        }

        public OTPResponse[] newArray(int size) {
            return (new OTPResponse[size]);
        }

    };
    @SerializedName("status")
    private String status;
    @SerializedName("responseType")
    private String responseType;
    @SerializedName("data")
    private Data data;

    protected OTPResponse(Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.responseType = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
    }

    public OTPResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(responseType);
        dest.writeValue(data);
    }

    public int describeContents() {
        return 0;
    }

}