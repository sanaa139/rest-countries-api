package dev.sana.volvorecruitementtask.DTO;

public class CurrencyDTO {
    private String name;
    private String symbol;

    public CurrencyDTO(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public CurrencyDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "CurrencyDTO{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
