package com.example.demo;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.axual.client.AxualClient;
import io.axual.client.config.SpecificAvroConsumerConfig;
import io.axual.client.consumer.Consumer;
import io.axual.client.consumer.ConsumerMessage;
import io.axual.client.consumer.Processor;
import io.axual.client.example.schema.Application;
import io.axual.client.example.schema.ApplicationLogEvent;

public class LogEventSpecificConsumer implements Processor<Application, ApplicationLogEvent>, AutoCloseable {
    
    public static final Logger LOG = LoggerFactory.getLogger(LogEventSpecificConsumer.class);
    private final Consumer<Application, ApplicationLogEvent> consumer;
    private final LinkedList<ConsumerMessage<Application, ApplicationLogEvent>> received = new LinkedList<>();

    public LogEventSpecificConsumer(
            final AxualClient axualClient
            , final SpecificAvroConsumerConfig<Application
            , ApplicationLogEvent> consumerConfig) {
        this.consumer = axualClient.buildConsumer(consumerConfig, this);
        // This will start a user thread that does the actual consumption and processing of messages
        this.consumer.startConsuming();
    }

    // This method is used to process the message.
    @Override
    public void processMessage(ConsumerMessage<Application, ApplicationLogEvent> msg) {

        LOG.info("Received message on topic {} partition {} offset {} key {} value {}", msg.getSystem(), msg.getPartition(), msg.getOffset(), msg.getKey(), msg.getValue());
        received.add(msg);
    }

    public LinkedList<ConsumerMessage<Application, ApplicationLogEvent>> getReceived() {
        return received;
    }

    @Override
    public void close() {
        this.consumer.stopConsuming();
    }

    public boolean isConsuming() {
        return this.consumer.isConsuming();
    }
}
