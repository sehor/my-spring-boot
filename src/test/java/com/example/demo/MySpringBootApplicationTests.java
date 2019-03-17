package com.example.demo;

import javax.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.MQService.AyMoodProducer;
import com.example.demo.data.JpaAyUserRepository;
import com.example.demo.service.AyMoodService;
import com.example.demo.service.AyUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpringBootApplicationTests {

	private org.apache.logging.log4j.Logger logger=LogManager.getLogger(this.getClass());
	@Resource
	 private JdbcTemplate jdbcTemplate;
	@Resource
	private JpaAyUserRepository repository;
	@Resource
	private AyUserService ayUserService;
	@Resource
	private AyMoodService ayMoodService;
	
	@Resource
	private AyMoodProducer ayMoodProducer;
	
	@Resource
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private UserDetailsService userDetailService;
	
	/*
	 * @Test public void contextLoads() { }
	 */
	
	@Test
	public void mysqlTest() {
		
		/*
		 * String sql="select id,name,password from ay_user";
		 * 
		 * List<AyUser> userList=jdbcTemplate.query(sql,new RowMapper<AyUser>() {
		 * 
		 * @Override public AyUser mapRow(ResultSet rs, int rowNum) throws SQLException
		 * { // TODO Auto-generated method stub AyUser user=new AyUser();
		 * user.setId(rs.getString("id")); user.setName(rs.getString("name"));
		 * user.setPassword(rs.getString("password"));
		 * 
		 * return user; }
		 * 
		 * 
		 * });
		 * 
		 * for(AyUser user:userList) {
		 * 
		 * System.out.println(" [id]: "+user.getId()+"  [name]:"+user.getName()); }
		 */
		
		  
		/*
		 * String key="阿";
		 * 
		 * for(AyUser user:ayUserService.findByKey(key)) {
		 * System.out.println("[id]:"+user.getId()+"  [name]:"+user.getName()+
		 * "  [password]:"+user.getPassword()); }
		 */
		
		/*
		 * AyMood mood=new AyMood(); mood.setId("2"); mood.setUserId("3");
		 * mood.setPublishTime(new Date()); mood.setContent("这是我的第二条看法，请指教！（asyn）");
		 * 
		 * ayMoodService.aysnSave(mood);
		 * 
		 * System.out.println("save mood successfully!");
		 */
		
		
		 UserDetails user=userDetailService.loadUserByUsername("tom");
		 
		 System.out.println(user.getPassword()+"  "+user.getUsername()+" "+user.getAuthorities().size());
		 
	    for(GrantedAuthority authority:user.getAuthorities()) {
	    	System.out.println(authority.getAuthority().toString());
	    	
	    }

		
	}

}
