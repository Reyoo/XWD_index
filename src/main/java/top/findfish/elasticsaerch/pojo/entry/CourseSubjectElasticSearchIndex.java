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
 * @Title: CourseSubjectElasticSearchIndex
 * @Package top.findfish.elasticsaerch.pojo.entry
 * @Author: libbytian
 * @Copyright 版权归新文达教育 企业（或个人）所有
 * @CreateTime: 2021/7/29 9:45
 */

@Document(indexName = "course_subject", shards = 3, replicas = 0, refreshInterval = "5s")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseSubjectElasticSearchIndex implements Serializable {


    private static final long serialVersionUID = -1L;

    @Id
    private String id;

    @Field(name = "course_id", type = FieldType.Integer)
    private Integer course_id;

    @Field(name = "tree_subject_code", type = FieldType.Integer)
    private Integer tree_subject_code;


}
