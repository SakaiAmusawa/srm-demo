package com.srm.supplier.service.impl;

import com.google.gson.Gson;
import com.srm.common.utils.StringUtils;
import com.srm.supplier.domain.*;
import com.srm.supplier.mapper.SrmSupplierInformationMapper;
import com.srm.supplier.service.ISrmSupplierInformationService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 供应商信息Service业务层处理
 *
 * @author sakai
 * @date 2024-07-01
 */
@Service
public class SrmSupplierInformationServiceImpl implements ISrmSupplierInformationService {
    @Autowired
    private SrmSupplierInformationMapper srmSupplierInformationMapper;

    /**
     * 查询供应商信息
     *
     * @param id 供应商信息主键
     * @return 供应商信息
     */
    @Override
    public SrmSupplierInformation selectSrmSupplierInformationById(Long id) {
        return srmSupplierInformationMapper.selectSrmSupplierInformationById(id);
    }

    /**
     * 查询供应商信息列表
     *
     * @param srmSupplierInformation 供应商信息
     * @return 供应商信息
     */
    @Override
    public List<SrmSupplierInformation> selectSrmSupplierInformationList(SrmSupplierInformation srmSupplierInformation) {
        return srmSupplierInformationMapper.selectSrmSupplierInformationList(srmSupplierInformation);
    }

    /**
     * 新增供应商信息
     *
     * @param srmSupplierInformation 供应商信息
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSrmSupplierInformation(SrmSupplierInformation srmSupplierInformation) {
        int rows = srmSupplierInformationMapper.insertSrmSupplierInformation(srmSupplierInformation);
        srmSupplierInformation.setSupplierCode("263016");
        String supplierName = srmSupplierInformation.getSupplierName();

        //token在生产时需要替换为实际可用的token
        String token = "c1a18228-d4e9-4d3e-bcd7-bbf00f7f0edd";
        String url = "http://open.api.tianyancha.com/services/open/ic/baseinfo/normal?keyword=" + supplierName;
        String jsonResponse = executeGet(url, token);

        // Convert JSON response to Java object
        Gson gson = new Gson();
        CompanyInfo companyInfo = gson.fromJson(jsonResponse, CompanyInfo.class);

        srmSupplierInformation.setIndustryType(companyInfo.getResult().getIndustryAll().getCategoryMiddle());

        //todo 从天眼查获取部分信息
        insertSrmSupplierContactInformation(srmSupplierInformation);
        insertSrmSupplierAddressInformation(srmSupplierInformation);
        insertSrmSupplierBankInformation(srmSupplierInformation);
        insertSrmSupplierInvoiceInformation(srmSupplierInformation);
        return rows;
    }

    /**
     * 修改供应商信息
     *
     * @param srmSupplierInformation 供应商信息
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSrmSupplierInformation(SrmSupplierInformation srmSupplierInformation) {
        srmSupplierInformationMapper.deleteSrmSupplierContactInformationBySupplierId(srmSupplierInformation.getId());
        insertSrmSupplierContactInformation(srmSupplierInformation);
        insertSrmSupplierAddressInformation(srmSupplierInformation);
        insertSrmSupplierBankInformation(srmSupplierInformation);
        insertSrmSupplierInvoiceInformation(srmSupplierInformation);
        return srmSupplierInformationMapper.updateSrmSupplierInformation(srmSupplierInformation);
    }

    /**
     * 批量删除供应商信息
     *
     * @param ids 需要删除的供应商信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmSupplierInformationByIds(Long[] ids) {
        srmSupplierInformationMapper.deleteSrmSupplierContactInformationBySupplierIds(ids);
        srmSupplierInformationMapper.deleteSrmSupplierAddressInformationBySupplierIds(ids);
        srmSupplierInformationMapper.deleteSrmSupplierInformationByIds(ids);
        srmSupplierInformationMapper.deleteSrmSupplierInvoiceInformationBySupplierIds(ids);
        return srmSupplierInformationMapper.deleteSrmSupplierInformationByIds(ids);
    }

    /**
     * 删除供应商信息信息
     *
     * @param id 供应商信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmSupplierInformationById(Long id) {
        srmSupplierInformationMapper.deleteSrmSupplierContactInformationBySupplierId(id);
        srmSupplierInformationMapper.deleteSrmSupplierAddressInformationBySupplierId(id);
        srmSupplierInformationMapper.deleteSrmSupplierInformationById(id);
        srmSupplierInformationMapper.deleteSrmSupplierInvoiceInformationBySupplierId(id);
        return srmSupplierInformationMapper.deleteSrmSupplierInformationById(id);
    }

    /**
     * 新增供应商联系人信息信息
     *
     * @param srmSupplierInformation 供应商信息对象
     */
    public void insertSrmSupplierContactInformation(SrmSupplierInformation srmSupplierInformation) {
        List<SrmSupplierContactInformation> srmSupplierContactInformationList = srmSupplierInformation.getSrmSupplierContactInformationList();
        Long id = srmSupplierInformation.getId();
        if (StringUtils.isNotNull(srmSupplierContactInformationList)) {
            List<SrmSupplierContactInformation> list = new ArrayList<SrmSupplierContactInformation>();
            for (SrmSupplierContactInformation srmSupplierContactInformation : srmSupplierContactInformationList) {
                srmSupplierContactInformation.setSupplierId(id);
                list.add(srmSupplierContactInformation);
            }
            if (list.size() > 0) {
                srmSupplierInformationMapper.batchSrmSupplierContactInformation(list);
            }
        }
    }

    /**
     * 新增供应商地址信息信息
     *
     * @param srmSupplierInformation 供应商信息对象
     */
    public void insertSrmSupplierAddressInformation(SrmSupplierInformation srmSupplierInformation) {
        List<SrmSupplierAddressInformation> srmSupplierAddressInformationList = srmSupplierInformation.getSrmSupplierAddressInformationList();
        Long id = srmSupplierInformation.getId();
        if (StringUtils.isNotNull(srmSupplierAddressInformationList)) {
            List<SrmSupplierAddressInformation> list = new ArrayList<SrmSupplierAddressInformation>();
            for (SrmSupplierAddressInformation srmSupplierAddressInformation : srmSupplierAddressInformationList) {
                srmSupplierAddressInformation.setSupplierId(id);
                list.add(srmSupplierAddressInformation);
            }
            if (list.size() > 0) {
                srmSupplierInformationMapper.batchSrmSupplierAddressInformation(list);
            }
        }
    }


    /**
     * 新增供应商银行信息信息
     *
     * @param srmSupplierInformation 供应商信息对象
     */
    public void insertSrmSupplierBankInformation(SrmSupplierInformation srmSupplierInformation) {
        List<SrmSupplierBankInformation> srmSupplierBankInformationList = srmSupplierInformation.getSrmSupplierBankInformationList();
        Long id = srmSupplierInformation.getId();
        if (StringUtils.isNotNull(srmSupplierBankInformationList)) {
            List<SrmSupplierBankInformation> list = new ArrayList<SrmSupplierBankInformation>();
            for (SrmSupplierBankInformation srmSupplierBankInformation : srmSupplierBankInformationList) {
                srmSupplierBankInformation.setSupplierId(id);
                list.add(srmSupplierBankInformation);
            }
            if (list.size() > 0) {
                srmSupplierInformationMapper.batchSrmSupplierBankInformation(list);
            }
        }
    }

    /**
     * 新增供应商开票信息信息
     *
     * @param srmSupplierInformation 供应商信息对象
     */
    public void insertSrmSupplierInvoiceInformation(SrmSupplierInformation srmSupplierInformation) {
        List<SrmSupplierInvoiceInformation> srmSupplierInvoiceInformationList = srmSupplierInformation.getSrmSupplierInvoiceInformationList();
        Long id = srmSupplierInformation.getId();
        if (StringUtils.isNotNull(srmSupplierInvoiceInformationList)) {
            List<SrmSupplierInvoiceInformation> list = new ArrayList<SrmSupplierInvoiceInformation>();
            for (SrmSupplierInvoiceInformation srmSupplierInvoiceInformation : srmSupplierInvoiceInformationList) {
                srmSupplierInvoiceInformation.setSupplierId(id);
                list.add(srmSupplierInvoiceInformation);
            }
            if (list.size() > 0) {
                srmSupplierInformationMapper.batchSrmSupplierInvoiceInformation(list);
            }
        }
    }


    /**
     * http get请求
     *
     * @param url   接口url
     * @param token token
     * @return 返回接口数据
     */
    protected static String executeGet(String url, String token) {
        BasicHttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, 1000);
        HttpConnectionParams.setSoTimeout(httpParams, 1000);
        HttpClient httpClient = new DefaultHttpClient(httpParams);
        String result = null;
        try {

            HttpGet get = new HttpGet(url);
            // 设置header
            get.setHeader("Authorization", token);
            // 设置类型
            HttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "utf-8");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return result;
    }
}
