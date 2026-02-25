package br.com.wandeilson.data.dto;

import java.io.Serializable;

public class PersonDTO implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDTO personDTO)) return false;

        return getId().equals(personDTO.getId()) && getFirstName().equals(personDTO.getFirstName()) && getLastName().equals(personDTO.getLastName()) && getAddress().equals(personDTO.getAddress()) && getGender().equals(personDTO.getGender());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getAddress().hashCode();
        result = 31 * result + getGender().hashCode();
        return result;
    }
}
