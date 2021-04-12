package library;

public class Users {
    User users[] = new User[50];

//books book;


    public static int count = 0;

    public void addStudent(User s){

        for (int i=0; i<count; i++){

            if(s.regNum.equalsIgnoreCase(users[i].regNum)){

                System.out.println("User of Reg Num " + s.regNum + " is Already Registered.");
                return;
            }

        }

        if (count<=50){

            users[count] = s;
            count++;

        }

    }
    public void showAllStudents(){

        System.out.println("User Name\t\tReg Number");
        for (int i=0; i<count; i++){

            System.out.println(users[i].userName + "\t\t" + users[i].regNum);

        }


    }

    public int isUser(){
        //return index number of student if available
        //System.out.println("Enter Student Name:");
        //String studentName = input.nextLine();

        String regNum = Input.nextString("Enter Reg Number:");

        for (int i=0; i<count; i++){

            if (users[i].regNum.equalsIgnoreCase(regNum)){

                return i;

            }

        }
        System.out.println("User is not Registered.");
        System.out.println("Get Registered First.");


        return -1;

    }
    public void checkOutBook(Books book){
        int studentIndex =this.isUser();

        if (studentIndex!=-1){
            System.out.println("checking out");

            book.showAllBooks();//jjjjjjjjjjjj
            Book b = book.checkOutBook();
            System.out.println("checking out");
            if (b!= null){

                if (users[studentIndex].booksCount<=3){
                    System.out.println("adding book");
                    users[studentIndex].borrowedBooks[users[studentIndex].booksCount] = b;
                    users[studentIndex].booksCount++;
                    return;

                }
                else {

                    System.out.println("User Can not Borrow more than 3 Books.");
                    return;

                }
            }
            System.out.println("Book is not Available.");

        }

    }

    public void checkInBook(Books book){

        int userIndex = this.isUser();
        if (userIndex != -1){
            System.out.println("S.No\t\t\tBook Name\t\t\tAuthor Name");
            User s = users[userIndex];
            for (int i=0; i<s.booksCount; i++){

                System.out.println(s.borrowedBooks[i].sNo+ "\t\t\t" + s.borrowedBooks[i].bookName + "\t\t\t"+
                        s.borrowedBooks[i].authorName);

            }
            int sNo = Input.nextInt("Enter Serial Number of Book to be Checked In:");
            for (int i=0; i<s.booksCount; i++){

                if (sNo == s.borrowedBooks[i].sNo){

                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i]=null;
                    return;

                }

            }
            System.out.println("Book of Serial No "+sNo+"not Found");

        }

    }

}
