package com.example.demo;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import io.axual.client.AxualClient;
import io.axual.client.config.DeliveryStrategy;
import io.axual.client.config.OrderingStrategy;
import io.axual.client.config.SpecificAvroProducerConfig;
import io.axual.client.example.schema.Application;
import io.axual.client.example.schema.ApplicationLogEvent;
import io.axual.client.example.schema.ApplicationLogLevel;
import io.axual.client.producer.ProducedMessage;
import io.axual.client.proxy.generic.registry.ProxyChain;
import io.axual.client.proxy.generic.registry.ProxyTypeRegistry;
import io.axual.common.config.ClientConfig;
import io.axual.common.config.PasswordConfig;
import io.axual.common.config.SslConfig;

public class MyProducer {
  @Autowired private Processor processor;
  
  private static int counter = 0;

  public void produceApplication() {
    ClientConfig config =
        ClientConfig.newBuilder()
            .setApplicationId("io.axual.example.client.avro.producer")
            .setApplicationVersion("0.0.1")
            .setEndpoint("https://epo82e30ee36-75624457-discoveryapi.axual.cloud")
            .setTenant("epo82e30ee36")
            .setEnvironment("default")
            .setSslConfig(
                SslConfig.newBuilder()
                    .setEnableHostnameVerification(false)
                    .setKeystoreLocation(
                        "C:\\axiom\\epo82e30ee36-app-keystores\\application-one\\epo82e30ee36-application-one.keystore.jks") // Absolute path to the application keystore
                    .setKeystorePassword(new PasswordConfig("password"))
                    .setKeyPassword(new PasswordConfig("password"))
                    .setTruststoreLocation(
                        "C:\\axiom\\epo82e30ee36.truststore.jks") // Absolute path to the
                                                                  // application truststore
                    .setTruststorePassword(new PasswordConfig("password"))
                    .build())
            .build();

    SpecificAvroProducerConfig<Application, ApplicationLogEvent> specificAvroProducerConfig =
        SpecificAvroProducerConfig.<Application, ApplicationLogEvent>builder()
            // The strategy you want your producer to apply while sending records.
            .setDeliveryStrategy(DeliveryStrategy.AT_LEAST_ONCE)
            .setOrderingStrategy(OrderingStrategy.KEEPING_ORDER)
            .setMessageBufferWaitTimeout(100)
            .setBatchSize(1)
            .setProxyChain(
                ProxyChain.newBuilder()
                    .append(ProxyTypeRegistry.SWITCHING_PROXY_ID)
                    .append(ProxyTypeRegistry.RESOLVING_PROXY_ID)
                    .append(ProxyTypeRegistry.LINEAGE_PROXY_ID)
                    .append(ProxyTypeRegistry.HEADER_PROXY_ID)
                    .build())
            .build();

    try (final AxualClient axualClient = new AxualClient(config);
        final LogEventSpecificProducer producer =
            new LogEventSpecificProducer(
                axualClient, specificAvroProducerConfig, "logeventproducer", "0.0.1", "Team Log")) {
      // The produce method returns a `Future` with which you can do all your usual Future
      // operations that you desire. This will act on errors or on a successful produce.
      List<Future<ProducedMessage<Application, ApplicationLogEvent>>> futures =
          IntStream.range(0, 1)
              .mapToObj(
                  i ->
                      (Future<ProducedMessage<Application, ApplicationLogEvent>>)
                          producer.produce(
                              "app_" + (counter + i),
                              1000 + (counter + i),
                              ApplicationLogLevel.INFO,
                              String.format("Message %d", (counter + i)),
                              Collections.singletonMap("Some key", "Some Value")))
              .collect(Collectors.toList());
      do {
        futures.removeIf(
            future -> {
              if (!future.isDone()) {
                return false;
              }

              try {
                ProducedMessage<Application, ApplicationLogEvent> producedMessage = future.get();
                //                          LOG.info("Produced message to topic {} partition {}
                // offset {}", producedMessage.getStream(), producedMessage.getPartition(),
                // producedMessage.getOffset());
              } catch (InterruptedException | ExecutionException e) {
                //                           LOG.error("Error getting future, produce failed", e);
              }
              return true;
            });
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      } while (!futures.isEmpty());
      counter++;
    }
  }
}
