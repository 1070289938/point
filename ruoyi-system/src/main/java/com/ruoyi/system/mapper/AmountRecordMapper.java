package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AmountRecord;
import org.apache.ibatis.annotations.Param;

/**
 * 消费记录Mapper接口
 *
 * @author ruoyi
 * @date 2022-05-21
 */
public interface AmountRecordMapper
{
    /**
     * 查询消费记录
     *
     * @param id 消费记录主键
     * @return 消费记录
     */
    public AmountRecord selectAmountRecordById(Long id);

    /**
     * 查询消费记录列表
     *
     * @param amountRecord 消费记录
     * @return 消费记录集合
     */
    public List<AmountRecord> selectAmountRecordList(AmountRecord amountRecord);

    /**
     * 新增消费记录
     *
     * @param amountRecord 消费记录
     * @return 结果
     */
    public int insertAmountRecord(AmountRecord amountRecord);

    /**
     * 修改消费记录
     *
     * @param amountRecord 消费记录
     * @return 结果
     */
    public int updateAmountRecord(AmountRecord amountRecord);

    /**
     * 删除消费记录
     *
     * @param id 消费记录主键
     * @return 结果
     */
    public int deleteAmountRecordById(Long id);

    /**
     * 批量删除消费记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAmountRecordByIds(String[] ids);

    /**
     * 获取用户的金额
     * @param userId
     * @return
     */
    Long getMoney(@Param("userId") Integer userId);

    /**
     * 获取用户消费记录列表
     * @param userId
     * @return
     */
    List<AmountRecord> selectAmountRecordByUserId(@Param("userId") Integer userId);
}
