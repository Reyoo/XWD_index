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
 * @Description:
 * @Title: Findfish
 * @Package top.findfish.elasticsaerch.pojo.entry
 * @Author: libbytian
 * @Copyright 版权归新文达教育 企业（或个人）所有
 * @CreateTime: 2021/5/13 19:01
 */
@Document(indexName = "teacher_table", shards = 3, replicas = 0, refreshInterval = "5s")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherElasticSearchIndex implements Serializable {

      private static final long serialVersionUID = -1L;

    @Id
    @Field(type = FieldType.Long)
    private Long id;

    /**
     * 上一个版本用的user_name  这里为不影响之前API涉及到的业务代码，不做改动
     */
    @Field(name = "teacherName",type = FieldType.Keyword)
    private String teacherName;

    /**
     * 上一个版本用的image_photo  这里为不影响之前API涉及到的业务代码，不做改动
     */
    @Field(name = "image",type = FieldType.Text)
    private String image;

    @Field(name = "sex",type = FieldType.Text)
    private String sex;

    @Field(name = "deptId",type = FieldType.Integer)
    private Integer deptId;



    @Field(name = "education",type =FieldType.Text )
    private String education;

    @Field(name = "graduationSchool",type =FieldType.Text )
    private String graduationSchool;

    @Field(name = "teachingYears",type =FieldType.Text )
    private String teachingYears;

    @Field(name = "teacherQualification",type =FieldType.Text )
    private String teacherQualification;

    @Field(name = "personalIntroduction",type =FieldType.Text )
    private String personalIntroduction;

    @Field(name = "teacherStyle",type =FieldType.Text )
    private String teacherStyle;

    @Field(name = "deleteStatus",type =FieldType.Keyword )
    private String deleteStatus;



//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
//    private String employeeId;
//
//
//
//    @Field(type = FieldType.Integer)
//    private Integer jobType;
//
//
//
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
//    private String jobNumber;
//
//    /**
//     * 手机号
//     */
//    @Field(type = FieldType.Text, analyzer = "ik_smart")
//    private String phone;
//
//    /**
//     * 部门ID
//     */
//    @Field(type = FieldType.Integer)
//    private Integer deptId;
//
//    @Field(type = FieldType.Text )
//    private String orgName;
//
//    /**
//     * 职位
//     */
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
//    private String position;
//
//
//    /**
//     * 学历 1： 本科 2： 硕士  3：博士
//     */
//    @Field(type = FieldType.Integer)
//    private Integer education;
//
//    @Field(type = FieldType.Text, analyzer = "ik_smart")
//    private String graduationSchool;
//
//
//    /**
//     * 教师级别 1：三星教师 2：四星教师 3：五星教师
//     */
//    @Field(type = FieldType.Text )
//    private String teacherType;
//
//    //    状态 0：在职 1：离职
//    @Field(type = FieldType.Integer)
//    private Integer status;
//
//;
//
//    /**
//     * 教龄
//     */
//    @Field(type = FieldType.Text )
//    private String teachingYears;
//
//
//    @Field(type = FieldType.Text )
//    private String headImage;
//
//    /**
//     * 教师资格证
//     */
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
//    private String teacherQualification;
//
//    /**
//     * 个人介绍
//     */
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
//    private String personalIntroduction;
//
//    /**
//     * 授课风格
//     */
//    @Field(type = FieldType.Text, analyzer = "ik_smart")
//    private String teacherStyle;
//
//    /**
//     * 教师编号
//     */
//    @Field(type = FieldType.Text)
//    private String teacherNum;
//
//
//    /**
//     * 用户名
//     */
//    @Field(type = FieldType.Text)
//    String name;
//    @Field(type = FieldType.Text)
//    String engName;
//    @Field(type = FieldType.Text)
//    String crossCampus;
//    @Field(type = FieldType.Date)
//    String birthday;
//    @Field(type = FieldType.Date)
//    String email;
//    @Field(type = FieldType.Date)
//    String entryTime;
//    @Field(type = FieldType.Date)
//    String departureTime;
//    @Field(type = FieldType.Integer)
//    String enableDisable;
//    @Field(type = FieldType.Integer)
//    String leader;
//    /**
//     * 从业经历
//     */
//    @Field(type = FieldType.Integer)
//    String workingexperience;
//    /**
//     * 擅长领域和个人品牌定位
//     */
//    @Field(type = FieldType.Text)
//    String goodAreabrandPositioning;
//    @Field(type = FieldType.Text)
//    String tiktokName;
//    @Field(type = FieldType.Text)
//    String wechatName;
//    @Field(type = FieldType.Text)
//    String microblogName;
//    @Field(type = FieldType.Text)
//    String remark;
//    @Field(type = FieldType.Integer)
//    String orgId;
//    @Field(type = FieldType.Integer)
//    String appId;
//    /**
//     * 删除状态 0：未删除 1：已删除
//     */
//    @Field(type = FieldType.Integer)
//    String deleteStatus;
//    @Field(type = FieldType.Date,format = DateFormat.date_hour_minute_second_fraction,ignoreMalformed = true)
//    String createTime;
//    @Field(type = FieldType.Integer)
//    String createUserId;
//    @Field(type = FieldType.Date,format = DateFormat.date_hour_minute_second_fraction,ignoreMalformed = true)
//    String updateTime;
//    @Field(type = FieldType.Integer)
//    Integer updateUserId;
//    @Field(type = FieldType.Integer)
//    Integer whetherTeacher;
//    @Field(type = FieldType.Integer)
//    Integer whetherHeadmaster;
//    @Field(type = FieldType.Integer)
//    Integer manageTeacher;



}
