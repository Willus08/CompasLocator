package posidenpalace.com.compaslocator.view.mainActivity;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import posidenpalace.com.compaslocator.model.Banks;
import posidenpalace.com.compaslocator.model.Locations;
import retrofit2.Call;
import retrofit2.Response;

public class MapActivityPresenter implements MapActivityContract.Presenter {
    private static final String TAG = "rest";
    MapActivityContract.View view;
    public List<Banks> banksList = new ArrayList<>();
    @Override
    public void addView(MapActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void makeRestCall(String location) {
        retrofit2.Call<Locations> locationsCall = MapRestHelper.locationsCall(location);
        locationsCall.enqueue(new retrofit2.Callback<Locations>() {



            @Override
            public void onResponse(Call<Locations> call, Response<Locations> response) {
                Log.d(TAG, "onResponse: " + response.body().getResults().size());

                for (int i = 0; i <response.body().getResults().size() ; i++) {
                    banksList.add( new Banks(
                            response.body().getResults().get(i),
                            response.body().getResults().get(i).getGeometry()
                    ));
                    Log.d(TAG, "onResponse: "+ banksList.get(i).getResult().getName());
                }
                view.setupAdapter(banksList);
            }

            @Override
            public void onFailure(Call<Locations> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });

    }

}
