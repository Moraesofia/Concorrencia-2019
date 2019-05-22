package javaapplication1;

import java.io.IOException;
import java.net.ServerSocket;
import javaapplication1.AtenderCliente;
import javaapplication1.SocketCliente;

public class Servidor {

    public static void main(String[] args) throws IOException {
        ServerSocket chat = new ServerSocket(19980);

        while (true) {
            new AtenderCliente(chat.accept()).start();

        }

    }

}
