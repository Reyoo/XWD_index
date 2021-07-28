package top.findfish.elasticsaerch;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;

import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.*;

import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.document.Document;
import top.findfish.elasticsaerch.Repository.FindfishRepository;
import top.findfish.elasticsaerch.pojo.entry.*;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@SpringBootTest
@Slf4j
class ElasticsearchApplicationTests {

    @Autowired
    RestHighLevelClient highLevelClient;

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;


    @Autowired
    FindfishRepository findfishRepository;


    @Test
    void contextLoads() throws IOException {

//        initIndex(TeacherElasticSearchIndex.class);
        initIndex(ResouceCampusElasticSearchIndex.class);
        initIndex(ResouceCampusLocationElasticSearchIndex.class);
        initIndex(CmsTeacherShowColumnElasticSearchIndex.class);
        initIndex(ProductInternationSubjectRelationElasticSearchIndex.class);
        initIndex(ProductInternationLabelRelationElasticSearchIndex.class);
        initIndex(ProductInternationSubjectLabelElasticSearchIndex.class);
        initIndex(ESCourseCampus.class);
        initIndex(CmsTeacherElasticSearchIndex.class);

        initIndex(CourseClassInfoElasticSearchIndex.class);

        initIndex(ProductSkuElasticSearchIndex.class);
        initIndex(CourseElasticSearchIndex.class);
        initIndex(CmsTeacherGradeElasticSearchIndex.class);

        initIndex(CmsTeacherLabelRelationElasticSearchIndex.class);
        initIndex(TeacherGradeElasticSearchIndex.class);
        initIndex(CourseTypeElasticSearchIndex.class);

        initIndex(DictElasticSearchIndex.class);
        initIndex(ESRelation.class);
        initIndex(ESTeacherSubject.class);

        initIndex(ProductSpu.class);
        initIndex(ProductSpuStyleElasticSearchIndex.class);
        initIndex(CourseGradeElasticSearchIndex.class);

        initIndex(CoursePeriodPriceElasticSearchIndex.class);
        initIndex(CoursePeriodInfoElasticSearchIndex.class);
        initIndex(CourseClassPeriodInfoElasticSearchIndex.class);

    }

    void initIndex(Class<?> object) {
        IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(object);
        indexOperations.create();
        Document document = indexOperations.createMapping(object);
        indexOperations.putMapping(document);
        Map<String, Object> objectMap = indexOperations.getMapping();
        System.out.println(objectMap.size());
    }


    @Test
    void create_index() throws IOException {
        IndexRequest indexRequest = new IndexRequest("product");
//        Findfish blog = Findfish.builder().teacherId(3L).user_name("我是中国人").employee_id("3").build();
//        indexRequest.source(JSON.toJSONString(blog), XContentType.JSON);
//        indexRequest.timeout("1s");
        IndexResponse indexResponse = highLevelClient.index(indexRequest,
                RequestOptions.DEFAULT);
        log.info(indexResponse.getResult().toString());

    }


    /**
     * 精确查询termQuery
     *
     * @throws IOException
     */
    @Test
    void termQuery() throws IOException {
//        SearchRequest searchRequest = new SearchRequest("teacher");
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
////        sourceBuilder.query(QueryBuilders.termQuery("user_name", "毛"));
//        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("user_name","Ada");
//        sourceBuilder.query(termQueryBuilder);
//        searchRequest.source(sourceBuilder);
//        SearchResponse searchResponse = highLevelClient.
//                search(searchRequest, RequestOptions.DEFAULT);
//        System.out.println(searchResponse.getHits().getHits().length);


        SearchRequest searchRequest = new SearchRequest("teacher");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery("user_name", "桂鸣涧"));
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(searchResponse.getHits().getHits().length);
        searchResponse.getHits().forEach(res -> {
            log.info(res.toString());
        });

    }

    @Test
    void teacherGradeQuery() throws IOException {

        String teacherId = "306";
        String gradeCode = "41";
        try {
            SearchRequest searchRequest = new SearchRequest("teacher_grade");
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
            boolBuilder.must(QueryBuilders.termQuery("teacherId", teacherId));
            boolBuilder.must(QueryBuilders.termQuery("gradeCode", gradeCode));
            searchSourceBuilder.query(boolBuilder);
            searchRequest.source(searchSourceBuilder);
            SearchResponse searchResponse = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            if (searchResponse.getHits().getHits().length != 0) {
                for (SearchHit searchHit : searchResponse.getHits()) {
                    searchHit.getSourceAsMap();
                    log.info(String.valueOf(searchHit.getSourceAsMap()));
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }


    /**
     * 模糊查询matchQuery
     *
     * @throws IOException
     */

    @Test
    void matchQuery() throws IOException {
        SearchRequest searchRequest = new SearchRequest("teacher");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.from(0);
        sourceBuilder.size(1000);
//        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("user_name", "张二").analyzer("ik_max_word");
//        sourceBuilder.query(matchQueryBuilder);
        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = highLevelClient
                .search(searchRequest, RequestOptions.DEFAULT);
        searchResponse.getHits().forEach(res -> {
            log.info(res.toString());


        });
    }

    /**
     * 多个索引联合查询
     *
     * @throws IOException
     */
    @Test
    void muiltymatchQuery() throws IOException {
        SearchRequest searchRequest = new SearchRequest("product");

//        MatchPhrasePrefixQueryBuilder matchPhrasePrefixQueryBuilder = new MatchPhrasePrefixQueryBuilder("courseName","高一数学");
//        matchPhrasePrefixQueryBuilder.analyzer("ik_smart");
//        matchPhrasePrefixQueryBuilder.slop(1);

        MatchQueryBuilder matchQueryBuilder   = new MatchQueryBuilder("courseName","高一数学");
//        matchQueryBuilder.analyzer("standard");
//        matchQueryBuilder.analyzer("standard");



        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(9999);
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
//        boolBuilder.must(matchPhrasePrefixQueryBuilder);
        boolBuilder.must(matchQueryBuilder);
//        boolBuilder.must(QueryBuilders.matchQuery("courseName","高一数学"));
//        boolBuilder.must(QueryBuilders.termQuery("deleteStatus", BigDecimal.ZERO.intValue()));
//        boolBuilder.must(QueryBuilders.termQuery("onSaleStatus", BigDecimal.ONE.intValue()));

//        TermQueryBuilder termQueryBuilder  =QueryBuilders.termQuery("courseName", "高二数学寒假直播班");
        searchSourceBuilder.query(boolBuilder);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        for(SearchHit searchHit : searchResponse.getHits()){
            log.info(searchHit.getSourceAsMap().toString());
        }

//
    }


    /**
     * 商品匹配平台
     *
     * @throws IOException
     */
    @Test
    void matchPlatform() throws IOException {

        String scrollStr  = "FGluY2x1ZGVfY29udGV4dF91dWlkDnF1ZXJ5VGhlbkZldGNoAxRmcnhLZEhvQnM1RWFPX1pxNWZzTgAAAAAAIsgrFjJQVFg5clpfUkRlVXhHak1RcVFZYlEUZjd4S2RIb0JzNUVhT19acTVmc04AAAAAACLILBYyUFRYOXJaX1JEZVV4R2pNUXFRWWJRFGdMeEtkSG9CczVFYU9fWnE1ZnNOAAAAAAAiyC0WMlBUWDlyWl9SRGVVeEdqTVFxUVliUQ==";

        if(scrollStr !=null){
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.size(9);
            SearchRequest searchRequest = new SearchRequest("product");
            SearchScrollRequest searchScrollRequest = new SearchScrollRequest(scrollStr);

            BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
            boolBuilder.must(QueryBuilders.termQuery("deleteStatus", BigDecimal.ZERO.intValue()));
            boolBuilder.must(QueryBuilders.termQuery("onSaleStatus", BigDecimal.ONE.intValue()));
            searchSourceBuilder.query(boolBuilder);
            searchRequest.source(searchSourceBuilder);
            SearchResponse searchResponse = highLevelClient.scroll(searchScrollRequest, RequestOptions.DEFAULT);

        }else {

        }


        SearchRequest searchRequest = new SearchRequest("product");
        //设置滚动对象，并设置游标过期时间
        Scroll scroll = new Scroll(TimeValue.timeValueSeconds(60));

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchRequest.scroll(scroll);
        searchSourceBuilder.size(2);


//
    }


    @Test
    void queryById() throws IOException {
        SearchRequest searchRequest = new SearchRequest("teacher_table");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(10000);

        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
//        String[] ids = new String[]{"204906"
//                ,"570"
//                ,"582"
//                ,"205423"
//                ,"204861"
//                ,"205452"
//                ,"205322"
//                ,"205568"
//                ,"620"
//                ,"205604"};

        String[] ids = new String[]{"483905"};


        boolBuilder.must(QueryBuilders.idsQuery().addIds(ids));
        boolBuilder.must(QueryBuilders.termQuery("deleteStatus", BigDecimal.ONE.intValue()));
//        boolBuilder.must(QueryBuilders.termQuery("onSaleStatus", BigDecimal.ONE.intValue()));
//        boolBuilder.must(QueryBuilders.matchQuery("grade","高一"));

        searchSourceBuilder.query(boolBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        searchResponse.getHits().forEach(res -> {
            log.info(res.getSourceAsMap().toString());

        });

//
    }


    @Test
    void queryCourseClassInfo() throws IOException {
        SearchRequest searchRequest = new SearchRequest("course_class_info");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        boolBuilder.must(QueryBuilders.termQuery("courseId", 101884));
        boolBuilder.must(QueryBuilders.termQuery("deleteStatus", BigDecimal.ZERO.intValue()));
        searchSourceBuilder.query(boolBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(searchResponse.getHits().getHits().length);
    }


    @Test
    void queryCourseGradeInfo() throws IOException {
        SearchRequest searchRequest = new SearchRequest("course_grade");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        boolBuilder.should(QueryBuilders.termQuery("courseId", 101884));
        boolBuilder.should(QueryBuilders.termQuery("courseId",
                689982));
        searchSourceBuilder.query(boolBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(searchResponse.getHits().getHits().length);
    }


    @Test
    void matchSkuInfo() throws IOException {
        SearchRequest searchRequest = new SearchRequest("product_sku");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        boolBuilder.must(QueryBuilders.termQuery("courseSpuId", 570));

        searchSourceBuilder.query(boolBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        searchResponse.getHits().forEach(res -> {
            log.info(res.getSourceAsMap().toString());
        });

//
    }

    @Test
    void matchCourseCampusInfo() throws IOException {

            SearchRequest searchRequest = new SearchRequest("course_campus");
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
            boolBuilder.must(QueryBuilders.termQuery("courseId", 689313));
            searchSourceBuilder.query(boolBuilder);
            searchRequest.source(searchSourceBuilder);
            SearchResponse searchResponse = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);

            for (SearchHit searchHit : searchResponse.getHits().getHits()) {
                JSONObject json = new JSONObject(searchHit.getSourceAsMap());
                ESCourseCampus esCourseCampus = JSONObject.parseObject(json.toJSONString(), ESCourseCampus.class);
                esCourseCampus.setId(searchHit.getId());

            }
    }


    @Test
    void matchMoreSearchInfo() throws IOException {
        SearchRequest searchRequest = new SearchRequest("product_spu_style");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(10000);
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        boolBuilder.must(QueryBuilders.termQuery("spuId", "604"));
        boolBuilder.should(QueryBuilders.termQuery("platform", "7"));
        searchSourceBuilder.query(boolBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        searchResponse.getHits().forEach(res -> {
            log.info(res.getSourceAsMap().toString());

        });
    }




    @Test
    void matchCmsTeacherSearchInfo() throws IOException {
        SearchRequest searchRequest = new SearchRequest("cms_teacher_show_column");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        boolBuilder.must(QueryBuilders.termQuery("cmsTeacherId", "534"));
        boolBuilder.must(QueryBuilders.termQuery("showLocation", "6"));

//        boolBuilder.should(QueryBuilders.termQuery("agencyId", ""));

        searchSourceBuilder.query(boolBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        searchResponse.getHits().forEach(res -> {
            log.info(res.getSourceAsMap().toString());
        });
    }



}
