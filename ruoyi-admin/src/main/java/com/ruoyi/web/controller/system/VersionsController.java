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
import com.ruoyi.system.domain.Versions;
import com.ruoyi.system.service.IVersionsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 版本管理器Controller
 *
 * @author ruoyi
 * @date 2022-05-20
 */
@Controller
@RequestMapping("/system/versions")
public class VersionsController extends BaseController
{
    private String prefix = "system/versions";

    @Autowired
    private IVersionsService versionsService;

    @RequiresPermissions("system:versions:view")
    @GetMapping()
    public String versions()
    {
        return prefix + "/versions";
    }

    /**
     * 查询版本管理器列表
     */
    @RequiresPermissions("system:versions:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Versions versions)
    {
        startPage();
        List<Versions> list = versionsService.selectVersionsList(versions);
        return getDataTable(list);
    }

    /**
     * 导出版本管理器列表
     */
    @RequiresPermissions("system:versions:export")
    @Log(title = "版本管理器", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Versions versions)
    {
        List<Versions> list = versionsService.selectVersionsList(versions);
        ExcelUtil<Versions> util = new ExcelUtil<Versions>(Versions.class);
        return util.exportExcel(list, "版本管理器数据");
    }

    /**
     * 新增版本管理器
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存版本管理器
     */
    @RequiresPermissions("system:versions:add")
    @Log(title = "版本管理器", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Versions versions)
    {
        return toAjax(versionsService.insertVersions(versions));
    }

    /**
     * 修改版本管理器
     */
    @RequiresPermissions("system:versions:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Versions versions = versionsService.selectVersionsById(id);
        mmap.put("versions", versions);
        return prefix + "/edit";
    }

    /**
     * 修改保存版本管理器
     */
    @RequiresPermissions("system:versions:edit")
    @Log(title = "版本管理器", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Versions versions)
    {
        return toAjax(versionsService.updateVersions(versions));
    }

    /**
     * 删除版本管理器
     */
    @RequiresPermissions("system:versions:remove")
    @Log(title = "版本管理器", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(versionsService.deleteVersionsByIds(ids));
    }
}
