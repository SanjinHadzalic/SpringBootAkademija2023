package hr.kingict.akademija2023.springbootakademija2023.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
@Entity
@Table(name = "rezultati_pretrage")
public class FlightSearchResultEntity {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "polazak_sifra_aerodroma_polazak")
    private String outboundDepartureAirport;
    @Column(name = "polazak_sifra_aerodroma_odrediste")
    private String outboundArrivalAirport;
    @Column(name = "polazak_datum_polaska")
    private String outboundDepartureDate;
    @Column(name = "polazak_datum_dolaska")
    private String outboundArrivalDate;
    @Column(name = "povratak_sifra_aerodroma_polazak")
    private String inboundDepartureAirport;
    @Column(name = "povratak_sifra_aerodroma_odrediste")
    private String inboundArrivalAirport;
    @Column(name = "povratak_datum_polaska")
    private String inboundDepartureDate;
    @Column(name = "povratak_datum_dolaska")
    private String inboundArrivalDate;
    @Column(name = "prijevoznik")
    private String carrier;
    @Column(name = "cijena")
    private String price;
    @Column(name = "datum_kreiranja")
    private LocalDate dateCreated;
    @Column(name = "korisnik_kreiranja")
    private String userCreated;
    @Column(name = "datum_azuriranja")
    private LocalDate dateUpdated;
    @Column(name = "korisnik_azuriranja")
    private String userUpdated;

    @ManyToOne
    @JoinColumn(name = "id_pretrage")
    private FlightSearchEntity flightSearchEntity;

    public FlightSearchEntity getFlightSearchEntity() {
        return flightSearchEntity;
    }

    public void setFlightSearchEntity(FlightSearchEntity flightSearchEntity) {
        this.flightSearchEntity = flightSearchEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOutboundDepartureAirport() {
        return outboundDepartureAirport;
    }

    public void setOutboundDepartureAirport(String outboundDepartureAirport) {
        this.outboundDepartureAirport = outboundDepartureAirport;
    }

    public String getOutboundArrivalAirport() {
        return outboundArrivalAirport;
    }

    public void setOutboundArrivalAirport(String outboundArrivalAirport) {
        this.outboundArrivalAirport = outboundArrivalAirport;
    }

    public String getOutboundDepartureDate() {
        return outboundDepartureDate;
    }

    public void setOutboundDepartureDate(String outboundDepartureDate) {
        this.outboundDepartureDate = outboundDepartureDate;
    }

    public String getOutboundArrivalDate() {
        return outboundArrivalDate;
    }

    public void setOutboundArrivalDate(String outboundArrivalDate) {
        this.outboundArrivalDate = outboundArrivalDate;
    }

    public String getInboundDepartureAirport() {
        return inboundDepartureAirport;
    }

    public void setInboundDepartureAirport(String inboundDepartureAirport) {
        this.inboundDepartureAirport = inboundDepartureAirport;
    }

    public String getInboundArrivalAirport() {
        return inboundArrivalAirport;
    }

    public void setInboundArrivalAirport(String inboundArrivalAirport) {
        this.inboundArrivalAirport = inboundArrivalAirport;
    }

    public String getInboundDepartureDate() {
        return inboundDepartureDate;
    }

    public void setInboundDepartureDate(String inboundDepartureDate) {
        this.inboundDepartureDate = inboundDepartureDate;
    }

    public String getInboundArrivalDate() {
        return inboundArrivalDate;
    }

    public void setInboundArrivalDate(String inboundArrivalDate) {
        this.inboundArrivalDate = inboundArrivalDate;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
        FlightSearchResultEntity that = (FlightSearchResultEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
