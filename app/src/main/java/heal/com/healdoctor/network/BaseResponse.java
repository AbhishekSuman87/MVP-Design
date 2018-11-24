package heal.com.healdoctor.network;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseResponse implements Parcelable {

    public final static Parcelable.Creator<BaseResponse> CREATOR = new Creator<BaseResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public BaseResponse createFromParcel(Parcel in) {
            return new BaseResponse(in);
        }

        public BaseResponse[] newArray(int size) {
            return (new BaseResponse[size]);
        }

    };
    @SerializedName("status")
    private String status;
    @SerializedName("responseType")
    private String responseType;
    @SerializedName("errors")
    private List<Error> errors = null;

    protected BaseResponse(Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.responseType = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.errors, (Error.class.getClassLoader()));
    }

    public BaseResponse() {
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

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(responseType);
        dest.writeList(errors);
    }

    public int describeContents() {
        return 0;
    }

}