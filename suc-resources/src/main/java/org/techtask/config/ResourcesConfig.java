package org.techtask.config;

import org.techtask.mapper.UserMapper;
import org.techtask.mapper.impl.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.techtask.repository.SellerRetailReportsRepository;
import org.techtask.service.SellerRetailReportsService;
import org.techtask.service.impl.SellerRetailReportsServiceImpl;

@Configuration
public class ResourcesConfig {

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public SellerRetailReportsService SellerRetailReportsService(
            SellerRetailReportsRepository sellerRetailReportsRepository) {
        return new SellerRetailReportsServiceImpl(sellerRetailReportsRepository);
    }

}
