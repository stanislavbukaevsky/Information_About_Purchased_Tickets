package com.github.stanislavbukaevsky.informationaboutpurchasedtickets.parser;

import com.google.gson.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

import static com.github.stanislavbukaevsky.informationaboutpurchasedtickets.constant.LoggerTextMessageConstant.DESERIALIZE_MESSAGE_LOGGER_SERVICE;

/**
 * Сервис-класс с бизнес-логикой для десериализации даты и времени из JSON в объект LocalDateTime.
 * Реализует интерфейс {@link JsonDeserializer}
 */
@Slf4j
@Component
public class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {

    /**
     * Этот метод преобразует дату и время из JSON в объект LocalDateTime
     *
     * @param jsonElement                объект JSON
     * @param type                       интерфейст типа объекта
     * @param jsonDeserializationContext контекст для десериализации
     * @return Возвращает сформированный объект LocalDateTime
     * @throws JsonParseException исключение связанное с проблемами синтаксического анализа
     */
    @Override
    public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        int year = jsonArray.get(0).getAsInt();
        int month = jsonArray.get(1).getAsInt();
        int day = jsonArray.get(2).getAsInt();
        int hour = jsonArray.get(3).getAsInt();
        int minute = jsonArray.get(4).getAsInt();

        log.info(DESERIALIZE_MESSAGE_LOGGER_SERVICE);
        return LocalDateTime.of(year, month, day, hour, minute);
    }
}
