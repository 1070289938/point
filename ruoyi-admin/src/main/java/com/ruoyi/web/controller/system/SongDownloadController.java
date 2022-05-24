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
import com.ruoyi.system.domain.SongDownload;
import com.ruoyi.system.service.ISongDownloadService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 歌曲下载Controller
 *
 * @author ruoyi
 * @date 2022-04-19
 */
@Controller
@RequestMapping("/system/songDownload")
public class SongDownloadController extends BaseController
{
    private String prefix = "system/songDownload";

    @Autowired
    private ISongDownloadService songDownloadService;

    @RequiresPermissions("system:songDownload:view")
    @GetMapping()
    public String songDownload()
    {
        return prefix + "/songDownload";
    }

    /**
     * 查询歌曲下载列表
     */
    @RequiresPermissions("system:songDownload:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SongDownload songDownload)
    {
        startPage();
        List<SongDownload> list = songDownloadService.selectSongDownloadList(songDownload);
        return getDataTable(list);
    }

    /**
     * 导出歌曲下载列表
     */
    @RequiresPermissions("system:songDownload:export")
    @Log(title = "歌曲下载", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SongDownload songDownload)
    {
        List<SongDownload> list = songDownloadService.selectSongDownloadList(songDownload);
        ExcelUtil<SongDownload> util = new ExcelUtil<SongDownload>(SongDownload.class);
        return util.exportExcel(list, "歌曲下载数据");
    }

    /**
     * 新增歌曲下载
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存歌曲下载
     */
    @RequiresPermissions("system:songDownload:add")
    @Log(title = "歌曲下载", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SongDownload songDownload)
    {
        return toAjax(songDownloadService.insertSongDownload(songDownload));
    }

    /**
     * 修改歌曲下载
     */
    @RequiresPermissions("system:songDownload:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SongDownload songDownload = songDownloadService.selectSongDownloadById(id);
        mmap.put("songDownload", songDownload);
        return prefix + "/edit";
    }

    /**
     * 修改保存歌曲下载
     */
    @RequiresPermissions("system:songDownload:edit")
    @Log(title = "歌曲下载", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SongDownload songDownload)
    {
        return toAjax(songDownloadService.updateSongDownload(songDownload));
    }

    /**
     * 删除歌曲下载
     */
    @RequiresPermissions("system:songDownload:remove")
    @Log(title = "歌曲下载", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(songDownloadService.deleteSongDownloadByIds(ids));
    }
}
