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
@Document(indexName = "course_period_price", shards = 3, replicas = 0, refreshInterval = "5s")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoursePeriodPriceElasticSearchIndex implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    private String id;

    @Field(name = "courseId", type = FieldType.Integer)
    private Integer courseId;

    @Field(name = "billingMethod", type = FieldType.Integer)
    private Integer billingMethod;

    @Field(name = "totalClassHour", type = FieldType.Double)
    private Double totalClassHour;


    @Field(name = "classPeriodClassHour", type = FieldType.Double)
    private Double classPeriodClassHour;

    @Field(name = "classHours", type = FieldType.Integer)
    private Integer classHours;


    @Field(name = "classHourPrice", type = FieldType.Double)
    private Double classHourPrice;

    @Field(name = "totalClassPeriod", type = FieldType.Integer)
    private Integer totalClassPeriod;


    @Field(name = "totalPrice", type = FieldType.Double)
    private Double totalPrice;

}
