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
public class Consumer {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection=factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic=session.createTopic("hello.topic");
        MessageConsumer consumer= session.createConsumer(topic);
        /*
        while (true){
            TextMessage msg=(TextMessage)  consumer.receive();
            System.out.println("consumer收到消息："+msg.getText());
        }
        */
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if(message instanceof TextMessage){
                    TextMessage msg=(TextMessage) message;
                    try {
                        System.out.println("consumer收到消息："+msg.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        /*
        try {
            consumer.setMessageListener((message)-> {
                 if(message instanceof TextMessage){
                     TextMessage msg=(TextMessage) message;
                     try {
                         System.out.println("consumer收到消息："+msg.getText());
                     } catch (JMSException e) {
                         e.printStackTrace();
                     }
                 }
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
            session.close();
            connection.close();
        }
        while(true){

        }
        */
    }
}
