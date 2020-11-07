package com.sda.starter.services;

import com.sda.starter.dtos.GuestbookEntryDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class GuestbookService {

    private List<GuestbookEntryDTO> entries = new ArrayList<>();

    public void saveGuestbookEntry(String name, String text) {
        final GuestbookEntryDTO dto = new GuestbookEntryDTO(name, text, LocalDateTime.now());
        entries.add(dto);
    }

    public List<GuestbookEntryDTO> getTopGuestbookEntries() {
        return entries.subList(Math.max(0, entries.size() - 3), entries.size());
    }
}
