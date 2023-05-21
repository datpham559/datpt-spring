package rest.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public class PTUserDTO {
    private Long id;
    private String username;
    private String password;
    private String dateofbirth;
    private String address;
    private String fullname;
    private String identifycation;
    private String phonenumber;
    private String email;

    public PTUserDTO(String username, String password, String dateofbirth, String address, String fullname, String identifycation, String phonenumber, String email) {
        this.username = username;
        this.password = password;
        this.dateofbirth = dateofbirth;
        this.address = address;
        this.fullname = fullname;
        this.identifycation = identifycation;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public PTUserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getIdentifycation() {
        return identifycation;
    }

    public void setIdentifycation(String identifycation) {
        this.identifycation = identifycation;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
