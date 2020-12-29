package actividad9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    String host;
    int port;
    Socket cliente;
    BufferedReader fentrada;
    PrintWriter fsalida;
    BufferedReader br;
    String cadena;
    String mensaje;

    public Cliente() throws IOException {
        host = "localhost";
        port = 44444;
        cliente = new Socket(host, port);
        fsalida = new PrintWriter(cliente.getOutputStream(), true);
        fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void enviar(String cad) throws IOException {
        fsalida.println(cad);
    }

    public String recibe() throws IOException {
        mensaje = fentrada.readLine();
        System.out.println(" => Mensaje: " + mensaje);
        return mensaje;
    }

    public void cerrar() throws IOException {
        fsalida.println("*");
        fsalida.close();
        fentrada.close();
        System.out.println("Saliendo....");
        br.close();
        cliente.close();
    }
}
