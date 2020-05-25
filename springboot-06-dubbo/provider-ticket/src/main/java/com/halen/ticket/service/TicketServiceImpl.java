package com.halen.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * Created By Halen 2020/5/25 14:56
 */
@Component
@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "Halen";
    }
}
