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
import com.ruoyi.system.domain.SongLike;
import com.ruoyi.system.service.ISongLikeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 歌曲点赞Controller
 *
 * @author ruoyi
 * @date 2022-04-19
 */
@Controller
@RequestMapping("/system/songLike")
public class SongLikeController extends BaseController
{
    private String prefix = "system/songLike";

    @Autowired
    private ISongLikeService songLikeService;

    @RequiresPermissions("system:songLike:view")
    @GetMapping()
    public String songLike()
    {
        return prefix + "/songLike";
    }

    /**
     * 查询歌曲点赞列表
     */
    @RequiresPermissions("system:songLike:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SongLike songLike)
    {
        startPage();
        List<SongLike> list = songLikeService.selectSongLikeList(songLike);
        return getDataTable(list);
    }

    /**
     * 导出歌曲点赞列表
     */
    @RequiresPermissions("system:songLike:export")
    @Log(title = "歌曲点赞", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SongLike songLike)
    {
        List<SongLike> list = songLikeService.selectSongLikeList(songLike);
        ExcelUtil<SongLike> util = new ExcelUtil<SongLike>(SongLike.class);
        return util.exportExcel(list, "歌曲点赞数据");
    }

    /**
     * 新增歌曲点赞
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存歌曲点赞
     */
    @RequiresPermissions("system:songLike:add")
    @Log(title = "歌曲点赞", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SongLike songLike)
    {
        return toAjax(songLikeService.insertSongLike(songLike));
    }

    /**
     * 修改歌曲点赞
     */
    @RequiresPermissions("system:songLike:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SongLike songLike = songLikeService.selectSongLikeById(id);
        mmap.put("songLike", songLike);
        return prefix + "/edit";
    }

    /**
     * 修改保存歌曲点赞
     */
    @RequiresPermissions("system:songLike:edit")
    @Log(title = "歌曲点赞", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SongLike songLike)
    {
        return toAjax(songLikeService.updateSongLike(songLike));
    }

    /**
     * 删除歌曲点赞
     */
    @RequiresPermissions("system:songLike:remove")
    @Log(title = "歌曲点赞", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(songLikeService.deleteSongLikeByIds(ids));
    }
}
