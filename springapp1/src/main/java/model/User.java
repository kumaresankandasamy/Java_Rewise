package model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "email_address",nullable = false)
    private String email;
    @Column(name = "created-at",nullable = false)
    @CreatedDate
    private String createdAt;
    @Column(name = "getcreated_by",nullable = false)
    @CreatedBy
    private String getCreatedBy;
    @Column(name = "updated_at",nullable = false)
    @LastModifiedDate
    private Date updatedAt;
    @Column(name = "getupdated_by",nullable = false)
    @LastModifiedBy
    private String getUpdatedBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getGetCreatedBy() {
        return getCreatedBy;
    }

    public void setGetCreatedBy(String getCreatedBy) {
        this.getCreatedBy = getCreatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getGetUpdatedBy(String admin) {
        return getUpdatedBy;
    }

    public void setGetUpdatedBy(String getUpdatedBy) {
        this.getUpdatedBy = getUpdatedBy;
    }
}
