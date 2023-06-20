package asset.repository;

import asset.domain.AssetAllocation;

import java.util.List;
import java.util.Optional;

public interface AssetAllocationRepository {
    void save(AssetAllocation assetAllocation);

    Optional<AssetAllocation> findByName(String name);
    List<AssetAllocation> findAll();
    public void clearStore();
    public AssetAllocation findById(int id);
    public void update(int id, AssetAllocation updateParam);
    public void delete(int id);

}
