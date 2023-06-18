package hr.kingict.akademija2023.springbootakademija2023.services;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.referencedata.Locations;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Location;
import hr.kingict.akademija2023.springbootakademija2023.dto.FlightSearchResultDto;
import hr.kingict.akademija2023.springbootakademija2023.mapper.FlightOffersSearchFlightSearchResultDtoMapper;
import hr.kingict.akademija2023.springbootakademija2023.model.FlightSearchEntity;
import hr.kingict.akademija2023.springbootakademija2023.repository.FlightSearchEntityRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class AmadeusService {
    Logger logger = LoggerFactory.getLogger(AmadeusService.class);
    @Autowired
    private FlightOffersSearchFlightSearchResultDtoMapper flightOffersSearchFlightSearchResultDtoMapper;
    @Autowired
    private Amadeus amadeus;
    @Autowired
    private FlightSearchEntityRepository flightSearchEntityRepository;

    public List<Location> searchAirports(String keyword) {
        try {
            Params param = Params.with("subType", Locations.AIRPORT)
                    .and("keyword", keyword);

            return Arrays.asList(amadeus.referenceData.locations
                    .get(param)
            );
        } catch (Exception ex) {
            logger.error("Search airports error", ex);

            return Collections.emptyList();
        }
    }
    @Transactional
    public List<FlightSearchResultDto> searchFlights(String originLocationCode, String destinationLocationCode, LocalDate departureDate, LocalDate returnDate, Integer adults) {
        try {

            FlightSearchEntity flightSearchEntity1 = new FlightSearchEntity();
            flightSearchEntity1.setOriginLocationCode(originLocationCode);
            flightSearchEntity1.setDestinationLocationCode(destinationLocationCode);
            flightSearchEntity1.setDepartureDate(departureDate);
            flightSearchEntity1.setReturnDate(returnDate);
            flightSearchEntity1.setAdults(adults);

            flightSearchEntity1.setDateCreated(LocalDate.now());
            flightSearchEntity1.setUserCreated("Sanjin");

            flightSearchEntityRepository.save(flightSearchEntity1);

            Params params = Params
                    .with("originLocationCode", originLocationCode)
                    .and("destinationLocationCode", destinationLocationCode)
                    .and("departureDate", departureDate.toString())
//                    .and("returnDate", returnDate)
                    .and("adults", adults)
                    .and("nonStop", true)
                    .and("max", 5);
            if (returnDate != null) {
                params.and("returnDate", returnDate.toString());
            }
            List<FlightOfferSearch> flightOfferSearcheList = Arrays.asList(amadeus.shopping.flightOffersSearch.get(params));
            List<FlightSearchResultDto> flightSearchResultDtoList = flightOfferSearcheList.stream()
                    .map(flightOfferSearch -> flightOffersSearchFlightSearchResultDtoMapper.map(flightOfferSearch))
                    .toList();

            return flightSearchResultDtoList;
        } catch (Exception ex) {
            logger.error("Search flight error", ex);
            return Collections.emptyList();
        }
    }
}
