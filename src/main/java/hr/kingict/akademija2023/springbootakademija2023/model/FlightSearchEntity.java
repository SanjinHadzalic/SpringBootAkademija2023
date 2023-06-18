package hr.kingict.akademija2023.springbootakademija2023.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pretrage_letova")
public class FlightSearchEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
    @Column(name = "datum_kreiranja")
    private LocalDate dateCreated;
    @Column(name = "korisnik_kreiranja")
    private String userCreated;
    @Column(name = "datum_azuriranja")
    private LocalDate dateUpdated;
    @Column(name = "korisnik_azuriranja")
    private String userUpdated;
    @OneToMany(mappedBy = "flightSearchEntity")
    private List<FlightSearchResultEntity> flightSearchResultEntityList;

    public List<FlightSearchResultEntity> getFlightSearchResultEntityList() {
        return flightSearchResultEntityList;
    }

    public void setFlightSearchResultEntityList(List<FlightSearchResultEntity> flightSearchResultEntityList) {
        this.flightSearchResultEntityList = flightSearchResultEntityList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getUserUpdated() {
        return userUpdated;
    }

    public void setUserUpdated(String userUpdated) {
        this.userUpdated = userUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightSearchEntity that = (FlightSearchEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
