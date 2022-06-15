package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.exception.LogicException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.pojo.song.QueryKeywordPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.QueryKeywordMapper;
import com.ruoyi.system.domain.QueryKeyword;
import com.ruoyi.system.service.IQueryKeywordService;
import com.ruoyi.common.core.text.Convert;

/**
 * 热门查询关键词Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-08
 */
@Service
public class QueryKeywordServiceImpl implements IQueryKeywordService {
    @Autowired
    private QueryKeywordMapper queryKeywordMapper;

    /**
     * 查询热门查询关键词
     *
     * @param id 热门查询关键词主键
     * @return 热门查询关键词
     */
    @Override
    public QueryKeyword selectQueryKeywordById(Long id) {
        return queryKeywordMapper.selectQueryKeywordById(id);
    }

    /**
     * 查询热门查询关键词列表
     *
     * @param queryKeyword 热门查询关键词
     * @return 热门查询关键词
     */
    @Override
    public List<QueryKeyword> selectQueryKeywordList(QueryKeyword queryKeyword) {
        return queryKeywordMapper.selectQueryKeywordList(queryKeyword);
    }

    /**
     * 新增热门查询关键词
     *
     * @param queryKeyword 热门查询关键词
     * @return 结果
     */
    @Override
    public int insertQueryKeyword(QueryKeyword queryKeyword) {
        queryKeyword.setCreateTime(DateUtils.getNowDate());
        return queryKeywordMapper.insertQueryKeyword(queryKeyword);
    }

    /**
     * 修改热门查询关键词
     *
     * @param queryKeyword 热门查询关键词
     * @return 结果
     */
    @Override
    public int updateQueryKeyword(QueryKeyword queryKeyword) {
        queryKeyword.setUpdateTime(DateUtils.getNowDate());
        return queryKeywordMapper.updateQueryKeyword(queryKeyword);
    }

    /**
     * 批量删除热门查询关键词
     *
     * @param ids 需要删除的热门查询关键词主键
     * @return 结果
     */
    @Override
    public int deleteQueryKeywordByIds(String ids) {
        return queryKeywordMapper.deleteQueryKeywordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除热门查询关键词信息
     *
     * @param id 热门查询关键词主键
     * @return 结果
     */
    @Override
    public int deleteQueryKeywordById(Long id) {
        return queryKeywordMapper.deleteQueryKeywordById(id);
    }


    @Override
    public void addQueryKeyword(String name) {
        QueryKeyword queryKeyword = queryKeywordMapper.selectQueryKeywordByKey(name);
        if (queryKeyword != null) {
            queryKeyword.setCount(queryKeyword.getCount() + 1);
            queryKeyword.setUpdateTime(new Date());
            queryKeywordMapper.updateQueryKeyword(queryKeyword);
            return;
        }
        queryKeyword = new QueryKeyword();
        queryKeyword.setKey(name);
        queryKeyword.setCount(1L);
        queryKeyword.setCreateTime(new Date());
        queryKeyword.setUpdateTime(new Date());
        queryKeywordMapper.insertQueryKeyword(queryKeyword);
    }

    @Override
    public QueryKeywordPojo.OutPut queryHotKeyword() throws LogicException {
        List<String> hot = queryKeywordMapper.selectQueryKeywordHot();
        QueryKeywordPojo.OutPut outPut = new QueryKeywordPojo.OutPut();
        outPut.setKeyWord(hot);
        return outPut;
    }
}
