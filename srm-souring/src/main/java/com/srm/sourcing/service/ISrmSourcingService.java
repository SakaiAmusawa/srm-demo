package com.srm.sourcing.service;

import java.util.List;
import com.srm.sourcing.domain.SrmSourcing;

/**
 * 询价台Service接口
 * 
 * @author sakai
 * @date 2024-08-12
 */
public interface ISrmSourcingService 
{
    /**
     * 查询询价台
     * 
     * @param id 询价台主键
     * @return 询价台
     */
    public SrmSourcing selectSrmSourcingById(Long id);

    /**
     * 查询询价台列表
     * 
     * @param srmSourcing 询价台
     * @return 询价台集合
     */
    public List<SrmSourcing> selectSrmSourcingList(SrmSourcing srmSourcing);

    /**
     * 新增询价台
     * 
     * @param srmSourcing 询价台
     * @return 结果
     */
    public int insertSrmSourcing(SrmSourcing srmSourcing);

    /**
     * 修改询价台
     * 
     * @param srmSourcing 询价台
     * @return 结果
     */
    public int updateSrmSourcing(SrmSourcing srmSourcing);

    /**
     * 批量删除询价台
     * 
     * @param ids 需要删除的询价台主键集合
     * @return 结果
     */
    public int deleteSrmSourcingByIds(Long[] ids);

    /**
     * 删除询价台信息
     * 
     * @param id 询价台主键
     * @return 结果
     */
    public int deleteSrmSourcingById(Long id);
}
