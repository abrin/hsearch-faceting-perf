package org.hibernate.search.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Type;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
public class Book {

	@Id
	@GeneratedValue
	@DocumentId
	private Integer id;

	@Field(store=Store.YES)
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String title;

	@Field(analyze = Analyze.NO,store=Store.YES)
	private String isbn;

	@Field(analyze = Analyze.NO,store=Store.YES)
	private String publisher;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@IndexedEmbedded
	private Set<Author> authors = new HashSet<Author>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}



