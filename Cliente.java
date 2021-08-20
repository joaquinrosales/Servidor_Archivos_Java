import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

  public static void main(String[] args) {
    System.out.println("Conectandose al servidor...");
        //Crea la conexión Socket en la dirección IP, Puerto que designamos.
    try {
      Socket socket = new Socket("127.0.0.1", 8189);
      System.out.println("Conexión exitosa...");

      BufferedReader br = new BufferedReader(
        new InputStreamReader(socket.getInputStream())
      );
        //Creamos un lector de textos y uno que imprima o escriba.
      PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
      Scanner scan = new Scanner(System.in);
      String respuesta = br.readLine();
      System.out.println(respuesta);

      String x2 = "1";
      while (x2.equals("1")) {
        respuesta = br.readLine();
        System.out.println(respuesta); //archivos
        respuesta = br.readLine();
        System.out.println(respuesta); //pregunta
        String line = scan.nextLine();
        pw.println(line); //envia

        //proceso buffer

        respuesta = br.readLine();
        System.out.println(respuesta); //desea copiar algo mas
        x2 = scan.nextLine();
        pw.println(x2); //envia
      }
    } catch (IOException ex) { //fin try server
      System.out.println("F");
      System.out.println(ex.getMessage());
    }
  }
}
