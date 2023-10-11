package com.github.stanislavbukaevsky.informationaboutpurchasedtickets.repository;

import com.github.stanislavbukaevsky.informationaboutpurchasedtickets.mapper.record.TicketRecordMapper;
import com.github.stanislavbukaevsky.informationaboutpurchasedtickets.model.Ticket;
import com.github.stanislavbukaevsky.informationaboutpurchasedtickets.model.tables.Tickets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.springframework.stereotype.Repository;

import static com.github.stanislavbukaevsky.informationaboutpurchasedtickets.constant.ExceptionTextMessageConstant.DATA_ACCESS_EXCEPTION_MESSAGE_REPOSITORY;
import static com.github.stanislavbukaevsky.informationaboutpurchasedtickets.constant.LoggerTextMessageConstant.SAVE_TICKET_MESSAGE_LOGGER_REPOSITORY;

/**
 * Класс-репозиторий, для связи с базой данных и вытягивания из нее информации о купленном билете
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class TicketRepository {
    private final DSLContext dsl;
    private final TicketRecordMapper ticketRecordMapper;

    /**
     * Этот метод сохраняет информацию о купленном билете в базу данных
     *
     * @param ticket модель билета
     * @return Возвращает модель билета
     */
    public Ticket save(Ticket ticket) {
        log.info(SAVE_TICKET_MESSAGE_LOGGER_REPOSITORY, ticket);
        return dsl.insertInto(Tickets.TICKETS)
                .set(ticketRecordMapper.unmap(ticket))
                .returning()
                .fetchOptional()
                .orElseThrow(() -> new DataAccessException(DATA_ACCESS_EXCEPTION_MESSAGE_REPOSITORY + ticket))
                .into(Ticket.class);
    }
}
