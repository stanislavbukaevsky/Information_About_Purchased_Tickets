package com.github.stanislavbukaevsky.informationaboutpurchasedtickets.kafka.impl;

import com.github.stanislavbukaevsky.informationaboutpurchasedtickets.dto.BuyingTicketResponseDto;
import com.github.stanislavbukaevsky.informationaboutpurchasedtickets.kafka.KafkaReceiverService;
import com.github.stanislavbukaevsky.informationaboutpurchasedtickets.parser.LocalDateTimeDeserializer;
import com.github.stanislavbukaevsky.informationaboutpurchasedtickets.service.TicketService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;

import java.time.LocalDateTime;

import static com.github.stanislavbukaevsky.informationaboutpurchasedtickets.constant.LoggerTextMessageConstant.KAFKA_ACCEPT_MESSAGE_LOGGER_SERVICE;

/**
 * Сервис-класс с бизнес-логикой для Kafka в приложении.
 * Реализует интерфейс {@link KafkaReceiverService}
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaReceiverServiceImpl implements KafkaReceiverService {
    private final LocalDateTimeDeserializer localDateTimeDeserializer;
    private final KafkaReceiver<String, Object> kafkaReceiver;
    private final TicketService ticketService;

    /**
     * Этот метод запускается сразу же после загрузки всего приложения
     */
    @PostConstruct
    public void init() {
        accept();
    }

    /**
     * Реализация метода для получения сообщений из топика Kafka
     */
    @Override
    public void accept() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, localDateTimeDeserializer)
                .create();

        kafkaReceiver.receive()
                .subscribe(r -> {
                    log.info(KAFKA_ACCEPT_MESSAGE_LOGGER_SERVICE, r.value());
                    BuyingTicketResponseDto buyingTicketResponseDto = gson
                            .fromJson(r.value().toString(), BuyingTicketResponseDto.class);
                    ticketService.saveBuyingTicket(buyingTicketResponseDto);
                    r.receiverOffset().acknowledge();
                });
    }
}
