package top.findfish.elasticsaerch.pojo.entry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author cyy
 * @date 2020/9/21 15:57
 * @Description:
 */


@Document(indexName = "resource_campus_location", shards = 3, replicas = 0, refreshInterval = "5s")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResouceCampusLocationElasticSearchIndex implements Serializable {


    private static final long serialVersionUID = -1L;

    @Id
    @Field(type = FieldType.Text)
    String id;

    @Field(value = "campusId",type = FieldType.Integer)
    Integer campusId;

    @Field(value = "provinceCode",type = FieldType.Keyword)
    String provinceCode;

    @Field(value = "cityCode", type = FieldType.Keyword)
    String cityCode;

    @Field(value = "areaCode",type = FieldType.Keyword)
    String areaCode;

    @Field(value = "longitude", type = FieldType.Keyword)
    String longitude;

    @Field(value = "latitude", type = FieldType.Keyword)
    String latitude;

    @Field(value = "address", type = FieldType.Keyword)
    String address;

    @Field(name = "houseNumber", type = FieldType.Keyword)
    String houseNumber;

    @Field(name = "orgId", type = FieldType.Integer)
    Integer orgId;

    @Field(name = "appId", type = FieldType.Integer)
    Integer appId;

    @Field(name = "deleteStatus", type = FieldType.Integer)
    Integer deleteStatus;


}
