package asset;

import asset.service.AssetAllocationService;
import asset.service.AssetAllocationServiceImpl;
import asset.repository.MemoryAssetAllocationRepository;
import asset.repository.AssetAllocationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public static AssetAllocationRepository assetAllocationRepository(){
        return  new MemoryAssetAllocationRepository();
    }
    @Bean
    public AssetAllocationService assetAllocationService(){
        return new AssetAllocationServiceImpl(assetAllocationRepository());
    }

//    @Bean
//    public AssetAllocationController assetAllocationController(){
//        return new AssetAllocationController(assetAllocationService());
//    }

}
