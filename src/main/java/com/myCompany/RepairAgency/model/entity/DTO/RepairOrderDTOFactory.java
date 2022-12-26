package com.myCompany.RepairAgency.model.entity.DTO;

import com.myCompany.RepairAgency.Constants;
import com.myCompany.RepairAgency.model.entity.RepairOrder;

import java.util.ArrayList;

public class RepairOrderDTOFactory {

    public static RepairOrderDTO getRepairOrder(RepairOrder order) {
        return new RepairOrderDTO.RepairOrderBuilder()
                .setId(order.getId())
                .setUser_id(order.getUser_id())
                .setCraftsman_id(order.getCraftsman_id())
                .setText(order.getText())
                .setPrice(order.getPrice())
                .setStatus(Constants.ORDER_STATUS.values()[(int) order.getStatus_id()].getToString())
                .setFeedback_text(order.getFeedback_text())
                .setFeedback_mark(order.getFeedback_mark())
                .build();
    }

    public static ArrayList<RepairOrderDTO> getRepairOrders(ArrayList <RepairOrder> orders) {
        ArrayList<RepairOrderDTO> answer = new ArrayList<>();
        orders.forEach(o -> answer.add(getRepairOrder(o)));
        return answer;
    }
}