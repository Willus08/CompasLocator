package posidenpalace.com.compaslocator.view.mainActivity;


import posidenpalace.com.compaslocator.model.Locations;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class MapRestHelper {
    //

    public static final String BASE_URL ="https://maps.googleapis.com/maps/";
    public static final String KEY = "AIzaSyBxJafoLNXXJhVOtEfRXoKVhYDCobhRfEQ";
    public  static Retrofit create(){

        Retrofit retro = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retro;
    }

    public static Call<Locations> locationsCall(String location){
        Retrofit retrofit = create();
        Calls calls = retrofit.create(Calls.class);
        return calls.getLocations(location,1000000,KEY);
    }
//
    interface Calls{
        @GET("api/place/textsearch/json?query=BBVA+Compass")
        Call<Locations> getLocations(@Query("location") String string, @Query("radius") int radius, @Query("key")String key);

    }
}
