package hr.kingict.akademija2023.springbootakademija2023.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pretrage_letova")
public class FlightSearchEntity extends BasicEntity{

    @Column(name = "sifra_polazista")
    private String originLocationCode;
    @Column(name = "sifra_odredista")
    private String destinationLocationCode;
    @Column(name = "datum_odlaska")
    private LocalDate departureDate;
    @Column(name = "datum_povratka")
    private LocalDate returnDate;
    @Column(name = "broj_odraslih")
    private Integer adults;
    @OneToMany(mappedBy = "flightSearchEntity")
    private List<FlightSearchResultEntity> flightSearchResultEntityList;

    public List<FlightSearchResultEntity> getFlightSearchResultEntityList() {
        return flightSearchResultEntityList;
    }

    public void setFlightSearchResultEntityList(List<FlightSearchResultEntity> flightSearchResultEntityList) {
        this.flightSearchResultEntityList = flightSearchResultEntityList;
    }


    public String getOriginLocationCode() {
        return originLocationCode;
    }

    public void setOriginLocationCode(String originLocationCode) {
        this.originLocationCode = originLocationCode;
    }

    public String getDestinationLocationCode() {
        return destinationLocationCode;
    }

    public void setDestinationLocationCode(String destinationLocationCode) {
        this.destinationLocationCode = destinationLocationCode;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }


}
