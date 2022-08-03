package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {
	private final int PORT = 1234;
	private final String HOST = "localhost";
	private Socket socket;
	private DataOutputStream output;
	private DataInputStream input;

	public Connection() throws UnknownHostException, IOException {
		socket = new Socket(HOST, PORT);
		output = new DataOutputStream(socket.getOutputStream());
		input = new DataInputStream(socket.getInputStream());
	}

	public int readInt() throws IOException {
		int i =input.readInt();
		return i;
	}
	
	public void writeInt(int x) throws IOException {
		output.writeInt(x);
	}
	
	public boolean available() throws IOException {
		return input.available() > 0;
	}
	
	public void writeUTF(String string) throws IOException {
		output.writeUTF(string);
	}
	
	public String readUTF() throws IOException {
		return input.readUTF();
	}
	
	public String readObject() throws IOException {
		return input.toString();
	}
	
	public Boolean readBoolean() throws IOException {
		return input.readBoolean();
	}
	
}
