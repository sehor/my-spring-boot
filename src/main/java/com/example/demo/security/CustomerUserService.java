package com.example.demo.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.error.BusinessException;
import com.example.demo.model.AyRole;
import com.example.demo.model.AyUser;
import com.example.demo.model.AyUserRole;
import com.example.demo.service.AyRoleService;
import com.example.demo.service.AyUserRoleService;
import com.example.demo.service.AyUserService;

public class CustomerUserService implements UserDetailsService {

	@Resource
	private AyUserRoleService userRoleService;

	@Resource
	private AyRoleService roleService;
	@Resource
	private AyUserService ayUserService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		AyUser ayUser = ayUserService.findByUsername(username);
		if (ayUser == null) {
			throw new BusinessException("用户不存在！");
		}

		List<AyUserRole> userRoles = new ArrayList<>();

		userRoles = userRoleService.findByUserId(ayUser.getId());

		if (userRoles.isEmpty() || userRoles == null) {
			throw new BusinessException("该用户没有授权！");
		}

		List<GrantedAuthority> authorities = new ArrayList<>();

		for (AyUserRole userRole : userRoles) {

			AyRole role=roleService.findRole(userRole.getRoleId());
			String roleName=role.getRole();
			
			authorities.add(new SimpleGrantedAuthority(roleName));

		}

		String encodePassword=new BCryptPasswordEncoder().encode(ayUser.getPassword());
		return new User(ayUser.getName(), encodePassword, authorities);
	}

}
