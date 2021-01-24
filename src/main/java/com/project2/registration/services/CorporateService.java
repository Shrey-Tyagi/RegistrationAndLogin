package com.project2.registration.services;

import com.project2.registration.entity.Corporate;

public interface CorporateService {
    Corporate addCorporateData(Corporate corporate);

    Corporate findByChannelIdAndPageIdAndRole(int channelId, String pageId, String role);

    Corporate updateCorporateData(Corporate corporate);
}
