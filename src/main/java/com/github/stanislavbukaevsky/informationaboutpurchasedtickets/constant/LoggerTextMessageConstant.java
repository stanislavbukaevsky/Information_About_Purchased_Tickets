package com.github.stanislavbukaevsky.informationaboutpurchasedtickets.constant;

/**
 * Этот класс содержит текстовые константные переменные для всех логов в приложении
 */
public class LoggerTextMessageConstant {
    // Логи для методов в конфигурационных файлах
    public static final String ADD_ASSIGN_LISTENER_MESSAGE_LOGGER_CONFIGURATION = "Добавлен новый слушатель для получения новых сообщений. Раздел получения сообщений: {}";
    public static final String ADD_REVOKE_LISTENER_MESSAGE_LOGGER_CONFIGURATION = "Слушатель перестал принимать новые сообщения. Раздел сообщений: {}";

    // Логи для методов в сервисах
    public static final String DESERIALIZE_MESSAGE_LOGGER_SERVICE = "Вызван метод для десериализации даты и времени из JSON в объект LocalDateTime в сервисе";
    public static final String KAFKA_ACCEPT_MESSAGE_LOGGER_SERVICE = "Вызван метод для получения сообщений из топика Kafka в сервисе. Получено новое сообщение из топика: {}";
    public static final String SAVE_BUYING_TICKET_MESSAGE_LOGGER_SERVICE = "Вызван метод для сохранения купленного билета взятого из топика основного микросервиса в сервисе. Купленный билет пользователем: {}";

    // Логи для методов в репозиториях
    public static final String SAVE_TICKET_MESSAGE_LOGGER_REPOSITORY = "Вызван метод сохранения нового билета в базу данных. Запрос от пользователя: {}";
}
