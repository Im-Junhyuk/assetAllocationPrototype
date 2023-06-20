package asset.repository;

import asset.domain.AssetAllocation;

import java.util.*;

public class MemoryAssetAllocationRepository implements AssetAllocationRepository {

    private static Map<Integer, AssetAllocation> store = new HashMap<>();
    private static int sequence = 0;

    public MemoryAssetAllocationRepository(){
        if (store.isEmpty() ==true) {
            System.out.println("repo 생성자 실행");
            AssetAllocation a1 = new AssetAllocation();
            a1.setName("a1");
            a1.setCash(0);
            a1.setGold(10);
            a1.setBond(20);
            a1.setStock(70);

            save(a1);

            AssetAllocation a2 = new AssetAllocation();
            a2.setName("a2");
            a2.setCash(0);
            a2.setGold(10);
            a2.setBond(60);
            a2.setStock(30);

            save(a2);
        }
    }


    @Override
    public void save(AssetAllocation assetAllocation) {
        assetAllocation.setId(++sequence);
        if(assetAllocation.getName() == null){
            assetAllocation.setName("입력없음");
        }
        if(assetAllocation.getStock() == null){
            assetAllocation.setStock(0);
        }
        if(assetAllocation.getBond() == null){
            assetAllocation.setBond(0);
        }
        if(assetAllocation.getGold() == null){
            assetAllocation.setGold(0);
        }

        store.put(assetAllocation.getId(), assetAllocation);
    }
    @Override
    public AssetAllocation findById(int id){
        return store.get(id);
    }
    @Override
    public Optional<AssetAllocation> findByName(String name) {
        return Optional.ofNullable(store.get(name));
    }

    @Override
    public List<AssetAllocation> findAll(){
        return new ArrayList<>(store.values());
    }

    @Override
    public void update(int id, AssetAllocation updateParam){
        System.out.println("repo 수정 실행");
        AssetAllocation findAA = findById(id);

        if(updateParam.getName()==null){
            findAA.setName("입력없음");}
        else{
            findAA.setName(updateParam.getName());
        }

        if(updateParam.getStock()==null){
            findAA.setStock(0);}
        else{
            findAA.setStock(updateParam.getStock());
        }

        if(updateParam.getBond()==null){
            findAA.setBond(0);}
        else{
            findAA.setBond(updateParam.getBond());
        }
        if(updateParam.getGold()==null){
            findAA.setGold(0);}
        else{
            findAA.setGold(updateParam.getGold());
        }

    }

    @Override
    public void delete(int id){
        System.out.println("repo 삭제 실행");
        store.remove(id);
    }
    @Override
    public void clearStore(){ store.clear();}

}
