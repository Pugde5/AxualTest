package com.example.demo;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;

import io.axual.client.AxualClient;
import io.axual.client.config.DeliveryStrategy;
import io.axual.client.config.SpecificAvroConsumerConfig;
import io.axual.client.example.schema.Application;
import io.axual.client.example.schema.ApplicationLogEvent;
import io.axual.client.proxy.generic.registry.ProxyChain;
import io.axual.client.proxy.generic.registry.ProxyTypeRegistry;
import io.axual.common.config.ClientConfig;
import io.axual.common.config.PasswordConfig;
import io.axual.common.config.SslConfig;


public class MyConsumer {
    public void consume() throws InterruptedException {
        ClientConfig config = ClientConfig.newBuilder()
                .setApplicationId("io.axual.example.client.avro.consumer")
                .setApplicationVersion("0.0.1")
                .setEndpoint("https://epo82e30ee36-75624457-discoveryapi.axual.cloud")
                .setTenant("epo82e30ee36")
                .setEnvironment("default")
                .setSslConfig(
                        SslConfig.newBuilder()
                                .setEnableHostnameVerification(false)
                                .setKeystoreLocation("C:\\axiom\\epo82e30ee36-app-keystores\\application-two\\epo82e30ee36-application-two.keystore.jks") // Absolute path to the application keystore
                                .setKeystorePassword(new PasswordConfig("password"))
                                .setKeyPassword(new PasswordConfig("password"))
                                .setTruststoreLocation("C:\\axiom\\epo82e30ee36.truststore.jks") // Absolute path to the application truststore
                                .setTruststorePassword(new PasswordConfig("password"))
                                .build()
                )
                .build();
        SpecificAvroConsumerConfig<Application, ApplicationLogEvent> specificAvroConsumerConfig =
                SpecificAvroConsumerConfig.<Application, ApplicationLogEvent>builder()
                    // We want to make sure we get all the messages at least once. On a Kafka level, this means
                    // that the offsets are committed once the message have been processed bey the application.
                    .setDeliveryStrategy(DeliveryStrategy.AT_LEAST_ONCE)
                    .setStream("TestOne")
                    .setProxyChain(ProxyChain.newBuilder()
                            .append(ProxyTypeRegistry.SWITCHING_PROXY_ID)
                            .append(ProxyTypeRegistry.RESOLVING_PROXY_ID)
                            .append(ProxyTypeRegistry.LINEAGE_PROXY_ID)
                            .append(ProxyTypeRegistry.HEADER_PROXY_ID)
                            .build())
                    .build();
        try (final AxualClient axualClient = new AxualClient(config);
                final LogEventSpecificConsumer consumer = new LogEventSpecificConsumer(axualClient, specificAvroConsumerConfig)) {
               // We want to prevent that the main thread exits the try-with-resources block, since that
               // will cause the consumer and axualClient to close, ending the user thread that started
               // the consumption. So in this example we make the main thread sleep for a second as long
               // as the consumer is still consuming.
               while (consumer.isConsuming()) {
                   Thread.sleep(1000);
               }
           }
    }
}
