package heal.com.healdoctor.network;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Error implements Parcelable {

    public final static Parcelable.Creator<Error> CREATOR = new Creator<Error>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Error createFromParcel(Parcel in) {
            return new Error(in);
        }

        public Error[] newArray(int size) {
            return (new Error[size]);
        }

    };
    @SerializedName("errorCode")
    private String errorCode;
    @SerializedName("errorDesc")
    private String errorDesc;

    protected Error(Parcel in) {
        this.errorCode = ((String) in.readValue((String.class.getClassLoader())));
        this.errorDesc = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Error() {
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(errorCode);
        dest.writeValue(errorDesc);
    }

    public int describeContents() {
        return 0;
    }

}