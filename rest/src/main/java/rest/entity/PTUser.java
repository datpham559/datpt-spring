package rest.entity;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="PTUser")
public class PTUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    @NotEmpty(message = "Username không được để trống!")
    private String username;

    @Column(name="password")
    @NotEmpty(message = "Password không được để trống!")
    @Min(value = 6, message = "Password phải từ 6 kí tự trở lên!")
    private String password;

    @Column(name="dateofbirth")
    private LocalDateTime dateofbirth;
    @Column(name="address")
    private String address;

    @Column(name="fullname")
    @NotEmpty(message = "Họ tên không được để trống!")
    private String fullname;
    @Column(name="identifycation")
    private String identifycation;

    @Column(name="phonenumber")
    private String phonenumber;

    @Column(name="email")
    @Email(message = "Email không hợp lệ!")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<PTRole> roles;

    public PTUser() {
    }

    public PTUser(Long id, String username, String password, LocalDateTime dateofbirth, String address, String fullname, String identifycation, String phonenumber, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.dateofbirth = dateofbirth;
        this.address = address;
        this.fullname = fullname;
        this.identifycation = identifycation;
        this.phonenumber = phonenumber;
        this.email = email;
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

    public LocalDateTime getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDateTime dateofbirth) {
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

    public Set<PTRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<PTRole> roles) {
        this.roles = roles;
    }
}
