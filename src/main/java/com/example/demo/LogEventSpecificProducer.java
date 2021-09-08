package com.example.demo;

import java.util.Map;
import java.util.concurrent.Future;

import io.axual.client.AxualClient;
import io.axual.client.config.SpecificAvroProducerConfig;
import io.axual.client.example.schema.Application;
import io.axual.client.example.schema.ApplicationLogEvent;
import io.axual.client.example.schema.ApplicationLogLevel;
import io.axual.client.producer.ProducedMessage;
import io.axual.client.producer.Producer;
import io.axual.client.producer.ProducerMessage;

public class LogEventSpecificProducer implements AutoCloseable {
    private final Producer<Application, ApplicationLogEvent> producer;
    private final Application application;

    public LogEventSpecificProducer(
            final AxualClient axualClient
            , final SpecificAvroProducerConfig<Application, ApplicationLogEvent> producerConfig
            , final String applicationName
            , final String applicationVersion
            , final String applicationOwner) {
        producer = axualClient.buildProducer(producerConfig);
        this.application = Application.newBuilder()
                .setName(applicationName)
                .setVersion(applicationVersion)
                .setOwner(applicationOwner)
                .build();
    }

    public Future<ProducedMessage<Application, ApplicationLogEvent>> produce(
            final String applicationName,
            final long timestamp,
            final ApplicationLogLevel logLevel,
            final CharSequence logMessage,
            final Map<CharSequence, CharSequence> context) {
        Application key = Application.newBuilder()
                .setName(applicationName)
                .setVersion("1.9.9")
                .setOwner("none")
                .build();
        ApplicationLogEvent value = ApplicationLogEvent.newBuilder()
                .setTimestamp(timestamp)
                .setSource(this.application)
                .setLevel(logLevel)
                .setMessage(logMessage)
                .setContext(context)
                .build();

        ProducerMessage<Application, ApplicationLogEvent> message = ProducerMessage.<Application, ApplicationLogEvent>newBuilder()
                .setStream("TestOne")
                .setKey(key)
                .setValue(value)
                .build();
        Future<ProducedMessage<Application, ApplicationLogEvent>> result = producer.produce(message);
        return result;
    }

    @Override
    public void close() {
        producer.close();
    }
}