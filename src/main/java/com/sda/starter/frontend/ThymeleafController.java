package com.sda.starter.frontend;

import com.sda.starter.frontend.form.GuestbookForm;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
public class ThymeleafController {

    private int licznik = 0;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("powitanie", "Siemanko! Jesteś " + (++licznik) + " odwiedzającym moją stronę!");
        model.addAttribute("guestbookForm", new GuestbookForm());
        return "index";
    }

    @PostMapping("/")
    public String postIndex(Model model, GuestbookForm guestbookForm) {
        log.info("Nowy wpis do księgi gości: " + guestbookForm);
        return "redirect:/";
    }
}
