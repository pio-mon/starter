package com.sda.starter.frontend;

import com.sda.starter.frontend.form.GuestbookForm;
import com.sda.starter.services.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ThymeleafController {
    private final GuestbookService guestbookService;

    private int licznik = 0;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("powitanie", "Siemanko! Jesteś " + (++licznik) + " odwiedzającym moją stronę!");
        model.addAttribute("guestbookForm", new GuestbookForm());
        model.addAttribute("guestbookEntries", guestbookService.getTopGuestbookEntries());
        return "index";
    }

    @PostMapping("/")
    public String postIndex(Model model, GuestbookForm guestbookForm) {
        log.info("Nowy wpis do księgi gości: " + guestbookForm);
        guestbookService.saveGuestbookEntry(guestbookForm.getName(),
                guestbookForm.getEntry());
        return "redirect:/";
    }
}
