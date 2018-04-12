package sockets;

import java.net.*;

import Display.Display;

import java.io.*;

public class connector {
	ServerSocket server;
	Socket socket;
	int port = 9000;
	DataOutputStream output;
	BufferedReader input;
	String message;
	public void init(Display display) {
		try {
			server = new ServerSocket(port);
			socket = new Socket();
			socket = server.accept();
			
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//Información por recibir
			message = input.readLine();//recibe el nombre de un booleano
			System.out.println(message);
			
			output = new DataOutputStream(socket.getOutputStream());
			//Información por mandar
			output.writeByte(display.getScore());//Puntaje
			output.writeByte(display.getLevel());//Nivel
			output.writeUTF(display.getEnemies().getName());//Hilera
			output.writeUTF(display.getNext().getName());//Hilera por salir
			
			
			
			
			
			socket.close();
		}catch(Exception e) {};
	}
}
