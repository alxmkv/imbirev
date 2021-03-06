package com.nikolay.imbirev.model.entities;

public enum RequestCode {

    SYNTAX_ERROR(20),
    WARNING(1),
    ENTER_ERROR(10),
    DATE_PARSING_ERROR(50),
    DATA_ERROR(60),
    SQL_SYNTAX_ERROR(99),
    SUCCESS(0),
    DATABASE_ERROR(30),
    EMPTY_SET(2);

    private int value;

    RequestCode(int value) {
        this.value = value;
    }

}
