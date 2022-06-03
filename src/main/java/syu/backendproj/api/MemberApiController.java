package syu.backendproj.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.web.bind.annotation.*;
import syu.backendproj.entity.Member;
import syu.backendproj.service.MemberService;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;
    //회원 조회 api (json)

    @CrossOrigin(origins = "*")
    @GetMapping("/api/members")
    public List<Member> member(){
    return memberService.findMembers();

    }
    @Data
    @AllArgsConstructor
    static  class Result<T>{
        private T data;
    }
    @Data
    @AllArgsConstructor
    static class MemberDto{
        private String name;
        private	String phonenumber;
        private String location;
        private String date;
        private String startAt;
        private String endAt;
        private String dateDesc;


    }

    //회원 등록  api (json)

    @CrossOrigin(origins = "*")
    @PostMapping("/api/members")
    public CreateMemberResponse saveMember(@RequestBody @Valid CreateMemberRequest request){
        Member member = new Member();
        member.setName(request.getName());
        member.setPhonenumber(request.getPhonenumber());
        member.setLocation(request.getLocation());
        member.setDate(request.getDate());
        member.setStartAt(request.getStartAt());
        member.setEndAt(request.getEndAt());
        member.setCreateAt(request.getCreateAt());
        Long id =  memberService.join(member);
        return new CreateMemberResponse(id);
    }
    //회원수정 api(json)

    @CrossOrigin(origins = "*")
    @PutMapping("/api/members/{id}")
    public UpdateMemberResponse updateMember(@PathVariable("id") Long id, @RequestBody @Valid UpdateMemberRequest request){

        memberService.update(id,request.getName());
        Member findMember = memberService.findOne(id);
        return new UpdateMemberResponse(findMember.getId(), findMember.getName());

    }
    //수정 요청 dto
    @Data
    static class UpdateMemberRequest{
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
    // 수정 응답 dto
    @Data
    @AllArgsConstructor
    static  class UpdateMemberResponse{
        private Long id;
        private String name;

    }

    //등록 요청 dto
    @Data
    static class CreateMemberRequest{
        @NotEmpty
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
    //응답값 설정
    @Data
    static class CreateMemberResponse{
        private Long id; //등록된 id값 반환
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

        //생성자
        public CreateMemberResponse(Long id){
            this.id = id;
        }
    }
}
