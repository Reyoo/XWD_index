package top.findfish.elasticsaerch.configuration;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @Description:
 * @Title: ElasticsearchConfig
 * @Package top.findfish.elasticsaerch.configuration
 * @Author: libbytian
 * @Copyright 版权归新文达教育 企业（或个人）所有
 * @CreateTime: 2021/5/12 19:50
 */
@Configuration
public class RestClientConfig extends AbstractElasticsearchConfiguration {

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {

//          uat
//        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo("124.70.94.194:9200")
//                .build();

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("119.3.248.85:9200")
                .build();

//pre
//        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo("124.70.25.232:9200")
//                .build();



//prod
//        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo("121.36.38.122:9200")
//                .build();


        return RestClients.create(clientConfiguration).rest();


    }
}

