package repository;

import model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class BookList {
    ArrayList<Book> booksList;

    public BookList(ArrayList<Book> booksList) {
        this.booksList = booksList;
    }

    public ArrayList<Book> all(){
        return booksList;
    }

    public BookList() {
        this.booksList = new ArrayList<Book>();
    }
    private int comparatorName(Book b1,Book b2,String value){
        String a1=b1.getName();
        String a2=b2.getName();
        int v1=(a1.length()-a1.replace(value,"").length())/value.length();
        int v2=(a2.length()-a2.replace(value,"").length())/value.length();
        if (v1>v2) return -1;
        else if (v1<v2) return 1;
        else return 0;
    }
    private int comparatorAuthorName(Book b1,Book b2,String value){
        String a1=b1.getAuthorName();
        String a2=b2.getAuthorName();
        int v1=(a1.length()-a1.replace(value,"").length())/value.length();
        int v2=(a2.length()-a2.replace(value,"").length())/value.length();
        if (v1>v2) return -1;
        else if (v1<v2) return 1;
        else return 0;
    }
    private int comparatorIsbn(Book b1,Book b2,String value) {
        String a1=b1.getIsbn();
        String a2=b2.getIsbn();
        int v1=(a1.length()-a1.replace(value,"").length())/value.length();
        int v2=(a2.length()-a2.replace(value,"").length())/value.length();
        if (v1>v2) return -1;
        else if (v1<v2) return 1;
        else return 0;
    }
    private int comparatorAnnotation(Book b1,Book b2,String value) {
        String a1=b1.getAnnotation();
        String a2=b2.getAnnotation();
        int v1=(a1.length()-a1.replace(value,"").length())/value.length();
        int v2=(a2.length()-a2.replace(value,"").length())/value.length();
        if (v1>v2) return -1;
        else if (v1<v2) return 1;
        else return 0;
    }

    public BookList findBy(String by,String value) throws Exception {
        ArrayList<Book> sortedBooksList= (ArrayList<Book>)this.booksList.clone();

        //сортировка по количеству вхождений
        if (by.equals("name")){
            sortedBooksList.sort((b1, b2) -> this.comparatorName(b1,b2,value));

        } else if (by.equals("isbn")){
            sortedBooksList.sort((b1, b2) -> this.comparatorIsbn(b1,b2,value));

        } else if (by.equals("authorName")){
            sortedBooksList.sort((b1, b2) -> this.comparatorAuthorName(b1,b2,value));

        } else if (by.equals("annotation")){
            sortedBooksList.sort((b1, b2) -> this.comparatorAnnotation(b1,b2,value));

        } else throw new Exception("Wrong by parameter");


        return new BookList(sortedBooksList);
        };
//            Book selectedBook=null;
//            for (int j=0;j<=5;j++){
//                booksList[j].
//
//            }
//            sortedBooksList.add(selectedBook)
          //  return booksList;
        //}



       // arrayList.sort((p1, p2) -> p1.compareTo(p2));;



    public void addBook(Book book){
        booksList.add(book);
    }


    @Override
    public String toString() {
        String output="";
        for (Book b: booksList){
            output+="Название: "+b.getName()+
                    "\nИмя автора: "+b.getAuthorName()+
                    "\nЖанр: "+b.getGenre()+
                    "\nДата публикации: "+b.getPublishDate()+
                    "\nISBN: "+b.getIsbn()+"\n\n";

        }
        return output;
    }
}
