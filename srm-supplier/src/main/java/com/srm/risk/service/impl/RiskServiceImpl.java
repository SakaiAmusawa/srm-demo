package com.srm.risk.service.impl;

import com.srm.risk.domain.entity.TaxRisk;
import com.srm.risk.mapper.RiskMapper;
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
     * @param supplierName 供应商名称
     * @return
     */
    @Override
    public TaxResponse executeGet(String supplierName) {
        String url = "http://open.api.tianyancha.com/services/open/mr/taxContravention/2.0?pageSize=20&keyword=" + supplierName + "&pageNum=1";
        String token = "c1a18228-d4e9-4d3e-bcd7-bbf00f7f0edd";
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", token);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<TaxResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, TaxResponse.class);
            TaxResponse body = response.getBody();
            assert body != null;
            List<TaxRisk> items = body.getResult().getItems();
            for (TaxRisk item : items) {
                riskMapper.insertTaskRisk(item);
            }
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
