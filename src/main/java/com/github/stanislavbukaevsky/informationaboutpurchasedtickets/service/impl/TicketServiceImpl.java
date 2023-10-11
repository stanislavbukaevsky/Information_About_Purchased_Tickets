package com.github.stanislavbukaevsky.informationaboutpurchasedtickets.service.impl;

import com.github.stanislavbukaevsky.informationaboutpurchasedtickets.dto.BuyingTicketResponseDto;
import com.github.stanislavbukaevsky.informationaboutpurchasedtickets.mapper.TicketMapper;
import com.github.stanislavbukaevsky.informationaboutpurchasedtickets.model.Ticket;
import com.github.stanislavbukaevsky.informationaboutpurchasedtickets.repository.TicketRepository;
import com.github.stanislavbukaevsky.informationaboutpurchasedtickets.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.github.stanislavbukaevsky.informationaboutpurchasedtickets.constant.LoggerTextMessageConstant.SAVE_BUYING_TICKET_MESSAGE_LOGGER_SERVICE;

/**
 * Сервис-класс с бизнес-логикой для купленного билета в приложении.
 * Реализует интерфейс {@link TicketService}
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    /**
     * Реализация метода для сохранения купленного билета взятого из топика основного микросервиса
     *
     * @param buyingTicketResponseDto объект DTO с запросом от пользователя
     */
    @Override
    public void saveBuyingTicket(BuyingTicketResponseDto buyingTicketResponseDto) {
        Ticket ticket = ticketMapper.toBuyingTicketModel(buyingTicketResponseDto);
        ticketRepository.save(ticket);
        log.info(SAVE_BUYING_TICKET_MESSAGE_LOGGER_SERVICE, ticket);
    }
}
