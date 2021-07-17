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


@Document(indexName = "relation", shards = 3, replicas = 0, refreshInterval = "5s")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ESRelation implements Serializable {


    private static final long serialVersionUID = -1L;

    @Id
    @Field(type = FieldType.Long)
    private Long id;

    @Field(type = FieldType.Integer)
//    @Field(value = "spu_id")
    private Integer spu_id;

//    @Field(value = "teacher_id",searchAnalyzer = "ik_max_word", analyzer = "ik_max_word", store = true)
    @Field(type = FieldType.Integer)
    private Integer teacher_id;

}
