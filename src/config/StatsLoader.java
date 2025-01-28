package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class  StatsLoader {
	private static Properties properties = new Properties();
	
	public static void loadStats(String filepath) throws IOException {
		FileInputStream fis = new FileInputStream(filepath);
		properties.load(fis);
	}
	
	public static int getStat(String key) {
		return Integer.parseInt(properties.getProperty(key));
	}
}