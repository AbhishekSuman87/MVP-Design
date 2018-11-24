package heal.com.healdoctor.login.model.entity;

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
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("personId")
    @Expose
    private Integer personId;
    @SerializedName("idType")
    @Expose
    private String idType;
    @SerializedName("idValue")
    @Expose
    private Integer idValue;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("module")
    @Expose
    private String module;

    public Data(Parcel in) {
        this.token = (String) in.readValue((String.class.getClassLoader()));
        this.email = (String) in.readValue((String.class.getClassLoader()));
        this.personId = (Integer) in.readValue((Integer.class.getClassLoader()));
        this.idType = (String) in.readValue((String.class.getClassLoader()));
        this.idValue = (Integer) in.readValue((Integer.class.getClassLoader()));
        this.status = (String) in.readValue((String.class.getClassLoader()));
        this.module = (String) in.readValue((String.class.getClassLoader()));
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public Integer getIdValue() {
        return idValue;
    }

    public void setIdValue(Integer idValue) {
        this.idValue = idValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(token);
        dest.writeValue(email);
        dest.writeValue(personId);
        dest.writeValue(idType);
        dest.writeValue(idValue);
        dest.writeValue(status);
        dest.writeValue(module);

    }

    public int describeContents() {
        return 0;
    }

}