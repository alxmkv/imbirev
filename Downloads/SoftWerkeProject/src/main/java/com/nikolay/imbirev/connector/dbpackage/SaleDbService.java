package com.nikolay.imbirev.connector.dbpackage;

import com.nikolay.imbirev.model.dao.SaleDao;
import com.nikolay.imbirev.model.entities.*;
import com.nikolay.imbirev.model.exceptions.DatabaseAccessException;
import com.nikolay.imbirev.model.executors.AbstractExecutor;

import java.util.logging.Logger;

public class SaleDbService implements DbInterface {

    private SaleDao dao;
    private final static Logger log = Logger.getAnonymousLogger();
    private final static String TAG = "SaleDbService";

    public SaleDbService() throws DatabaseAccessException {
        AbstractExecutor executor;
        try {
            executor = new AbstractExecutor();
        } catch (DatabaseAccessException e) {
            log.info(TAG);
            throw new DatabaseAccessException(e.getMessage());
        }
        dao = new SaleDao(executor);
    }

    @Override
    public RequestCode createTable(Column[] array) {
        return dao.createTable(SaleTable.TABLE_NAME, array);
    }

    @Override
    public RequestCode deleteFromTable(Query[] array) {
        return dao.deleteFromTable(SaleTable.TABLE_NAME, array);
    }

    @Override
    public RequestCode updateTable(Query[] condArray, Query[] newArray) {
        return dao.updateTable(SaleTable.TABLE_NAME, condArray, newArray);
    }

    @Override
    public RequestCode insertIntoTable(Query[] array) {
        return dao.insertIntoTable(array, SaleTable.TABLE_NAME);
    }

    @Override
    public RequestCode getFromTable(Query[] array, Column[] sortArray) {
        return dao.getListFromTable(SaleTable.TABLE_NAME, array, sortArray);
    }
}
