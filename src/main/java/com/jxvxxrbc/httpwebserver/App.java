package com.jxvxxrbc.httpwebserver;

import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class App {

	String rutaArchivo = "src/main/java/com/jxvxxrbc/httpwebserver/messages.txt";
	byte[] buffer = new byte[8];
	StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// server socket to handle connections
		try (ServerSocket server = new ServerSocket(1234)) {
			System.out.println("server iniciado");

			// accept connections and print inetAddress
			Socket client = server.accept();
			System.out.println("client: " + client.getInetAddress());

		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
		}
	}

	public void getLinesReader(Socket s) {
		int readBytes;
		try (FileInputStream fis = new FileInputStream(rutaArchivo)) {
			while ((readBytes = fis.read(buffer)) != -1) {
				for (int i = 0; i < readBytes; i++) {
					char c = (char) buffer[i];
					if (c == '\n') {
						System.out.printf("read: %s\n", sb.toString());
						sb.setLength(0);
					} else {
						sb.append(c);
					}
				}

				if (sb.length() > 0) {
					System.out.printf("%s\n", sb.toString());
				}
			}
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}
	}
}
