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
 * @author Admin
 */
@Document(indexName = "product_international_label_relation", shards = 3, replicas = 0, refreshInterval = "5s")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInternationLabelRelationElasticSearchIndex implements Serializable {

    private static final long serialVersionUID = -1;

    @Id
    @Field(type = FieldType.Text)
    private String id;

    @Field(name = "spuId",type = FieldType.Integer)
    Integer spuId;

    @Field(name = "lableId",type = FieldType.Integer)
    Integer lableId;

    @Field(name = "deleteStatus",type = FieldType.Integer)
    Integer deleteStatus;

}
