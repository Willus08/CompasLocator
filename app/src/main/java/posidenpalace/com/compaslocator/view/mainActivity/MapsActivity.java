package posidenpalace.com.compaslocator.view.mainActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import javax.inject.Inject;

import posidenpalace.com.compaslocator.R;
import posidenpalace.com.compaslocator.model.Banks;
import posidenpalace.com.compaslocator.view.detailsActivity.DetailsActivity;
import posidenpalace.com.compaslocator.view.injection.mainActivity.DaggerMapActivityComponent;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, MapActivityContract.View {
    private static final String TAG = "maps";
    private static final int LOCATION = 1;
    @Inject
    MapActivityPresenter presenter;
    GoogleMap mMap;
    LinearLayout mapContainer;
    FusedLocationProviderClient local;
    private Location current;
    Boolean changer = false;
    RecyclerView recy;
    MapActivityAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        checkForLocationPermission();
        recy = (RecyclerView) findViewById(R.id.rvRecycler);
        mapContainer = (LinearLayout) findViewById(R.id.llMapContainer);
        layoutManager = new LinearLayoutManager(this);
        animator = new DefaultItemAnimator();

        setUpDaggerComponent();

        presenter.addView(this);
        mapFragment.getMapAsync(this);

    }

    private void setUpDaggerComponent() {
        DaggerMapActivityComponent.create().inject(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera


        String location = "33,-88";
        presenter.makeRestCall(location);


    }

    @Override
    public void showError(Error error) {

    }

    @Override
    public void setupAdapter(final List<Banks> banksList) {
        Log.d(TAG, "setupAdapter: ");
        adapter = new MapActivityAdapter(banksList);
        recy.setItemAnimator(animator);
        recy.setAdapter(adapter);
        recy.setLayoutManager(layoutManager);
        for (int i = 0; i < banksList.size(); i++) {
            LatLng bankLocation = new LatLng(banksList.get(i).getGeometry().getLocation().getLat(), banksList.get(i).getGeometry().getLocation().getLng());
            MarkerOptions marker = new MarkerOptions().position(bankLocation).title(banksList.get(i).getResult().getFormattedAddress());
            mMap.addMarker(marker);
            final int finalI = i;
            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    Toast.makeText(MapsActivity.this, marker.getTitle(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MapsActivity.this, DetailsActivity.class);
                    intent.putExtra("passed",banksList.get(finalI));
                    startActivity(intent);
                    return true;
                }
            });


        }

    }

    @Override
    public void alternateView() {

        if(changer){
            changer = false;
            mapContainer.setVisibility(View.VISIBLE);
            recy.setVisibility(View.GONE);
        }else{

            LatLng temp = new LatLng(32,-87);
            String location = "33,-88";
            presenter.makeRestCall(location);
            mMap.addMarker(new MarkerOptions().position(temp).title("Should Be Alabama"));
            changer = true;
            mapContainer.setVisibility(View.GONE);
            recy.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void zoomToLocation(Banks bank) {
        alternateView();
        LatLng zoomTo = new LatLng(bank.getGeometry().getLocation().getLat(), bank.getGeometry().getLocation().getLng());
        mMap.moveCamera(CameraUpdateFactory.newLatLng(zoomTo));

    }

    public void checkForLocationPermission() {
        String[] permissions = new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        };

        for (int i = 0; i < permissions.length ; i++) {


            if (ContextCompat.checkSelfPermission(this,
                    permissions[i])
                    != PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "onCreate: no premission");

                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        permissions[i])) {
                    Log.d(TAG, "onCreate: explain");


                } else {

                    // No explanation needed, we can request the permission.
                    Log.d(TAG, "onCreate: no explain");
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},
                            LOCATION);

                }
            }
        }
    }

    public void toggle(View view) {
        alternateView();

    }


}
