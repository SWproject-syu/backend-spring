package com.schoolproj2.schoolproj2;


import com.schoolproj2.schoolproj2.entity.Volunteer;
import com.schoolproj2.schoolproj2.entity.VolunteerDto;
import com.schoolproj2.schoolproj2.repository.VolunteerRepository;
import com.schoolproj2.schoolproj2.service.VolunteerSerivce;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;


@SpringBootTest
@Transactional
public class DbTest {

 VolunteerRepository volunteerRepository;



   /** @Test
    public void 데이터넣기(){
        VolunteerDto vol1 = new VolunteerDto();
        vol1.setName("jsy");


        volunteerRepository.save(vol1);
        vol1 result = volunteerRepository.findById(vol1.getId()).get();
    }**/

    @Test
    public void findAll() {

        //given
       Volunteer member1 = new Volunteer("jsy", "0102038222", "seoul", "201213", "2203121",
              "2321313", "12");

        volunteerRepository.save(member1);

        //when
        List<Volunteer> result = volunteerRepository.findAll();

        //then
        //사이즈는 두개가 나와야한다.

    }
}


