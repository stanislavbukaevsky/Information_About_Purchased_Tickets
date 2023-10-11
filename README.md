# Сервис для получения купленных транспортных билетов

### **Задача**

Разработать микросервис, который принимает данные о купленных билетах из топика Kafka и сохраняет в базу данных.
Это вторая
часть **[основного микросервисного приложения](https://github.com/stanislavbukaevsky/Purchase_Transport_Tickets)**
и работает в связке с ней.

**В проекте реализован следующий функционал:**

- Получение из очереди Kafka данных о купленных билетах и сохранение в отдельную базу данных.

***

## **Функционал**

### В приложении использован следующий функционал:

- Java 17;
- Spring Boot 3.1.4;
- Maven;
- Spring WevFlux;
- Apache Kafka;
- Reactor Kafka;
- Jooq;
- PostgresSQL;
- Liquibase;
- Mapstruct;
- Lombok;
- Swagger-UI.

## **Запуск приложения**

### Для запуска приложения выполните следующие действия

**1. Настройка файла application.properties**

- Для работы приложения вам нужно правильно настроить
  файл **[application.properties](src/main/resources/application.properties)**.
  Открыв этот файл вы увидете множество заглушек, которые нужно описать.
- Создайте в корне проекта файл с названием **.env** (не забудьте символ точки перед названием файла!) и опишите все
  значения
  переменных как это показано ниже

```
SPRING_DATASOURCE_HOST=Локальный хостинг вашего сервера
SPRING_DATASOURCE_PORT=Порт вашего сервера
SPRING_DATASOURCE_DATABASE=Название базы данных
SPRING_DATASOURCE_USERNAME=Имя пользователя базы данных
SPRING_DATASOURCE_PASSWORD=Пароль пользователя базы данных

SPRING_KAFKA_SUBSCRIBE_TOPIC=Название топика для Kafka
KAFKA_BOOTSTRAP_SERVERS_HOST=Локальный хостинг вашего сервера Kafka
KAFKA_BOOTSTRAP_SERVERS_PORT=Порт вашего сервера Kafka

```

**2. Настройка файла pom.xml**

- Откройте файл **[pom.xml](pom.xml)** и найдите в нем следующие строки в теге ```<properties>```

````html

<db.driver>org.postgresql.Driver</db.driver>
<db.url>Полный путь к базе данных (url)</db.url>
<db.username>Имя пользователя базы данных</db.username>
<db.password>Пароль пользователя базы данных</db.password>
````

- Эти поля в тегах нужно заполнить для библиотеки Jooq.

**3. Запуск приложения**

- Настройте и запустите все части
  из **[основного микросервисного приложения](https://github.com/stanislavbukaevsky/Purchase_Transport_Tickets)**.
- Теперь запустите приложение в
  файле [InformationAboutPurchasedTicketsApplication](src/main/java/com/github/stanislavbukaevsky/informationaboutpurchasedtickets/InformationAboutPurchasedTicketsApplication.java)
  .

***

## **Разработка**

### В реализации проекта принимал участие:

- Букаевский Станислав - [ссылка на GitHub](https://github.com/stanislavbukaevsky)