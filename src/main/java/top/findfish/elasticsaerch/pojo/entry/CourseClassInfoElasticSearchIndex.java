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

@Document(indexName = "course_class_info", shards = 3, replicas = 0, refreshInterval = "5s")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseClassInfoElasticSearchIndex implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    @Field(type = FieldType.Text)
    String id;

    @Field(value = "className", type = FieldType.Text, analyzer = "ik_max_word")
    String className;

    @Field(value = "courseId", type = FieldType.Integer)
    Integer courseId;

    @Field(value = "deleteStatus", type = FieldType.Integer)
    Integer deleteStatus;

    @Field(value = "courseType", type = FieldType.Integer)
    Integer courseType;

    @Field(value = "totalPrice", type = FieldType.Double)
     Double totalPrice;

//    上课状态 0：未上课，1：上课中，2：已结课
    @Field(value = "classStatus", type = FieldType.Integer)
    Integer classStatus;

    @Field(value = "totalClassHour", type = FieldType.Double)
    Double totalClassHour;

    //开课后是否继续售卖 0：否 1：是
    @Field(value = "continueSell", type = FieldType.Integer)
    Integer continueSell;

}