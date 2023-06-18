package hr.kingict.akademija2023.springbootakademija2023.controller;

import com.amadeus.referencedata.Locations;
import com.amadeus.resources.Location;
import hr.kingict.akademija2023.springbootakademija2023.dto.LocationDto;
import hr.kingict.akademija2023.springbootakademija2023.mapper.LocationLocationDtoMapper;
import hr.kingict.akademija2023.springbootakademija2023.services.AmadeusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/flight-search")
public class FlightSearchController {
    @Autowired
    private AmadeusService amadeusService;
    @Autowired
    private LocationLocationDtoMapper locationLocationDtoMapper;

    @GetMapping(value = "/airports/{keyword}")
    public ResponseEntity<List<LocationDto>> searchAirports(@PathVariable String keyword) {

        List<Location> locationList = amadeusService.searchAirports(keyword);
        List<LocationDto> locationDtoList = locationList.stream()
                .map(location -> locationLocationDtoMapper.map(location))
                .toList();

        return ResponseEntity
                .ok()
                .body(locationDtoList);
    }
}
