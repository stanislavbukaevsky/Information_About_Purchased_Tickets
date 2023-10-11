package com.github.stanislavbukaevsky.informationaboutpurchasedtickets.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационный класс для настройки Swagger
 */
@Configuration
@OpenAPIDefinition(info =
@Info(title = "Приложение для покупки транспортных билетов", description = "Web интерфейс для покупки транспортных билетов", contact =
@Contact(name = "Букаевский Станислав", email = "stanislavbukaevsky@yandex.ru"))
)
public class OpenApiConfiguration {
}
