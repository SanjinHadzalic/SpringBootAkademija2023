package hr.kingict.akademija2023.springbootakademija2023.services;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referencedata.Locations;
import com.amadeus.resources.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class AmadeusService {
    Logger logger = LoggerFactory.getLogger(AmadeusService.class);
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
}
