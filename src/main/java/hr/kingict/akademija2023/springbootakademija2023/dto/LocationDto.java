package hr.kingict.akademija2023.springbootakademija2023.dto;

public class LocationDto {
    private String iataCode;
    private String name;

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
