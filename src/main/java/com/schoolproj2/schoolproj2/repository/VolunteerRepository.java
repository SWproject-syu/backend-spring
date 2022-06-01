package com.schoolproj2.schoolproj2.repository;

import com.schoolproj2.schoolproj2.entity.Volunteer;
import com.schoolproj2.schoolproj2.entity.VolunteerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VolunteerRepository {
private  final EntityManager em;

public void save(Volunteer volunteer){
    if(volunteer.getId()==null){
        em.persist(volunteer);

    }else{
        em.merge(volunteer);
    }


}

public Volunteer findOne(Long id){
    return em.find(Volunteer.class,id);

}

public List<Volunteer> findAll(){
    return em.createQuery("select v from Volunteer v",Volunteer.class)
            .getResultList();
}


    List<Volunteer> findAll();

    @Query("select v from Volunteer v where v.name = :name")
    Volunteer findByName(@Param("name") String name);
}
