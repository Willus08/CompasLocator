package posidenpalace.com.compaslocator.view.injection.mainActivity;


import dagger.Module;
import dagger.Provides;
import posidenpalace.com.compaslocator.view.mainActivity.MapActivityPresenter;

@Module
public class MapActivityModule {
    @Provides
    MapActivityPresenter providesMainActivityPresenter(){
        return new MapActivityPresenter();
    }
}
