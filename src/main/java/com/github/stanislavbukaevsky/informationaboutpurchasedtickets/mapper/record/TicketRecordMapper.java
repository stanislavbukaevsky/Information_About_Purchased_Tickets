package com.github.stanislavbukaevsky.informationaboutpurchasedtickets.mapper.record;

import com.github.stanislavbukaevsky.informationaboutpurchasedtickets.model.Ticket;
import com.github.stanislavbukaevsky.informationaboutpurchasedtickets.model.tables.Tickets;
import com.github.stanislavbukaevsky.informationaboutpurchasedtickets.model.tables.records.TicketsRecord;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.RecordUnmapper;
import org.jooq.exception.MappingException;
import org.springframework.stereotype.Component;

/**
 * Класс-маппер, который преобразует информацию о купленном билете в сущность. <br>
 * Этот класс расширяет интерфейс {@link RecordUnmapper}. Параметры: <br>
 * {@link Ticket} - модель билета <br>
 * {@link TicketsRecord} - сущность билета
 */
@Component
@RequiredArgsConstructor
public class TicketRecordMapper implements RecordUnmapper<Ticket, TicketsRecord> {
    private final DSLContext dsl;

    /**
     * Этот метод преобразует модель купленного билета в сущность
     *
     * @param ticket модель билета
     * @return Возвращает сформированную сущность купленного билета
     * @throws MappingException исключение, возникающее при сбое запросов связанной службы сопоставления
     */
    @Override
    public @NotNull TicketsRecord unmap(Ticket ticket) throws MappingException {
        TicketsRecord ticketsRecord = dsl.newRecord(Tickets.TICKETS, ticket);
        ticketsRecord.setDeparturePoint(ticket.getDeparturePoint());
        ticketsRecord.setDestination(ticket.getDestination());
        ticketsRecord.setDurationInMinutes(ticket.getDurationInMinutes());
        ticketsRecord.setCompanyName(ticket.getCompanyName());
        ticketsRecord.setPhoneNumber(ticket.getPhoneNumber());
        ticketsRecord.setDateTimeDeparture(ticket.getDateTimeDeparture());
        ticketsRecord.setSeatNumber(ticket.getSeatNumber());
        ticketsRecord.setPrice(ticket.getPrice());
        ticketsRecord.setDateTimeTicketIssuance(ticket.getDateTimeTicketIssuance());
        ticketsRecord.setTicketStatus(ticket.getTicketStatus());
        ticketsRecord.setLogin(ticket.getLogin());
        ticketsRecord.setFirstName(ticket.getFirstName());
        ticketsRecord.setMiddleName(ticket.getMiddleName());
        ticketsRecord.setLastName(ticket.getLastName());
        ticketsRecord.setRole(ticket.getRole());
        return ticketsRecord;
    }
}
