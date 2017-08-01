package posidenpalace.com.compaslocator.view.detailsActivity;

import android.content.Intent;

import posidenpalace.com.compaslocator.model.Banks;

public class DetailsActivityPresenter implements DetailsActivityContract.Presenter {
    DetailsActivityContract.View view;
    @Override
    public void addView(DetailsActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void handleData(Intent intent) {
        Banks bank = intent.getParcelableExtra("passed");
        view.setupViews(bank);
    }
}
