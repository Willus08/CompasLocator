package posidenpalace.com.compaslocator.view.injection.detailsActivity;


import dagger.Module;
import dagger.Provides;
import posidenpalace.com.compaslocator.view.detailsActivity.DetailsActivityPresenter;

@Module
public class DetailsActivityModule {
    @Provides
    public DetailsActivityPresenter detailsActivityPresenter(){
        return new DetailsActivityPresenter();
    }
}
