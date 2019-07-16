import org.json.simple.JSONObject;

import java.io.*;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException {
        String jsonEnString;
        char[] arrayLetrasCodificado;
        JSONObject jsonObject;
        jsonObject = crearJSON();
        jsonEnString = jsonObject.toString();
        arrayLetrasCodificado = encriptarMensaje(jsonEnString);
        guardarEnArchivo(arrayLetrasCodificado, jsonObject);

    }

    public static String[] leerDatos() throws IOException {
        String[] datosLeidos = new String[26];
        Scanner scanner = new Scanner(System.in);



        datosLeidos[0]= "levelActual";
        System.out.println("Ingrese el valor para la llave "+datosLeidos[0]+": ");
        datosLeidos[1]=scanner.nextLine();


        // Comienzo lectura ascii
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String entrada = "";
        String linea;
        datosLeidos[2]= "asciiArt";
        System.out.println("Ingrese el valor para la llave "+datosLeidos[2]+": ");

        while((linea = bufferedReader.readLine()) != null){
            if(linea.isEmpty()){
                break;
            }
            entrada += linea + "\n";
        }
        datosLeidos[3]=entrada;
        // Fin lectura ascii





        datosLeidos[4]= "historia";
        System.out.println("Ingrese el valor para la llave "+datosLeidos[4]+": ");
        entrada = "";
        linea ="";
        while((linea = bufferedReader.readLine()) != null){
            if(linea.isEmpty()){
                break;
            }
            entrada += linea + "\n";
        }
        datosLeidos[5]=entrada;
       // datosLeidos[5]=scanner.nextLine();

        datosLeidos[6]= "menuA";
        System.out.println("Ingrese el valor para la llave "+datosLeidos[6]+": ");
        datosLeidos[7]=scanner.nextLine();

        datosLeidos[8]= "menuB";
        System.out.println("Ingrese el valor para la llave "+datosLeidos[8]+": ");
        datosLeidos[9]=scanner.nextLine();

        datosLeidos[10]= "menuC";
        System.out.println("Ingrese el valor para la llave "+datosLeidos[10]+": ");
        datosLeidos[11]=scanner.nextLine();

        datosLeidos[12]= "menuD";
        System.out.println("Ingrese el valor para la llave "+datosLeidos[12]+": ");
        datosLeidos[13]=scanner.nextLine();

        datosLeidos[14]= "menuE";
        System.out.println("Ingrese el valor para la llave "+datosLeidos[14]+": ");
        datosLeidos[15]=scanner.nextLine();

        datosLeidos[16]= "irAA";
        System.out.println("Ingrese el valor para la llave "+datosLeidos[16]+": ");
        datosLeidos[17]=scanner.nextLine();

        datosLeidos[18]= "irAB";
        System.out.println("Ingrese el valor para la llave "+datosLeidos[18]+": ");
        datosLeidos[19]=scanner.nextLine();

        datosLeidos[20]= "irAC";
        System.out.println("Ingrese el valor para la llave "+datosLeidos[20]+": ");
        datosLeidos[21]=scanner.nextLine();

        datosLeidos[22]= "irAD";
        System.out.println("Ingrese el valor para la llave "+datosLeidos[22]+": ");
        datosLeidos[23]=scanner.nextLine();

        datosLeidos[24]= "irAE";
        System.out.println("Ingrese el valor para la llave "+datosLeidos[24]+": ");
        datosLeidos[25]=scanner.nextLine();




        return datosLeidos;
    }

    public static JSONObject crearJSON() throws IOException {

        JSONObject jsonObject = new JSONObject();
            int i;
            String[] datosLeidos = leerDatos();
            for (i=0;i<datosLeidos.length;i+=2){
                jsonObject.put(datosLeidos[i],datosLeidos[i+1]);
            }
            System.out.println("El JSON sin encriptar es: ");
            System.out.println(jsonObject);

        return jsonObject;
    }

    public static void guardarEnArchivo(char[] mensajeEncriptado, JSONObject jsonObject) throws IOException {

        int i;
        FileWriter fileWriter = new FileWriter("json/"+(String)jsonObject.get("levelActual")+".json", false);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for(i=0;i<mensajeEncriptado.length;i++){
            printWriter.print(mensajeEncriptado[i]+" ");
        }
        guardarLista((String) jsonObject.get("levelActual"));
        printWriter.close();

    }

    public static char[] encriptarMensaje(String stringRecibido){
        int i;
        char[] arrayLetras = new char[stringRecibido.length()];
        int[] arrayNum = new int[arrayLetras.length];

        for(i=0;i<arrayLetras.length;i++){
            arrayLetras[i]=stringRecibido.charAt(i);
        }
        System.out.println("El JSON encriptado y a guardar es: ");
        for(i=0;i<arrayLetras.length;i++){
            arrayNum[i] = ((arrayLetras[i]*4)-40)/2;
            arrayLetras[i] = (char) arrayNum[i];
            System.out.print(arrayLetras[i]);
        }
        return  arrayLetras;

    }

    public static void guardarLista(String elemento) throws IOException {
        FileWriter fileWriter = new FileWriter("lista.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(elemento);
        printWriter.close();
    }
}
