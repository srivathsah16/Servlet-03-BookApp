package in.srivath.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	private static HikariDataSource dataSource = null;

	public static Connection getConnection() throws SQLException {
		if (dataSource == null) {
			try {
				FileInputStream fis = new FileInputStream(
						new File("C:\\Users\\SRIVATH\\new-eclipse-ws\\Servlet-03-BookApp\\dbProp.properties"));
				Properties props = new Properties();
				props.load(fis);
				HikariConfig config = new HikariConfig();
				config.setDriverClassName(props.getProperty("db.driver"));
				config.setJdbcUrl(props.getProperty("db.url"));
				config.setUsername(props.getProperty("db.username"));
				config.setPassword(props.getProperty("db.password"));
				dataSource = new HikariDataSource(config);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dataSource.getConnection();
	}
}
