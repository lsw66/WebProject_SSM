package youdao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;



public class yuodaoapi {
//	private static Logger logger = LoggerFactory.getLogger(OcrtransV1Demo.class);

    private static final String YOUDAO_URL = "https://openapi.youdao.com/ocrtransapi";

    private static final String APP_KEY = "08a596877b07f6c0";

    private static final String APP_SECRET = "RN4ciPjwNdZrQk2SYHeHQT9P4FQiDxCe";

    
    
    public static String youdao(String urlAddress){

        Map<String,String> params = new HashMap<String,String>();
       // String q = loadAsBase64(urlAddress);
        String q=urlAddress;
        System.out.println("q:   "+q);
        String salt = String.valueOf(System.currentTimeMillis());
        String from = "zh-CHS";
        String to = "en";
        String type = "1";
        params.put("from",from);
        params.put("to",to);
        params.put("type",type);
        params.put("q", q);
        String signStr = APP_KEY + q + salt + APP_SECRET;
        String sign = getDigest(signStr);
        params.put("appKey", APP_KEY);
        params.put("salt", salt);
        params.put("sign", sign);
        String result;
		try {
			result = requestForHttp(YOUDAO_URL,params);
	        System.out.println(result);
	        return result; 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return null; 
		}
        /** 处理结果 */

    }

    public static String requestForHttp(String url,Map<String,String> params) throws IOException {
        String result = "";

        /** 创建HttpClient */
        CloseableHttpClient httpClient = HttpClients.createDefault();

        /** httpPost */
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> paramsList = new ArrayList<NameValuePair>();
        Iterator<Map.Entry<String,String>> it = params.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,String> en = it.next();
            String key = en.getKey();
            String value = en.getValue();
            paramsList.add(new BasicNameValuePair(key,value));
        }
        httpPost.setEntity(new UrlEncodedFormEntity(paramsList,"UTF-8"));
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        try{
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity,"UTF-8");
            EntityUtils.consume(httpEntity);
        }finally {
            try{
                if(httpResponse!=null){
                    httpResponse.close();
                }
            }catch(IOException e){
               // logger.info("## release resouce error ##" + e);
            }
        }
        return result;
    }

    /**
     * 生成加密字段
     */
    public static String getDigest(String string) {
        if (string == null) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        byte[] btInput = string.getBytes(StandardCharsets.UTF_8);
        try {
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String loadAsBase64(String imgFile)
  {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理

    File file = new File(imgFile);
    if(!file.exists()){
      //  logger.error("文件不存在");
        return null;
    }
    InputStream in = null;
    byte[] data = null;
      //读取图片字节数组
    try
    {
        in = new FileInputStream(imgFile);
        data = new byte[in.available()];
        in.read(data);
        in.close();
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
      //对字节数组Base64编码
    return Base64.getEncoder().encodeToString(data);//返回Base64编码过的字节数组字符串
  }

  public static String truncate(String q) {
        if (q == null) {
            return null;
        }
        int len = q.length();
        String result;
        return len <= 20 ? q : (q.substring(0, 10) + len + q.substring(len - 10, len));
    }
}

