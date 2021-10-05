package prbd.construction_company.entities;

public enum SaleStatus {
    SALE("В продаже"), RESERVED("Забронирована"), SOLD("Продана");
    private final String status;

    SaleStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
