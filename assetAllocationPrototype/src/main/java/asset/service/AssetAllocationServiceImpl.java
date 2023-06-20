package asset.service;

import asset.domain.AssetAllocation;
import asset.repository.AssetAllocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetAllocationServiceImpl implements AssetAllocationService{

    private final AssetAllocationRepository assetAllocationRepository;

    public AssetAllocationServiceImpl(AssetAllocationRepository assetAllocationRepository) {
        this.assetAllocationRepository = assetAllocationRepository;
    }
    @Override
    public void addAssetAllocation(AssetAllocation assetAllocation) {
        validateDuplicateName(assetAllocation);
        assetAllocationRepository.save(assetAllocation);
    }

    @Override
    public void validateDuplicateName(AssetAllocation assetAllocation) {
        assetAllocationRepository.findByName(assetAllocation.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이름");
                });
    }

    @Override
    public List<AssetAllocation> findAllAssetAllocation() {
        return assetAllocationRepository.findAll();
    }

    @Override
    public Optional<AssetAllocation> findOneByName(String name) {
        return assetAllocationRepository.findByName(name);
    }

    @Override
    public AssetAllocation findById(int id){
        return assetAllocationRepository.findById(id);
    }

    @Override
    public void update(int id, AssetAllocation assetAllocation){
        System.out.println("수정 서비스 실행");
        assetAllocationRepository.update(id, assetAllocation);
    }

    @Override
    public  void delete(int id){
        System.out.println("삭제 서비스 실행");
        assetAllocationRepository.delete(id);
    }

}
