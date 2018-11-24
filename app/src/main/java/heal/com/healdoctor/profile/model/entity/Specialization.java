package heal.com.healdoctor.profile.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Specialization implements Parcelable {


    public final static Creator<PatientAddress> CREATOR = new Creator<PatientAddress>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PatientAddress createFromParcel(Parcel in) {
            return new PatientAddress(in);
        }

        public PatientAddress[] newArray(int size) {
            return (new PatientAddress[size]);
        }

    };
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("responseType")
    @Expose
    private String responseType;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public Specialization(Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));;
        this.responseType = ((String) in.readValue((String.class.getClassLoader())));
        this.data = (List<Datum>) in.readValue((Datum.class.getClassLoader()));
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

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
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
