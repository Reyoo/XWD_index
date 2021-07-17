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
 * @Title: ESCourseCampus
 * @Package com.xwd.elasticsearch.searchEntity
 * @Author: libbytian
 * @Copyright 版权归新文达教育 企业（或个人）所有
 * @CreateTime: 2021/6/29 22:04
 */



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "course_campus", shards = 3, replicas = 0, refreshInterval = "5s")
public class ESCourseCampus implements Serializable {

    private static final long serialVersionUID = -1L;
    @Id
    @Field(type = FieldType.Text)
    String id;
    @Field(name = "courseId",type = FieldType.Integer)
    Integer courseId;
    @Field(name = "campusId",type = FieldType.Integer)
    Integer campusId;
    @Field(name = "deptId",type = FieldType.Integer)
    Integer deptId;
    @Field(name = "orgId",type = FieldType.Integer)
    Integer orgId;

}