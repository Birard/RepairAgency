package com.myCompany.RepairAgency.model.db.abstractDB.abstractRepository.primitive;

import java.util.ArrayList;

public interface iRepositoryForGetAble<T>{
    T getById(int id);
    ArrayList<T> getAll();
    ArrayList<T> getWithPagination(int skip, int quantity);
}
