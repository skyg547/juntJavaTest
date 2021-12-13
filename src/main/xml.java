package main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
//import java.net.URLEncoder;
import java.net.http.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class xml {

    //make xml request
    public static String makeXMLRequest(String url, String xml) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "text/xml");
        con.setRequestProperty("Content-Length", Integer.toString(xml.getBytes().length));
        con.setRequestProperty("Content-Language", "en-US");
        con.setUseCaches(false);
        con.setDoInput(true);
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(xml);
        wr.flush();
        wr.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    // combinaiton of makeXMLRequest and getXMLResponse
    public static String makeXMLRequestAndGetXMLResponse(String url, String xml) throws Exception {
        String response = makeXMLRequest(url, xml);
        return getXMLResponse(response);
    }

    // get xml response
    public static String getXMLResponse(String response) throws Exception {
        String xml = "";
        int start = response.indexOf("<response>");
        int end = response.indexOf("</response>");
        if (start != -1 && end != -1) {
            xml = response.substring(start + 10, end);
        }
        return xml;
    }

    // make xml document 
    public static String makeXml(HashMap<String, String> map) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        xml += "<root>";
        Set<String> keys = map.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            xml += "<" + key + ">" + map.get(key) + "</" + key + ">";
        }
        xml += "</root>";
        return xml;
    }

    // send xml document to server
    public static String sendXml(String xml, String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "text/xml");
        con.setDoOutput(true);
        con.setDoInput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(xml);
        wr.flush();
        wr.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    //get response from server
    public static String getResponse(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "text/xml");
        con.setDoOutput(true);
        con.setDoInput(true);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    public static void main(String[] args) {
        String xmlDatasStringf = "";

        xmlDatasStringf += "<root>";
        xmlDatasStringf += "<dataset01>";
        xmlDatasStringf += "<mobslipno>100041222282</mobslipno>";
        xmlDatasStringf += "<regusernm>김성욱</regusernm>";
        xmlDatasStringf += "<regdeptnm>영업팀</regdeptnm>";
        xmlDatasStringf += "<slipamt>1,000,000</slipamt>";
        xmlDatasStringf += "<essnccntn>삼성카드</essnccntn>";
        xmlDatasStringf += "<acntdt>2017-01-01</acntdt>";
        xmlDatasStringf += "<regdtm>2017-01-01</regdtm></dataset01>";
        xmlDatasStringf += "<dataset02>";
        xmlDatasStringf += "<record>";
        xmlDatasStringf += "<slipsno>1</slipsno>";
        xmlDatasStringf += "<essnccntn>삼성카드</essnccntn>";
        xmlDatasStringf += "<accd>1</accd>";
        xmlDatasStringf += "<acamt>1,000,000</acamt>";
        xmlDatasStringf += "<svos>1,000,000</svos>";
        xmlDatasStringf += "<vatamt>0</vatamt>";
        xmlDatasStringf += "</record>";
        xmlDatasStringf += "</dataset02>";
        xmlDatasStringf += "<dataset03><amt>1,000,000</amt></dataset03>";
        xmlDatasStringf += "<dataset04>";
        xmlDatasStringf += "<record>";
        xmlDatasStringf += "<slipsno>1</slipsno>";
        xmlDatasStringf += "<essnccntn>삼성카드</essnccntn>";
        xmlDatasStringf += "<accd>1</accd>";
        xmlDatasStringf += "<acamt>1,000,000</acamt>";
        xmlDatasStringf += "<svos>1,000,000</svos>";   
        xmlDatasStringf += "<vatamt>0</vatamt>";
        xmlDatasStringf += "</record>";
        xmlDatasStringf += "</dataset04>";
        xmlDatasStringf += "<dataset05><amt>1,000,000</amt></dataset05>";
        xmlDatasStringf += "</root>";

        //String xmlDatasString = URLEncoder.(xmlDatasStringf, "UTF-8");
        URL portalUrl = null;
        

        try {
            portalUrl =  new URL("http://portaldev.daiso.co.kr:8080/ikep/rest/comb/autoappr/report");  
            //BufferedReader in = new BufferedReader(new InputStreamReader(portalUrl.openStream()));
            
            HttpURLConnection conn = (HttpURLConnection)portalUrl.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setDoInput(true);


            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // 넘기는 값 세팅 
            StringBuffer buffer = new StringBuffer();

            HashMap<String, String> pList = new HashMap<String, String>();
            
            pList.put("FORM_ID", "100041222282");
            pList.put("APPR_TITLE", "경비전용 삼성 카드");
            pList.put("USER_ID", "ameerk789");
            pList.put("XML_PARAM", xmlDatasStringf);
            pList.put("PORTAL_ID", "P1");
            pList.put("APPKEY_01", "1000");
            pList.put("APPKEY_02", "17594387MOBTESTJAVA");


            Set key = pList.keySet();
            
            for(Iterator iterator = key.iterator(); iterator.hasNext();){
                String keyName = (String)iterator.next();
                String keyValue = pList.get(keyName);
                buffer.append(keyName + "=" + keyValue + "&");
            }


            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            PrintWriter writer = new PrintWriter(outputStreamWriter);
            writer.write(buffer.toString());
            writer.flush();

            // DataOutputStream outputStream = null;

            // try{
            //     outputStream = new DataOutputStream(conn.getOutputStream());
            //     outputStream.writeBytes(xmlDatasStringf);
            //     outputStream.flush();

            // }finally{
            //     if(outputStream != null){
            //         outputStream.close();
            //     }
            // }

            //conn.connect();           
            System.out.println(conn.getResponseCode()); 
            System.out.println( conn.getResponseMessage());

          
            // OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            // out.write("Firstname=kitae&LasstName-Hwang");
            // out.close();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));


            String line = null;

            while((line = in.readLine()) != null) {// 잃기
                System.out.println(line);
            }
            in.close();
            

        } catch (Exception e) {
            //TODO: handle exception
        }

        System.out.println("Protocol : " + portalUrl.getProtocol());   
        System.out.println("host : " + portalUrl.getHost());   
        System.out.println("path : " + portalUrl.getPath());   
        System.out.println("file : " + portalUrl.getFile());   
        System.out.println("port : " + portalUrl.getPort());     
        
        
        
        // type Post
        // url: "http://portaldev.daiso.co.kr:8080/ikep/rest/comb/autoappr/report", 개발
        // url: "http://portal.daiso.co.kr/rest/comb/autoappr/report",
        // header {Content-Type: application/x-www-form-urlencoded; charset=UTF-8}
        // "X-HTTP-Method-Override: Post"
        // time out 
        /* data
            {	"FORM_ID": "100041222282",
				"APPR_TITLE": "경비전용 삼성카드 " + response.sql1[0].ESSNC_CNTN,
				"USER_ID": erpId,
				"XML_PARAM": root,
				"PORTAL_ID": "P1",
				"APPKEY_01": "1000",
				"APPKEY_02": response.sql1[0].MOB_SLIP_NO
            }               
        */
        
        /* 데이터 구조 
        "<root>"
         '<dataset01>
         <mobslipno>' + $.fn.limitSpecialCharacters(response.sql1[0].MOB_SLIP_NO) + '</mobslipno>' +
				'<regusernm>' + $.fn.limitSpecialCharacters(response.sql1[0].USER_NM) + '</regusernm>' +
				'<regdeptnm>' + $.fn.limitSpecialCharacters(response.sql1[0].DEPT_NM) + '</regdeptnm>' +
				'<slipamt>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(response.sql1[0].SLIP_AMT)) + '</slipamt>' +
				'<essnccntn>' + $.fn.limitSpecialCharacters(response.sql1[0].ESSNC_CNTN) + '</essnccntn>' +
				'<acntdt>' + $.fn.limitSpecialCharacters(response.sql1[0].ACNT_DT.substr(0, 4)) + '-' + response.sql1[0].ACNT_DT.substr(4, 2) + '-' + response.sql1[0].ACNT_DT.substr(6, 2) + '</acntdt>' +
				'<regdtm>' + $.fn.limitSpecialCharacters(response.sql1[0].REG_DTM.substr(0, 10)) + '</regdtm></dataset01>';
               
                <dataset02>
                '<record>' +
                '<slipsno>' + $.fn.limitSpecialCharacters(element.SLIP_SNO) + '</slipsno>' +
                '<essnccntn>' + $.fn.limitSpecialCharacters(element.ESSNC_CNTN) + '</essnccntn>' +
                '<accd>' + $.fn.limitSpecialCharacters(element.AC_CD) + '</accd>' +
                '<acamt>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(element.AC_AMT)) + '</acamt>' +
                '<svos>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(element.SVOS)) + '</svos>' +
                '<vatamt>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(element.VAT_AMT)) + '</vatamt>' +
                '</record>';
                '</dataset02>'

                '<dataset03><amt>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(response.sql3[0].AC_AMT)) + '</amt></dataset03>';
              
                '</dataset04>'
                '<record>' +
					'<slipsno>' + $.fn.limitSpecialCharacters(element.SLIP_SNO) + '</slipsno>' +
					'<essnccntn>' + $.fn.limitSpecialCharacters(element.ESSNC_CNTN) + '</essnccntn>' +
					'<accd>' + $.fn.limitSpecialCharacters(element.AC_CD) + '</accd>' +
					'<acamt>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(element.AC_AMT)) + '</acamt>' +
					'<svos>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(element.SVOS)) + '</svos>' +
					'<vatamt>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(element.VAT_AMT)) + '</vatamt>' +
					'</record>';

                '</dataset04>'

                    '<dataset05><amt>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(response.sql5[0].AC_AMT)) + '</amt></dataset05>';
                   
                    "</root>" 
                     */ 
                    
                
     


        // try {

        //     URL url = new URL("http://www.google.com");
        //     HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //     connection.setRequestMethod("GET");
        //     connection.connect();
        //     int responseCode = connection.getResponseCode();
        //     System.out.println("Response Code: " + responseCode);
        //     if (responseCode == 200) {
        //         System.out.println("Success");
        //     } else {
        //         System.out.println("Failed");
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

    }

}
