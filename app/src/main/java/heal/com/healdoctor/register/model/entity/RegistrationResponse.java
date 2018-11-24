package heal.com.healdoctor.register.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import heal.com.healdoctor.network.BaseResponse;

public class RegistrationResponse extends BaseResponse implements Parcelable {

    public final static Parcelable.Creator<RegistrationResponse> CREATOR = new Creator<RegistrationResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public RegistrationResponse createFromParcel(Parcel in) {
            return new RegistrationResponse(in);
        }

        public RegistrationResponse[] newArray(int size) {
            return (new RegistrationResponse[size]);
        }

    };
    @SerializedName("data")
    private Data data;

    protected RegistrationResponse(Parcel in) {
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
    }

    public RegistrationResponse() {
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(data);
    }

    public int describeContents() {
        return 0;
    }

}