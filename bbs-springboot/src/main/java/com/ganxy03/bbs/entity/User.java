package com.ganxy03.bbs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nickname;
    private String name;
    private String sex;
    private String email;
    private String phone;
    private String sno;
    private Integer lv;
    private String password;
    private String city;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    private LocalDateTime create_time;
    private LocalDateTime update_time;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

}
