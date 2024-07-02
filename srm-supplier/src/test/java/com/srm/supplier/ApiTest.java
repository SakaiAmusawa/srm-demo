package com.srm.supplier;

import com.google.gson.Gson;
import com.srm.common.core.domain.AjaxResult;
import com.srm.supplier.domain.CompanyInfo;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

public class ApiTest {

    public static void main(String[] args) {
        String companyName = "test";

        String token = "c1a18228-d4e9-4d3e-bcd7-bbf00f7f0edd";
        String url = "http://open.api.tianyancha.com/services/open/ic/baseinfo/normal?keyword=" + companyName;
        String jsonResponse = executeGet(url, token);

        Gson gson = new Gson();
        CompanyInfo companyInfo = gson.fromJson(jsonResponse, CompanyInfo.class);

        if (companyInfo.getResult() != null) {
            String ln = companyInfo.getResult().getLegalPersonName();
            System.out.println(ln);
        } else {
            System.out.println("查询失败");
            AjaxResult.error(companyInfo.getErrorCode(), companyInfo.getReason());
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
