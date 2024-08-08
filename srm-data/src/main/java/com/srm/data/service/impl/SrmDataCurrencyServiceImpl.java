package com.srm.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srm.data.mapper.SrmDataCurrencyMapper;
import com.srm.data.domain.SrmDataCurrency;
import com.srm.data.service.ISrmDataCurrencyService;

/**
 * 货币定义Service业务层处理
 * 
 * @author sakai
 * @date 2024-08-08
 */
@Service
public class SrmDataCurrencyServiceImpl implements ISrmDataCurrencyService 
{
    @Autowired
    private SrmDataCurrencyMapper srmDataCurrencyMapper;

    /**
     * 查询货币定义
     * 
     * @param id 货币定义主键
     * @return 货币定义
     */
    @Override
    public SrmDataCurrency selectSrmDataCurrencyById(Long id)
    {
        return srmDataCurrencyMapper.selectSrmDataCurrencyById(id);
    }

    /**
     * 查询货币定义列表
     * 
     * @param srmDataCurrency 货币定义
     * @return 货币定义
     */
    @Override
    public List<SrmDataCurrency> selectSrmDataCurrencyList(SrmDataCurrency srmDataCurrency)
    {
        return srmDataCurrencyMapper.selectSrmDataCurrencyList(srmDataCurrency);
    }

    /**
     * 新增货币定义
     * 
     * @param srmDataCurrency 货币定义
     * @return 结果
     */
    @Override
    public int insertSrmDataCurrency(SrmDataCurrency srmDataCurrency)
    {
        return srmDataCurrencyMapper.insertSrmDataCurrency(srmDataCurrency);
    }

    /**
     * 修改货币定义
     * 
     * @param srmDataCurrency 货币定义
     * @return 结果
     */
    @Override
    public int updateSrmDataCurrency(SrmDataCurrency srmDataCurrency)
    {
        return srmDataCurrencyMapper.updateSrmDataCurrency(srmDataCurrency);
    }

    /**
     * 批量删除货币定义
     * 
     * @param ids 需要删除的货币定义主键
     * @return 结果
     */
    @Override
    public int deleteSrmDataCurrencyByIds(Long[] ids)
    {
        return srmDataCurrencyMapper.deleteSrmDataCurrencyByIds(ids);
    }

    /**
     * 删除货币定义信息
     * 
     * @param id 货币定义主键
     * @return 结果
     */
    @Override
    public int deleteSrmDataCurrencyById(Long id)
    {
        return srmDataCurrencyMapper.deleteSrmDataCurrencyById(id);
    }
}
