package heal.com.healdoctor.login.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import heal.com.healdoctor.network.BaseResponse;

public class LoginResponse extends BaseResponse implements Parcelable {

    public final static Creator<LoginResponse> CREATOR = new Creator<LoginResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LoginResponse createFromParcel(Parcel in) {
            return new LoginResponse(in);
        }

        public LoginResponse[] newArray(int size) {
            return (new LoginResponse[size]);
        }

    };
    @SerializedName("data")
    @Expose
    private Data data;

    public LoginResponse(Parcel in) {
         this.data= (Data) in.readValue((Data.class.getClassLoader()));
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