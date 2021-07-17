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
 * @author cyy
 * @date 2020/9/21 15:57
 * @Description:
 */


@Document(indexName = "cms_teacher", shards = 3, replicas = 0, refreshInterval = "5s")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CmsTeacherElasticSearchIndex implements Serializable {


    private static final long serialVersionUID = -1L;

    @Id
    @Field(type = FieldType.Text)
    String id;

    @Field(value = "teacherId",type = FieldType.Integer)
    Integer teacherId;

    @Field(value = "education",type = FieldType.Keyword)
    String education;

    @Field(value = "graduationSchool")
    String graduationSchool;

    @Field(value = "imagePhoto")
    String imagePhoto;

    @Field(value = "teachingYears")
    String teachingYears;

    @Field(value = "personalIntroduction")
    String personalIntroduction;

    @Field(value = "teacherStyle")
    String teacherStyle;

    @Field(value = "remark")
    String remark;

    @Field(name = "orgId", type = FieldType.Integer)
    Integer orgId;
    @Field(name = "appId", type = FieldType.Integer)
    Integer appId;

    @Field(name = "deleteStatus", type = FieldType.Keyword)
    String deleteStatus;

    @Field(name = "createUserId", type = FieldType.Integer)
    Integer createUserId;

    @Field(name = "createTime", type = FieldType.Date, format = DateFormat.date_hour_minute_second_fraction, ignoreMalformed = true)
    LocalDateTime createTime;

    @Field(name = "updateUserId", type = FieldType.Integer)
    Integer updateUserId;

    @Field(name = "updateTime", type = FieldType.Date, format = DateFormat.date_hour_minute_second_fraction, ignoreMalformed = true)
    LocalDateTime updateTime;

    @Field(value = "showOrder",type = FieldType.Integer)
    Integer showOrder;

    @Field(value = "tapcode",type = FieldType.Integer)
    Integer tapcode;

    @Field(value = "agencyId",type = FieldType.Keyword)
    String agencyId;

    @Field(value = "ownerId" ,type = FieldType.Integer)
    Integer ownerId;

    @Field(value = "whetherTeacher" ,type = FieldType.Integer)
    Integer whetherTeacher;

    @Field(value = "whetherHeadmaster" ,type = FieldType.Integer)
    Integer whetherHeadmaster;

    @Field(value = "manageTeacher" ,type = FieldType.Integer)
    Integer manageTeacher;

    @Field(value = "teacherType" ,type = FieldType.Keyword)
    String teacherType;

    @Field(value = "teacherQualification",type = FieldType.Keyword)
    String teacherQualification;

}
