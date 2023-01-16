package com.example.websitetest.company;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/company")
public class CompanyInfoController {
    private final CompanyService companyService;

    public CompanyInfoController(CompanyService companyService) {
        this.companyService = companyService;
    }
//
//    @GetMapping()
//    public String getInfo(String id) {
//        return "company";
//    }

    @GetMapping("/companyInfo")
    public ModelAndView getInfo(String id) {
        ModelAndView model = new ModelAndView();

        model.setViewName("company");
        model.addObject("list", companyService.getAllAbSamSung());
        return model;
    }
}
