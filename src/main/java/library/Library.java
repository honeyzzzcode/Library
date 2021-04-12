package library;



public class Library {
    public static void main(String[] args) {


        System.out.println("********************Welcome to the Student Library!********************");
        System.out.println("              Please Select From The Following Options:               ");
        System.out.println("**********************************************************************");
        Books books = new Books();
        Users users = new Users();

        books.dispMenu();
        int choice;
        int searchChoice;

        do{


            choice = Input.nextInt(" ");

            switch(choice){

                case 1:
                    Book b = new Book();
                    books.addBook(b);
                    break;

                case 2:
                    books.upgradeBookQty();
                    break;

                case 3:
                    System.out.println("Enter 1 to Search with Serial No.");
                    searchChoice = Input.nextInt("Enter 2 to Search with Author Name(Full Name).");

                    switch(searchChoice){

                        case 1:
                            books.searchBySno();
                            break;
                        case 2:
                            books.searchByAuthorName();

                    }
                    break;

                case 4:
                    books.showAllBooks();
                    break;
                case 5:
                    User s = new User();
                    users.addStudent(s);
                    break;
                case 6:
                    users.showAllStudents();
                    break;
                case 7:
                    users.checkOutBook(books);
                    break;
                case 8:
                    users.checkInBook(books);
                    break;
                default:
                    System.out.println("CHOICE SHOULD BE BETWEEN 0 TO 8.");

            }

        }
        while (choice!=0);





    }
}
