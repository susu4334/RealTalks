package com.reeltalks.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JwtDecoder {
	@Autowired
    private ObjectMapper objectMapper;

    public <T> T decode(String jwt, Class<T> type){
        try{
            String[] pieces = jwt.split("\\.");
            String b64payload = pieces[1];
            String jsonString = new String(Base64Utils.decode(b64payload.getBytes()));
            return objectMapper.readValue(jsonString,type);
        }catch (JsonProcessingException e){
            return null;
        }
    }
}
