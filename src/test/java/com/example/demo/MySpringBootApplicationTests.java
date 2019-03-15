package com.example.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.data.JpaAyUserRepository;
import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpringBootApplicationTests {

	@Resource
	 private JdbcTemplate jdbcTemplate;
	@Resource
	private JpaAyUserRepository repository;
	@Resource
	private AyUserService ayUserService;
	
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
		
		String key="阿";
		
		for(AyUser user:ayUserService.findByKey(key)) {
			System.out.println("[id]:"+user.getId()+"  [name]:"+user.getName()+
					"  [password]:"+user.getPassword());
		}
		
	}

}
