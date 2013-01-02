package com.symbio.sbtm.model;

import java.io.InputStream;
import java.io.Serializable;
import java.nio.Buffer;

import javax.persistence.*;

import org.hibernate.type.BlobType;

import com.mysql.jdbc.Blob;

//@Entity
public class DataFile implements Serializable {
	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "charterId")
	private Charter charter;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bugId")
	private Bug bug;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "issueId")
	private Issue issue;

	@JoinColumn(name = "fileName")
	private String fileName;

	@JoinColumn(name = "description")
	private String description;

	@JoinColumn(name = "binData")
	private Blob buffer;

	@JoinColumn(name = "fileSize")
	private Long size;

	@JoinColumn(name = "fileType")
	private String type;

	@Override
	public String toString() {
		return this.fileName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((bug == null) ? 0 : bug.hashCode());
		result = prime * result + ((charter == null) ? 0 : charter.hashCode());
		result = prime * result + ((issue == null) ? 0 : issue.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}
}
