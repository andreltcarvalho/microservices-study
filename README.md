# Estudo de Microsserviços com Kafka e MongoDB



# Kafka

Comando para entrar no container do Kafka

```shell
docker exec -it <containerId> bash
```

### Criar tópico no Kafka

```shell
 kafka-topics --create --topic MICROSERVICES_TOPIC --partitions 1 --replication-factor 1 --if-not-exists --bootstrap-server localhost:9092
```

### Checar se o tópico está OK

```shell
docker-compose exec kafka kafka-topics --describe --topic MICROSERVICES_TOPIC --bootstrap-server localhost:9092
```

### Enviar mensagens para o tópico

```shell
kafka-console-producer --request-required-acks 1 --broker-list kafka:29092 --topic MICROSERVICES_TOPIC
```

### Ler mensagens do tópico

```shell
kafka-console-consumer --bootstrap-server kafka:29092 --topic MICROSERVICES_TOPIC --from-beginning --max-messages 100
```
