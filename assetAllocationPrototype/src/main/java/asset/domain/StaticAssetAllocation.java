package asset.domain;

public class StaticAssetAllocation extends AssetAllocation {

    public StaticAssetAllocation(String name, Integer cash, Integer stock, Integer bond, Integer gold) {
        super(name, cash, stock, bond, gold);
    }
}

