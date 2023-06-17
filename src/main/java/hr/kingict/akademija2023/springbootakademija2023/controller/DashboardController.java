package hr.kingict.akademija2023.springbootakademija2023.controller;

import hr.kingict.akademija2023.springbootakademija2023.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

    @GetMapping(value = "/dashboard")
    public String getDashboard(){
        return dashboardService.getDashboard();
    }
}
