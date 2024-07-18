package com.srm.unity.service.impl;

import com.srm.unity.domain.SrmUnitDef;
import com.srm.unity.domain.SrmUnitTypeDefinition;
import com.srm.unity.mapper.SrmUnitDefMapper;
import com.srm.unity.service.ISrmUnitDefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 计量单位定义Service业务层处理
 *
 * @author ruoyi
 * @date 2024-07-18
 */
@Service
public class SrmUnitDefServiceImpl implements ISrmUnitDefService {
    @Autowired
    private SrmUnitDefMapper srmUnitDefMapper;

    /**
     * 查询计量单位定义
     *
     * @param unitCode 计量单位定义主键
     * @return 计量单位定义
     */
    @Override
    public SrmUnitDef selectSrmUnitDefByUnitCode(Long unitCode) {
        return srmUnitDefMapper.selectSrmUnitDefByUnitCode(unitCode);
    }

    /**
     * 查询计量单位定义列表
     *
     * @param srmUnitDef 计量单位定义
     * @return 计量单位定义
     */
    @Override
    public List<SrmUnitDef> selectSrmUnitDefList(SrmUnitDef srmUnitDef) {
        return srmUnitDefMapper.selectSrmUnitDefList(srmUnitDef);
    }

    /**
     * 新增计量单位定义
     *
     * @param srmUnitDef 计量单位定义
     * @return 结果
     */
    @Override
    public int insertSrmUnitDef(SrmUnitDef srmUnitDef) {
        return srmUnitDefMapper.insertSrmUnitDef(srmUnitDef);
    }

    /**
     * 修改计量单位定义
     *
     * @param srmUnitDef 计量单位定义
     * @return 结果
     */
    @Override
    public int updateSrmUnitDef(SrmUnitDef srmUnitDef) {
        return srmUnitDefMapper.updateSrmUnitDef(srmUnitDef);
    }

    /**
     * 批量删除计量单位定义
     *
     * @param unitCodes 需要删除的计量单位定义主键
     * @return 结果
     */
    @Override
    public int deleteSrmUnitDefByUnitCodes(Long[] unitCodes) {
        return srmUnitDefMapper.deleteSrmUnitDefByUnitCodes(unitCodes);
    }

    /**
     * 删除计量单位定义信息
     *
     * @param unitCode 计量单位定义主键
     * @return 结果
     */
    @Override
    public int deleteSrmUnitDefByUnitCode(Long unitCode) {
        return srmUnitDefMapper.deleteSrmUnitDefByUnitCode(unitCode);
    }

    @Override
    public List<SrmUnitTypeDefinition> selectUnitTypeList() {
        return srmUnitDefMapper.selectUnitTypeList();
    }
}
