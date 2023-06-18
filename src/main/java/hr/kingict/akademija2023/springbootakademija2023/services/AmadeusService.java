package hr.kingict.akademija2023.springbootakademija2023.services;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.referencedata.Locations;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Location;
import hr.kingict.akademija2023.springbootakademija2023.dto.FlightSearchResultDto;
import hr.kingict.akademija2023.springbootakademija2023.mapper.FlightOffersSearchFlightSearchResultDtoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AmadeusService {
    Logger logger = LoggerFactory.getLogger(AmadeusService.class);
    @Autowired
    private FlightOffersSearchFlightSearchResultDtoMapper flightOffersSearchFlightSearchResultDtoMapper;
    @Autowired
    private Amadeus amadeus;

    public List<Location> searchAirports(String keyword) {
        try {
            Params param = Params.with("subType", Locations.AIRPORT)
                    .and("keyword",keyword);

            return Arrays.asList(amadeus.referenceData.locations
                    .get(param)
            );
        } catch (Exception ex) {
            logger.error("Search airports error", ex);

            return Collections.emptyList();
        }
    }
    public List<FlightSearchResultDto> searchFlights(String originLocationCode, String destinationLocationCode, String departureDate, String returnDate, String adults ) {
        try {
            Params params = Params
                    .with("originLocationCode", originLocationCode)
                    .and("destinationLocationCode", destinationLocationCode)
                    .and("departureDate", departureDate)
                    .and("returnDate", returnDate)
                    .and("adults", adults);

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
