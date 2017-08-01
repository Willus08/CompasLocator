package posidenpalace.com.compaslocator.view.mainActivity;


import java.util.List;

import posidenpalace.com.compaslocator.model.Banks;
import posidenpalace.com.compaslocator.view.BasePresenter;
import posidenpalace.com.compaslocator.view.BaseView;

public interface MapActivityContract {
    interface View extends BaseView{
        void setupAdapter(List<Banks> banksList);
        void alternateView();
        void zoomToLocation(Banks bank);
    }

    interface Presenter extends BasePresenter<View>{
        void makeRestCall(String location);
    }
}
