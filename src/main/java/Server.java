import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import model.Book;
import model.Response;
import model.Task;
import repository.BookList;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет
    private static BookList bookList;
    private static String filename="books.json";
    public static void main(String[] args) {

        try{
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(filename));
            bookList = gson.fromJson(reader, BookList.class);
            if (bookList==null) bookList=new BookList();

        } catch (Exception e){
            e.printStackTrace();
            bookList=new BookList();
        }



        try {
            server = new ServerSocket(4004); // серверсокет прослушивает порт 4004

        System.out.println("Сервер запущен!");
        clientSocket = server.accept();
        while (true) {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            String input = in.readLine();
            Gson gson = new Gson();
            Task task = gson.fromJson(input, Task.class);
            System.out.println("Task recieved: "+input);

            Response response;
            BookList responseBookList=null;

            if (task==null) {
                response=new Response("Fatal Error: task is null");
            }else if (task.getType().equals("add")) {
                bookList.addBook(task.getBook());
                response=new Response("Success");
            }else if (task.getType().equals("find")) {
                try {
                    responseBookList = bookList.findBy(task.getBy(), task.getValue());
                    response=new Response("Success");
                } catch (Exception e) {
                    e.printStackTrace();
                    response=new Response("Error: Exception during findBy operation");
                }
            } else {
                response=new Response("Error: Unknown Method");
            }

            String message;
            if (responseBookList!=null) message = gson.toJson(responseBookList);
            else message=gson.toJson(response);


            System.out.println(message);
            out.write(message+ "\n");
            out.flush();

            Gson dump_gson = new GsonBuilder().setPrettyPrinting().create();

            FileWriter writer=new FileWriter(filename);
            dump_gson.toJson(bookList, writer);
            writer.close();
            System.out.println(dump_gson.toJson(bookList));
            System.out.println("request handling done");
        }

        } catch (IOException e) {
            try {
                clientSocket.close();
                in.close();
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }


            e.printStackTrace();
        }




    }

}

