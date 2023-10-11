package com.github.stanislavbukaevsky.informationaboutpurchasedtickets.kafka;

/**
 * Сервис-интерфейс с методами для Kafka в приложении.
 * В этом интерфейсе прописана только сигнатура методов без реализации
 */
public interface KafkaReceiverService {
    /**
     * Сигнатура метода для получения сообщений из топика Kafka
     */
    void accept();
}
