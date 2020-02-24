package com.cft.chat;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@CrossOrigin
@RestController
public class LinkedinHomeController {

	public static String clientId="86e9rhaw77axs3";
	public static String redirectUrl="http://localhost:8069/home";
   public static String clientSecret="roENIevRNwCRVaAS";
   
	 //after login in your linkedin account your app will hit this get request
    @GetMapping("/home")
    //now store your authorization code
    public String home(@RequestParam("code") String authorizationCode) throws Exception {
		String url = "https://www.linkedin.com/oauth/v2/accessToken";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		//add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("Host", "www.linkedin.com");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		String urlParameters = "grant_type=authorization_code&code="+authorizationCode+"&redirect_uri="+redirectUrl+"&client_id="+clientId+"&client_secret="+clientSecret+"";
        System.out.println(urlParameters);
		String new_url = url+"?"+urlParameters;
		System.out.println("===>"+new_url);
		String urlResponse = URLCONNection.callHttpsPost(new_url);
		System.out.println("   ");
		System.out.println("   ");
		System.out.println("   ");
		System.out.println("urlResponse===>"+urlResponse);
		JSONObject jobj3 = null;
		if(urlResponse.length() !=0)
		{
			JSONObject jobj = new JSONObject(urlResponse);
			String access_token = jobj.getString("access_token");
			System.out.println(access_token);
			LinkedInparam obj_LinkedInProfile=new LinkedInparam();
			obj_LinkedInProfile=sendGet(access_token);
			jobj3 = new JSONObject(obj_LinkedInProfile);
			System.out.println("jobj3======"+jobj3);
     	}
		else {
			jobj3 = new JSONObject();
			jobj3.put("message", "Invalid token");
	
		}
      return jobj3.toString();
    }
    private static LinkedInparam sendGet(String access_token) throws Exception {
		LinkedInparam obj_LinkedInProfile=new LinkedInparam();
		String authorization = "Bearer "+access_token;
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url("https://api.linkedin.com/v2/me").get().addHeader("format", "json").addHeader("Host", "api.linkedin.com")
				.addHeader("Connection", "Keep-Alive").addHeader("Authorization", authorization).build();
		Response response = client.newCall(request).execute();
		String responseBody = response.body().string();
		
		if(responseBody.contains("localizedFirstName"))
		{
			JSONObject jsonObj = new JSONObject(responseBody);
			System.out.println(jsonObj);
			obj_LinkedInProfile.setFirstName(jsonObj.getString("localizedFirstName"));
			obj_LinkedInProfile.setLastName(jsonObj.getString("localizedLastName"));
			obj_LinkedInProfile.setId(jsonObj.getString("id"));
		}
		return obj_LinkedInProfile;
	}
}
