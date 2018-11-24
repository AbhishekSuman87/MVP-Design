package heal.com.healdoctor.register.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Data implements Parcelable {

    public final static Parcelable.Creator<Data> CREATOR = new Creator<Data>() {


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
    @SerializedName("map")
    private Map map;

    protected Data(Parcel in) {
        this.map = ((Map) in.readValue((Map.class.getClassLoader())));
    }

    public Data() {
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(map);
    }

    public int describeContents() {
        return 0;
    }

}