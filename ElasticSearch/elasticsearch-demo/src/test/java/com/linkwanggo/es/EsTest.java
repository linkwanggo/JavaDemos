package com.linkwanggo.es;

import com.linkwanggo.es.pojo.Item;
import com.linkwanggo.es.repository.ItemRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SourceFilter;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {

    @Autowired
    private ElasticsearchTemplate template;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testEsCreate() {
        // 创建索引
        template.createIndex(Item.class);
        // 创建映射
        template.putMapping(Item.class);
    }

    @Test
    public void testInsert() {
        Item item = new Item(1L, "小米手机7", " 手机",
                "小米", 3499.00, "http://image.leyou.com/13123.jpg");
        itemRepository.save(item);
    }

    @Test
    public void testInsertAll() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1L, "小米手机7", "手机", "小米", 3299.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(2L, "坚果手机R1", "手机", "锤子", 3699.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(3L, "华为META10", "手机", "华为", 4499.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(4L, "小米Mix2S", "手机", "小米", 4299.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(5L, "荣耀V10", "手机", "华为", 2799.00, "http://image.leyou.com/13123.jpg"));
        itemRepository.saveAll(list);
    }

    @Test
    public void testSearch() {
        Iterable<Item> all = itemRepository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void testFindBy() {
        List<Item> itemList = itemRepository.findByPriceBetween(3400d, 3700d);
        itemList.forEach(System.out::println);
    }

    /**
     * 高级查询
     */
    @Test
    public void testQuery() {
        // 创建查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 结果查询
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{"id", "title", "price", "image"}, null));
        // 查询条件
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "小米手机"));
        // 排序
        queryBuilder.withPageable(PageRequest.of(0, 1));
        // 分页
        queryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));
        // 使用itemRepository查询结果
        Page<Item> result = itemRepository.search(queryBuilder.build());
        long totalElements = result.getTotalElements();
        System.out.println("totalElements = " + totalElements);
        int totalPages = result.getTotalPages();
        System.out.println("totalPages = " + totalPages);
        List<Item> itemList = result.getContent();
        itemList.forEach(System.out::println);
    }

    @Test
    public void testAggregations() {
        // 创建构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        String aggName = "popularBrand";
        // 使用template进行聚合查询
        queryBuilder.addAggregation(AggregationBuilders.terms(aggName).field("brand"));
        // 查询并返回带聚合结果
        AggregatedPage<Item> aggregatedPage = template.queryForPage(queryBuilder.build(), Item.class);
        // 解析聚合
        Aggregations aggs = aggregatedPage.getAggregations();
        // 获取指定名称的聚合
        StringTerms stringTerms = aggs.get(aggName);
        // 获取桶
        List<StringTerms.Bucket> buckets = stringTerms.getBuckets();

        buckets.forEach(bucket -> {
            System.out.println(bucket.getKey());
            System.out.println(bucket.getDocCount());
        });
    }
}
