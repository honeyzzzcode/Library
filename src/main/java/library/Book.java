package library;

public class Book {

    public int sNo;
    public String bookName;
    public String authorName;
    public int bookQty;
    public int bookQtyCopy;

    public Book(){

        this.sNo = Input.nextInt("Enter Serial No of Book:");
        Input.nextString(" ");
        this.bookName = Input.nextString("Enter Book Name:");
        this.authorName = Input.nextString("Enter Author Name:");
        this.bookQty = Input.nextInt("Enter Quantity of Books:");
        bookQtyCopy = this.bookQty;

    }


}



