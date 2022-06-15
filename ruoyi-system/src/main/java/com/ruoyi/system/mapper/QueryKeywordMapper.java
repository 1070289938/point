package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.QueryKeyword;
import org.apache.ibatis.annotations.Param;

/**
 * 热门查询关键词Mapper接口
 *
 * @author ruoyi
 * @date 2022-06-08
 */
public interface QueryKeywordMapper {
    /**
     * 查询热门查询关键词
     *
     * @param id 热门查询关键词主键
     * @return 热门查询关键词
     */
    public QueryKeyword selectQueryKeywordById(Long id);

    /**
     * 查询热门查询关键词列表
     *
     * @param queryKeyword 热门查询关键词
     * @return 热门查询关键词集合
     */
    public List<QueryKeyword> selectQueryKeywordList(QueryKeyword queryKeyword);

    /**
     * 新增热门查询关键词
     *
     * @param queryKeyword 热门查询关键词
     * @return 结果
     */
    public int insertQueryKeyword(QueryKeyword queryKeyword);

    /**
     * 修改热门查询关键词
     *
     * @param queryKeyword 热门查询关键词
     * @return 结果
     */
    public int updateQueryKeyword(QueryKeyword queryKeyword);

    /**
     * 删除热门查询关键词
     *
     * @param id 热门查询关键词主键
     * @return 结果
     */
    public int deleteQueryKeywordById(Long id);

    /**
     * 批量删除热门查询关键词
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQueryKeywordByIds(String[] ids);

    /**
     * 根据名称查询关键词
     *
     * @param name
     * @return
     */
    QueryKeyword selectQueryKeywordByKey(@Param("name") String name);


    /**
     * 查询热门关键词
     */
    List<String> selectQueryKeywordHot();


}
