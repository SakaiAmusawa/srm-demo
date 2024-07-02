package com.srm.supplier.service.impl;

import com.google.gson.Gson;
import com.srm.supplier.domain.CompanyInfo;
import com.srm.supplier.mapper.SrmSupplierMapper;
import com.srm.supplier.service.ISrmSupplierService;
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

@Service
public class SrmSupplierServiceImpl implements ISrmSupplierService {

    @Autowired
    private SrmSupplierMapper srmSupplierMapper;

    @Override
    public void supplierRegister() {

        String companyName = "test";

        String token = "c1a18228-d4e9-4d3e-bcd7-bbf00f7f0edd";
        String url = "http://open.api.tianyancha.com/services/open/ic/baseinfo/normal?keyword=" + companyName;
        String jsonResponse = executeGet(url, token);
        System.out.println(jsonResponse);

        // Convert JSON response to Java object
        Gson gson = new Gson();
        CompanyInfo companyInfo = gson.fromJson(jsonResponse, CompanyInfo.class);
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
