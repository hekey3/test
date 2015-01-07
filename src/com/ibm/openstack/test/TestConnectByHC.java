package com.ibm.openstack.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class TestConnectByHC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			post();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	  

    /** 
     * 发送 post请求访问本地应用并根据传递参数不同返回不同结果 
     * @throws UnsupportedEncodingException 
     */  
    public static void post() throws UnsupportedEncodingException {  
        // 创建默认的httpClient实例.    
    	DefaultHttpClient httpclient = new DefaultHttpClient(); 
        // 创建httppost    
        HttpPost httppost = new HttpPost("http://9.112.233.26:5000/v2.0/tokens");
        httppost.setHeader("Content-Type", "application/json");
        httppost.setHeader("Accept", "application/json");
        
        
        StringEntity s = new StringEntity("{"+
	    " \"auth\": {"+  
	    "\"tenantName\": \"service\","+   
	    "\"passwordCredentials\": {"+	
	    	"\"username\": \"admin\","+    
	    	"\"password\": \"openstack1\""+    
	    	"}"+    
        "}"+
        "}");    
        s.setContentEncoding("UTF-8");    
        s.setContentType("application/json");    
        httppost.setEntity(s); 
        
        
        
        try {  
            //uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
            //httppost.setEntity(uefEntity);  
            System.out.println("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                HttpEntity entity = response.getEntity();  
                if (entity != null) {  
                    System.out.println("--------------------------------------");  
                    System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));  
                    System.out.println("--------------------------------------");  
                }  
            } finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
        	 httpclient.close();  
        }  
    } 
    
}
