package com.example.embeddedmq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisConfigurationCustomizer;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ArtemisConfig implements ArtemisConfigurationCustomizer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.artemis.acceptor.host}")
    private String host;
    @Value("${spring.artemis.acceptor.port}")
    private String port;


    @Override
    public void customize(org.apache.activemq.artemis.core.config.Configuration configuration) {
        try {
            configuration.addAcceptorConfiguration("netty-connection", host + ":" + port);
            configuration.addConnectorConfiguration("netty-connection", host + ":" + port); // added Connector as we want to test if messages sent to embedded queue via controller are received by the JMS Listener.
        } catch (Exception e) {
            logger.error(getErrorMessage());
            throw new IllegalStateException(getErrorMessage());
        }
    }

    private String getErrorMessage() {
        return "unable to configure Artemis: acceptor configuration could not be set!";
    }
}
