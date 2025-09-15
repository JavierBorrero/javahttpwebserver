package com.jxvxxrbc.httpwebserver;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class App {

	static String rutaArchivo = "src/main/java/com/jxvxxrbc/httpwebserver/messages.txt";
	static byte[] buffer = new byte[1024];

	public static void main(String[] args) {
		// server socket to handle connections
		try (ServerSocket server = new ServerSocket(1234)) {
			System.out.println("server iniciado");

			// accept connections and print inetAddress
			Socket conn = server.accept();
			System.out.println("client: " + conn.getInetAddress());

			String s = getLinesReader(conn);
			System.out.println("read: " + s);

			conn.close();
			server.close();

		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
		}
	}

	public static String getLinesReader(Socket s) {
		String str = "";
		int readBytes;

		try {
			InputStream is = s.getInputStream();
			while ((readBytes = is.read(buffer)) != -1) {
				for (int i = 0; i < readBytes; i++) {
					char c = (char) buffer[i];
					if (c == '\n') {
						return str;
					} else {
						str += c;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}

		return str;
	}
}
