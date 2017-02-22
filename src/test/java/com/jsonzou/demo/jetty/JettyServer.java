/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.jsonzou.demo.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * Created by v_zoupengfei on 2017/2/22.
 */
public class JettyServer {

    public void start() throws Exception {
          Server server=new Server(81);
          ServletContextHandler servletContext=new ServletContextHandler(ServletContextHandler.SESSIONS);
          servletContext.setContextPath("/jetty");
          server.setHandler(servletContext);
          servletContext.addServlet(HelloServlet.class,"/hello");
          server.start();
    }
}
