package hr.kingict.akademija2023.springbootakademija2023.impl;

import hr.kingict.akademija2023.springbootakademija2023.services.DashboardService;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceTest implements DashboardService {
    @Override
    public String getDashboard() {
        return "dashboardTest.html";
    }
}
