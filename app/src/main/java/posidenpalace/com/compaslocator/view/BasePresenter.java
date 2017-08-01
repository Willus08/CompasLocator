package posidenpalace.com.compaslocator.view;


public interface BasePresenter<V extends BaseView> {
    void addView(V view);
    void removeView();
}
