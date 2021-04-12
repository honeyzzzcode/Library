package library;



public class User {
    String userName;
    String regNum;

    Book borrowedBooks[] = new Book[3];
    public int booksCount = 0;

    public User() {

        this.userName = Input.nextString("Enter User Name:");
        this.regNum = Input.nextString("Enter Reg Number:");
    }
}
