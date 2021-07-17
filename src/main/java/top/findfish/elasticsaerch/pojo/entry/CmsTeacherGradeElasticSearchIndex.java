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
 * @date 2020/9/19 9:11
 * @Description:
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "cms_teacher_grade", shards = 3, replicas = 0, refreshInterval = "5s")
public class CmsTeacherGradeElasticSearchIndex implements Serializable {

    private static final long serialVersionUID = -3336137680600782800L;

    @Id
    @Field(type = FieldType.Text)
    String id;

    @Field(value = "cmsTeacherId",type = FieldType.Integer)
    Integer cmsTeacherId;

    @Field(value = "treeGradeCode",type = FieldType.Keyword)
    String treeGradeCode;

    @Field(value = "teacherId",type = FieldType.Integer)
    Integer teacherId;

    @Field(value = "ownerId",type = FieldType.Integer)
    Integer ownerId;

    @Field(value = "deleteStatus",type = FieldType.Integer)
    Integer deleteStatus;


}
