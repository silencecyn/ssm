package com.example.ssm.controller;

import com.example.ssm.entity.Country;
import com.example.ssm.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;

    @RequestMapping("/")
    public String getCountryId(Model model) throws IOException {
        model.addAttribute("ids", countryService.getAllCountryId());
        return "index";
    }

    @RequestMapping("/queryCountryById")
    public String queryCountryById(@RequestParam("id") Long id, Model model) throws IOException {
        Country country = countryService.queryCountryById(id);
        model.addAttribute("country", country);
        return "show_country";
    }

    @RequestMapping("/add_country_page")
    public String addCountryPage(Country country) {
        return "add_country";
    }

    @RequestMapping("/addCountry")
    public String addCountry(@ModelAttribute @Valid Country country, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "add_country";
        countryService.addCountry(country);
        return "redirect:/";
    }

    @RequestMapping("/selectAll")
    public String showAllCountry(Model model, Country country) {
        model.addAttribute("allCountry", countryService.selectAll());
        return "show_country_all";
    }

    @RequestMapping("/queryCountryByCondition")
    public String queryCountryByCondition(@ModelAttribute Country country, Model model, RedirectAttributes ra) {
        ra.addFlashAttribute("tempCountry", countryService.queryCountryByCondition(country));
        return "redirect:selectAll";
    }

    @RequestMapping("/updateCountryById")
    public String updateCountryById(@ModelAttribute Country country) {
        countryService.updateCountry(country);
        return "redirect:selectAll";
    }

    @RequestMapping("/showByPageNo")
    public String showCountryByPage(@RequestParam("pageNo") int pageNo,Model model ){
        model.addAttribute("countries",countryService.showCountryByPage(pageNo));
        return "show_by_page";
    }
}
