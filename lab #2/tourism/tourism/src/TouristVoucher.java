public class TouristVoucher implements Comparable<TouristVoucher> {

    private String id;

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String countryCode;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    private Integer dayCount;
    
    public Integer getDayCount() {
        return dayCount;
    }

    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
    }

    public enum Transportation {
        PLANE("plane"),
        SHIP("ship"),
        CAR("car"),
        NONE("n/a");

        private String transportation;
        
        Transportation(String transportation) {
            this.transportation = transportation;
        }

        public String getTransportation() {
            return transportation;
        }
    }

    public Transportation transportation;

    public Transportation getTransportation() {
        return transportation;
    }

    public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

    public static class HotelCharacteristic {
        public Integer stars;
        public Boolean freeMeals;
        public Integer rooms;

        public HotelCharacteristic() {};

        @Override
        public String toString() {
            return "HotelCharacteristic[ stars=" + stars + ", freeMeals=" + freeMeals + ", rooms=" + rooms + " ]";
        }
    }

    public HotelCharacteristic hotelCharacteristic;

    public HotelCharacteristic getHotelCharacteristic() {
        return hotelCharacteristic;
    }

    public void setHotelCharacteristic(HotelCharacteristic hotelCharacteristic) {
        this.hotelCharacteristic = hotelCharacteristic;
    }

    @Override
    public int compareTo(TouristVoucher o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return "TouristVoucher [ id=" + id + ", type=" + type + ", countryCode=" + countryCode + ", dayCount=" + dayCount + ", transportationType=" + transportation + ", hotelCharacteristic=" + hotelCharacteristic + " ]";
    }
}