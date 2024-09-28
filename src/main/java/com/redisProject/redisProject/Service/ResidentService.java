package com.redisProject.redisProject.Service;

import com.redisProject.redisProject.Entity.ResidentEntity;

import java.util.List;

public interface ResidentService {

    //Create
    public ResidentEntity saveResident(ResidentEntity residentEntity);

    //Read
    public ResidentEntity getResidentByID(Long residentID);

    public List<ResidentEntity> getAllResidents();

    //Update
    public ResidentEntity updateResident(ResidentEntity residentEntity);

    //Delete
    public List<ResidentEntity> deleteResident(Long residentID);
}
