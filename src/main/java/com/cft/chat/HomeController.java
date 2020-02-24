package com.cft.chat;

import java.io.PrintWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@CrossOrigin
@Controller
public class HomeController {
	
    //get client id and client Secret by creating a app in 
    //https://www.linkedin.com developers
    //and set your redirect url
	public static String clientId="86e9rhaw77axs3";
	public static String redirectUrl="http://localhost:8069/home";
   public static String clientSecret="roENIevRNwCRVaAS";
	

    //create button on your page and hit this get request
    @GetMapping("/authorization")
    public String authorization() {
        String authorizationUri="https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id="+clientId+"&redirect_uri="+redirectUrl+"&state=asasasasasas&scope=r_liteprofile%20r_emailaddress";
        return "redirect:" + authorizationUri;
    }

   
   
}