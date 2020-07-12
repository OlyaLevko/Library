package Library;

public enum Genre {

    ROMANCE,
    ADVENTURE,
    HISTORY,
    THRILLER,
    HORROR,
    DETECTIVE,
    COMICS,
    FANTASY,
    PSYCHOLOGY,
    CHILDRENS,
    SCIENCE,
    PHILOSOPHY;

    public static void listOfGenre(){
        System.out.println("1." + ROMANCE);
        System.out.println("2." + ADVENTURE);
        System.out.println("3." + HISTORY);
        System.out.println("4." + THRILLER);
        System.out.println("5." + HORROR);
        System.out.println("6." + DETECTIVE);
        System.out.println("7." + COMICS);
        System.out.println("8." + FANTASY);
        System.out.println("9." + PSYCHOLOGY);
        System.out.println("10." + CHILDRENS);
        System.out.println("11." + SCIENCE);
        System.out.println("12." + PHILOSOPHY);
    }


    public static Genre switchGenre(int a) {
        switch (a) {
            case (1):
                return ROMANCE;
            case (2):
                return ADVENTURE;
            case (3):
                return HISTORY;
            case (4):
                return THRILLER;
            case (5):
                return HORROR;
            case (6):
                return DETECTIVE;
            case (7):
                return COMICS;
            case (8):
                return FANTASY;
            case (9):
                return PSYCHOLOGY;
            case (10):
                return CHILDRENS;
            case (11):
                return SCIENCE;
            case (12):
                return PHILOSOPHY;
            default:
                System.out.println("The genre has not found.");
                return null;
        }
    }
}
