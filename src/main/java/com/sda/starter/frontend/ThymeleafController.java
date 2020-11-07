package com.sda.starter.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    private int licznik = 0;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("powitanie", "Siemanko! Jesteś " + (++licznik) + " odwiedzającym moją stronę!");
        return "index";
    }
}
