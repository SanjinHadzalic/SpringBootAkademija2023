package hr.kingict.akademija2023.springbootakademija2023.services.impl;

import hr.kingict.akademija2023.springbootakademija2023.services.DashboardService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@Profile("prod")
public class DashboardServiceProduction implements DashboardService {
    @Override
    public String getDashboard() {
        return "dashboardPRO.html";
    }
}
