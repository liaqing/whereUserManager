package com.where.where_user_management.service;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.where.where_user_management.model.Users;
/**
 * 
 * @author AQing
 *
 */
public class PasswordHelper {
	private RandomNumberGenerator randomNumberGenerator=new SecureRandomNumberGenerator();
	private String algorithmName = "md5";
	private int hashIterations = 2;
	
    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }
    
    public void encryptPassword(Users users) {

        users.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                users.getPassword(),
                ByteSource.Util.bytes(users.getCredentialsSalt()),
                hashIterations).toHex();
        System.out.println("fffffff");
        System.out.println(newPassword);
        users.setPassword(newPassword);
    }

}
