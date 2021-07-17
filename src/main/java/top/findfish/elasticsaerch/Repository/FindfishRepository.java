package top.findfish.elasticsaerch.Repository;
import org.springframework.data.repository.CrudRepository;
import top.findfish.elasticsaerch.pojo.entry.TeacherElasticSearchIndex;

/**
 * @Description:
 * @Title: Findfish
 * @Package top.findfish.elasticsaerch.pojo.entry
 * @Author: libbytian
 * @Copyright 版权归新文达教育 企业（或个人）所有
 * @CreateTime: 2021/5/13 19:01
 */

public interface FindfishRepository  extends CrudRepository<TeacherElasticSearchIndex, String>  {


}

