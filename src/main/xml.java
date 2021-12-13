package main;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class xml {

    public static void main(String[] args) {

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
         '<dataset01><mobslipno>' + $.fn.limitSpecialCharacters(response.sql1[0].MOB_SLIP_NO) + '</mobslipno>' +
				'<regusernm>' + $.fn.limitSpecialCharacters(response.sql1[0].USER_NM) + '</regusernm>' +
				'<regdeptnm>' + $.fn.limitSpecialCharacters(response.sql1[0].DEPT_NM) + '</regdeptnm>' +
				'<slipamt>' + $.fn.limitSpecialCharacters($.fn.newStrfunction(response.sql1[0].SLIP_AMT)) + '</slipamt>' +
				'<essnccntn>' + $.fn.limitSpecialCharacters(response.sql1[0].ESSNC_CNTN) + '</essnccntn>' +
				'<acntdt>' + $.fn.limitSpecialCharacters(response.sql1[0].ACNT_DT.substr(0, 4)) + '-' + response.sql1[0].ACNT_DT.substr(4, 2) + '-' + response.sql1[0].ACNT_DT.substr(6, 2) + '</acntdt>' +
				'<regdtm>' + $.fn.limitSpecialCharacters(response.sql1[0].REG_DTM.substr(0, 10)) + '</regdtm></dataset01>';
               
                <dataset02>'<record>' +
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
                    
                
        String xmlDatasStringf = "";

        try {

            URL url = new URL("http://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            if (responseCode == 200) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
