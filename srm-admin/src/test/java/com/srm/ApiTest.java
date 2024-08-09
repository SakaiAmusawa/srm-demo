package com.srm;


import com.srm.risk.domain.entity.IllegalRisk;
import com.srm.risk.mapper.RiskMapper;
import com.srm.risk.response.IllegalResponse;
import com.srm.risk.service.impl.RiskServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@Slf4j
@SpringBootTest
public class ApiTest {


    @Nested
    class RiskServiceImplTest {

        @Mock
        private RestTemplate restTemplate;

        @Mock
        private RiskMapper riskMapper;

        @InjectMocks
        private RiskServiceImpl riskService;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        void testExecuteGetIllegal() {
            // 准备测试数据
            String supplierName = "Test Supplier";
            String token = "c1a18228-d4e9-4d3e-bcd7-bbf00f7f0edd";
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", token);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            /**
             * 测试报文
             * {
             *   "result": {
             *     "total": 1,
             *     "items": [
             *       {
             *         "removeDate": null,
             *         "putReason": "被列入经营异常名录届满3年仍未履行相关义务的",
             *         "putDepartment": "广州市市场监督管理局",
             *         "removeDepartment": "",
             *         "removeReason": "",
             *         "putDate": 1563897600000
             *       }
             *     ]
             *   },
             *   "reason": "ok",
             *   "error_code": 0
             * }
             */

            // 模拟响应数据
            IllegalRisk illegalRisk = new IllegalRisk();
            illegalRisk.setPutDate(1563897600000L);
            illegalRisk.setPutReason("被列入经营异常名录届满3年仍未履行相关义务的");
            illegalRisk.setPutDepartment("广州市市场监督管理局");

            IllegalResponse.Result result = new IllegalResponse.Result();
            result.setTotal(1);
            result.setItems(Collections.singletonList(illegalRisk));

            IllegalResponse mockResponse = new IllegalResponse();
            mockResponse.setErrorCode(0);
            mockResponse.setReason("ok");
            mockResponse.setResult(result);

            when(restTemplate.exchange(
                    ArgumentMatchers.any(String.class),
                    ArgumentMatchers.eq(HttpMethod.GET),
                    ArgumentMatchers.any(HttpEntity.class),
                    ArgumentMatchers.eq(IllegalResponse.class)
            )).thenReturn(ResponseEntity.ok(mockResponse));

            // 调用方法
            IllegalResponse response = riskService.executeGetIllegal(supplierName);

            // Assert
            assertNotNull(response);
            assertEquals(0, response.getErrorCode());
            assertEquals("ok", response.getReason());
            assertEquals(1, response.getResult().getTotal());
            assertEquals(1, response.getResult().getItems().size());
            IllegalRisk risk = response.getResult().getItems().get(0);
            assertEquals(1563897600000L, risk.getPutDate());
            assertEquals("被列入经营异常名录届满3年仍未履行相关义务的", risk.getPutReason());
            assertEquals("广州市市场监督管理局", risk.getPutDepartment());

            //测试数据的展示
            log.info("Response: {}", response);
        }

    }


    @Test
    public void timeTest() {
        long currentTimeSeconds = System.currentTimeMillis() / 1000;
        System.out.println("currentTimeSeconds = " + currentTimeSeconds);
    }
}


