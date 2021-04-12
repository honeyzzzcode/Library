package library;

public class Books {
    Book theBooks[] = new Book[50];     // Array that stores 'book' Objects.
    public static int count;    // Counter for No of book objects Added in Array.

    public int compareBookObjects(Book b1, Book b2) {

        if (b1.bookName.equalsIgnoreCase(b2.bookName)) {

            System.out.println("Book of this Name Already Exists.");
            return 0;

        }
        if (b1.sNo == b2.sNo) {

            System.out.println("Book of this Serial No Already Exists.");
            return 0;
        }
        return 1;
    }

    public void addBook(Book b) {

        for (int i = 0; i < count; i++) {

            if (this.compareBookObjects(b, this.theBooks[i]) == 0)
                return;

        }

        if (count < 50) {

            theBooks[count] = b;
            count++;

        } else {

            System.out.println("No Space to Add More Books.");

        }

    }

    public void searchBySno() {

        System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");

        int sNo;
        sNo = Input.nextInt("Enter Serial No of Book:");

        int flag = 0;
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
        for (int i = 0; i < count; i++) {

            if (sNo == theBooks[i].sNo) {

                System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" +
                        theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);
                flag++;
                return;

            }

        }
        if (flag == 0)
            System.out.println("No Book for Serial No " + sNo + " Found.");

    }

    public void searchByAuthorName() {

        Input.nextString("\t\t\t\tSEARCH BY AUTHOR'S NAME");

        String authorName = Input.nextString("Enter Author Name:");
        int flag = 0;
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
        for (int i = 0; i < count; i++) {

            if (authorName.equalsIgnoreCase(theBooks[i].authorName)) {

                System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" +
                        theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);
                flag++;
            }

        }
        if (flag == 0)
            System.out.println("No Books of " + authorName + " Found.");

    }


    public void showAllBooks() {

        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
        for (int i = 0; i < count; i++) {

            System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" +
                    theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);


        }

    }

    public void upgradeBookQty() {

        System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");

        int sNo = Input.nextInt("Enter Serial No of Book");
        for (int i = 0; i < count; i++) {

            if (sNo == theBooks[i].sNo) {

                int addingQty = Input.nextInt("Enter No of Books to be Added:");
                theBooks[i].bookQty += addingQty;
                theBooks[i].bookQtyCopy += addingQty;
                return;

            }

        }

    }


    public void dispMenu() {

        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Enter 0 to Exit Application.");
        System.out.println("Enter 1 to Add new Book.");
        System.out.println("Enter 2 to Upgrade Quantity of a Book.");
        System.out.println("Enter 3 to Search a Book.");
        System.out.println("Enter 4 to Show All Books.");
        System.out.println("Enter 5 to Register User.");
        System.out.println("Enter 6 to Show All Registered Users.");
        System.out.println("Enter 7 to Check Out Book. ");
        System.out.println("Enter 8 to Check In Book");
        System.out.println("---------------------------------------------------");
    }

    public int isAvailable(int sNo) {

        //returns the index number if available


        for (int i = 0; i < count; i++) {

            if (sNo == theBooks[i].sNo) {
                if (theBooks[i].bookQtyCopy > 0) {

                    System.out.println("Book is Available.");
                    return i;

                }
                System.out.println("Book is Unavailable");
                return -1;

            }

        }

        System.out.println("No Book of Serial Number " + " Available in Library.");
        return -1;


    }

    public Book checkOutBook() {

        int sNo = Input.nextInt("Enter Serial No of Book to be Checked Out.");

        int bookIndex = isAvailable(sNo);

        if (bookIndex != -1) {

            //int bookIndex = isAvailable(sNo);
            theBooks[bookIndex].bookQtyCopy--;

            return theBooks[bookIndex];
        }

        return null;

    }

    public void checkInBook(Book b) {

        for (int i = 0; i < count; i++) {

            if (b.equals(theBooks[i])) {

                theBooks[i].bookQtyCopy++;
                return;

            }

        }

    }
}
