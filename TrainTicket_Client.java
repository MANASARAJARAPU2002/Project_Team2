package Project.Team2.FinalCode;

	import java.io.BufferedReader;

	import java.io.IOException;

	import java.io.InputStream;

	import java.io.InputStreamReader;

	import java.io.OutputStream;

	import java.io.PrintWriter;

	import java.net.Socket;

	import java.net.UnknownHostException;
	public class TrainTicket_Client {

	    public static void main(String[] args) {

	        String hostname = "localhost";

	        int port = 9999;
	 
	        try (Socket socket = new Socket(hostname, port)) {

	            OutputStream output = socket.getOutputStream();

	            PrintWriter writer = new PrintWriter(output, true);
	 
	            InputStream input = socket.getInputStream();

	            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	 
	            writer.println("Hello, Server. Server started");
	 
	            String response = reader.readLine();

	            System.out.println(response);

	        } catch (UnknownHostException ex) {

	            System.out.println("Server not found: " + ex.getMessage());

	        } catch (IOException ex) {

	            System.out.println("I/O error: " + ex.getMessage());

	        }

	    }

	}

