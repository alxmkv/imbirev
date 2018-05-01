package com.nikolay.imbirev.connector.dbpackage;

import com.nikolay.imbirev.model.dao.ClientDao;
import com.nikolay.imbirev.model.entities.*;
import com.nikolay.imbirev.model.exceptions.DatabaseAccessException;
import com.nikolay.imbirev.model.executors.AbstractExecutor;
import org.apache.log4j.Logger;

public class ClientDbService implements DbInterface {

    private ClientDao dao;
    private final static Logger log = Logger.getLogger(ClientDbService.class);
    private final static String TAG = "ClientDbService";

    public ClientDbService() throws DatabaseAccessException {
        AbstractExecutor executor;
        try {
            executor = new AbstractExecutor();
        } catch (DatabaseAccessException e) {
            log.error(TAG);
            throw new DatabaseAccessException(e.getMessage());
        }
        dao = new ClientDao(executor);
    }

    @Override
    public RequestCode createTable(Column[] array) {
        return dao.createTable(ClientTable.TABLE_NAME, array);
    }

    @Override
    public RequestCode dropTable() {
        return dao.dropTable(ClientTable.TABLE_NAME);
    }

    @Override
    public RequestCode deleteFromTable(Query[] array) {
        return dao.deleteFromTable(ClientTable.TABLE_NAME, array);
    }

    @Override
    public RequestCode updateTable(Query[] condArray, Query[] newArray) {
        return dao.updateTable(ClientTable.TABLE_NAME, condArray, newArray);
    }

    @Override
    public RequestCode insertIntoTable(Query[] array) {
        return dao.insertIntoTable(array, ClientTable.TABLE_NAME);
    }

    @Override
    public RequestCode getFromTable(Query[] array, Column[] sortArray) {
        return dao.getListFromTable(ClientTable.TABLE_NAME, array, sortArray);
    }
}
