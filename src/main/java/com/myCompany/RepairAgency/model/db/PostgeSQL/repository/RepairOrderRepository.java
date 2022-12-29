package com.myCompany.RepairAgency.model.db.PostgeSQL.repository;

import com.myCompany.RepairAgency.Constants;
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
                            order.getCraftsman_id()==0?null:order.getCraftsman_id(),
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
    public ArrayList<RepairOrder> getWithPagination(int skip, int quantity) {
        Connection conn = ConnectionPool.getConnection();
        ArrayList<RepairOrder> res = QueryExecutioner.readList(RepairOrderFactory.ins, conn,
                Query.RepairOrdersQuery.SELECT_WITH_PAGINATION, skip, quantity);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public ArrayList<RepairOrder> getAllWhereCraftsmanIdIs(long id, int skip, int quantity) {
        Connection conn = ConnectionPool.getConnection();
        ArrayList<RepairOrder> res = QueryExecutioner.readList(RepairOrderFactory.ins, conn, Query.RepairOrdersQuery.SELECT_BY_CRAFTSMAN_ID, id, skip, quantity);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public ArrayList<RepairOrder> getAllWhereUserIdIs(long id, int skip, int quantity) {
        Connection conn = ConnectionPool.getConnection();
        ArrayList<RepairOrder> res = QueryExecutioner.readList(RepairOrderFactory.ins, conn, Query.RepairOrdersQuery.SELECT_BY_USER_ID, id, skip, quantity);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public long getCountWhereUserIdIs(long id) {
        Connection conn = ConnectionPool.getConnection();
        long res = QueryExecutioner.readNumber(conn, Query.RepairOrdersQuery.COUNT_BY_USER_ID, id);
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
    public long getCountWhereCraftsmanIdIs(long id) {
        Connection conn = ConnectionPool.getConnection();
        long res = QueryExecutioner.readNumber(conn, Query.RepairOrdersQuery.COUNT_BY_CRAFTSMAN_ID, id);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public ArrayList<RepairOrder> getByCraftUserStatus(long[] craftIds, long userId, long[] statusIds, int skip, int quantity) {
        Connection conn = ConnectionPool.getConnection();
        ArrayList<RepairOrder> res = QueryExecutioner.readList(RepairOrderFactory.ins, conn, Query.RepairOrdersQuery.SELECT_BY_CRAFT_USER_STATUS, craftIds, userId, statusIds, skip, quantity);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public long getCountByCraftUserStatus(long[] craftIds, long userId, long[] statusIds) {
        Connection conn = ConnectionPool.getConnection();
        long res = QueryExecutioner.readNumber(conn, Query.RepairOrdersQuery.COUNT_BY_CRAFT_USER_STATUS, craftIds, userId, statusIds);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public ArrayList<RepairOrder> getByCraftStatus(long[] craftIds, long[] statusIds, int skip, int quantity) {
        Connection conn = ConnectionPool.getConnection();
        ArrayList<RepairOrder> res = QueryExecutioner.readList(RepairOrderFactory.ins, conn, Query.RepairOrdersQuery.SELECT_BY_CRAFT_STATUS, craftIds, statusIds, skip, quantity);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public long getCountByCraftStatus(long[] craftIds, long[] statusIds) {
        Connection conn = ConnectionPool.getConnection();
        long res = QueryExecutioner.readNumber(conn, Query.RepairOrdersQuery.COUNT_BY_CRAFT_STATUS, craftIds, statusIds);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public ArrayList<RepairOrder> getByUserStatus(long userId, long[] statusIds, int skip, int quantity) {
        Connection conn = ConnectionPool.getConnection();
        ArrayList<RepairOrder> res = QueryExecutioner.readList(RepairOrderFactory.ins, conn, Query.RepairOrdersQuery.SELECT_BY_USER_STATUS, userId, statusIds, skip, quantity);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public long getCountByUserStatus(long userId, long[] statusIds) {
        Connection conn = ConnectionPool.getConnection();
        long res = QueryExecutioner.readNumber(conn, Query.RepairOrdersQuery.COUNT_BY_USER_STATUS, userId, statusIds);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public ArrayList<RepairOrder> getByStatus(long[] statusIds, int skip, int quantity) {
        Connection conn = ConnectionPool.getConnection();
        ArrayList<RepairOrder> res = QueryExecutioner.readList(RepairOrderFactory.ins, conn, Query.RepairOrdersQuery.SELECT_BY_STATUS, statusIds, skip, quantity);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

    @Override
    public long getCountByStatus(long[] statusIds) {
        Connection conn = ConnectionPool.getConnection();
        long res = QueryExecutioner.readNumber(conn, Query.RepairOrdersQuery.COUNT_BY_STATUS, statusIds);
        ConnectionPool.releaseConnection(conn);
        return res;
    }

}
