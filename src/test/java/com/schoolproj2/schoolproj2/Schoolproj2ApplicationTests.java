package com.schoolproj2.schoolproj2;

import com.schoolproj2.schoolproj2.entity.Volunteer;
import com.schoolproj2.schoolproj2.repository.VolunteerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Schoolproj2ApplicationTests {

	@Autowired
	VolunteerRepository volunteerRepository;

	@Test
	void 가입(){
		Volunteer volunteer = new Volunteer();
		volunteer.setName("kim");
		volunteerRepository.save(volunteer);
	}

}
