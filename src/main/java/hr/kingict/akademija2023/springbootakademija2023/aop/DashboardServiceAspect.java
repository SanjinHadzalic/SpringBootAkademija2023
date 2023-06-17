package hr.kingict.akademija2023.springbootakademija2023.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class DashboardServiceAspect {

    @Before("execution(* hr.kingict.akademija2023.springbootakademija2023.services.DashboardService.getDashboard(..))")
    public void beforeDashboardServiceGetDashboard(){

    }
}
