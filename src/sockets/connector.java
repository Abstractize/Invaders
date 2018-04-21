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
	private static connector Server;
	//Singleton para definir solo un servidor a la vez
	public static connector getConnector(Display display){
		if (Server == null){
			Server = new connector(display);
		}
		return Server;
	}
	private connector(Display display){
		dis=display;
	}
	@Override
	public void run(){
		super.run();
		try {
			this.init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		
	}
	public void init() throws IOException {
		try {
			System.out.println("Estableciendo Conexión");
			server = new ServerSocket(port);
			socket = new Socket();
			
			System.out.println("Conexión establecida");
			
			
			while (true){
				System.out.println("Esperando cliente...");
				socket = server.accept();
				input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				output = new PrintStream(socket.getOutputStream());
				System.out.println("Aceptando cliente...");
				System.out.println("recibiendo mensaje");
				//Información por recibir
				
				
				message = input.readLine();//recibe el nombre de un booleano
				System.out.println(message);
				
				System.out.println("mandando mensaje");
				//Información por mandar
				
				String msg = (String.valueOf(dis.getScore())+","+String.valueOf(dis.getLevel())+","+dis.getEnemies().getName()+","+dis.getNext().getName());
				output.println(msg);
			}
		}catch(Exception e) {}
		finally{
			input.close();
			output.close();
			socket.close();	
		};
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
