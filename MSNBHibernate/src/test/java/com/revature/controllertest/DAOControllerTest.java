package com.revature.controllertest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.controllers.DAOController;
import com.revature.models.Friend;
import com.revature.models.Location;
import com.revature.models.MUser;
import com.revature.models.Preference;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DAOControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	DAOController dc;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void returnAUser() {
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/users/1", MUser.class).getFirstName()).isNotNull();
	}
	@Test
	public void returnsDefaultUser() {
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/users/0", MUser.class).getEmail()).toString().equals("default@email.com");
	}
	@Test
	public void returnAPreference() {
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/preferences/pref/1/1", Preference.class).getGenre()).isNotNull();
	}
	@Test
	public void returnAFriend() {
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/friends/1", Friend.class).getIsFriendsWith()).isNotNull();
	}
	@Test
	public void returnALocation() {
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/locations/1", Location.class)).isInstanceOf(Location.class);
	}
	@Test
	public void returnsMartin() {
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/users/byemail/msmallwood@rev.com", MUser.class).getFirstName().equals("Martin")).isTrue();
	}
	@Test
	public void returnsReston() {
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/locations/1", Location.class).getCity().equals("Reston")).isTrue();
	}
	@Test
	public void returnsMartinsRockPref() {
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/preferences/pref/1/1", Preference.class).getGenre().equals("rock")).isTrue();
	}
	
	
	
//	@Test
//	public void returnsAListOfPreferences() {
//		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/preferences/", List.class)).asList().first().isInstanceOf(Preference.class);
//	}
//	@Test
//	public void returnsAListOfLocations() {
//		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/locations/", List.class).contains(Location.class));
//	}
//	@Test
//	public void returnsAListOfMUsers() {
//		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/users/", List.class).contains(MUser.class));
//	}
//	@Test
//	public void returnsAListOfFriends() {
//		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/friends/", List.class).contains(Friend.class));
//	}
	
	
}
