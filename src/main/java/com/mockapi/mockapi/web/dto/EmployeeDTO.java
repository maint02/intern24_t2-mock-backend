package com.mockapi.mockapi.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mockapi.mockapi.model.*;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDTO extends BaseDTO {
    private Long id;


    @NotNull(message = "Username can't be null")
    private String username;

    @NotNull(message = "Username can't be null")
    private String password;

    @Email(message = "email can't be null")
    private String email;

    @NotNull(message = "birthday can't be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @NotNull(message = "address can't be null")
    private String address;

    @NotNull(message = "createDate can't be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    @NotNull(message = "education can't be null")
    private String education;

    @NotNull(message = "faculity can't be null")
    private String faculty;

    @NotNull(message = "facebook can't be null")
    private String fbLink;

    @NotNull(message = "fullName can't be null")
    private String fullName;

    @NotNull(message = "GraduatedYear can't be null")
    private int graduationYear;


    private String image;


    private boolean isActived;

    private boolean isLeader;

    private boolean isManager;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastAccess;

    @NotNull(message = "phoneNumber can't be null")

    private int phoneNumber;

    @NotNull(message = "skypeAcc can't be null")
    private String skypeAcc;

    @NotNull(message = "university can't be null")
    private String university;

    @NotNull(message = "userType can't be null")
    private String userType;

    private List<News> news;

    private List<ABSENT> absents;

    private List<Issues_History> issues_histories;

    private List<String> authorities;

    private EmployeeToken employeeToken;

    private Department department;

    private Position position;
 
    public EmployeeDTO(Employee emp){
        this.id = emp.getId();
        this.address = emp.getAddress();
        this.birthday = emp.getBirthday();
        this.createdDate = emp.getCreatedDate();
        this.issues_histories = emp.getIssues_histories();
        this.education = emp.getEducation();
        this.email = emp.getEmail();
        this.faculty = emp.getFaculty();
        this.fbLink = emp.getFbLink();
        this.fullName = emp.getFullName();
        this.graduationYear = emp.getGraduationYear();
        this.image = emp.getImage();
        this.isActived = emp.isActived();
        this.isLeader = emp.isLeader();
        this.isManager = emp.isManager();
        this.lastAccess = emp.getLastAccess();
        this.password = emp.getPassword();
        this.phoneNumber = emp.getPhoneNumber();
        this.news = emp.getNews();
        this.skypeAcc = emp.getSkypeAcc();
        this.absents = emp.getAbsents();
        this.university = emp.getUniversity();
        this.userType = emp.getUserType();
        this.username = emp.getUsername();
        this.authorities = emp.getRoles().stream()
                .map(auth -> ((Role) auth).getName()).collect(Collectors.toList());
        this.department = emp.getDepartment();
        this.position = emp.getPosition();
    }
}
