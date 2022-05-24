package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.page.PageMethod;
import com.ruoyi.common.enums.AmountRecordEnum;
import com.ruoyi.common.exception.LogicException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.system.domain.UserInfo;
import com.ruoyi.system.domain.pojo.ParamPojo;
import com.ruoyi.system.domain.pojo.song.QuerySongPojo;
import com.ruoyi.system.domain.pojo.user.GetMoneyRecordPojo;
import com.ruoyi.system.domain.pojo.vo.RecordVO;
import com.ruoyi.system.domain.pojo.vo.SongVO;
import com.ruoyi.system.domain.pojo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AmountRecordMapper;
import com.ruoyi.system.domain.AmountRecord;
import com.ruoyi.system.service.IAmountRecordService;
import com.ruoyi.common.core.text.Convert;

/**
 * 消费记录Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-21
 */
@Service
public class AmountRecordServiceImpl implements IAmountRecordService {
    @Autowired
    private AmountRecordMapper amountRecordMapper;

    /**
     * 查询消费记录
     *
     * @param id 消费记录主键
     * @return 消费记录
     */
    @Override
    public AmountRecord selectAmountRecordById(Long id) {
        return amountRecordMapper.selectAmountRecordById(id);
    }

    /**
     * 查询消费记录列表
     *
     * @param amountRecord 消费记录
     * @return 消费记录
     */
    @Override
    public List<AmountRecord> selectAmountRecordList(AmountRecord amountRecord) {
        return amountRecordMapper.selectAmountRecordList(amountRecord);
    }

    /**
     * 新增消费记录
     *
     * @param amountRecord 消费记录
     * @return 结果
     */
    @Override
    public int insertAmountRecord(AmountRecord amountRecord) {
        amountRecord.setCreateTime(DateUtils.getNowDate());
        return amountRecordMapper.insertAmountRecord(amountRecord);
    }

    @Override
    public void addAmountRecord(Integer userId, Long money, AmountRecordEnum type) {
        addAmountRecord(userId, money, type, type.getContent());
    }

    @Override
    public void addAmountRecord(Integer userId, Long money, AmountRecordEnum type, String detail) {
        AmountRecord amountRecord = new AmountRecord();
        amountRecord.setOrderId(IdUtils.fastSimpleUUID());
        amountRecord.setUserId(userId);
        amountRecord.setMoney(money);
        amountRecord.setDetails(detail);
        amountRecord.setType(type.getType());
        amountRecord.setCreateTime(new Date());
        amountRecordMapper.insertAmountRecord(amountRecord);

    }

    /**
     * 修改消费记录
     *
     * @param amountRecord 消费记录
     * @return 结果
     */
    @Override
    public int updateAmountRecord(AmountRecord amountRecord) {
        return amountRecordMapper.updateAmountRecord(amountRecord);
    }

    /**
     * 批量删除消费记录
     *
     * @param ids 需要删除的消费记录主键
     * @return 结果
     */
    @Override
    public int deleteAmountRecordByIds(String ids) {
        return amountRecordMapper.deleteAmountRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除消费记录信息
     *
     * @param id 消费记录主键
     * @return 结果
     */
    @Override
    public int deleteAmountRecordById(Long id) {
        return amountRecordMapper.deleteAmountRecordById(id);
    }

    @Override
    public Long getMoney(Integer userId) {

        Long money = amountRecordMapper.getMoney(userId);

        return money;
    }

    /**
     * 获取消费记录列表
     *
     * @param param
     * @return
     * @throws LogicException
     */
    @Override
    public GetMoneyRecordPojo.OutPut getMoneyRecordList(ParamPojo<GetMoneyRecordPojo.Param> param) throws LogicException {


        PageMethod.startPage(param.getData().getPage(), param.getData().getSize());
        //查询歌曲
        List<AmountRecord> amountRecords = amountRecordMapper.selectAmountRecordByUserId(param.getUserId());
        List<RecordVO> recordVOList = new ArrayList<>();
        for (AmountRecord record : amountRecords) {
            recordVOList.add(new RecordVO(record));
        }

        GetMoneyRecordPojo.OutPut outPut = new GetMoneyRecordPojo.OutPut();
        outPut.setRecordVOList(recordVOList);

        return outPut;
    }
}
