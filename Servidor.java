import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {

  public static void main(String[] args) {
    String x = "1";
    String archivo1 = null;
    String ruta = "C:/Users/***/Desktop/Cliente/";

    try {
        //Crea el ServerSocket en el puerto designado.
      ServerSocket serverSocket = new ServerSocket(8189);
      System.out.println("Esperando que alguien se conecte...");

      Socket clientSocket = serverSocket.accept();
      System.out.println("Conectado al cliente...");

        //Creamos un lector de textos y uno que imprima o escriba.
      BufferedReader br = new BufferedReader(
        new InputStreamReader(clientSocket.getInputStream())
      );
      PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
      pw.println("Bienvenido");
        
        //fin = File Input. fout = File Output
      BufferedInputStream fin;
      BufferedOutputStream fout;

      while (x.equals("1")) {
        pw.println("ARCHIVOS: ipn.png  img002.jpg  texto.txt");
        pw.println("Que archivo desea copiar?");
        archivo1 = br.readLine();

        try {
          fin = new BufferedInputStream(new FileInputStream(archivo1));
        } catch (FileNotFoundException exc) {
          System.out.println("Archivo de entrada no encontrado");
          return;
        }

        try {
          fout = new BufferedOutputStream(new FileOutputStream(ruta + archivo1));
        } catch (FileNotFoundException exc) {
          System.out.println("Error de apertura del archivo de salida");
          try {
            fin.close();
          } catch (IOException exc2) {
            System.out.println("Error al cerrar el archivo de salida");
          }
          return;
        }

        try {
          int i;
          do {
            i = fin.read();
            if (i != -1) fout.write(i);
          } while (i != -1);
        } catch (IOException exc) {
          System.out.println("Error de archivo");
        }

        try {
          fin.close();
        } catch (IOException exc) {
          System.out.println("Error al cerrar el archivo de entrada");
        }

        try {
          fout.close();
          System.out.println("Archivo: " + archivo1 + " enviado");
        } catch (IOException exc) {
          System.out.println("Error al cerrar el archivo de salida");
        }

        pw.println("Desea copiar algo mas?  1:Si  0:No");
        x = br.readLine(); //recibe
      } 
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
