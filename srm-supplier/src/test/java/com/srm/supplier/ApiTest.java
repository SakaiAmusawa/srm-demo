package com.srm.supplier;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.srm.risk.response.IllegalResponse;
import com.srm.risk.service.IRiskService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;


@SpringBootTest
public class ApiTest {

    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private IRiskService riskService;
    @InjectMocks
    private ObjectMapper objectMapper;

    @Test
    void testExecuteGetIllegal() throws Exception {
        // 准备测试数据
        String supplierName = "testSupplier";
        String token = "c1a18228-d4e9-4d3e-bcd7-bbf00f7f0edd";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // 构建你的测试用的响应报文
        String responseBody = "{\"result\": {\"total\": 1,\"items\": [{\"removeDate\": null,\"putReason\": \"被列入经营异常名录届满3年仍未履行相关义务的\",\"putDepartment\": \"广州市市场监督管理局\",\"removeDepartment\": \"\",\"removeReason\": \"\",\"putDate\": 1563897600000}]},\"reason\": \"ok\",\"error_code\": 0}";

        // 使用Mockito模拟RestTemplate的exchange方法
        when(restTemplate.exchange(
                "http://open.api.tianyancha.com/services/open/mr/illegalinfo/2.0?pageSize=20&keyword=" + supplierName + "&pageNum=1",
                HttpMethod.GET,
                entity,
                IllegalResponse.class))
                .thenReturn(ResponseEntity.ok(objectMapper.readValue(responseBody, IllegalResponse.class)));

        // 调用你的方法
        IllegalResponse result = riskService.executeGetIllegal(supplierName);


    }
}


