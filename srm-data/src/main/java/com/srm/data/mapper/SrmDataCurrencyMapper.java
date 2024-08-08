package com.srm.data.mapper;

import java.util.List;
import com.srm.data.domain.SrmDataCurrency;

/**
 * 货币定义Mapper接口
 * 
 * @author sakai
 * @date 2024-08-08
 */
public interface SrmDataCurrencyMapper 
{
    /**
     * 查询货币定义
     * 
     * @param id 货币定义主键
     * @return 货币定义
     */
    public SrmDataCurrency selectSrmDataCurrencyById(Long id);

    /**
     * 查询货币定义列表
     * 
     * @param srmDataCurrency 货币定义
     * @return 货币定义集合
     */
    public List<SrmDataCurrency> selectSrmDataCurrencyList(SrmDataCurrency srmDataCurrency);

    /**
     * 新增货币定义
     * 
     * @param srmDataCurrency 货币定义
     * @return 结果
     */
    public int insertSrmDataCurrency(SrmDataCurrency srmDataCurrency);

    /**
     * 修改货币定义
     * 
     * @param srmDataCurrency 货币定义
     * @return 结果
     */
    public int updateSrmDataCurrency(SrmDataCurrency srmDataCurrency);

    /**
     * 删除货币定义
     * 
     * @param id 货币定义主键
     * @return 结果
     */
    public int deleteSrmDataCurrencyById(Long id);

    /**
     * 批量删除货币定义
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmDataCurrencyByIds(Long[] ids);
}
