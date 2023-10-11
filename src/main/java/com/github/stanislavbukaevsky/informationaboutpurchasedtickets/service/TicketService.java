package com.github.stanislavbukaevsky.informationaboutpurchasedtickets.service;

import com.github.stanislavbukaevsky.informationaboutpurchasedtickets.dto.BuyingTicketResponseDto;

/**
 * Сервис-интерфейс с методами для купленного билета в приложении.
 * В этом интерфейсе прописана только сигнатура методов без реализации
 */
public interface TicketService {
    /**
     * Сигнатура метода для сохранения купленного билета взятого из топика основного микросервиса
     *
     * @param buyingTicketResponseDto объект DTO с запросом от пользователя
     */
    void saveBuyingTicket(BuyingTicketResponseDto buyingTicketResponseDto);
}
