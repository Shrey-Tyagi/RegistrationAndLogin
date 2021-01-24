package com.project2.registration.services;

import com.project2.registration.entity.Corporate;

public interface CorporateService {
    Corporate addCorporateData(Corporate corporate);

    Corporate findByChannelIdAndPageIdAndRole(int channelId, String pageId, int role);

//    Corporate updateCorporateData(Corporate corporate);

    Corporate deleteByChannelIdAndPageIdAndUserId(int channelId, String pageId, int userId);
}
