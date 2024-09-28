package com.redisProject.redisProject.Controller;

import com.redisProject.redisProject.Entity.ResidentEntity;
import com.redisProject.redisProject.Service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Residents")
public class ResidentControllerImpl implements ResidentController{

    @Autowired
    ResidentService residentService;


    @Override
    @PostMapping("/Save")
    public ResidentEntity saveResidentData(@RequestBody ResidentEntity residentEntity) {
        return residentService.saveResident(residentEntity);
    }

    @Override
    @GetMapping("/{residentID}")
    public ResidentEntity getResidentDataByID(@PathVariable Long residentID) {
        return residentService.getResidentByID(residentID);
    }

    @Override
    @GetMapping
    public List<ResidentEntity> getAllResidentsData() {
        return residentService.getAllResidents();
    }

    @Override
    @PostMapping("/Update")
    public ResidentEntity updateResidentData(@RequestBody ResidentEntity residentEntity) {
        return residentService.updateResident(residentEntity);
    }

    @Override
    @PostMapping("/Delete/{residentID}")
    public List<ResidentEntity> deleteResidentData(@PathVariable Long residentID) {
        return residentService.deleteResident(residentID);
    }
}
