package com.where.where_user_management.service;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.where.where_user_management.model.Business;
/**
 * 
 * @author AQing
 *
 */
public class BusinessPasswordHelper {
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
    
    public void encryptPassword(Business business) {
    	business.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                algorithmName,
                business.getPassword(),
                ByteSource.Util.bytes(business.getCredentialsSalt()),
                hashIterations).toHex();
        business.setPassword(newPassword);
    }

}
