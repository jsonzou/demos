/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.activemq.pubsub;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;

/**
 * Created by v_zoupengfei on 2017/2/28.
 */
public class ActiveMqManager {
    public static ActiveMqManager getInstance() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = factory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
       return null;
    }

    public void createTopic(String topicName) throws JMSException {


    }

}
