/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.activemq.pubsub;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by v_zoupengfei on 2017/2/28.
 */
public class Producer {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection=factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic=session.createTopic("hello.topic");
        MessageProducer producer= session.createProducer(topic);
        TextMessage message=new ActiveMQTextMessage();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                    String line = br.readLine();
                    message.setText(line);
                    producer.send(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            producer.close();
            session.close();
            connection.close();
        }


    }
}

