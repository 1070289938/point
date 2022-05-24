package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.AmountRecord;
import com.ruoyi.system.service.IAmountRecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 消费记录Controller
 *
 * @author ruoyi
 * @date 2022-05-21
 */
@Controller
@RequestMapping("/system/amount_record")
public class AmountRecordController extends BaseController
{
    private String prefix = "system/amount_record";

    @Autowired
    private IAmountRecordService amountRecordService;

    @RequiresPermissions("system:amount_record:view")
    @GetMapping()
    public String amount_record()
    {
        return prefix + "/amount_record";
    }

    /**
     * 查询消费记录列表
     */
    @RequiresPermissions("system:amount_record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AmountRecord amountRecord)
    {
        startPage();
        List<AmountRecord> list = amountRecordService.selectAmountRecordList(amountRecord);
        return getDataTable(list);
    }

    /**
     * 导出消费记录列表
     */
    @RequiresPermissions("system:amount_record:export")
    @Log(title = "消费记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AmountRecord amountRecord)
    {
        List<AmountRecord> list = amountRecordService.selectAmountRecordList(amountRecord);
        ExcelUtil<AmountRecord> util = new ExcelUtil<AmountRecord>(AmountRecord.class);
        return util.exportExcel(list, "消费记录数据");
    }

    /**
     * 新增消费记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存消费记录
     */
    @RequiresPermissions("system:amount_record:add")
    @Log(title = "消费记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AmountRecord amountRecord)
    {
        return toAjax(amountRecordService.insertAmountRecord(amountRecord));
    }

    /**
     * 修改消费记录
     */
    @RequiresPermissions("system:amount_record:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AmountRecord amountRecord = amountRecordService.selectAmountRecordById(id);
        mmap.put("amountRecord", amountRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存消费记录
     */
    @RequiresPermissions("system:amount_record:edit")
    @Log(title = "消费记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AmountRecord amountRecord)
    {
        return toAjax(amountRecordService.updateAmountRecord(amountRecord));
    }

    /**
     * 删除消费记录
     */
    @RequiresPermissions("system:amount_record:remove")
    @Log(title = "消费记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(amountRecordService.deleteAmountRecordByIds(ids));
    }
}
