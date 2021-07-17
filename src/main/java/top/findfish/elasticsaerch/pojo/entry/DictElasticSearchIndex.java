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
 * @date 2020/9/21 16:01
 * @Description:
 */

@Document(indexName = "dict", shards = 3, replicas = 0, refreshInterval = "5s")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DictElasticSearchIndex implements Serializable {


    private static final long serialVersionUID = -1L;


    @Id
    @Field(type = FieldType.Text)
    String id;
    @Field(type = FieldType.Integer)
    Integer parent_id;
    @Field(type = FieldType.Text)
    String main_code;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    String main_name;
    @Field(name = "dictCode",type = FieldType.Text,analyzer = "ik_max_word")
    String dict_code;
    @Field(name = "dictValue",type = FieldType.Text)
    String dict_value;
    @Field(type = FieldType.Integer)
    Integer order;
    @Field(type = FieldType.Text)
    String remake;
    @Field(name = "userStatus",type = FieldType.Integer)
    Integer userStatus;
    @Field(type = FieldType.Integer)
    Integer type;
    @Field(type = FieldType.Integer)
    Integer delete_status;
    @Field(type = FieldType.Integer)
    Integer org_id;
    @Field(type = FieldType.Integer)
    Integer app_id;

}
