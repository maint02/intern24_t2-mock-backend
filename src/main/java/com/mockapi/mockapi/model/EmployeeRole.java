//package com.mockapi.mockapi.model;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Getter
//@Setter
//
//@Entity(name = "EMPLOYEE_ROLE")
//public class EmployeeRole {
//    @EmbeddedId
//    private EmployeeRoleId employeeRoleId;
//
//    @Column(name = "EMPLOYEE_ID")
//    private Long employeeId;
//
//    @Column(name = "ROLE_ID")
//    private Long roleId;
//
//    @ManyToOne
//    @MapsId("EMPLOYEE_ID")
//    private Employee employee;
//
//    @ManyToOne
//    @MapsId("ROLE_ID")
//    private Role role;
//}
