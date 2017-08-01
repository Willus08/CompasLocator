package posidenpalace.com.compaslocator.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Banks implements Parcelable{
    Result result;
    Geometry geometry;


    protected Banks(Parcel in) {
    }

    public static final Creator<Banks> CREATOR = new Creator<Banks>() {
        @Override
        public Banks createFromParcel(Parcel in) {
            return new Banks(in);
        }

        @Override
        public Banks[] newArray(int size) {
            return new Banks[size];
        }
    };

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Banks(Result result, Geometry geometry) {

        this.result = result;
        this.geometry = geometry;

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
