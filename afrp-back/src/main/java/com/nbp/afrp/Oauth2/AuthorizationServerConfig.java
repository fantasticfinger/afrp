package com.nbp.afrp.Oauth2;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import com.nbp.afrp.Login.UserService;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	static final String CLIEN_ID = "foo";
	static final String CLIENT_SECRET = "bar";
	static final String GRANT_TYPE_PASSWORD = "password";
	static final String AUTHORIZATION_CODE = "authorization_code";
	static final String REFRESH_TOKEN = "refresh_token";
	static final String IMPLICIT = "implicit";
	static final String SCOPE_READ = "read";
	static final String SCOPE_WRITE = "write";
	static final String TRUST = "trust";
	static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1*60*60;
    static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 6*60*60;
	
    @Autowired 
    private DataSource dataSource;
    
    @Autowired 
    private ClientDetailsService clientDetailsService;

	@Autowired
	private TokenStore tokenStore;  //인메모리가 아니라 디비를 사용하느 토큰 스토어로 변경해야함 + 토큰스토어에 등록할 수 있는 여러가지 앱들을 등록해줘야함

	@Autowired
	private AuthenticationManager authenticationManager;   // 실제인증하는곳
	
    @Autowired
    private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;	
	
	
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
//        security.tokenKeyAccess("permitAll()")
//                .checkTokenAccess("isAuthenticated()") //allow check token
//                .allowFormAuthenticationForClients();
    }
	
	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

		
		configurer
				.inMemory() 
				.withClient("afrp")   //앱 이름
				.secret(passwordEncoder.encode("afrp-secret"))  //앱의 시크릿  페북이나 구글등에서 자동생성해주는것임
				.authorizedGrantTypes("password","authorization_code" , "refresh_token")
				.redirectUris("http://127.0.0.1:8081/oauth/callback")     
	            .scopes("read", "write")
	            .accessTokenValiditySeconds(30000);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	        super.configure(endpoints);
	        endpoints.accessTokenConverter(jwtAccessTokenConverter())
	           	 	 .authenticationManager(authenticationManager)
	        		 .userDetailsService(userDetailsService);
	}
	

	
	@Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
		 KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new FileSystemResource("src/main/resources/oauth2jwt.jks"), "oauth2jwtpass".toCharArray());
	        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("oauth2jwt"));
	        return converter;
    }
	
	
}