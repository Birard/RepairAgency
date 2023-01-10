package com.myCompany.RepairAgency.servlet.filter;

import com.myCompany.RepairAgency.Constants;
import com.myCompany.RepairAgency.model.ModelManager;
import com.myCompany.RepairAgency.model.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebFilter(filterName = "SessionLocaleFilter", urlPatterns = {"/*"})
    public class SessionLocaleFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(SessionLocaleFilter.class);

        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)

                throws IOException, ServletException {
            logger.debug("Filter starts");

            HttpServletRequest req = (HttpServletRequest) request;

            if (req.getParameter("language") != null) {
                if(((HttpServletRequest)request).getSession().getAttribute("userId") != null){
                    User user = ModelManager.ins.getUserRepository().getById((Long) (
                            (HttpServletRequest)request).getSession().getAttribute("userId"));
                    user.setLocale_id(Constants.LOCALE.valueOf(req.getParameter("language")).ordinal());
                    ModelManager.ins.getUserRepository().update(user);
                }

                logger.debug("language changed from " + req.getSession().getAttribute("language")
                        + " to " + req.getParameter("language"));
                req.getSession().setAttribute("language", req.getParameter("language"));
            }

            if(req.getSession().getAttribute("language")  == null){
                logger.debug("language was null set to en_US");
                req.getSession().setAttribute("language", "en_US");
            }

            logger.debug("Filter finished");
            chain.doFilter(request, response);
        }

    @Override
    public void init(FilterConfig config) {
        logger.debug("Filter initialization");
    }

    @Override
    public void destroy() {
        logger.debug("Filter destruction");
    }
    }
