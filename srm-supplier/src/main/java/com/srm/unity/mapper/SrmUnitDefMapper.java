package com.srm.unity.mapper;

import com.srm.unity.domain.SrmUnitDef;
import com.srm.unity.domain.SrmUnitTypeDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 计量单位定义Mapper接口
 *
 * @author ruoyi
 * @date 2024-07-18
 */

@Repository
public interface SrmUnitDefMapper {
    /**
     * 查询计量单位定义
     *
     * @param unitCode 计量单位定义主键
     * @return 计量单位定义
     */
    public SrmUnitDef selectSrmUnitDefByUnitCode(Long unitCode);

    /**
     * 查询计量单位定义列表
     *
     * @param srmUnitDef 计量单位定义
     * @return 计量单位定义集合
     */
    public List<SrmUnitDef> selectSrmUnitDefList(SrmUnitDef srmUnitDef);

    /**
     * 新增计量单位定义
     *
     * @param srmUnitDef 计量单位定义
     * @return 结果
     */
    public int insertSrmUnitDef(SrmUnitDef srmUnitDef);

    /**
     * 修改计量单位定义
     *
     * @param srmUnitDef 计量单位定义
     * @return 结果
     */
    public int updateSrmUnitDef(SrmUnitDef srmUnitDef);

    /**
     * 删除计量单位定义
     *
     * @param unitCode 计量单位定义主键
     * @return 结果
     */
    public int deleteSrmUnitDefByUnitCode(Long unitCode);

    /**
     * 批量删除计量单位定义
     *
     * @param unitCodes 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmUnitDefByUnitCodes(Long[] unitCodes);

    List<SrmUnitTypeDefinition> selectUnitTypeList();
}
