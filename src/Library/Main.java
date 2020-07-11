package Library;

public class Main {
    public static void main(String[] args) {

        Book book = new Book("jjjj", "hhhh", Genre.ROMANCE);
        book.setAuthor("sss a ss a");
        System.out.println(book.getAuthor());
    }
}
