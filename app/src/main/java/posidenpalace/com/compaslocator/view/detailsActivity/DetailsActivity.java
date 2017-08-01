package posidenpalace.com.compaslocator.view.detailsActivity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import posidenpalace.com.compaslocator.R;
import posidenpalace.com.compaslocator.model.Banks;
import posidenpalace.com.compaslocator.view.injection.detailsActivity.DaggerDetailsActivityComponent;

public class DetailsActivity extends AppCompatActivity implements DetailsActivityContract.View{
    @Inject DetailsActivityPresenter presenter;
    TextView name;
    TextView address;
    ImageView photo;
    RatingBar rating;
    TextView openingHours;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setUpInjection();
        presenter.addView(this);
        name = (TextView) findViewById(R.id.tvDetailedName);
        address = (TextView) findViewById(R.id.tvDetailedAddress);
        openingHours= (TextView) findViewById(R.id.tvDetailedOpenHours);
        photo = (ImageView) findViewById(R.id.ivDetailedPicture);
        rating= (RatingBar) findViewById(R.id.rbDetailedRating);
    }

    public void setUpInjection(){
        DaggerDetailsActivityComponent.create().inject(this);
    }

    @Override
    public void showError(Error error) {

    }

    @Override
    public void setupViews(Banks banks) {
        name.setText(banks.getResult().getName());
        address.setText(banks.getResult().getFormattedAddress());
        if (banks.getResult().getOpeningHours().getOpenNow()) {
            openingHours.setText("Open");
            openingHours.setTextColor(Color.GREEN);
        }
        else {
            openingHours.setText("Closed");
            openingHours.setTextColor(Color.RED);
        }
        if (banks.getResult().getPhotos().size()>0) {
            Glide.with(this).load(banks.getResult().getPhotos().get(0)).into(photo);
        }else{
            photo.setVisibility(View.GONE);
        }
        rating.setProgress(banks.getResult().getRating());

    }
}
