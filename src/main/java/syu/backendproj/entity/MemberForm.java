package syu.backendproj.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter

public class MemberForm {

    @NotEmpty(message = "이름은 필수 입니다다")
    private String name;
    private	String phonenumber;
    private String location;
    private String date;
    private String startAt;
    private String endAt;
    private String dateDesc;

    @CreatedDate
    private LocalDateTime createAt;
    @LastModifiedDate
    private LocalDateTime updateAt;
}
