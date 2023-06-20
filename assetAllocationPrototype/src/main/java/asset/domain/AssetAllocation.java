package asset.domain;

public class AssetAllocation {

    private int id;

    private String name;
    private Integer cash;
    private Integer stock;
    private Integer bond;
    private Integer gold;

    public AssetAllocation() {
    }

    public AssetAllocation(String name, Integer cash, Integer stock, Integer bond, Integer gold) {
        this.name = name;
        this.cash = cash;
        this.stock = stock;
        this.bond = bond;
        this.gold = gold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getBond() {
        return bond;
    }

    public void setBond(Integer bond) {
        this.bond = bond;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }
}
