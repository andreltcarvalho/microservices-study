# microservices-study

Study for Microservices using Docker and Kafka

# Kafka

Enter the kafka container with command:

```shell
docker exec -it <containerId> bash
```

### Create Kafka topic

```shell
 kafka-topics --create --topic EXEMPLO_TOPICO --partitions 1 --replication-factor 1 --if-not-exists --bootstrap-server localhost:9092
```

### Check if topic is OK

```shell
docker-compose exec kafka kafka-topics --describe --topic EXEMPLO_TOPICO --bootstrap-server localhost:9092
```

### Send messages to topic on Kafka

```shell
kafka-console-producer --request-required-acks 1 --broker-list kafka:29092 --topic EXEMPLO_TOPICO
```

### Read Kafka topic messages

```shell
kafka-console-consumer --bootstrap-server kafka:29092 --topic EXEMPLO_TOPICO --from-beginning --max-messages 100
```
