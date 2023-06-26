import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Hashtable;

import com.pub.database.QueryBean;


public class FileServiceTransferToDB {

	public static void main(String[] args) {
		String directory = "path"; 

		QueryBean gqbnDAO_CSDQCS = null;
		Hashtable htSourceData = null;
		String fileName = null;
		String fileId = null;
		String file = null;
		Connection conn = null;
		File f = null;
		PreparedStatement statement=null;
		String[] paths;
		System.out.println("startTime:"+new Date());
		try {
			gqbnDAO_CSDQCS = new QueryBean("CSDQCS_CSDQCS", true, "utf-8",
					"utf-8");
			conn = gqbnDAO_CSDQCS.getConnection();

			f = new File(directory);

			// array of files and directory
			paths = f.list();

			// for each name in the path array
			for (String path : paths) {

				String str[] = path.split(",");
				System.out.println(str[0].trim());
				System.out.println(str[1]);
				InputStream inputStream = new FileInputStream(new File(directory+path));

				String sql = "update blob sql";
				statement = conn.prepareStatement(sql);
				statement.setBlob(1, inputStream);
				
				int row = statement.executeUpdate();
				if (row > 0) {
					System.out.println(str[0] + " update success! </br>");
				} else {
					System.out.println(str[0] + " update fail! </br>");
				}
				statement.close();
			}
			System.out.println("endTime:"+new Date());
			
			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}

}
