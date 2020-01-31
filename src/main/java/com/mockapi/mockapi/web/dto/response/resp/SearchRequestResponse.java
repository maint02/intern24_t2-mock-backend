package com.mockapi.mockapi.web.dto.response.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mockapi.mockapi.model.Department;
import com.mockapi.mockapi.model.Position;
import com.mockapi.mockapi.model.Role;
import com.mockapi.mockapi.model.Team;
import com.mockapi.mockapi.web.dto.response.BaseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchRequestResponse{
    private Long id;

    private String username;

    private String email;

    private Date createdDate;

    private String fullName;

    private boolean isActived;

    private boolean isLeader;

    private boolean isManager;

    private Date lastAccess;

    private int phoneNumber;

    private String userType;

    private String roleName;

    private String departmentName;

    private Long leaderId;

    @Override
    public String toString() {
        return "SearchRequestResponse{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", createdDate=" + createdDate +
                ", fullName='" + fullName + '\'' +
                ", isActived=" + isActived +
                ", isLeader=" + isLeader +
                ", isManager=" + isManager +
                ", lastAccess=" + lastAccess +
                ", phoneNumber=" + phoneNumber +
                ", userType='" + userType + '\'' +
                ", roleName='" + roleName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", leaderId=" + leaderId +
                '}';
    }
}
