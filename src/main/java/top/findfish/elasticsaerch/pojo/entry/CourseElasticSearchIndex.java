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

@Document(indexName = "course", shards = 3, replicas = 0, refreshInterval = "5s")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseElasticSearchIndex implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    @Field(type = FieldType.Text)
    String id;

    @Field(name = "deptId",type = FieldType.Integer)
    Integer deptId;

    @Field(name = "courseName",type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    String courseName;

    @Field(name = "courseType",type = FieldType.Integer)
    Integer courseType;

    @Field(name = "courseYear",type = FieldType.Integer)
    Integer courseYear;

    @Field(name = "courseQuarter",type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    String courseQuarter;

    @Field(name = "effectiveDate",type = FieldType.Date, format = DateFormat.date_hour_minute_second_fraction, ignoreMalformed = true)
    LocalDateTime effectiveDate;

    @Field(name = "effectiveDateEnd",type = FieldType.Date, format = DateFormat.date_hour_minute_second_fraction, ignoreMalformed = true)
    LocalDateTime effectiveDateEnd;

    @Field(name = "extendClassHour",type = FieldType.Integer)
    Integer extendClassHour;

    @Field(type = FieldType.Integer)
    Integer handout;

    @Field(name = "courseClassify",type = FieldType.Text, analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    String courseClassify;

    @Field(name = "projectClassify",type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    String projectClassify;

    @Field(name = "courseDetails",type = FieldType.Text, analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    String courseDetails;

    @Field(name = "enableStatus",type = FieldType.Integer)
    Integer enableStatus;

    @Field(name = "allowChangeUnitPrice",type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    String allowChangeUnitPrice;

    @Field(name = "allowChangeTotalNum",type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    String allowChangeTotalNum;

    @Field(name = "allowChangeUnitLessonMuntine",type = FieldType.Text, analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    String allowChangeUnitLessonMuntine;

    @Field(name = "deductionMode",type = FieldType.Integer)
    Integer deductionMode;
    @Field(name = "courseRemarks",type = FieldType.Text, analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    String courseRemarks;

    @Field(name = "courseTypeLabel",type = FieldType.Text, analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    String courseTypeLabel;

    @Field(name = "courseSource",type = FieldType.Integer)
    Integer courseSource;
    @Field(name = "orgId",type = FieldType.Integer)
    Integer orgId;
    @Field(name = "appId",type = FieldType.Integer)
    Integer appId;
    @Field(name = "deleteStatus",type = FieldType.Integer)
    Integer deleteStatus;
    @Field(name = "createUserId",type = FieldType.Integer)
    Integer createUserId;
    @Field(name = "createTime",type = FieldType.Date,format = DateFormat.date_hour_minute_second_fraction, ignoreMalformed = true)
    LocalDateTime createTime;
    @Field(name = "updateUserId",type = FieldType.Integer)
    Integer updateUserId;

    @Field(name = "updateTime",type = FieldType.Date,format = DateFormat.date_hour_minute_second_fraction,ignoreMalformed = true)
    LocalDateTime updateTime;


}