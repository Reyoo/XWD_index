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
@Document(indexName = "product_international_subject_label", shards = 3, replicas = 0, refreshInterval = "5s")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInternationSubjectLabelElasticSearchIndex implements Serializable {

    private static final long serialVersionUID = -1;

    @Id
    @Field(type = FieldType.Text)
    private String id;

    @Field(name = "labelName",type = FieldType.Keyword)
    String labelName;

    @Field(name = "order",type = FieldType.Integer)
    Integer order;

    @Field(name = "subjectId",type = FieldType.Integer)
    Integer subjectId;

    @Field(name = "selectId",type = FieldType.Integer)
    Integer selectId;

    @Field(name = "deleteStatus",type = FieldType.Integer)
    Integer deleteStatus;


}
