package com.myCompany.RepairAgency.servlet.request.get.realization;

import com.myCompany.RepairAgency.servlet.ConfigurationManager;
import com.myCompany.RepairAgency.servlet.request.ActionCommand;
import jakarta.servlet.http.HttpServletRequest;

public class ShowSignupFormCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.forward.signup");
        request.setAttribute("errorEmptyPassword",
                request.getSession().getAttribute("errorEmptyPassword"));
        request.setAttribute("errorLoginPassMessage",
                request.getSession().getAttribute("errorLoginPassMessage"));
        request.setAttribute("errorEmptyLogin",
                request.getSession().getAttribute("errorEmptyLogin"));
        request.setAttribute("errorEmptyPasswordRepeat",
                request.getSession().getAttribute("errorEmptyPasswordRepeat"));

        request.getSession().removeAttribute("errorEmptyPassword");
        request.getSession().removeAttribute("errorLoginPassMessage");
        request.getSession().removeAttribute("errorEmptyLogin");
        request.getSession().removeAttribute("errorEmptyPasswordRepeat");
        request.setAttribute("title", "title.signup");
        return page;
    }
}