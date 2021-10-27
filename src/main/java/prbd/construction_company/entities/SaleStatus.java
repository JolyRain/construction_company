package prbd.construction_company.entities;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SaleStatus {
    SALE("В продаже"), RESERVED("Забронирована"), SOLD("Продана");
    private final String status;

    SaleStatus(String status) {
        this.status = status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }
}
