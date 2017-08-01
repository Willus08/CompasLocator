
package posidenpalace.com.compaslocator.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable
{

    @SerializedName("formatted_address")
    @Expose
    private String formattedAddress;
    @SerializedName("geometry")
    @Expose
    private Geometry geometry;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("photos")
    @Expose
    private List<Photo> photos = null;
    @SerializedName("place_id")
    @Expose
    private String placeId;
    @SerializedName("reference")
    @Expose
    private String reference;
    @SerializedName("types")
    @Expose
    private List<String> types = null;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("opening_hours")
    @Expose
    private OpeningHours openingHours;
    private final static long serialVersionUID = -6016105950483865331L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param photos
     * @param id
     * @param icon
     * @param openingHours
     * @param placeId
     * @param name
     * @param formattedAddress
     * @param rating
     * @param types
     * @param reference
     * @param geometry
     */
    public Result(String formattedAddress, Geometry geometry, String icon, String id, String name, List<Photo> photos, String placeId, String reference, List<String> types, Integer rating, OpeningHours openingHours) {
        super();
        this.formattedAddress = formattedAddress;
        this.geometry = geometry;
        this.icon = icon;
        this.id = id;
        this.name = name;
        this.photos = photos;
        this.placeId = placeId;
        this.reference = reference;
        this.types = types;
        this.rating = rating;
        this.openingHours = openingHours;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(OpeningHours openingHours) {
        this.openingHours = openingHours;
    }

}
