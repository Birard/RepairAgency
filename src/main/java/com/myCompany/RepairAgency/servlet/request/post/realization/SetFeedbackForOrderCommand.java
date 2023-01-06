package com.myCompany.RepairAgency.servlet.request.post.realization;

import com.myCompany.RepairAgency.Constants;
import com.myCompany.RepairAgency.model.ModelManager;
import com.myCompany.RepairAgency.model.entity.RepairOrder;
import com.myCompany.RepairAgency.model.entity.User;
import com.myCompany.RepairAgency.servlet.Path;
import com.myCompany.RepairAgency.servlet.PathFactory;
import com.myCompany.RepairAgency.servlet.request.IActionCommand;
import com.myCompany.RepairAgency.servlet.request.IHasRoleRequirement;
import com.myCompany.RepairAgency.servlet.util.ForChangeEntity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class SetFeedbackForOrderCommand implements IActionCommand, IHasRoleRequirement {
    @Override
    public Path execute(HttpServletRequest request, HttpServletResponse response) {
        ForChangeEntity.updateGoalId("Order", request);

        String goalOrderFeedback_mark = request.getParameter("goalOrderFeedback_mark");
        if (goalOrderFeedback_mark != null && !goalOrderFeedback_mark.isBlank()) {
            String goalOrderFeedback_text = request.getParameter("goalOrderFeedback_text");
            if (goalOrderFeedback_text != null && !goalOrderFeedback_text.isBlank()) {
                RepairOrder order = ModelManager.ins.getRepairOrderRepository().getById((Long) request.getSession().getAttribute("goalIdOrder"));
                order.setFeedback_text(goalOrderFeedback_text);
                order.setFeedback_date(LocalDateTime.now());
                order.setFeedback_mark(Integer.parseInt(goalOrderFeedback_mark));
                ModelManager.ins.getRepairOrderRepository().update(order);
            }
        }

        Path path = PathFactory.getPath("path.page.redirect.order");
        path.addParameter("id", request.getParameter("goalIdOrder"));

        return path;
    }

    @Override
    public List<Constants.ROLE> allowedUserRoles() {
        return Stream.of(Constants.ROLE.Client, Constants.ROLE.Manager, Constants.ROLE.Admin, Constants.ROLE.Craftsman).collect(Collectors.toList());
    }
}