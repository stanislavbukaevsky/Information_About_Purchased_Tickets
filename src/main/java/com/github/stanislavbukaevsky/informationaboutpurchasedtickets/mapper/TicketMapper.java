package com.github.stanislavbukaevsky.informationaboutpurchasedtickets.mapper;

import com.github.stanislavbukaevsky.informationaboutpurchasedtickets.dto.BuyingTicketResponseDto;
import com.github.stanislavbukaevsky.informationaboutpurchasedtickets.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Маппер-интерфейс, который преобразует информацию о купленном билете в DTO
 */
@Mapper
public interface TicketMapper {
    /**
     * Этот метод преобразует полученные поля из DTO в модель, для получения информации о купленном билете. <br>
     * Используется аннотация {@link Mapping} для игнорирования маппинга полей
     *
     * @param buyingTicketResponseDto DTO запроса с информацией о купленном билете
     * @return Возвращает сформированную модель с информацией о купленном билете
     */
    @Mapping(ignore = true, target = "id")
    Ticket toBuyingTicketModel(BuyingTicketResponseDto buyingTicketResponseDto);
}
