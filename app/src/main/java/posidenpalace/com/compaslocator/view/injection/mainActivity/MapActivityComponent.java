package posidenpalace.com.compaslocator.view.injection.mainActivity;


import dagger.Component;
import posidenpalace.com.compaslocator.view.mainActivity.MapsActivity;

@Component(modules = MapActivityModule.class)
public interface MapActivityComponent {
    void inject(MapsActivity mapsActivity);
}
