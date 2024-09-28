package com.redisProject.redisProject.Controller;

import com.redisProject.redisProject.Entity.ResidentEntity;

import java.util.List;

public interface ResidentController {

    //Create
    public ResidentEntity saveResidentData(ResidentEntity residentEntity);

    //Read
    public ResidentEntity getResidentDataByID(Long residentID);

    public List<ResidentEntity> getAllResidentsData();

    //Update
    public ResidentEntity updateResidentData(ResidentEntity residentEntity);

    //Delete
    public List<ResidentEntity> deleteResidentData(Long residentID);
}
