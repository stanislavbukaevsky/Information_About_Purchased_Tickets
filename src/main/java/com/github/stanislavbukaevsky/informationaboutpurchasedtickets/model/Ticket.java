package com.github.stanislavbukaevsky.informationaboutpurchasedtickets.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Модель представления купленного билета
 */
@Data
@Schema(description = "Модель купленного транспортного билета пользователем")
public class Ticket {
    @Schema(description = "Уникальный идентификатор транспортного билета")
    private Long id;
    @Schema(description = "Пункт отправления покупателя")
    private String departurePoint;
    @Schema(description = "Пункт назначения покупателя")
    private String destination;
    @Schema(description = "Продолжительность поездки покупателя")
    private Integer durationInMinutes;
    @Schema(description = "Название компании перевозчика")
    private String companyName;
    @Schema(description = "Номер телефона компании перевозчика")
    private String phoneNumber;
    @Schema(description = "Дата и время отправления")
    private LocalDateTime dateTimeDeparture;
    @Schema(description = "Посадочное места")
    private Integer seatNumber;
    @Schema(description = "Цена билета")
    private Integer price;
    @Schema(description = "Дата и время покупки транспортного билета")
    private LocalDateTime dateTimeTicketIssuance;
    @Schema(description = "Статус билета")
    private String ticketStatus;
    @Schema(description = "Логин пользователя")
    private String login;
    @Schema(description = "Имя пользователя")
    private String firstName;
    @Schema(description = "Отчество пользователя")
    private String middleName;
    @Schema(description = "Фамилия пользователя")
    private String lastName;
    @Schema(description = "Роль пользователя")
    private String role;
}
