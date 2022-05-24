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
import com.ruoyi.system.domain.SongCollect;
import com.ruoyi.system.service.ISongCollectService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户收藏列Controller
 *
 * @author ruoyi
 * @date 2022-05-23
 */
@Controller
@RequestMapping("/system/song_collect")
public class SongCollectController extends BaseController
{
    private String prefix = "system/song_collect";

    @Autowired
    private ISongCollectService songCollectService;

    @RequiresPermissions("system:song_collect:view")
    @GetMapping()
    public String song_collect()
    {
        return prefix + "/song_collect";
    }

    /**
     * 查询用户收藏列列表
     */
    @RequiresPermissions("system:song_collect:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SongCollect songCollect)
    {
        startPage();
        List<SongCollect> list = songCollectService.selectSongCollectList(songCollect);
        return getDataTable(list);
    }

    /**
     * 导出用户收藏列列表
     */
    @RequiresPermissions("system:song_collect:export")
    @Log(title = "用户收藏列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SongCollect songCollect)
    {
        List<SongCollect> list = songCollectService.selectSongCollectList(songCollect);
        ExcelUtil<SongCollect> util = new ExcelUtil<SongCollect>(SongCollect.class);
        return util.exportExcel(list, "用户收藏列数据");
    }

    /**
     * 新增用户收藏列
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户收藏列
     */
    @RequiresPermissions("system:song_collect:add")
    @Log(title = "用户收藏列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SongCollect songCollect)
    {
        return toAjax(songCollectService.insertSongCollect(songCollect));
    }

    /**
     * 修改用户收藏列
     */
    @RequiresPermissions("system:song_collect:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SongCollect songCollect = songCollectService.selectSongCollectById(id);
        mmap.put("songCollect", songCollect);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户收藏列
     */
    @RequiresPermissions("system:song_collect:edit")
    @Log(title = "用户收藏列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SongCollect songCollect)
    {
        return toAjax(songCollectService.updateSongCollect(songCollect));
    }

    /**
     * 删除用户收藏列
     */
    @RequiresPermissions("system:song_collect:remove")
    @Log(title = "用户收藏列", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(songCollectService.deleteSongCollectByIds(ids));
    }
}
