
package posidenpalace.com.compaslocator.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpeningHours implements Serializable
{

    @SerializedName("open_now")
    @Expose
    private Boolean openNow;
    @SerializedName("weekday_text")
    @Expose
    private List<Object> weekdayText = null;
    private final static long serialVersionUID = 344936637433503814L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpeningHours() {
    }

    /**
     * 
     * @param weekdayText
     * @param openNow
     */
    public OpeningHours(Boolean openNow, List<Object> weekdayText) {
        super();
        this.openNow = openNow;
        this.weekdayText = weekdayText;
    }

    public Boolean getOpenNow() {
        return openNow;
    }

    public void setOpenNow(Boolean openNow) {
        this.openNow = openNow;
    }

    public List<Object> getWeekdayText() {
        return weekdayText;
    }

    public void setWeekdayText(List<Object> weekdayText) {
        this.weekdayText = weekdayText;
    }

}
