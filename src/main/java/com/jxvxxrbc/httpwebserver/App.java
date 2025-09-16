package com.jxvxxrbc.httpwebserver;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.jxvxxrbc.httpwebserver.tcplistener.TcpListener;

public class App {
	public static void main(String[] args) {
		TcpListener tcpListener = new TcpListener();
		tcpListener.ServerInit();
	}
}
