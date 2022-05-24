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
import com.ruoyi.system.domain.SongCode;
import com.ruoyi.system.service.ISongCodeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 歌曲代码Controller
 *
 * @author ruoyi
 * @date 2022-04-19
 */
@Controller
@RequestMapping("/system/songCode")
public class SongCodeController extends BaseController
{
    private String prefix = "system/songCode";

    @Autowired
    private ISongCodeService songCodeService;

    @RequiresPermissions("system:songCode:view")
    @GetMapping()
    public String songCode()
    {
        return prefix + "/songCode";
    }

    /**
     * 查询歌曲代码列表
     */
    @RequiresPermissions("system:songCode:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SongCode songCode)
    {
        startPage();
        List<SongCode> list = songCodeService.selectSongCodeList(songCode);
        return getDataTable(list);
    }

    /**
     * 导出歌曲代码列表
     */
    @RequiresPermissions("system:songCode:export")
    @Log(title = "歌曲代码", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SongCode songCode)
    {
        List<SongCode> list = songCodeService.selectSongCodeList(songCode);
        ExcelUtil<SongCode> util = new ExcelUtil<SongCode>(SongCode.class);
        return util.exportExcel(list, "歌曲代码数据");
    }

    /**
     * 新增歌曲代码
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存歌曲代码
     */
    @RequiresPermissions("system:songCode:add")
    @Log(title = "歌曲代码", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SongCode songCode)
    {
        return toAjax(songCodeService.insertSongCode(songCode));
    }

    /**
     * 修改歌曲代码
     */
    @RequiresPermissions("system:songCode:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SongCode songCode = songCodeService.selectSongCodeById(id);
        mmap.put("songCode", songCode);
        return prefix + "/edit";
    }

    /**
     * 修改保存歌曲代码
     */
    @RequiresPermissions("system:songCode:edit")
    @Log(title = "歌曲代码", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SongCode songCode)
    {
        return toAjax(songCodeService.updateSongCode(songCode));
    }

    /**
     * 删除歌曲代码
     */
    @RequiresPermissions("system:songCode:remove")
    @Log(title = "歌曲代码", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(songCodeService.deleteSongCodeByIds(ids));
    }
}
