package heal.com.healdoctor.profile.model.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.renderscript.Sampler.Value;

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
    @SerializedName("value")
    @Expose
    private Value value;
    @SerializedName("present")
    @Expose
    private Boolean present;

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }

    protected Data(Parcel in) {
        this.value = (Value) in.readValue((Value.class.getClassLoader()));
        this.present = (Boolean) in.readValue((Boolean.class.getClassLoader()));

    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(value);
        dest.writeValue(present);

    }

    public int describeContents() {
        return 0;
    }

}