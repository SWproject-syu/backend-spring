package syu.backendproj.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(length = 100, nullable = true)
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(length = 100, nullable = true)
    private LocalDateTime updateAt;
    @Column(length = 100, nullable = true)
    private String name;
    @Column(length = 100, nullable = true)
    private	String phonenumber;
    @Column(length = 100, nullable = true)
    private String location;
    @Column(length = 100, nullable = true)
    private String date;
    @Column(length = 100, nullable = true)
    private String startAt;
    @Column(length = 100, nullable = true)
    private String endAt;
    @Column(length = 100, nullable = true)
    private String dateDesc;
}
