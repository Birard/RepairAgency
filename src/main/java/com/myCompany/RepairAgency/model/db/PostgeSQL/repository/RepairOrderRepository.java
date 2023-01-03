package com.myCompany.RepairAgency.model.db.PostgeSQL.repository;

import com.myCompany.RepairAgency.model.db.PostgeSQL.ConnectionPool;
import com.myCompany.RepairAgency.model.db.PostgeSQL.Query;
import com.myCompany.RepairAgency.model.db.PostgeSQL.QueryExecutioner;
import com.myCompany.RepairAgency.model.db.PostgeSQL.factory.RepairOrderFactory;
import com.myCompany.RepairAgency.model.db.abstractDB.abstractRepository.entity.iRepairOrderRepository;
import com.myCompany.RepairAgency.model.entity.RepairOrder;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class RepairOrderRepository implements iRepairOrderRepository {
    public static Object[] extractFields(RepairOrder order, Object... args) {
        Object[] arr1 = new Object[]{order.getUser_id(),
                order.getCraftsman_id() == 0 ? null : order.getCraftsman_id(),
                order.getCreation_date(),
                order.getText(),
                order.getPrice(),
                order.getFinish_date(),
                order.getStatus_id(),
                order.getFeedback_date(),
                order.getFeedback_text(),
                order.getFeedback_mark()};

        return Stream.concat(Arrays.stream(arr1), Arrays.stream(args)).toArray();
    }

    @Override
    public void update(RepairOrder order) {
        Connection conn = ConnectionPool.getConnection();
        QueryExecutioner.executeUpdate(conn, Query.RepairOrdersQuery.UPDATE,
                RepairOrderRepository.extractFields(order, order.getId()));
        ConnectionPool.releaseConnection(conn);
    }

    @Override
    public void delete(RepairOrder order) {
        Connection conn = ConnectionPool.getConnection();
        QueryExecutioner.executeUpdate(conn, Query.RepairOrdersQuery.DELETE, order.getId());
        ConnectionPool.releaseConnection(conn);
    }

    @Override
    public void insert(RepairOrder order) {
        Connection conn = ConnectionPool.getConnection();
        QueryExecutioner.executeUpdate(conn, Query.RepairOrdersQuery.INSERT,
                RepairOrderRepository.extractFields(order));
        ConnectionPool.releaseConnection(conn);
    }

    @Override
    public RepairOrder getById(long id) {
        Connection conn = ConnectionPool.getConnection();
        RepairOrder res = QueryExecutioner.readEntity(RepairOrderFactory.ins, conn, Query.RepairOrdersQuery.SELECT_BY_ID, id);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public ArrayList<RepairOrder> getWithPagination(long skip, long quantity) {
        Connection conn = ConnectionPool.getConnection();
        ArrayList<RepairOrder> res = QueryExecutioner.readList(RepairOrderFactory.ins, conn,
                Query.RepairOrdersQuery.SELECT +
                        Query.RepairOrdersQuery.getSortQuery(SORT_TYPE.ORDER_BY_ID_ASC)
                , skip, quantity);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public long getCount() {
        Connection conn = ConnectionPool.getConnection();
        long res = QueryExecutioner.readNumber(conn, Query.RepairOrdersQuery.COUNT);
        ConnectionPool.releaseConnection(conn);
        return res;
    }


    @Override
    public ArrayList<RepairOrder> getByStatus(long[] statusIds, SORT_TYPE sort, long skip, long quantity) {
        Connection conn = ConnectionPool.getConnection();
        ArrayList<RepairOrder> res = QueryExecutioner.readList(RepairOrderFactory.ins, conn
                , Query.RepairOrdersQuery.SELECT_BY_STATUS +
                        Query.RepairOrdersQuery.getSortQuery(sort)
                , statusIds, skip, quantity);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public long countByStatus(long[] statusIds) {
        Connection conn = ConnectionPool.getConnection();
        long res = QueryExecutioner.readNumber(conn, Query.RepairOrdersQuery.COUNT_BY_STATUS, statusIds);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public ArrayList<RepairOrder> getByCraftNNStatus(long[] craftIds, long[] statusIds, SORT_TYPE sort, long skip, long quantity) {
        Connection conn = ConnectionPool.getConnection();
        ArrayList<RepairOrder> res = QueryExecutioner.readList(RepairOrderFactory.ins, conn
                , Query.RepairOrdersQuery.SELECT_BY_CRAFT_NN_STATUS +
                        Query.RepairOrdersQuery.getSortQuery(sort)
                , craftIds, statusIds, skip, quantity);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public long countByCraftNNStatus(long[] craftIds, long[] statusIds) {
        Connection conn = ConnectionPool.getConnection();
        long res = QueryExecutioner.readNumber(conn, Query.RepairOrdersQuery.COUNT_BY_CRAFT_NN_STATUS, craftIds, statusIds);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public ArrayList<RepairOrder> getByCraftStatus(long[] craftIds, long[] statusIds, SORT_TYPE sort, long skip, long quantity) {
        Connection conn = ConnectionPool.getConnection();
        ArrayList<RepairOrder> res = QueryExecutioner.readList(RepairOrderFactory.ins, conn
                , Query.RepairOrdersQuery.SELECT_BY_CRAFT_STATUS +
                        Query.RepairOrdersQuery.getSortQuery(sort)
                , craftIds, statusIds, skip, quantity);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public long countByCraftStatus(long[] craftIds, long[] statusIds) {
        Connection conn = ConnectionPool.getConnection();
        long res = QueryExecutioner.readNumber(conn, Query.RepairOrdersQuery.COUNT_BY_CRAFT_STATUS, craftIds, statusIds);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public ArrayList<RepairOrder> getByUserStatus(long userId, long[] statusIds, SORT_TYPE sort, long skip, long quantity) {
        Connection conn = ConnectionPool.getConnection();
        ArrayList<RepairOrder> res = QueryExecutioner.readList(RepairOrderFactory.ins, conn
                , Query.RepairOrdersQuery.SELECT_BY_USER_STATUS +
                        Query.RepairOrdersQuery.getSortQuery(sort)
                , userId, statusIds, skip, quantity);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public long countByUserStatus(long userId, long[] statusIds) {
        Connection conn = ConnectionPool.getConnection();
        long res = QueryExecutioner.readNumber(conn, Query.RepairOrdersQuery.COUNT_BY_USER_STATUS, userId, statusIds);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public ArrayList<RepairOrder> getByCraftUserStatus(long[] craftIds, long userId, long[] statusIds, SORT_TYPE sort, long skip, long quantity) {
        Connection conn = ConnectionPool.getConnection();
        ArrayList<RepairOrder> res = QueryExecutioner.readList(RepairOrderFactory.ins, conn
                , Query.RepairOrdersQuery.SELECT_BY_CRAFT_USER_STATUS +
                        Query.RepairOrdersQuery.getSortQuery(sort)
                , craftIds, userId, statusIds, skip, quantity);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public long countByCraftUserStatus(long[] craftIds, long userId, long[] statusIds) {
        Connection conn = ConnectionPool.getConnection();
        long res = QueryExecutioner.readNumber(conn, Query.RepairOrdersQuery.COUNT_BY_CRAFT_USER_STATUS, craftIds, userId, statusIds);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

}
