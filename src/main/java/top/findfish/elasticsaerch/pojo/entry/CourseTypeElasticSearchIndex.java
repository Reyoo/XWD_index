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
 * @Description:
 * @Title: CourseType
 * @Package top.findfish.elasticsaerch.pojo.entry
 * @Author: libbytian
 * @Copyright 版权归新文达教育 企业（或个人）所有
 * @CreateTime: 2021/6/11 15:55
 */

@Document(indexName = "coursetype", shards = 3, replicas = 0, refreshInterval = "5s")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseTypeElasticSearchIndex implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    @Field(type = FieldType.Text)
    String id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    String main_code;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    String dict_code;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    String dict_value;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    String remark;
    @Field(type = FieldType.Integer)
    Integer order;
    @Field(type = FieldType.Integer)
    Integer status;
    @Field(type = FieldType.Integer)
    Integer org_id;
    @Field(type = FieldType.Integer)
    Integer delete_status;

    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second_fraction, ignoreMalformed = true)
    LocalDateTime create_time;
    @Field(type = FieldType.Integer)
    Integer create_user_id;

    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second_fraction, ignoreMalformed = true)
    LocalDateTime update_time;
    @Field(type = FieldType.Integer)
    Integer update_user_id;


}