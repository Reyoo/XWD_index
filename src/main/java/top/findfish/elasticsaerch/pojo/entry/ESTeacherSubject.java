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


@Document(indexName = "subject", shards = 3, replicas = 0, refreshInterval = "5s")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ESTeacherSubject implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String id;

    @Field(name = "teacherId",type = FieldType.Integer)
    private Integer teacherId;

    @Field(name = "subjectCode",type = FieldType.Integer)
    private Integer subjectCode;

    @Field(name = "createTime",type = FieldType.Date,format = DateFormat.date_hour_minute_second_fraction,ignoreMalformed = true)
    private LocalDateTime createTime;
}
