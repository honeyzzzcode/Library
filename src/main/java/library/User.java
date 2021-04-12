package library;



public class User {
    String studentName;
    String regNum;

    Book borrowedBooks[] = new Book[3];
    public int booksCount = 0;

    public User() {

        this.studentName = Input.nextString("Enter Student Name:");
        this.regNum = Input.nextString("Enter Reg Number:");
    }
}
