package asset.repository;

import asset.domain.AssetAllocation;
import asset.repository.MemoryAssetAllocationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RepositoryTest {

    MemoryAssetAllocationRepository repository = new MemoryAssetAllocationRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        //given
        AssetAllocation assetAllocation = new AssetAllocation("1", 0, 60, 40, 0);
        //when
        repository.save(assetAllocation);
        //then
        AssetAllocation result = repository.findByName(assetAllocation.getName()).get();
        assertThat(result).isEqualTo(assetAllocation);
    }

    @Test
    public void findAll(){
        //given
        AssetAllocation assetAllocation1 = new AssetAllocation("1", 0, 60, 40, 0);
        repository.save(assetAllocation1);

        AssetAllocation assetAllocation2 = new AssetAllocation("2", 0, 50, 50, 0);
        repository.save(assetAllocation2);

        //when
        List<AssetAllocation> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);

    }
}
