package heal.com.healdoctor.profile.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import heal.com.healdoctor.network.BaseResponse;

public class ProfileResponse extends BaseResponse implements Parcelable {

    public final static Creator<ProfileResponse> CREATOR = new Creator<ProfileResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ProfileResponse createFromParcel(Parcel in) {
            return new ProfileResponse(in);
        }

        public ProfileResponse[] newArray(int size) {
            return (new ProfileResponse[size]);
        }

    };
    @SerializedName("data")
    private Data data;

    protected ProfileResponse(Parcel in) {
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
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