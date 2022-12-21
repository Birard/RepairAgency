package com.myCompany.RepairAgency.servlet.request.get.realization;

import com.myCompany.RepairAgency.servlet.Path;
import com.myCompany.RepairAgency.servlet.PathFactory;
import com.myCompany.RepairAgency.servlet.request.ActionCommand;
import jakarta.servlet.http.HttpServletRequest;

public class ShowLoginFormCommand implements ActionCommand {
    @Override
    public Path execute(HttpServletRequest request) {
        Path page = PathFactory.getPath("path.page.forward.login");
        request.setAttribute("title", "title.login");

//        errorEmptyPassword = Password cannot be empty.
//        errorLoginPassMessage = Incorrect login or password.
//        errorEmptyLogin = Login cannot be empty.
        request.setAttribute("errorEmptyPassword",
                request.getSession().getAttribute("errorEmptyPassword"));
        request.setAttribute("errorLoginPassMessage",
                request.getSession().getAttribute("errorLoginPassMessage"));
        request.setAttribute("errorEmptyLogin",
                request.getSession().getAttribute("errorEmptyLogin"));

        request.getSession().removeAttribute("errorEmptyPassword");
        request.getSession().removeAttribute("errorLoginPassMessage");
        request.getSession().removeAttribute("errorEmptyLogin");

        return page;
    }
}