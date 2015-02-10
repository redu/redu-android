package br.com.developer.redu.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import android.content.Context;
import android.content.res.AssetManager;

/**
 * @author mateus
 * Classe estática que armazena informações do servidor(endereço IP e porta).
 */
public class ServerInfo {

	private static String IP_ADDRESS;
	private static String PORT;

	public static boolean init(Context context) {
		AssetManager assetManager = context.getResources().getAssets();
		InputStream inputStream;
		try {
			inputStream = assetManager.open("server.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			IP_ADDRESS = properties.getProperty("ip_address");
			PORT = properties.getProperty("port");
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static String getIpAddress() {
		return IP_ADDRESS;
	}

	public static String getPort() {
		return PORT;
	}
}
