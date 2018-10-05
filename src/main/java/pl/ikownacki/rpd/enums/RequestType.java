package pl.ikownacki.rpd.enums;

import lombok.Getter;

public enum RequestType {
    TYPE_1("Typ1"),
    TYPE_2("Typ2"),
    TYPE_3("Typ3"),
    TYPE_4("Typ4");

    @Getter
    private String typeName;

    RequestType(String typeName) {
        this.typeName = typeName;
    }
}
