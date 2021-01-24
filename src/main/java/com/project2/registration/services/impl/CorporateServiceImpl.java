package com.project2.registration.services.impl;

import com.project2.registration.entity.Corporate;
import com.project2.registration.repository.CorporateRepository;
import com.project2.registration.services.CorporateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorporateServiceImpl implements CorporateService {


    @Autowired
    CorporateRepository corporateRepository;

    @Override
    public Corporate addCorporateData(Corporate corporate) {
        return corporateRepository.save(corporate);
    }

    @Override
    public Corporate findByChannelIdAndPageIdAndRole(int channelId, String pageId, int role) {
        return corporateRepository.findByChannelIdAndPageIdAndRole(channelId,pageId,role);
    }

    @Override
    public Corporate deleteByChannelIdAndPageIdAndUserId(int channelId, String pageId, int role) {
        return corporateRepository.deleteByChannelIdAndPageIdAndUserId(channelId,pageId,role);
    }

//    @Override
//    public Corporate updateCorporateData(Corporate corporate) {
//        Corporate corporateData = corporateRepository.findByChannelIdAndPageIdAndRole(corporate.getChannelId(),corporate.getPageId(),corporate.getRole());
//        if(corporateData == null){
//            return corporateRepository.save(corporate);
//        }
//        else{
//            corporate.setUserIds(corporateData.getUserIds()+','+corporate.getUserIds());
//            return corporateRepository.save(corporate);
//        }
//    }
    //NEVER GONNA BE USED LOL
}
