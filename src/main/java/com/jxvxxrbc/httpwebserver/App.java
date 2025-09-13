package com.jxvxxrbc.httpwebserver;

import java.net.ServerSocket;
import java.net.Socket;

public class App {
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

		//// ruta del archivo
		// String rutaArchivo = "src/main/java/com/jxvxxrbc/httpwebserver/messages.txt";

		//// tamaño del buffer a leer
		// byte[] buffer = new byte[8];

		//// StringBuilder para almacenar los caracteres
		// StringBuilder sb = new StringBuilder();

		//// leer el archivo
		// try (FileInputStream fis = new FileInputStream(rutaArchivo)) {
		// int readBytes;

		// // leemos hasta eof
		// while ((readBytes = fis.read(buffer)) != -1) {
		// // recorremos los bytes leidos
		// for (int i = 0; i < readBytes; i++) {
		// // guardamos los caracteres del buffer por indice
		// char c = (char) buffer[i];
		// // Si uno de los caracteres es un salto de linea
		// if (c == '\n') {
		// // imprimimos a consola
		// System.out.printf("read: %s\n", sb.toString());
		// // limpiar StringBuilder
		// sb.setLength(0);
		// } else {
		// // si no es salto de linea lo añadimos al sb
		// sb.append(c);
		// }
		// }
		// }

		// // imprimir la ultima linea (no \n)
		// if (sb.length() > 0) {
		// System.out.printf("read: %s\n", sb.toString());
		// }

		// } catch (IOException e) {
		// System.err.println("error al leer el archivo " + e.getMessage());
		// }
	}

	public void getLinesReader() {
	}
}
