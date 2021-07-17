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
 * @Description: course_period_price
 * @Title: coursePeriodPriceElasticSearchIndex
 * @Package top.findfish.elasticsaerch.pojo.entry
 * @Author: libbytian
 * @Copyright 版权归新文达教育 企业（或个人）所有
 * @CreateTime: 2021/7/13 16:49
 */
@Document(indexName = "course_class_period_info", shards = 3, replicas = 0, refreshInterval = "5s")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseClassPeriodInfoElasticSearchIndex implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    private String id;

    @Field(name = "coursePeriodId", type = FieldType.Integer)
    private Integer coursePeriodId;

    @Field(name = "classId", type = FieldType.Integer)
    private Integer classId;

    @Field(name = "classPeriodName", type = FieldType.Text)
    private String classPeriodName;

    @Field(name = "classPeriodDetail", type = FieldType.Keyword)
    private String classPeriodDetail;


    @Field(name = "deleteStatus", type = FieldType.Integer)
    private Integer deleteStatus;

}
