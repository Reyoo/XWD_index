package top.findfish.elasticsaerch.pojo.entry;

import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2RTFDTM;
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
@Document(indexName = "cms_teacher_show_column", shards = 3, replicas = 0, refreshInterval = "5s")
public class CmsTeacherShowColumnElasticSearchIndex implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    @Field(type = FieldType.Text)
    String id;

    @Field(value = "cmsTeacherId",type = FieldType.Integer)
    Integer cmsTeacherId;

    @Field(value = "showLocation",type = FieldType.Integer)
    Integer showLocation;
    
    @Field(value = "columnId",type = FieldType.Integer)
    Integer columnId;

    @Field(value = "agencyId",type = FieldType.Keyword)
    String agencyId;

    @Field(value = "showOrder",type = FieldType.Integer)
    Integer showOrder;

    @Field(value = "appId",type = FieldType.Integer)
    Integer appId;

    @Field(value = "orgId",type = FieldType.Integer)
    Integer orgId;

    @Field(value = "deleteStatus",type = FieldType.Integer)
    Integer deleteStatus;

}
