package com.ruoyi.system.domain.pojo.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.system.domain.KeyLocation;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
public class KeyVO {

    private Integer id;

    /**
     * 键位id
     */
    private Integer key;

    /**
     * x轴位置
     */
    private BigDecimal x;

    /**
     * y轴位置
     */
    private BigDecimal y;


    public void iniKey(KeyLocation key) {
        this.id = key.getId();
        this.key = key.getKey();
        this.x = key.getX();
        this.y = key.getY();
    }

    public static Map<String, KeyVO> iniKeyVoMap(Map<String, KeyLocation> map) {
        Map<String, KeyVO> voMap = new HashMap<>();
        for (String key : map.keySet()) {
            voMap.put(key, new KeyVO() {{
                iniKey(map.get(key));
            }});
        }
        return voMap;
    }


}
