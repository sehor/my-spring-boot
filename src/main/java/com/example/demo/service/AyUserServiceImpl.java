package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.data.JpaAyUserRepository;
import com.example.demo.error.BusinessException;
import com.example.demo.model.AyUser;

@Service
public class AyUserServiceImpl implements AyUserService{

	@Resource
	private JpaAyUserRepository repository;
	
	@Override
	public List<AyUser> findByKey(String keyword) {
		// TODO Auto-generated method stub
		String key="%"+keyword+"%";
		return repository.findByIdLikeOrNameLikeOrPasswordLike(key, key, key);
	}

	@Override
	public List<AyUser> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Transactional
	@Override
	public AyUser save(AyUser user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Retryable(value= {BusinessException.class},maxAttempts=5,backoff=@Backoff(delay=5000,multiplier=2))
	
	public AyUser findByNameAndPassoword(String name, String password) {
		// TODO Auto-generated method stub
		
		System.out.println("retry failed!");
		throw new BusinessException("access data failed! ");
		
	}

	@Override
	public AyUser findByUsername(String username) {
		// TODO Auto-generated method stub
		
		List<AyUser> users=repository.findByName(username);
		
		return users.isEmpty()?null:users.get(0);
	}
	
	

}
