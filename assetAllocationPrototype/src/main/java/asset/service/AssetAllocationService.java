package asset.service;

import asset.domain.AssetAllocation;

import java.util.List;
import java.util.Optional;

public interface AssetAllocationService {
    public void addAssetAllocation(AssetAllocation assetAllocation);
    public void validateDuplicateName(AssetAllocation assetAllocation);
    public List<AssetAllocation> findAllAssetAllocation();
    public Optional<AssetAllocation> findOneByName(String name);

    public AssetAllocation findById(int id);
    public  void update(int id, AssetAllocation assetAllocation);
    public  void delete(int id);

}
