package com.halen.providerticket.controller;

import com.halen.providerticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Halen 2020/5/25 17:04
 */
@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/ticket")
    public String getTicket() {
        return ticketService.getTicket();
    }

}
