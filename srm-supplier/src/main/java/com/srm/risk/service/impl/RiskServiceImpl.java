package com.srm.risk.service.impl;

import com.srm.risk.domain.entity.OperateRisk;
import com.srm.risk.domain.entity.TaxRisk;
import com.srm.risk.mapper.RiskMapper;
import com.srm.risk.response.OperateResponse;
import com.srm.risk.response.TaxResponse;
import com.srm.risk.service.IRiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RiskServiceImpl implements IRiskService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RiskMapper riskMapper;

    /**
     * 税务风险查询
     *
     * @param supplierName 供应商名称
     * @return
     */
    @Override
    public TaxResponse executeGet(String supplierName) {
        //API地址
        String url = "http://open.api.tianyancha.com/services/open/mr/taxContravention/2.0?pageSize=20&keyword=" + supplierName + "&pageNum=1";
        //天眼查API的TOKEN
        String token = "c1a18228-d4e9-4d3e-bcd7-bbf00f7f0edd";
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", token);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<TaxResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, TaxResponse.class);
            TaxResponse body = response.getBody();
            assert body != null;
            List<TaxRisk> items = body.getResult().getItems();
            //存入数据库
            for (TaxRisk item : items) {
                item.setSupplierName(supplierName);
                riskMapper.insertTaskRisk(item);
            }
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 历史经营风险
     * @param supplierName 供应商名称
     * @return  响应体
     */
    @Override
    public OperateResponse executeGetOperate(String supplierName) {
        String url = "http://open.api.tianyancha.com/services/open/hi/abnormal/2.0?pageSize=20&keyword=" + supplierName + "&pageNum=1";
        String token = "c1a18228-d4e9-4d3e-bcd7-bbf00f7f0edd";
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", token);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<OperateResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, OperateResponse.class);
            OperateResponse operateResponse = response.getBody();
            assert operateResponse != null;
            List<OperateRisk> operateRisks = operateResponse.getResult().getOperateRisks();

            for (OperateRisk operateRisk : operateRisks) {
                operateRisk.setSupplierName(supplierName);
                riskMapper.insertOperateRisk(operateRisks);
            }

            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
