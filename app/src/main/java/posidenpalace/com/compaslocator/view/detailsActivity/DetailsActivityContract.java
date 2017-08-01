package posidenpalace.com.compaslocator.view.detailsActivity;


import android.content.Intent;

import posidenpalace.com.compaslocator.model.Banks;
import posidenpalace.com.compaslocator.view.BasePresenter;
import posidenpalace.com.compaslocator.view.BaseView;

public interface DetailsActivityContract {
    interface View extends BaseView{
        void setupViews(Banks banks);
    }

    interface Presenter extends BasePresenter<View>{
        void handleData(Intent intent);
    }
}
