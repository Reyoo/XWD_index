package top.findfish.elasticsaerch.pojo.entry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Description: sku_info
 * @Title: ProductSkuElasticSearchIndex
 * @Package top.findfish.elasticsaerch.pojo.entry
 * @Author: libbytian
 * @Copyright 版权归新文达教育 企业（或个人）所有
 * @CreateTime: 2021/6/20 16:16
 */


@Document(indexName = "product_sku", shards = 3, replicas = 0, refreshInterval = "5s")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSkuElasticSearchIndex implements Serializable {

    private static final long serialVersionUID = -1;

    @Id
    @Field(type = FieldType.Text)
    String id;

    @Field(name = "courseSpuId", type = FieldType.Integer)
    Integer courseSpuId;

    @Field(name = "courseSkuName", type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    String courseSkuName;

    @Field(name = "classId", type = FieldType.Integer)
    Integer classId;

    @Field(name = "campusId", type = FieldType.Integer)
    Integer campusId;

    @Field(name = "additionalGradeId", type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    String additionalGradeId;

    @Field(name = "additionalSubjectId", type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    String additionalSubjectId;

    @Field(name = "courseLevelCode", type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    String courseLevelCode;

    @Field(name = "classType", type = FieldType.Integer)
    Integer classType;

    @Field(name = "startTime", type = FieldType.Date, format = DateFormat.date_hour_minute_second_fraction, ignoreMalformed = true)
    LocalDateTime startTime;

    @Field(name = "teacherId", type = FieldType.Integer)
    Integer teacherId;

    @Field(name = "handout", type = FieldType.Integer)
    Integer handout;

    @Field(name = "totalClass", type = FieldType.Integer)
    Integer totalClass;

    @Field(name = "finishClass", type = FieldType.Integer)
    Integer finishClass;

    @Field(name = "courseType", type = FieldType.Integer)
    Integer courseType;

    @Field(name = "teachType", type = FieldType.Integer)
    Integer teachType;

    @Field(name = "saleOnStartCourse", type = FieldType.Integer)
    Integer saleOnStartCourse;

    @Field(name = "joinCouponBool", type = FieldType.Integer)
    Integer joinCouponBool;

    @Field(name = "underlinePrice", type = FieldType.Double)
    BigDecimal underlinePrice;

    @Field(name = "price", type = FieldType.Double)
    BigDecimal price;

    @Field(name = "costPrice", type = FieldType.Double)
    BigDecimal costPrice;

    @Field(name = "incidental", type = FieldType.Double)
    BigDecimal incidental;

    @Field(name = "unitPrice", type = FieldType.Double)
    BigDecimal unitPrice;

    @Field(name = "whetherPlaybackCharge", type = FieldType.Integer)
    Integer whetherPlaybackCharge;

    @Field(name = "playbackPrice", type = FieldType.Double)
    BigDecimal playbackPrice;

    @Field(name = "currencyDictCode", type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    String currencyDictCode;

    @Field(name = "courseTime", type = FieldType.Double)
    Double courseTime;

    @Field(name = "status", type = FieldType.Integer)
    Integer status;

    @Field(name = "groundingTime", type = FieldType.Date, format = DateFormat.date_hour_minute_second_fraction, ignoreMalformed = true)
    LocalDateTime groundingTime;

    @Field(name = "undercarriageTime", type = FieldType.Date, format = DateFormat.date_hour_minute_second_fraction, ignoreMalformed = true)
    LocalDateTime undercarriageTime;

    @Field(name = "skuLabel", type = FieldType.Integer)
    Integer skuLabel;

    @Field(name = "orgId", type = FieldType.Integer)
    Integer orgId;

    @Field(name = "appId", type = FieldType.Integer)
    Integer appId;

    @Field(name = "deleteStatus", type = FieldType.Integer)
    Integer deleteStatus;

    @Field(name = "createUserId", type = FieldType.Integer)
    Integer createUserId;

    @Field(name = "createTime", type = FieldType.Date, format = DateFormat.date_hour_minute_second_fraction, ignoreMalformed = true)
    LocalDateTime createTime;

    @Field(name = "updateUserId", type = FieldType.Integer)
    Integer updateUserId;

    @Field(name = "updateTime", type = FieldType.Date, format = DateFormat.date_hour_minute_second_fraction, ignoreMalformed = true)
    LocalDateTime updateTime;

    @Field(name = "deptId", type = FieldType.Integer)
    Integer deptId;


}
