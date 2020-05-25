package com.halen.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.halen.ticket.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * Created By Halen 2020/5/25 14:59
 */

@Service
public class UserService {

    @Reference
    TicketService ticketService;

    public void hello() {
        String ticket = ticketService.getTicket();
        System.out.println("买到票了："+ticket);
    }

}
