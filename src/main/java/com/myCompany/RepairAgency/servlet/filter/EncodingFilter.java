package com.myCompany.RepairAgency.servlet.filter;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;

@WebFilter(filterName="EncodingFilter",
        urlPatterns = {"/*"},
           initParams = {
           @WebInitParam(name = "encoding",
                         value = "UTF-8") }
           )

public class EncodingFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(EncodingFilter.class);
    private String encoding;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
    logger.debug("Filter starts");

    logger.debug("Change request encoding from " + request.getCharacterEncoding() + " to " + encoding );
        System.out.println(encoding);
    request.setCharacterEncoding(encoding);
//        response.setCharacterEncoding(encoding);

    logger.debug("Filter finished");
    chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) {
    logger.debug("Filter initialization starts");
        System.out.println(config.getInitParameter("encoding"));
    encoding = config.getInitParameter("encoding");
    logger.debug("Filter initialization finished");
    }

    @Override
    public void destroy() {
    logger.debug("Filter destruction starts");
    logger.debug("Filter destruction finished");
    }
}


