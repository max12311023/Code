import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.pub.database.QueryBean;


public class DBTransferToFileService {

	public static void main(String[] args) {
		String directory = "path";

		QueryBean gqbnDAO_CSDQCS=null;
		String fileName=null;
		String fileId=null;
		String file=null;
		Connection conn = null;
		Statement st=null;
		ResultSet rs = null;

		String sql=
				"select SQL";
		try {
			gqbnDAO_CSDQCS=new QueryBean("CSDQCS_CSDQCS",true,"utf-8","utf-8");
			conn = gqbnDAO_CSDQCS.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			System.out.println("startTime:"+new Date());
			while(rs.next()){
				fileId = rs.getString("file_id").trim();
				fileName = rs.getString("file_name").trim();
				file = fileId +","+fileName;
				System.out.println(file);
				java.sql.Blob blob = rs.getBlob("file_data");
				
				InputStream inputStream = blob.getBinaryStream();
				FileOutputStream fileOutputStream = new FileOutputStream(directory + file);
				fileOutputStream.write(blob.getBytes(1, (int) blob.length()));
				inputStream.close();
				fileOutputStream.flush();
				fileOutputStream.close();
			}
			System.out.println("endTime:"+new Date());
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
