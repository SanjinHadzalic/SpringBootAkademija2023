package hr.kingict.akademija2023.springbootakademija2023.impl;

import hr.kingict.akademija2023.springbootakademija2023.services.DashboardService;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceProduction implements DashboardService {
    @Override
    public String getDashboard() {
        return "dashboardPRO.html";
    }
}
