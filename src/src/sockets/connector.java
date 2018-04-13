package sockets;

import java.net.*;

import Display.Display;

import java.io.*;

public class connector extends Thread{
	private ServerSocket server;
	private Socket socket;
	private int port = 9000;
	private PrintStream output;
	private BufferedReader input;
	private String message="0";
	private Display dis;
	@Override
	public void run(){
		super.run();
		while(true){
			this.infoTrade();
		}
		
	}
	public void init(Display display) {
		setDis(display);
		try {
			System.out.println("Estableciendo Conexión");
			server = new ServerSocket(port);
			socket = new Socket();
			socket = server.accept();
			System.out.println("Conexión establecida");
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintStream(socket.getOutputStream());
		}catch(Exception e) {};
	}
	
	public void infoTrade(){
		System.out.println("verificando mensajes");
		try{
			System.out.println("recibiendo mensaje");
			//Información por recibir
			
			
			message = input.readLine();//recibe el nombre de un booleano
			System.out.println(message);
			
			System.out.println("mandando mensaje");
			//Información por mandar
			
			String msg = (String.valueOf(dis.getScore())+","+String.valueOf(dis.getLevel())+","+dis.getEnemies().getName()+","+dis.getNext().getName());
			output.println(msg);
		}catch(Exception e){};
		
		
		
	}
	public void finish(){
		try{
			socket.close();	
		}catch(Exception e){};
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Display getDis() {
		return dis;
	}
	public void setDis(Display dis) {
		this.dis = dis;
	}
}
