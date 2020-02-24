package com.cft.service;

import org.springframework.web.multipart.MultipartFile;

import com.cft.model.Advertisement;

public interface AdvertisementService {

	Advertisement sendEmails(MultipartFile imgpath, Advertisement ad, MultipartFile attachment);

}
