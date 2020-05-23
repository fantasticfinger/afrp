package com.nbp.afrp.RestController;


import com.nbp.afrp.Model.OAuthToken;
import com.nbp.afrp.Login.UserService;
import com.nbp.afrp.Model.LoginUser;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin (origins = "*")
@RestController
public class OAuthController {

	private Gson gson = new Gson();
    private RestTemplate restTemplate = new RestTemplate();

	
	@RequestMapping(value = "/oauth2/login", method = RequestMethod.POST)
	public Object getLogin(@RequestBody LoginUser user) {
		
		String credentials = "afrp:afrp-secret";
        String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Authorization", "Basic " + encodedCredentials);
        
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("client_id", "afrp"); //foo
        params.add("username", user.getUser_id());
        params.add("password", user.getUser_pw());
        //params.add("scope", "read"); //read
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        System.out.println("진입");
        ResponseEntity<String> response = restTemplate.postForEntity("http://127.0.0.1:8081/oauth/token", request, String.class);
        System.out.println("진입2");
        if (response.getStatusCode() == HttpStatus.OK) {
        	
        	System.out.println(response.getBody());
        	
            return response.getBody();
        }
        return null;
	}
	
	@RequestMapping(value = "/oauth/callback", method = RequestMethod.GET)
	
	
	public OAuthToken tokenCallBack(@RequestParam String code) {
		String credentials = "afrp:afrp-secret";
        String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Authorization", "Basic " + encodedCredentials);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", code);
        params.add("grant_type", "authorization_code");
        params.add("redirect_uri", "http://10.78.160.51:8081/oauth/callback");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<String> response = restTemplate.postForEntity("http://127.0.0.1/oauth/token", request, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return gson.fromJson(response.getBody(), OAuthToken.class);
        }
        return null;
	}
	
	
		@RequestMapping(value = "/oauth/token/refresh", method = RequestMethod.GET)
	    public OAuthToken refreshToken(@RequestParam String refreshToken) {

	        String credentials = "afrp:afrp-secret";
	        String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	        headers.add("Authorization", "Basic " + encodedCredentials);

	        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
	        params.add("refresh_token", refreshToken);
	        params.add("grant_type", "refresh_token");
	        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
	        ResponseEntity<String> response = restTemplate.postForEntity("http://127.0.0.1:8081/oauth/token", request, String.class);
	        if (response.getStatusCode() == HttpStatus.OK) {
	            return gson.fromJson(response.getBody(), OAuthToken.class);
	        }
	        return null;
	    }
	
	
	
	
}
