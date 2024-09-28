package com.redisProject.redisProject.Service;

import com.redisProject.redisProject.Entity.ResidentEntity;
import com.redisProject.redisProject.Repository.ResidentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResidentSeviceImpl implements ResidentService{

    @Autowired
    ResidentRepository residentRepository;

    @Override
    @Transactional
    @CachePut(value = "residentEntity", key = "#residentEntity.residentID")
    public ResidentEntity saveResident(ResidentEntity residentEntity) {
        return residentRepository.save(residentEntity);
    }

    @Override
    @Transactional
    @Cacheable(value = "residentEntity", key = "#residentID")
    public ResidentEntity getResidentByID(Long residentID) {
        return residentRepository.findById(residentID).orElseThrow(()-> new EntityNotFoundException("NOT FOUND"));
    }

    @Override
    @Transactional
    @Cacheable("residentEntity")
    public List<ResidentEntity> getAllResidents() {
        return residentRepository.findAll();
    }

    @Override
    @Transactional
    @CachePut(value = "residentEntity", key = "#residentEntity.residentID")
    public ResidentEntity updateResident(ResidentEntity residentEntity) {
        if(residentRepository.findById(residentEntity.getResidentID()).isPresent()){
            return residentRepository.save(residentEntity);
        }else {
            throw new EntityNotFoundException("Invalid residentID for update");
        }

    }

    @Override
    @Transactional
    @CacheEvict(value = "residentEntity", key = "#residentID")
    public List<ResidentEntity> deleteResident(Long residentID) {
        residentRepository.deleteById(residentID);
        return residentRepository.findAll();
    }

    @Scheduled(fixedRate = 60000) // Refresh every 10 seconds
    @CacheEvict(value = "residentEntity", allEntries = true)
    public void evictCache() {
        System.out.println("Cache evicted at " + LocalDateTime.now());
    }
}
