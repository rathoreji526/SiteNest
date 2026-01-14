package com.sitenest.patform.services;

import com.sitenest.patform.exceptions.UploadFileException;
import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.config.Configuration;
import io.imagekit.sdk.exceptions.*;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.results.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.classfile.Unknown;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Slf4j
@Service
public class ImageKitService {
    @Value("${UrlEndpoint}")
    private String UrlEndpoint;
    @Value("${PrivateKey}")
    private String PrivateKey;
    @Value("${PublicKey}")
    private String PublicKey;

    //Initialize SDK via Create an ImageKit Instance
    public ImageKit getImageObject(){
        ImageKit imageKit = ImageKit.getInstance();
        Configuration configuration = new Configuration(PublicKey , PrivateKey , UrlEndpoint);
        imageKit.setConfig(configuration);
        return imageKit;
    }
    //uploading image
    public Result uploadDocument(MultipartFile file ,
                                 String fileName ,
                                 String folder) throws ForbiddenException, TooManyRequestsException, InternalServerException , UnauthorizedException, BadRequestException , UnknownException , IOException{

        //throw exception if it file size is > 25MB
        try{
            long fileSizeInMB = file.getSize()/(1024*1024);
            if(fileSizeInMB > 25)throw new UploadFileException("File size is grater than 25MB");
        }catch (Exception e){
            log.warn(e.getMessage());
        }
//        process of storing an image to imagekit
//        step 1: convert file to to base64 using "Base64.getEncoder().encodeToString(file.getBytes);"
//        step 2: request for file creation using "FileCreateRequest" object
//        step 3: (if needed) set folder for filecreaterequest



        //convert file to base64 string
        String base64 = Base64.getEncoder().encodeToString(file.getBytes()); /// file.getBytes() returns a byte array

        //file create request
        FileCreateRequest fileCreateRequest = new FileCreateRequest(
                base64,
                fileName);
        //Setting folder
        fileCreateRequest.setFolder(folder);
        //Image
        ImageKit imageKit = getImageObject();
        //upload
        Result result = imageKit.upload(fileCreateRequest);
        return result;
    }

}
