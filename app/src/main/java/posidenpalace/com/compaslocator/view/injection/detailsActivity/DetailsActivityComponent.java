package posidenpalace.com.compaslocator.view.injection.detailsActivity;


import dagger.Component;
import posidenpalace.com.compaslocator.view.detailsActivity.DetailsActivity;

@Component(modules = DetailsActivityModule.class)
public interface DetailsActivityComponent {
    void inject(DetailsActivity detailsActivity);
}
