package top.findfish.elasticsaerch.pojo.entry;

/**
 * @Description:
 * @Title: ProductSpu
 * @Package top.findfish.elasticsaerch.pojo.entry
 * @Author: libbytian
 * @Copyright 版权归新文达教育 企业（或个人）所有
 * @CreateTime: 2021/6/11 9:01
 */


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
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Description:
 * @Title: Findfish
 * @Package top.findfish.elasticsaerch.pojo.entry
 * @Author: libbytian
 * @Copyright 版权归新文达教育 企业（或个人）所有
 * @CreateTime: 2021/5/13 19:01
 */
@Document(indexName = "product", shards = 3, replicas = 0, refreshInterval = "5s")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSpu implements Serializable {

    private static final long serialVersionUID = -1;

    @Id
    @Field(type = FieldType.Text)
    private String id;

    @Field(name = "storeId",type = FieldType.Integer)
    Integer storeId;

    @Field(name = "sellerId",type = FieldType.Integer)
    Integer sellerId;

    @Field(name = "courseId",type = FieldType.Integer)
    Integer courseId;

    @Field(index = true ,name = "courseName",type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
//    @Field(name = "courseName",type = FieldType.Text)
    String courseName;

    @Field(name = "handout",type = FieldType.Integer)
    String handout;

    @Field(name = "priceInfo",type = FieldType.Text)
    String priceInfo;

    @Field(name = "courseTimesText",type = FieldType.Text)
    String courseTimesText;

    @Field(name = "campus",type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    String campus;

    @Field(name = "grade",type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    String grade;

    @Field(name = "useDay",type = FieldType.Integer)
    Integer useDay;

    @Field(name = "effectiveUnit",type = FieldType.Integer)
    Integer effectiveUnit;

    @Field(name = "effectiveDate",type = FieldType.Text)
    String effectiveDate;

    @Field(name = "subject",type = FieldType.Text)
    String subject;

    @Field(name = "price",type = FieldType.Double)
    BigDecimal price;

    @Field(name = "currencyDictCode",type = FieldType.Text)
    String currencyDictCode;

    @Field(name = "salesVolume",type = FieldType.Integer)
    Integer salesVolume;

    @Field(name = "enableStatus",type = FieldType.Integer)
    Integer enableStatus;

    @Field(name = "courseSource",type = FieldType.Integer)
    Integer courseSource;

    @Field(name = "courseType",type = FieldType.Integer)
    Integer courseType;

    @Field(name = "additionalType",type = FieldType.Integer)
    Integer additionalType;

    @Field(name = "teachType",type = FieldType.Integer)
    Integer teachType;

    @Field(name = "coursePic",type = FieldType.Text)
    String coursePic;

    @Field(name = "popPic",type = FieldType.Text)
    String popPic;

    @Field(name = "content",type = FieldType.Text)
    String content;

    @Field(name = "courseDetails",type = FieldType.Text)
    String courseDetails;

    @Field(name = "grounding",type = FieldType.Date,format = DateFormat.date_hour_minute_second_fraction,ignoreMalformed = true)
    LocalDateTime grounding;

    @Field(name = "undercarriage",type = FieldType.Date,format = DateFormat.date_hour_minute_second_fraction,ignoreMalformed = true)
    LocalDateTime undercarriage;

    @Field(name = "groundingTime",type = FieldType.Date,format = DateFormat.date_hour_minute_second_fraction,ignoreMalformed = true)
    LocalDateTime groundingTime;

    @Field(name = "undercarriageTime",type = FieldType.Date,format = DateFormat.date_hour_minute_second_fraction,ignoreMalformed = true)
    LocalDateTime undercarriageTime;

    @Field(name = "courseSync", type = FieldType.Integer)
    Integer courseSync;

    @Field(name = "priceSync",type = FieldType.Integer)
    Integer priceSync;

    @Field(name = "onSaleStatus",type = FieldType.Keyword)
    String onSaleStatus;

    @Field(name = "checkStatus",type = FieldType.Keyword)
    String checkStatus;

    @Field(name = "orgId",type = FieldType.Integer)
    Integer orgId;

    @Field(name = "appId",type = FieldType.Integer)
    Integer appId;

    @Field(name = "deleteStatus",type = FieldType.Keyword)
    String deleteStatus;

    @Field(name = "createUserId",type = FieldType.Integer)
    Integer createUserId;

    @Field(name = "createTime",type = FieldType.Date,format = DateFormat.date_hour_minute_second_fraction,ignoreMalformed = true)
    String createTime;

    @Field(name = "updateUserId",type = FieldType.Integer)
    Integer updateUserId;

    @Field(name = "updateTime",type = FieldType.Date,format = DateFormat.date_hour_minute_second_fraction,ignoreMalformed = true)
    String updateTime;

    @Field(name = "recommendValue",type = FieldType.Integer)
    Integer recommendValue;



}
