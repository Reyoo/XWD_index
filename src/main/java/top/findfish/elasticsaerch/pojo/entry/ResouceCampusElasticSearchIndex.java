package top.findfish.elasticsaerch.pojo.entry;

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
import java.time.LocalDateTime;

/**
 * @author cyy
 * @date 2020/9/21 15:57
 * @Description:
 */


@Document(indexName = "resource_campus", shards = 3, replicas = 0, refreshInterval = "5s")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResouceCampusElasticSearchIndex implements Serializable {


    private static final long serialVersionUID = -1L;

    @Id
    @Field(type = FieldType.Text)
    String id;

    @Field(value = "campusName",type = FieldType.Keyword)
    String campusName;

    @Field(value = "deptId",type = FieldType.Integer)
    Integer deptId;

    @Field(value = "telephone", type = FieldType.Keyword)
    String telephone;

    @Field(value = "campusIntroduce",type = FieldType.Text)
    String campusIntroduce;

    @Field(value = "businessHours", type = FieldType.Keyword)
    String businessHours;

    @Field(value = "collectionAccounts", type = FieldType.Keyword)
    String collectionAccounts;

    @Field(value = "staffId", type = FieldType.Integer)
    Integer staffId;

    @Field(name = "remark", type = FieldType.Keyword)
    String remark;

    @Field(name = "orgId", type = FieldType.Integer)
    Integer orgId;

    @Field(name = "appId", type = FieldType.Integer)
    Integer appId;

    @Field(name = "deleteStatus", type = FieldType.Integer)
    Integer deleteStatus;

    @Field(name = "showStatus", type = FieldType.Integer)
    Integer showStatus;



}
