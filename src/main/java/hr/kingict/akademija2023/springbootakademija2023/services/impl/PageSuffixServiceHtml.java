package hr.kingict.akademija2023.springbootakademija2023.services.impl;

import hr.kingict.akademija2023.springbootakademija2023.services.PageSuffixService;
import org.springframework.stereotype.Service;

@Service("html")
public class PageSuffixServiceHtml implements PageSuffixService {
    @Override
    public String getSuffix() {
        return "html";
    }
}
