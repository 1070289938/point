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
import com.ruoyi.system.domain.KeyLocation;
import com.ruoyi.system.service.IKeyLocationService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 键位Controller
 *
 * @author ruoyi
 * @date 2022-05-18
 */
@Controller
@RequestMapping("/system/key_location")
public class KeyLocationController extends BaseController
{
    private String prefix = "system/key_location";

    @Autowired
    private IKeyLocationService keyLocationService;

    @RequiresPermissions("system:key_location:view")
    @GetMapping()
    public String key_location()
    {
        return prefix + "/key_location";
    }

    /**
     * 查询键位列表
     */
    @RequiresPermissions("system:key_location:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KeyLocation keyLocation)
    {
        startPage();
        List<KeyLocation> list = keyLocationService.selectKeyLocationList(keyLocation);
        return getDataTable(list);
    }

    /**
     * 导出键位列表
     */
    @RequiresPermissions("system:key_location:export")
    @Log(title = "键位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KeyLocation keyLocation)
    {
        List<KeyLocation> list = keyLocationService.selectKeyLocationList(keyLocation);
        ExcelUtil<KeyLocation> util = new ExcelUtil<KeyLocation>(KeyLocation.class);
        return util.exportExcel(list, "键位数据");
    }

    /**
     * 新增键位
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存键位
     */
    @RequiresPermissions("system:key_location:add")
    @Log(title = "键位", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(KeyLocation keyLocation)
    {
        return toAjax(keyLocationService.insertKeyLocation(keyLocation));
    }

    /**
     * 修改键位
     */
    @RequiresPermissions("system:key_location:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        KeyLocation keyLocation = keyLocationService.selectKeyLocationById(id);
        mmap.put("keyLocation", keyLocation);
        return prefix + "/edit";
    }

    /**
     * 修改保存键位
     */
    @RequiresPermissions("system:key_location:edit")
    @Log(title = "键位", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(KeyLocation keyLocation)
    {
        return toAjax(keyLocationService.updateKeyLocation(keyLocation));
    }

    /**
     * 删除键位
     */
    @RequiresPermissions("system:key_location:remove")
    @Log(title = "键位", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(keyLocationService.deleteKeyLocationByIds(ids));
    }
}
