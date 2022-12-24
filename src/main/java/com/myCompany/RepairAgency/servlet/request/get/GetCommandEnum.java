package com.myCompany.RepairAgency.servlet.request.get;


import com.myCompany.RepairAgency.servlet.request.IActionCommand;
import com.myCompany.RepairAgency.servlet.request.get.realization.*;

public enum GetCommandEnum{
    LOGIN {{
        this.command = new ShowLoginFormCommand();
    }},
    SIGNUP {{
        this.command = new ShowSignupFormCommand();
    }},
    ABOUT {{
        this.command = new ShowAboutCommand();
    }},
    FAQS {{
        this.command = new ShowFAQsCommand();
    }},
    HOME {{
        this.command = new ShowHomeCommand();
    }},
    PRICING {{
        this.command = new ShowPricingCommand();
    }},
    CABINET {{
        this.command = new ShowProfileCommand();
    }},
    ORDER {{
        this.command = new ShowOrderPageCommand();
    }},
    MY_ORDERS {{
        this.command = new ShowMyOrdersPageCommand();
    }};


    IActionCommand command;
    public IActionCommand getCurrentCommand() {
        return command;
    }
}