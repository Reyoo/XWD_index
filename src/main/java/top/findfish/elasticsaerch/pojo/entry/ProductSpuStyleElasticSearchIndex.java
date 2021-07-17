package top.findfish.elasticsaerch.pojo.entry;

/**
 * @Description:
 * @Title: ProductSpu
 * @Package top.findfish.elasticsaerch.pojo.entry
 * @Author: libbytian
 * @Copyright 版权归新文达教育 企业（或个人）所有
 * @CreateTime: 2021/6/11 9:01
 */


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description:
 * @Title: Findfish
 * @Package top.findfish.elasticsaerch.pojo.entry
 * @Author: libbytian
 * @Copyright 版权归新文达教育 企业（或个人）所有
 * @CreateTime: 2021/5/13 19:01
 */
@Document(indexName = "product_spu_style", shards = 3, replicas = 0, refreshInterval = "5s")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSpuStyleElasticSearchIndex implements Serializable {

    private static final long serialVersionUID = -1;

    @Id
    @Field(type = FieldType.Text)
    private String id;

    @Field(name = "spuId" ,type = FieldType.Keyword)
    String spuId;

    @Field(name = "platform" ,type = FieldType.Keyword)
    String platform;


    @Field(type = FieldType.Integer)
    String orgId;

    @Field(type = FieldType.Integer)
    String appId;

    @Field(type = FieldType.Keyword)
    String deleteStatus;

    @Field(type = FieldType.Keyword )
    String createUserId;

    @Field(type = FieldType.Date,format = DateFormat.date_hour_minute_second_fraction,ignoreMalformed = true)
    String createTime;

    @Field(type = FieldType.Integer)
    String updateUserId;

    @Field(type = FieldType.Date,format = DateFormat.date_hour_minute_second_fraction,ignoreMalformed = true)
    String updateTime;




}
