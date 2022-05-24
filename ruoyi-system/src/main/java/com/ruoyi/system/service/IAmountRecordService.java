package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.enums.AmountRecordEnum;
import com.ruoyi.common.exception.LogicException;
import com.ruoyi.system.domain.AmountRecord;
import com.ruoyi.system.domain.pojo.ParamPojo;
import com.ruoyi.system.domain.pojo.user.GetMoneyRecordPojo;

/**
 * 消费记录Service接口
 *
 * @author ruoyi
 * @date 2022-05-21
 */
public interface IAmountRecordService {
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


    public void addAmountRecord(Integer userId, Long money, AmountRecordEnum type);

    public void addAmountRecord(Integer userId, Long money, AmountRecordEnum type,String details);

    /**
     * 修改消费记录
     *
     * @param amountRecord 消费记录
     * @return 结果
     */
    public int updateAmountRecord(AmountRecord amountRecord);

    /**
     * 批量删除消费记录
     *
     * @param ids 需要删除的消费记录主键集合
     * @return 结果
     */
    public int deleteAmountRecordByIds(String ids);

    /**
     * 删除消费记录信息
     *
     * @param id 消费记录主键
     * @return 结果
     */
    public int deleteAmountRecordById(Long id);

    Long getMoney(Integer userId);

    /**
     * 获取消费记录列表
     * @param param
     * @return
     */
    GetMoneyRecordPojo.OutPut getMoneyRecordList(ParamPojo<GetMoneyRecordPojo.Param> param)throws LogicException;

}
