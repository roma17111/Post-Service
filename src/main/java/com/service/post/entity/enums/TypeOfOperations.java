package com.service.post.entity.enums;

public enum TypeOfOperations {

    REGISTRATION("Регистрация посылки"),
    ARRIVAL("Прибытие"),
    DEPARTURE("Убытие"),
    RECIEVED("Получение адресатом");

    private final String name;


    TypeOfOperations(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
