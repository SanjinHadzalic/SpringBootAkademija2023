package hr.kingict.akademija2023.springbootakademija2023.services.impl;

import hr.kingict.akademija2023.springbootakademija2023.services.DashboardService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!prod & !test")
public class DashboardServiceDefault implements DashboardService {
    @Override
    public String getDashboard() {
        return "dashboard";
    }
}
