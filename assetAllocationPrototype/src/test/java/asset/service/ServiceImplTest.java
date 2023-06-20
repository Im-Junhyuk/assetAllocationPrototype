package asset.service;

import asset.domain.AssetAllocation;
import asset.repository.AssetAllocationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static asset.AppConfig.assetAllocationRepository;
import static org.apache.coyote.http11.Constants.a;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceImplTest {

    AssetAllocationService assetAllocationService;

    @BeforeEach
    public void beforeEach(){
        assetAllocationService = new AssetAllocationServiceImpl(assetAllocationRepository());
    }

    @AfterEach
    public void afterEach(){
        assetAllocationRepository().clearStore();
    }

    @Test
    public void add() throws Exception{
        //given
        AssetAllocation assetAllocation1 = new AssetAllocation("1", 0, 50, 50, 0);

        //when
        assetAllocationService.addAssetAllocation(assetAllocation1);
        //then
        AssetAllocation one = assetAllocationRepository().findByName("1").get();
        assertEquals(one.getName(), assetAllocation1.getName());

    }

    @Test
    public void duplicate() throws Exception{
        //given
        AssetAllocation assetAllocation1 = new AssetAllocation("1", 0, 50, 50, 0);

        //when
        assetAllocationService.addAssetAllocation(assetAllocation1);
        AssetAllocation assetAllocation2 = new AssetAllocation("1", 0, 50, 50, 0);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> assetAllocationService.addAssetAllocation(assetAllocation2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름");
    }
}
