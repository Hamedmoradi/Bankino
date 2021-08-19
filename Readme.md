the project structure java 11,postgreSQL,Kafka,springBoot
for start project :

`1.lunch Kafka server`

`sudo systemctl start zookeeper`

`sudo systemctl start kafka`

`sudo systemctl status kafka`

`cd /usr/local/kafka`

`bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic testTopic`

`bin/kafka-console-producer.sh --broker-list localhost:9092 --topic testTopic`

`bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic testTopic --from-beginning --group bankino_group_id`

`2.connect to postge SQL DB`

`requirment for db connection exist in application.properties file in the ptoject`

`3.execute maven`

` mvn clean install`

`4. run application`

http://localhost:8080/swagger-ui.html#/counter-resource-api

for execute project :there is a sample file named counterData in the project,so at the first time you must
send a post request for run kafka producer.

	@FindBy(css="")
	private WebElement webElement;
http://localhost:8080/kafka/publish

