package com.lits.library.books;

import com.lits.library.exceptions.AuthorNotFoundException;
import com.lits.library.exceptions.BookNotFoundException;
import com.lits.library.records.BaseOfRecords;
import com.lits.library.records.Record;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Library {

    private HashMap<Integer, Book> listOfBooks;
    private BaseOfRecords baseOfRecords;
    private int maxId;
    private int minId;
    private static final String YES = "yes", NO = "no",
            FIRST_NAME = "first name", SURNAME = "surname", EXIT = "exit";
    Scanner sc = new Scanner(System.in);

    public Library() {

        listOfBooks = new HashMap<>();
        baseOfRecords = new BaseOfRecords();
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
        listOfBooks.put(1033, new Book("I Am Watching You", "Teresa Driscoll", Genre.THRILLER));
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
        listOfBooks.put(1043, new Book("The Mystery of a Hansom Cab", "Fergus Hume", Genre.DETECTIVE));
        listOfBooks.put(1007, new Book("Watchmen", "Alan Moore and Dave Gibbons", Genre.COMICS));
        listOfBooks.put(1045, new Book("Sweet Tooth", "Jeff Lemire", Genre.COMICS));
        listOfBooks.put(1031, new Book("Blacksad", "Juan Diaz Canales and Juanjo Guarnido", Genre.COMICS));
        listOfBooks.put(1023, new Book("Megahex", "Simon Hanselmann", Genre.COMICS));
        listOfBooks.put(1008, new Book("Dune", "Frank Herbert", Genre.FANTASY));
        listOfBooks.put(1003, new Book("A Song of Ice and Fire", "George R.R. Martin", Genre.FANTASY));
        listOfBooks.put(1002, new Book("The Fellowship of the Ring", "J. R. R. Tolkien", Genre.FANTASY));
        listOfBooks.put(1012, new Book("Gardens of the Moon", "Steven Erikson", Genre.FANTASY));
        listOfBooks.put(1013, new Book("A Prayer for Owen Meany", "John Irving", Genre.PSYCHOLOGY));
        listOfBooks.put(1049, new Book("I Know This Much Is True", "Wally Lamb", Genre.PSYCHOLOGY));
        listOfBooks.put(1021, new Book("The Stranger", "Albert Camus", Genre.PSYCHOLOGY));
        listOfBooks.put(1032, new Book("Sometimes I Lie", "Alice Feeney", Genre.PSYCHOLOGY));
        listOfBooks.put(1044, new Book("Pippi Longstocking", "Astrid Lindgren", Genre.CHILDRENS));
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

        maxId = listOfBooks.keySet().stream()
                .max(Comparator.naturalOrder())
                .get();
        minId = listOfBooks.keySet().stream()
                .min(Comparator.naturalOrder())
                .get();

        List<Integer> listOfBookNumber = baseOfRecords.getRecords().stream()
                .map(Record::getBookNumber)
                .collect(Collectors.toList());

        listOfBooks.entrySet().stream()
                .filter(pair -> listOfBookNumber.contains(pair.getKey()))
                .map(pair -> pair.getValue().isAvailable = false)
                .collect(Collectors.toSet());
    }

    public void addBook() {

        System.out.println("Enter the book title.");
        String title = sc.nextLine();
        System.out.println("Enter the book author.");
        String author = verifyAuthor(sc.nextLine());
        System.out.println("Enter the number of genre.");
        Genre.listOfGenre();
        String g = verifyGenre(sc.nextLine());
        int a = Integer.parseInt(g);
        Genre genre = Genre.switchGenre(a);
        Book book = new Book(title, author, genre);
        System.out.println("Do you want to add " + book + " to the library? Please, enter yes or no.");
        String st = verifyYesOrNo(sc.nextLine());
        if (YES.equals(st)) {
            listOfBooks.put(++maxId, book);
            System.out.println(book + " was added.\n");
        }
        System.out.println("Do you want to add another book? Please, enter yes or no.");
        st = verifyYesOrNo(sc.nextLine());
        if (YES.equals(st))
            addBook();
    }

    public void removeBook() {

        showListOfBooks();
        System.out.println("Choice by number book delete");
        String num = sc.nextLine();

        while (!num.matches("[0-9]+")) {
            System.out.println("Please, enter correct number");
            num = sc.nextLine();
        }
        int id = Integer.parseInt(num);
        if (listOfBooks.containsKey(id)) {
            System.out.println(listOfBooks.get(id));
            System.out.println("Are you sure you want to delete the book - enter \"yes\" or \"no\"?");
            String choose = sc.nextLine();
            choose = verifyYesOrNo(choose);

            if (choose.equals("yes")) {
                Object book = listOfBooks.remove(id);
                System.out.println(book + " has been deleted\n");
            }
        } else {
            System.out.println("The book number " + id + " is not found");
        }
        removeAnotherBook();
    }

    public void showListOfBooks() {

        listOfBooks.entrySet().stream()
                .peek(pair -> System.out.println(pair.getKey() + " " + pair.getValue()))
                .collect(Collectors.toSet());
    }

    public void showAvailable() {

        Set<Map.Entry<Integer, Book>> s =
                listOfBooks.entrySet().stream()
                        .filter(pair -> pair.getValue().isAvailable)
                        .peek(pair -> System.out.println(pair.getKey() + " " + pair.getValue()))
                        .collect(Collectors.toSet());
        if (s.size() == 0) {
            System.out.println("There is not any book to take to read.");
        }
    }

    public void showInUsing() {

        Set<Map.Entry<Integer, Book>> s =
                listOfBooks.entrySet().stream()
                        .filter(pair -> !pair.getValue().isAvailable)
                        .peek(pair -> System.out.println(pair.getKey() + " " + pair.getValue()))
                        .collect(Collectors.toSet());
        if (s.size() == 0) {
            System.out.println("There is not any book, which is taken to read.");
        }
    }

    public void showByGenre() {

        System.out.println("Please, choose the number of genre: ");
        Genre.listOfGenre();
        String st = verifyGenre(sc.nextLine());
        int a = Integer.parseInt(st);
        showByGenre(Genre.switchGenre(a));
        System.out.println("\nDo you want to choose another genre - enter yes or no.");
        st = verifyYesOrNo(sc.nextLine());
        if (YES.equals(st))
            showByGenre();
    }

    public void takeBook() {

        String st;
        printMenuOfTaking();
        st = sc.nextLine();
        while (!st.matches("^[1-4]")) {
            System.out.println("You entered an incorrect number. Please try again.");
            takeBook();
        }
        int a = Integer.parseInt(st);
        switchMenuOfTaking(a);
        do {
            System.out.println("Please, enter the book number or enter \"exit\" to previous menu.");
            st = sc.nextLine();
        }
        while (!st.toLowerCase().matches("exit|[0-9]"));
        if (EXIT.equals(st.toLowerCase()))
            takeBook();
        int number = verifyId(st);
        if (get(number).isAvailable) {
            System.out.println("You chose " + number + " " + listOfBooks.get(number) + ".");
            System.out.println("Do you want to take this book? Please, enter yes or no.");
            st = verifyYesOrNo(sc.nextLine());
            if (YES.equals(st))
                takeBook(number);
        } else
            System.out.println("The book is not available to take.");
        takeAnotherBook();
    }

    public void showByTitle() {

        System.out.println("Please, enter book's title.");
        String title = sc.nextLine();
        try {
            findByTitle(title).forEach((key, value) -> System.out.println(key + " " + value));
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {

            System.out.println("Do you want to search another book's title? Please, enter yes or no.");
            String st = verifyYesOrNo(sc.nextLine());
            if (YES.equals(st))
                showByTitle();
        }
    }

    public void showByAuthor() {

        System.out.println("Please, enter author's name.");
        String author = verifyAuthor(sc.nextLine());
        try {
            findByAuthor(author).forEach((key, value) -> System.out.println(key + " " + value));
        } catch (AuthorNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Do you want to search books by another author? Please, enter yes or no.");
            String st = verifyYesOrNo(sc.nextLine());
            if (YES.equals(st))
                showByAuthor();
        }
    }

    public void giveBookBack() {

        System.out.println("Please, enter the book's number, which you want to give back.");
        System.out.println("The book's number is typed on the first page.");
        int number = verifyId(sc.nextLine());
        System.out.println("Do you want to give " + listOfBooks.get(number) + " back? Please, enter yes or no.");
        String entry = verifyYesOrNo(sc.nextLine());
        if (NO.equals(entry)) {
            System.out.println("You entered a number, which didn't refer to book, that you want to give back. ");
            giveBookBack();
        }
        if (YES.equals(entry)) {
            giveBookBack(number);
            System.out.println(listOfBooks.get(number) + " is accepted.");
        }
        System.out.println("Do you want to give another book back? Please, enter yes or no.");
        String st = verifyYesOrNo(sc.nextLine());
        if (YES.equals(st))
            giveBookBack();
    }

    public void showDebtors() {
        baseOfRecords.getRecords().stream()
                .filter(record -> Period.between(record.getDate(), LocalDate.now()).getMonths() >= 1 ||
                        Period.between(record.getDate(), LocalDate.now()).getYears() >= 1)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public HashMap<Integer, Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(HashMap<Integer, Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public BaseOfRecords getBaseOfRecords() {
        return baseOfRecords;
    }

    public void setBaseOfRecords(BaseOfRecords baseOfRecords) {
        this.baseOfRecords = baseOfRecords;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }

    public int getMinId() {
        return minId;
    }

    public void setMinId(int minId) {
        this.minId = minId;
    }

    private String verifyGenre(String s) {
        while (!s.matches("^([1-9]|10|11|12)")) {
            System.out.println("You entered an incorrect number of genre. Please, try again.");
            Genre.listOfGenre();
            s = sc.nextLine();
        }
        return s;
    }

    private String verifyAuthor(String author) {
        while (!author.matches("^[\\p{L} .'-]+$")) {
            System.out.println("You entered author incorrectly.");
            System.out.println("Author name can contain only characters, whitespace, dots, apostrophes or dashes.");
            System.out.println("Please, try again.");
            author = sc.nextLine();
        }
        return author;
    }

    private String verifyName(String name, String nameType) {
        while (!name.matches("^[A-Z][\\p{L}'-]+$")) {
            System.out.println("You entered an incorrect " + nameType + ".");
            System.out.println("The " + nameType + " must begin with a capital letter, can contain only letters, apostrophes or dashes.");
            System.out.println("Please, try again.");
            name = sc.nextLine();
        }
        return name;
    }

    private int verifyId(String entry) {
        while (!entry.matches("[0-9]+")) {
            printEnteringBookNumber();
            entry = sc.nextLine();
        }
        int number = Integer.parseInt(entry);
        while (number < minId || number > maxId) {
            printEnteringBookNumber();
            number = verifyId(sc.nextLine());
        }
        return number;
    }

    private void printEnteringBookNumber() {
        System.out.println("You entered an incorrect number.");
        System.out.println("A number must be from " + minId + " up to " + maxId + ".");
        System.out.println("Please try again.");
    }

    private String verifyYesOrNo(String s) {
        while (!s.toLowerCase().matches("yes|no")) {
            System.out.println("Please, enter yes or no.");
            s = sc.nextLine();
        }
        return s.toLowerCase();
    }

    private Map<Integer, Book> findByTitle(String title) throws BookNotFoundException {
        Map<Integer, Book> book = listOfBooks.entrySet().stream()
                .filter(pair -> pair.getValue().getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        if (book.size() == 0)
            throw new BookNotFoundException("The book \"" + title + "\" is not found.");
        return book;
    }

    private Map<Integer, Book> findByAuthor(String author) throws AuthorNotFoundException {
        Map<Integer, Book> book = listOfBooks.entrySet().stream()
                .filter(pair -> pair.getValue().getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        if (book.size() == 0)
            throw new AuthorNotFoundException("The book by " + author + " is not found.");
        return book;
    }

    private void takeAnotherBook() {
        System.out.println("Do you want to choose another book? Please, enter yes or no.");
        String st = verifyYesOrNo(sc.nextLine());
        if (YES.equals(st))
            takeBook();
    }

    private void printMenuOfTaking() {
        System.out.println("To search by title - enter 1");
        System.out.println("To search by author - enter 2");
        System.out.println("To view available book - enter 3");
        System.out.println("To view by genre - enter 4");
    }

    private void switchMenuOfTaking(int a) {
        switch (a) {

            case 1 -> showByTitle();
            case 2 -> showByAuthor();
            case 3 -> showAvailable();
            case 4 -> showByGenre();
            default -> System.out.println("Another entering");
        }
    }

    private void takeBook(int id) {
        System.out.println("Please, enter your login.");
        String login = sc.nextLine();
        baseOfRecords.uo.setUser(baseOfRecords.uo.getUserByLogin(login));
        if (baseOfRecords.uo.getMapOfUsers().containsKey(login)) {
            baseOfRecords.addRecord(baseOfRecords.uo.getUserFirstName(), baseOfRecords.uo.getUserSurname(), id);
        } else {
            System.out.println("Please, enter your first name.");
            String fname = verifyName(sc.nextLine(), FIRST_NAME);
            System.out.println("Please, enter your surname.");
            String sname = verifyName(sc.nextLine(), SURNAME);
            baseOfRecords.addRecord(fname, sname, id);
        }
        listOfBooks.get(id).isAvailable = false;
        System.out.println("You took " + listOfBooks.get(id) + ". You should give it back by "
                + DateTimeFormatter.ofPattern("dd.MM.yyyy").format(LocalDate.now().plusMonths(1)));
    }

    private void giveBookBack(int id) {
        listOfBooks.get(id).isAvailable = true;
        baseOfRecords.removeRecord(id);
    }

    private Book get(int id) {
        return listOfBooks.get(id);
    }

    private void removeAnotherBook() {
        System.out.println("Do you want to choose another book delete - enter \"yes\" or \"no\".");
        String choice = sc.nextLine();
        while (!choice.matches("yes|no")) {
            System.out.println("Please, enter the correct answer");
            choice = sc.nextLine();
        }
        if ("yes".equals(choice))
            removeBook();
    }

    private void showByGenre(Genre genre) {
        listOfBooks.entrySet()
                .stream()
                .filter(pair -> pair.getValue().getGenre() == genre)
                .peek(pair -> System.out.println(pair.getKey() + " " + pair.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }


}