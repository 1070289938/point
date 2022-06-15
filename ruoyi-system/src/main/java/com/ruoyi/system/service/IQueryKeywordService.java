package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.exception.LogicException;
import com.ruoyi.system.domain.QueryKeyword;
import com.ruoyi.system.domain.pojo.song.QueryKeywordPojo;

/**
 * 热门查询关键词Service接口
 *
 * @author ruoyi
 * @date 2022-06-08
 */
public interface IQueryKeywordService
{
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
     * 批量删除热门查询关键词
     *
     * @param ids 需要删除的热门查询关键词主键集合
     * @return 结果
     */
    public int deleteQueryKeywordByIds(String ids);

    /**
     * 删除热门查询关键词信息
     *
     * @param id 热门查询关键词主键
     * @return 结果
     */
    public int deleteQueryKeywordById(Long id);


    /**
     * 增加关键词查询数
     * @param name
     */
    void addQueryKeyword(String name);

    /**
     * 查询热门关键词
     * @return
     */
    QueryKeywordPojo.OutPut queryHotKeyword()throws LogicException;


}
