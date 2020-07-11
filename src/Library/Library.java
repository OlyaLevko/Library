package Library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
//В цьому класі колекція книг і методи: подивитися доступні, подивитися на руках, подивитися за жанром,
// додати книгу, видалити книгу.
public class Library {
    HashMap<Integer, Book> listOfBooks;


    public Library(){
        listOfBooks = new HashMap<>();
        listOfBooks.put(1010, new Book("It Ends With Us", "COLLEEN HOOVER", Genre.ROMANCE));
        listOfBooks.put(1016, new Book("The Proposal", "JASMINE GUILLORY", Genre.ROMANCE));
        listOfBooks.put(1036, new Book("Vision In White", "NORA ROBERTS", Genre.ROMANCE));
        listOfBooks.put(1019, new Book("Gone with the Wind", "Margaret Mitchell", Genre.ROMANCE));
        listOfBooks.put(1020, new Book("The Notebook", "Nicholas Sparks", Genre.ROMANCE));
        listOfBooks.put(1005, new Book("Robinson Crusoe", "Daniel Defoe", Genre.ADVENTURE));
        listOfBooks.put(1050, new Book("The Last of the Mohicans", "James Fenimore Cooper", Genre.ADVENTURE));
        listOfBooks.put(1015, new Book("The Great Railway Bazaar", "Paul Theroux", Genre.ADVENTURE));
        listOfBooks.put(1027, new Book("Original", "Dan Brown", Genre.ADVENTURE));
        listOfBooks.put(1001, new Book("ALIAS GRACE", "MARGARET ATWOOD", Genre.HISTORY));
        listOfBooks.put(1041, new Book("THE GAME OF KINGS", "DOROTHY DUNNETT", Genre.HISTORY));
        listOfBooks.put(1025, new Book("NEFERTITI", "MICHELLE MORAN", Genre.HISTORY));
        listOfBooks.put(1011, new Book("THE SAMURAI’S GARDEN", "GAIL TSUKIYAMA", Genre.HISTORY));
        listOfBooks.put(1033, new Book("I Am Watching You", "Teresa Driscoll",Genre.THRILLER));
        listOfBooks.put(1022, new Book("The Woman in the Window", "A. J. Finn", Genre.THRILLER));
        listOfBooks.put(1014, new Book("Lock Every Door", "Riley Sager", Genre.THRILLER));
        listOfBooks.put(1006, new Book("The Glass Hotel", "Emily St. John Mandel", Genre.THRILLER));
        listOfBooks.put(1009, new Book("The Devil in Silver", "Victor LaValle", Genre.HORROR));
        listOfBooks.put(1034, new Book("Dracula", "Bram Stoker", Genre.HORROR));
        listOfBooks.put(1026, new Book("From Hell", "Alan Moore", Genre.HORROR));
        listOfBooks.put(1038, new Book("The Stand", "Stephen King", Genre.HORROR));
        listOfBooks.put(1042, new Book("The Hound of the Baskervilles", "Arthur Conan Doyle", Genre.DETECTIVE));
        listOfBooks.put(1029, new Book("The Murder of Roger Ackroyd", "Agatha Christie", Genre.DETECTIVE));
        listOfBooks.put(1004, new Book("The Dead of Jericho", "Colin Dexter", Genre.DETECTIVE));
        listOfBooks.put(1043, new Book ("The Mystery of a Hansom Cab", "Fergus Hume", Genre.DETECTIVE));
        listOfBooks.put(1007, new Book("Watchmen", "Alan Moore and Dave Gibbons", Genre.COMICS));
        listOfBooks.put(1045, new Book("Sweet Tooth", "Jeff Lemire", Genre.COMICS));
        listOfBooks.put(1031, new Book("Blacksad", "Juan Diaz Canales and Juanjo Guarnido", Genre.COMICS));
        listOfBooks.put(1023, new Book("Megahex", "Simon Hanselmann", Genre.COMICS));
        listOfBooks.put(1008, new Book("Dune", "Frank Herbert", Genre.FANTASY));
        listOfBooks.put(1003, new Book("A Song of Ice and Fire", "George R.R. Martin", Genre.FANTASY));
        listOfBooks.put(1002, new Book(" The Fellowship of the Ring", "J. R. R. Tolkien", Genre.FANTASY));
        listOfBooks.put(1012, new Book(" Gardens of the Moon", "Steven Erikson", Genre.FANTASY));
        listOfBooks.put(1013, new Book("A Prayer for Owen Meany", "John Irving", Genre.PSYCHOLOGY));
        listOfBooks.put(1049, new Book("I Know This Much Is True", " Wally Lamb", Genre.PSYCHOLOGY));
        listOfBooks.put(1021, new Book("The Stranger", "Albert Camus", Genre.PSYCHOLOGY));
        listOfBooks.put(1032, new Book("Sometimes I Lie", " Alice Feeney", Genre.PSYCHOLOGY));
        listOfBooks.put(1044, new Book("Pippi Longstocking", " Astrid Lindgren", Genre.CHILDRENS));
        listOfBooks.put(1024, new Book("The Little Prince", "Antoine de Saint-Exupery", Genre.CHILDRENS));
        listOfBooks.put(1035, new Book("The Hobbit", "JRR Tolkein", Genre.CHILDRENS));
        listOfBooks.put(1046, new Book("Winnie-the-Pooh", "A A Milne", Genre.CHILDRENS));
        listOfBooks.put(1028, new Book("Harry Potter and philosophy stone", "Joanne Rowling", Genre.CHILDRENS));
        listOfBooks.put(1017, new Book("Being Mortal", "ATUL GAWANDE", Genre.SCIENCE));
        listOfBooks.put(1040, new Book("Sapiens", "YUVOL NOAH HARARI", Genre.SCIENCE));
        listOfBooks.put(1039, new Book("Bad Blood", "JOHN CARREYROU", Genre.SCIENCE));
        listOfBooks.put(1018, new Book("Thinking, fast and slow", "DANIEL KAHNEMAN", Genre.SCIENCE));
        listOfBooks.put(1047, new Book("Seeking Wisdom", "Peter Bevelin ", Genre.PHILOSOPHY));
        listOfBooks.put(1048, new Book("The Visible and the Invisible", "Maurice Merleau-Ponty", Genre.PHILOSOPHY));
        listOfBooks.put(1037, new Book("The Moral Animal", "Robert Wright", Genre.PHILOSOPHY));
        listOfBooks.put(1030, new Book("Atlas Shrugged", "Ayn Rand", Genre.PHILOSOPHY));

    }
    public Book add(Integer id, Book book){
        listOfBooks.put(id, book);
        return book;
    }


    public Book get(int id){
        return listOfBooks.get(id);
    }
    public Book remove(int id){
        return listOfBooks.remove(id);
    }

    public List<Book> showAvailable(){
        List<Book> list =
                listOfBooks.values().stream()
                        .filter(book -> book.isAvailable)
                        .peek(book -> System.out.println(book.toString()))
                        .collect(Collectors.toList());
        return list;
    }

    public List<Book> showInUsing(){
        List<Book> list =
                listOfBooks.values().stream()
                        .filter(book -> !book.isAvailable)
                        .peek(book -> System.out.println(book.toString()))
                        .collect(Collectors.toList());
        return list;
    }

    public ArrayList<Book> showByGenre(Genre genre){
        ArrayList<Book> list = new ArrayList<>();
        listOfBooks.values()
                .stream()
                .filter(book -> book.getGenre() == genre)
                .peek(book -> {
                    System.out.println(book.toString());
                })
                .collect(Collectors.toList());
        return list;
    }

    public void viewByGenre(){
        Scanner sc = new Scanner(System.in);

        do
        {
            System.out.println("Please, choose the number of genre: ");
            Genre.listOfGenre();
            String st = sc.nextLine();
            while(!st.matches("^([1-9]|10|11|12)")){
                System.out.println("You entered an incorrect number of genre. Please, try again.");
                Genre.listOfGenre();
                st = sc.nextLine();
            }
            int a = Integer.parseInt(st);
            switch(a){
                case(1):
                    showByGenre(Genre.ROMANCE);
                    break;
                case(2):
                    showByGenre(Genre.ADVENTURE);
                    break;
                case(3):
                    showByGenre(Genre.HISTORY);
                    break;
                case(4):
                    showByGenre(Genre.THRILLER);
                    break;
                case(5):
                    showByGenre(Genre.HORROR);
                    break;
                case(6):
                    showByGenre(Genre.DETECTIVE);
                    break;
                case(7):
                    showByGenre(Genre.COMICS);
                    break;
                case(8):
                    showByGenre(Genre.FANTASY);
                    break;
                case(9):
                    showByGenre(Genre.PSYCHOLOGY);
                    break;
                case(10):
                    showByGenre(Genre.CHILDRENS);
                    break;
                case(11):
                    showByGenre(Genre.SCIENCE);
                    break;
                case(12):
                    showByGenre(Genre.PHILOSOPHY);
                    break;
                default:
                    System.out.println("The genre has not found.");
            }

            System.out.println("To choose another genre - enter yes or no.");

        }
        while(!"no".equals(sc.nextLine()));

    }

}
