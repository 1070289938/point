package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.bean.SongInfoData;
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
import com.ruoyi.system.domain.SongInfo;
import com.ruoyi.system.service.ISongInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 歌曲详情Controller
 *
 * @author ruoyi
 * @date 2022-04-19
 */
@Controller
@RequestMapping("/system/songInfo")
public class SongInfoController extends BaseController
{
    private String prefix = "system/songInfo";

    @Autowired
    private ISongInfoService songInfoService;

    @RequiresPermissions("system:songInfo:view")
    @GetMapping()
    public String songInfo()
    {
        return prefix + "/songInfo";
    }

    /**
     * 查询歌曲详情列表
     */
    @RequiresPermissions("system:songInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SongInfo songInfo)
    {
        startPage();
        List<SongInfo> list = songInfoService.selectSongInfoList(songInfo);
        return getDataTable(list);
    }

    /**
     * 导出歌曲详情列表
     */
    @RequiresPermissions("system:songInfo:export")
    @Log(title = "歌曲详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SongInfo songInfo)
    {
        List<SongInfo> list = songInfoService.selectSongInfoList(songInfo);
        ExcelUtil<SongInfo> util = new ExcelUtil<SongInfo>(SongInfo.class);
        return util.exportExcel(list, "歌曲详情数据");
    }

    /**
     * 新增歌曲详情
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存歌曲详情
     */
    @RequiresPermissions("system:songInfo:add")
    @Log(title = "歌曲详情", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SongInfoData songInfo)
    {
        return toAjax(songInfoService.insertSongInfo(songInfo));
    }

    /**
     * 修改歌曲详情
     */
    @RequiresPermissions("system:songInfo:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SongInfo songInfo = songInfoService.selectSongInfoById(id);
        mmap.put("songInfo", songInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存歌曲详情
     */
    @RequiresPermissions("system:songInfo:edit")
    @Log(title = "歌曲详情", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SongInfo songInfo)
    {
        return toAjax(songInfoService.updateSongInfo(songInfo));
    }

    /**
     * 删除歌曲详情
     */
    @RequiresPermissions("system:songInfo:remove")
    @Log(title = "歌曲详情", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(songInfoService.deleteSongInfoByIds(ids));
    }
}
