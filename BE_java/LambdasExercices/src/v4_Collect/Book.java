package v4_Collect;

import java.util.Objects;

public class Book implements Comparable<Book> {
	
	private final String isbn;
	private final String titol;
	private final int anyPublicacio;
	private final Genre genre;
	
	//--- CONSTRUCTOR ------------------------------------------------------
	public Book(String isbn, String titol, int anyPublicacio, Genre genre) {
		super();
		
		Objects.requireNonNull(isbn, "isbn must not be null");
		Objects.requireNonNull(titol, "titol must not be null");
		Objects.requireNonNull(genre, "genre must not be null");
		
		this.isbn = isbn;
		this.titol = titol;
		this.anyPublicacio = anyPublicacio;
		this.genre = genre;
	}

	// --- GETTERS ----------------
	public String getIsbn() {
		return isbn;
	}

	public String getTitol() {
		return titol;
	}

	public int getAnyPublicacio() {
		return anyPublicacio;
	}

	public Genre getGenre() {
		return genre;
	}

	@Override
	public String toString() {
		return "[isbn=" + isbn + ", titol=" + titol + ", anyPublicacio=" + anyPublicacio + ", genre=" + genre+ "]\n";
	}

	// --- EQUALS PER UN SET hashCode. --------------------------------
	@Override
	public int hashCode() {
		return Objects.hash(anyPublicacio, genre, isbn, titol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return anyPublicacio == other.anyPublicacio && genre == other.genre && Objects.equals(isbn, other.isbn)
				&& Objects.equals(titol, other.titol);
	}

	// --- Interface Comparable ---------
	@Override
	public int compareTo(Book o) {		
		return titol.compareTo(o.titol);
	}
	
	
	
	
}
