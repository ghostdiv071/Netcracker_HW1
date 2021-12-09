package contract;

public enum ContractType {
    CELLULAR("cellular"),
    INTERNET("internet"),
    TELEVISION("television");

    private final String value;

    ContractType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
