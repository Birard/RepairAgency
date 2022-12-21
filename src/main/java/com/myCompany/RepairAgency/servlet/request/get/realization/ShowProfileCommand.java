package com.myCompany.RepairAgency.servlet.request.get.realization;

import com.myCompany.RepairAgency.servlet.Path;
import com.myCompany.RepairAgency.servlet.PathFactory;
import com.myCompany.RepairAgency.servlet.request.ActionCommand;
import jakarta.servlet.http.HttpServletRequest;

public class ShowProfileCommand implements ActionCommand {
    @Override
    public Path execute(HttpServletRequest request) {
        /* в случае ошибки или прямого обращения к контроллеру
         * переадресация на страницу ввода логина */
        Path page = PathFactory.getPath("path.page.forward.cabinet");
//        String page = PathFactory.getProperty("path.page.error");
        request.setAttribute("title", "title.cabinet");
        return page;
    }
}
