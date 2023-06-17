package hr.kingict.akademija2023.springbootakademija2023.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DashboardServiceAspect {

    Logger logger = LoggerFactory.getLogger(DashboardServiceAspect.class);

    @Before("execution(* hr.kingict.akademija2023.springbootakademija2023.services.DashboardService.getDashboard(..))")
    public void beforeDashboardServiceGetDashboard(JoinPoint joinPoint) {

        logger.error("Before dashboard service get dashboard: " + joinPoint.getTarget().getClass().getSimpleName());
    }
}
