package com.service.post.entity.enums;

public enum TypeOfPostDelivery {

    LETTER("Письмо"),
    THE_PACKAGE("Посылка"),
    PARCEL("Бандероль"),
    POSTCARD("Открытка");

    public final String type;

    TypeOfPostDelivery(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
