package com.jxvxxrbc.httpwebserver.tcplistener;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TcpListener
 */
public class TcpListener {

	static byte[] buffer = new byte[16];

	public TcpListener() {
	}

	public void ServerInit() {
		// server socket to handle connections
		try (ServerSocket server = new ServerSocket(1234)) {
			System.out.println("server iniciado");

			// accept connections and print inetAddress
			Socket conn = server.accept();
			System.out.println("client: " + conn.getInetAddress());

			getLinesSocket(conn);

		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
		}
	}

	public void getLinesSocket(Socket s) {
		String str = "";
		int readBytes;
		try {
			InputStream is = s.getInputStream();
			// read message from socket until the end
			while ((readBytes = is.read(buffer)) != -1) {
				for (int i = 0; i < readBytes; i++) {
					// go char by char
					char c = (char) buffer[i];
					// if char is a new line
					if (c == '\n') {
						// print and clear the str
						System.out.println("read: " + str);
						str = "";
					} else {
						// else keep appending chars
						str += c;
					}
				}
			}
			// close inputstream
			is.close();
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}
	}
}
