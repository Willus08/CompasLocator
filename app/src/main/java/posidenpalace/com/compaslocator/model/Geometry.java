
package posidenpalace.com.compaslocator.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Geometry implements Serializable
{

    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("viewport")
    @Expose
    private Viewport viewport;
    private final static long serialVersionUID = -5205428570492736017L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Geometry() {
    }

    /**
     * 
     * @param viewport
     * @param location
     */
    public Geometry(Location location, Viewport viewport) {
        super();
        this.location = location;
        this.viewport = viewport;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

}
