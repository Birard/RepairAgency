package com.myCompany.RepairAgency.servlet.request.get;



import com.myCompany.RepairAgency.servlet.request.IActionCommand;
import com.myCompany.RepairAgency.servlet.request.abstractCommandFactory;
import com.myCompany.RepairAgency.servlet.request.get.realization.EmptyCommandI;
import com.myCompany.RepairAgency.servlet.request.post.PostCommandFactory;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class GetCommandFactory extends abstractCommandFactory {

    private static final Logger logger = LogManager.getLogger(PostCommandFactory.class);

    public static final GetCommandFactory inst = new GetCommandFactory();

    private GetCommandFactory() {}

    public IActionCommand defineCommand(HttpServletRequest request) {
        IActionCommand current = new EmptyCommandI();

//        String command = request.getParameter("command");
        String command = request.getRequestURI();
        command = command.substring(command.indexOf("/controller/")+12);
        logger.debug("[GetCommandFactory] " + command);
        if (command.isEmpty()) {
             return current;
        }

        try {
            GetCommandEnum currentEnum = GetCommandEnum.valueOf(command.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongCommand",
                    command + "message.wrongCommand");
        }
        return current;
    }
}