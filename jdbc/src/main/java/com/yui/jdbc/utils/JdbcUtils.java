package com.yui.jdbc.utils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class JdbcUtils {

	// 数据库连接用户名
	private static String USERNAME;

	// 数据库连接密码
	private static String PASSWORD;

	// 数据库连接驱动
	private static String DRIVER;

	// 数据库连接url
	private static String URL;

	// 定义数据库的链接
	private static Connection conn;

	// 定义sql语句的执行对象
	private static PreparedStatement pstmt;

	// 定义查询返回的结果集合
	private static ResultSet rs;

	static {
		// 加载配置
		loadConfig();
	}

	/**
	 * 加载配置
	 */
	private static void loadConfig() {
		try {
			InputStream in = JdbcUtils.class.getResourceAsStream("/db.properties");
			Properties prop = new Properties();
			prop.load(in);
			USERNAME = prop.getProperty("jdbc.username");
			PASSWORD = prop.getProperty("jdbc.password");
			DRIVER = prop.getProperty("jdbc.driver");
			URL = prop.getProperty("jdbc.url");
		} catch (Exception e) {
			throw new RuntimeException("读取数据库配置文件异常！", e);
		}
	}

	/**
	 * 私有化构造函数
	 */
	private JdbcUtils() {
		super();
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return 数据库连接
	 */
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER); // 注册驱动
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); // 获取连接
		} catch (Exception e) {
			throw new RuntimeException("get connection error!", e);
		}
		return conn;
	}

	/**
	 * 释放资源
	 */
	public static void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 执行更新操作
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            执行参数
	 * @return 执行结果
	 * @throws SQLException
	 */
	public static boolean update(String sql, List<?> params) {
		boolean flag = false;
		getConnection();
		try {
			int result = -1;// 表示当用户执行添加删除和修改的时候所影响数据库的行数
			pstmt = conn.prepareStatement(sql);
			int index = 1;
			// 填充sql语句中的占位符
			if (params != null && !params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(index++, params.get(i));
				}
			}
			result = pstmt.executeUpdate();
			flag = result > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return flag;
	}

	/**
	 * 执行查询操作
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            执行参数
	 * @return
	 * @throws SQLException
	 */
	public static List<Map<String, Object>> find(String sql, List<?> params) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		conn = getConnection();
		try {
			int index = 1;
			pstmt = conn.prepareStatement(sql);
			if (params != null && !params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(index++, params.get(i));
				}
			}
			rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int cols_len = metaData.getColumnCount();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 0; i < cols_len; i++) {
					String cols_name = metaData.getColumnName(i + 1);
					Object cols_value = rs.getObject(cols_name);
					if (cols_value == null) {
						cols_value = "";
					}
					map.put(cols_name, cols_value);
				}
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return list;
	}

	/**
	 * 执行查询操作
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            执行参数
	 * @return
	 * @throws SQLException
	 */
	public static <T> List<T> find(String sql, List<?> params, Class<T> clazz) {
		List<T> list = new ArrayList<T>();
		conn = getConnection();
		try {
			int index = 1;
			pstmt = conn.prepareStatement(sql);
			if (params != null && !params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(index++, params.get(i));
				}
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(rowMapper(clazz));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return list;
	}

	/**
	 * 结果映射
	 * @param clazz
	 * @return
	 */
	public static <T> T rowMapper(Class<T> clazz) {
		try {
			if (rs != null) {
				T t = clazz.newInstance();
				Field[] fields = clazz.getDeclaredFields();
				Method[] methods = clazz.getDeclaredMethods();

				for (Field field : fields) {
					field.setAccessible(true);
					if ("Integer".equals(field.getType().getSimpleName())) {
						for (Method method : methods) {
							method.setAccessible(true);
							String name = method.getName();
							
							if (name.contains("set") && name.replace("set", "").toLowerCase()
									.equals(field.getName().toLowerCase())) {
								method.invoke(t, rs.getInt(field.getName()));
							}
						}
					} else if ("String".equals(field.getType().getSimpleName())) {
						for (Method method : methods) {
							method.setAccessible(true);
							if (method.getName().contains("set") && method.getName().replace("set", "").toLowerCase()
									.equals(field.getName().toLowerCase())) {
								method.invoke(t, rs.getString(field.getName()));
							}
						}
					} else if ("Date".equals(field.getType().getSimpleName())) {
						for (Method method : methods) {
							method.setAccessible(true);
							if (method.getName().contains("set") && method.getName().replace("set", "").toLowerCase()
									.equals(field.getName().toLowerCase())) {
								method.invoke(t, rs.getDate(field.getName()));
							}
						}
					} else if ("long".equals(field.getType().getSimpleName())) {
						for (Method method : methods) {
							method.setAccessible(true);
							if (method.getName().contains("set") && method.getName().replace("set", "").toLowerCase()
									.equals(field.getName().toLowerCase())) {
								method.invoke(t, rs.getLong(field.getName()));
							}
						}
					} else {
						for (Method method : methods) {
							method.setAccessible(true);
							if (method.getName().contains("set") && method.getName().replace("set", "").toLowerCase()
									.equals(field.getName().toLowerCase())) {
								method.invoke(t, rs.getObject(field.getName()));
							}
						}
					}
				}
				return t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
