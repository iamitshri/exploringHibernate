package org.ihc.kr.hibernate.practice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	public Address() {
	}

	public Address(String city) {
		this.city = city;
		this.persons = new HashSet<>();
	}

	private long id;
	private String city;
	private Set<Person> persons;

	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq2")
	@SequenceGenerator(name = "sq2", sequenceName = "address_seq",allocationSize=1)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@ManyToMany(mappedBy = "addresses")
	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", persons=" + persons + "]";
	}
}
