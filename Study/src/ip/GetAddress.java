package ip;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;

import net.sf.json.JSONObject;

public class GetAddress {

	public static void main(String[] args){
		double d = 0.00;
		DecimalFormat df = new DecimalFormat("0.##");
		System.out.println(df.format(d));
	}
	
	
	
	public static String GetAddressByIp(String IP){
        String resout = null;
        try{
         String str = getJsonContent("http://ip.taobao.com/service/getIpInfo.php?ip="+IP);
         System.out.println(str);
          
         JSONObject obj = JSONObject.fromObject(str);
         JSONObject obj2 =  (JSONObject) obj.get("data");
         Integer code = (Integer) obj.get("code");
         if(code.equals(0)){
          
             resout =  obj2.get("country")+"." +obj2.get("region")+"." +obj2.get("city")+"." +obj2.get("isp");
         }else{
             resout =  "IP��ַ����";
         }
        }catch(Exception e){
             
            e.printStackTrace();
             resout = "��ȡIP��ַ�쳣��"+e.getMessage();
        }
        return resout;
          
    }
    
    public static String getJsonContent(String urlStr)
    {
        try
        {// ��ȡHttpURLConnection���Ӷ���
            URL url = new URL(urlStr);
            HttpURLConnection httpConn = (HttpURLConnection) url
                    .openConnection();
            // ������������
            httpConn.setConnectTimeout(3000);
            httpConn.setDoInput(true);
            httpConn.setRequestMethod("GET");
            // ��ȡ��Ӧ��
            int respCode = httpConn.getResponseCode();
            if (respCode == 200)
            {
                return ConvertStream2Json(httpConn.getInputStream());
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return "";
    }
 
    
    private static String ConvertStream2Json(InputStream inputStream)
    {
        String jsonStr = "";
        // ByteArrayOutputStream�൱���ڴ������
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        // ��������ת�Ƶ��ڴ��������
        try
        {
            while ((len = inputStream.read(buffer, 0, buffer.length)) != -1)
            {
                out.write(buffer, 0, len);
            }
            // ���ڴ���ת��Ϊ�ַ���
            jsonStr = new String(out.toByteArray());
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonStr;
    }
}
