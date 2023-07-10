import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testWebService {

	public static void main(String[] args) throws Exception {
		String strFlowNum = "BTSXXXXX";
		String strEmpno ="Sexy650227";
		String strDept_no = "G-Boy";
		String strEff_date = "2023/07/10";

		//call web service
		String strNote = call_CHECK_WS("XXXX?wsdl",strFlowNum,strEmpno,strDept_no,strEff_date);
		if (strNote.equals("OK")) {
			strNote = call_INSERT_WS("XXXX?wsdl",strFlowNum,strEmpno,strDept_no,strEff_date);
			if (strNote.equals("OK")){


			}
		}
	}
	static String call_INSERT_WS (String endpoint,String flow_num,String empno ,String deptno,String strEff_date) throws Exception{
		String result = "";
		//第一步：建立服務地址  
		URL url = new URL(endpoint);  
		//第二步：開啟一個通向服務地址的連線  
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();  
		//第三步：設定引數  
		//3.1傳送方式設定：POST必須大寫  
		connection.setRequestMethod("POST");  
		//3.2設定資料格式：content-type  
		connection.setRequestProperty("content-type", "text/xml;charset=utf-8");  
		//3.3設定輸入輸出，因為預設新建立的connection沒有讀寫許可權，  
		connection.setDoInput(true);  
		connection.setDoOutput(true);  

		//第四步：組織SOAP資料，傳送請求  
		String soapXML = getXML_INSERT_PERSONNEL(flow_num,empno,deptno,strEff_date);  
		//將資訊以流的方式傳送出去
		OutputStream os = connection.getOutputStream();  
		os.write(soapXML.getBytes());  
		//第五步：接收服務端響應，列印  
		int responseCode = connection.getResponseCode();  
		if(200 == responseCode){//表示服務端響應成功  
			//獲取當前連線請求返回的資料流
			InputStream is = connection.getInputStream();  
			InputStreamReader isr = new InputStreamReader(is);  
			BufferedReader br = new BufferedReader(isr);  

			StringBuilder sb = new StringBuilder();  
			String temp = null;  
			while(null != (temp = br.readLine())){  
				sb.append(temp);  
			}  



			/**
			 * 列印結果
			 */
			if (sb.indexOf("<MESSAGE>") !=-1){
				System.out.println("Get_P_INSERT_PERSONNEL_CHANGE_TW:"+ sb.toString());
				result = sb.substring(sb.indexOf("<MESSAGE>")+9,sb.indexOf("</MESSAGE>"));
			}
			is.close();  
			isr.close();  
			br.close(); 

		}  
		os.close();  

		return result;
	}
	private static String call_CHECK_WS (String endpoint,String flow_num,String empno ,String deptno,String strEff_date) throws Exception{
		String result = "";
		//第一步：建立服務地址  
		URL url = new URL(endpoint);  
		//第二步：開啟一個通向服務地址的連線  
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();  
		//第三步：設定引數  
		//3.1傳送方式設定：POST必須大寫  
		connection.setRequestMethod("POST");  
		//3.2設定資料格式：content-type  
		connection.setRequestProperty("content-type", "text/xml;charset=utf-8");  
		//3.3設定輸入輸出，因為預設新建立的connection沒有讀寫許可權，  
		connection.setDoInput(true);  
		connection.setDoOutput(true);  

		//第四步：組織SOAP資料，傳送請求  
		String soapXML = getXML_CHECK_PERSONNEL(flow_num,empno,deptno,strEff_date);  
		//將資訊以流的方式傳送出去
		OutputStream os = connection.getOutputStream();  
		os.write(soapXML.getBytes());  
		//第五步：接收服務端響應，列印  
		int responseCode = connection.getResponseCode();  
		if(200 == responseCode){//表示服務端響應成功  
			//獲取當前連線請求返回的資料流
			InputStream is = connection.getInputStream();  
			InputStreamReader isr = new InputStreamReader(is);  
			BufferedReader br = new BufferedReader(isr);  

			StringBuilder sb = new StringBuilder();  
			String temp = null;  
			while(null != (temp = br.readLine())){  
				sb.append(temp);  
			}  			
			/**
			 * 列印結果
			 */
			if (sb.indexOf("<MESSAGE>") != -1){
				System.out.println("Get_P_CHECK_PERSONNEL_CHANGE_TW:"+ sb.toString());
				result = sb.substring(sb.indexOf("<MESSAGE>")+9,sb.indexOf("</MESSAGE>"));
			}
			is.close();  
			isr.close();  	
			br.close();

		}  
		os.close(); 

		return result;
	}
	static String getXML_CHECK_PERSONNEL(String flow_num,String empno,String deptno,String strEff_date){  
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy/MM/dd");
		String dNow =ft.format(date);

		String soapXML =
				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">"
						+"   <soapenv:Header/>"
						+"   <soapenv:Body>"
						+"      <tem:Get_P_CHECK_PERSONNEL_CHANGE_TW>"
						+"         <!--Optional:-->"
						+"         <tem:SEGMENT_NO>A001</tem:SEGMENT_NO>"
						+"         <!--Optional:-->"
						+"         <tem:ID_NO_SZ>"+empno+"</tem:ID_NO_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:VALIDDATE>"+strEff_date+"</tem:VALIDDATE>"
						+"         <!--Optional:-->"
						+"         <tem:ISSUETYPE_SZ>P02</tem:ISSUETYPE_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_TRANSFER_REASON_SZ>PERSONNEL CHANGE</tem:NEW_TRANSFER_REASON_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_DEPARTMENT_SZ>"+deptno+"</tem:NEW_DEPARTMENT_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_TITLE_SZ></tem:NEW_TITLE_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_COSTALLOCATION_SZ></tem:NEW_COSTALLOCATION_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_OVERTIM_TYPE_SZ></tem:NEW_OVERTIM_TYPE_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_ABSENCE_TYPE_SZ></tem:NEW_ABSENCE_TYPE_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_YEAR_LEAVE_SZ></tem:NEW_YEAR_LEAVE_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_JOBCATEGORY></tem:NEW_JOBCATEGORY>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_CONTRACT></tem:NEW_CONTRACT>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_PERIOD_SZ></tem:NEW_PERIOD_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_TAX_SZ></tem:NEW_TAX_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_LEADER></tem:NEW_LEADER>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_ZONE_SZ></tem:NEW_ZONE_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_PRO_TITLE_SZ></tem:NEW_PRO_TITLE_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_JOB_NO></tem:NEW_JOB_NO>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_GL_DEPARTMENT_CODE></tem:NEW_GL_DEPARTMENT_CODE>"
						+"         <!--Optional:-->"
						+"         <tem:ISSUENO>"+flow_num+"</tem:ISSUENO>"
						+"         <!--Optional:-->"
						+"         <tem:ISSUEDATE>"+dNow+"</tem:ISSUEDATE>"
						+"      </tem:Get_P_CHECK_PERSONNEL_CHANGE_TW>"
						+"   </soapenv:Body>"
						+"</soapenv:Envelope>";

		return soapXML;  
	}
	static String getXML_INSERT_PERSONNEL(String flow_num,String empno,String deptno,String strEff_date){  
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy/MM/dd");
		String dNow =ft.format(date);

		String soapXML =
				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">"
						+"   <soapenv:Header/>"
						+"   <soapenv:Body>"
						+"      <tem:Get_P_INSERT_PERSONNEL_CHANGE_TW>"
						+"         <!--Optional:-->"
						+"         <tem:SEGMENT_NO>A001</tem:SEGMENT_NO>"
						+"         <!--Optional:-->"
						+"         <tem:ID_NO_SZ>"+empno+"</tem:ID_NO_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:VALIDDATE>"+strEff_date+"</tem:VALIDDATE>"
						+"         <!--Optional:-->"
						+"         <tem:ISSUETYPE_SZ>P02</tem:ISSUETYPE_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_TRANSFER_REASON_SZ>PERSONNEL CHANGE</tem:NEW_TRANSFER_REASON_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_DEPARTMENT_SZ>"+deptno+"</tem:NEW_DEPARTMENT_SZ>"
						+"         <!--Optional:-->"	
						+"         <tem:NEW_TITLE_SZ></tem:NEW_TITLE_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_COSTALLOCATION_SZ></tem:NEW_COSTALLOCATION_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_OVERTIM_TYPE_SZ></tem:NEW_OVERTIM_TYPE_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_ABSENCE_TYPE_SZ></tem:NEW_ABSENCE_TYPE_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_YEAR_LEAVE_SZ></tem:NEW_YEAR_LEAVE_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_JOBCATEGORY></tem:NEW_JOBCATEGORY>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_CONTRACT></tem:NEW_CONTRACT>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_PERIOD_SZ></tem:NEW_PERIOD_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_TAX_SZ></tem:NEW_TAX_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_LEADER></tem:NEW_LEADER>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_ZONE_SZ></tem:NEW_ZONE_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_PRO_TITLE_SZ></tem:NEW_PRO_TITLE_SZ>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_JOB_NO></tem:NEW_JOB_NO>"
						+"         <!--Optional:-->"
						+"         <tem:NEW_GL_DEPARTMENT_CODE></tem:NEW_GL_DEPARTMENT_CODE>"
						+"         <!--Optional:-->"
						+"         <tem:ISSUENO>"+flow_num+"</tem:ISSUENO>"
						+"         <!--Optional:-->"
						+"         <tem:ISSUEDATE>"+dNow+"</tem:ISSUEDATE>"
						+"      </tem:Get_P_INSERT_PERSONNEL_CHANGE_TW>"
						+"   </soapenv:Body>"
						+"</soapenv:Envelope>";

		return soapXML;  
	}
}


