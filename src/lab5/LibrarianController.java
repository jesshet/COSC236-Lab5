package lab5;

public class LibrarianController {
	
	Library library; // Library dependency
	
	public LibrarianController( ) {
		this.library = new Library(); // Constructor injection
	}
	public Library getLibrary() {
		return this.library;
	}
	public void showBooks() {
		library.showBooks();
	}
	public void showMembers() {
		library.showMembers();
	}
	public void addBook(String title) {
		library.addBook(new PaperBook(title));  // PaperBook class constructor dependency
	}
	public void addMember(String name) {
		library.addMember(new Member(name)); // Member class constructor dependency
	}
	public void removeBook(String title) {
		library.removeBook(title); // remove 
	}
	public void removeMember(String name) {
		library.removeMember(name);
	}
	public void showMember(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			System.out.println(member);
		else 
			System.out.println("Member " + name + " not found.");
	}
	public void showBook(String title) {
		PaperBook paperBook = library.findBookByTitle(title);
		if (paperBook != null)
			System.out.println(paperBook);
		else 
			System.out.println("PaperBook " + title + " not found.");
	}
	public void showMemberBooks(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			member.listBorrowedBooks();
		else 
			System.out.println("Member " + name + " not found.");
	}
	
	public void borrowBookByMember(String title, String name) {
		Member member = library.findMemberByName(name); // use library for search
		PaperBook paperBook = library.findBookByTitle(title);  // use library for search
		if (paperBook != null && member != null)
			member.borrowBook(paperBook); // member borrows a paperBook, not library
		else 	
			System.out.println("Either paperBook " + title + " or member " + name + " not found.");
	}
	
	public void returnBookByMember(String title, String name) {
		Member member = library.findMemberByName(name); // use library for search
		PaperBook paperBook = library.findBookByTitle(title); // use library for search
		if (paperBook != null && member != null)
			member.returnBook(paperBook); // members returns paperBook.
		else  	
			System.out.println("Either paperBook " + title + " or member " + name + " not found.");
	}
}
