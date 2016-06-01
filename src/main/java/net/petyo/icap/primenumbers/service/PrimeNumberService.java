package net.petyo.icap.primenumbers.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PrimeNumberService {
	
	private static final int INITIAL_SIEVE_CACHE_SIZE = 100_000_000;
	
	private boolean[] primeSieveCache = new boolean[0];
	
	public PrimeNumberService() {
		primeSieveCache = calculatePrimeSieve(INITIAL_SIEVE_CACHE_SIZE);
	}
	
	public boolean isPrime(int number) {
		
		if (number<2) {
			return false;
		}

		if (primeSieveCache.length>number) {
			return primeSieveCache[number];
		} 
		
		if (number > 2 && number % 2 == 0) {
			return false;
		}

		long top = (long) Math.sqrt(number) + 1;
				
		return checkPrime(top, number);
	}
	
	@Cacheable
	private boolean checkPrime(long top, long number) {
		for (long i = 3; i < top; ++i) {
			if (number % i == 0) {
				 return false;
			}
		}
		return true;
	}
	
	
	private boolean[] calculatePrimeSieve(int sieveLimit) {
		
		boolean[] sieve = new boolean[sieveLimit+1];
		
		sieve[0] = false; 
		sieve[1] = false; 
		for(int i=2; i<=sieveLimit; ++i){
			sieve[i] = true;
		}
		for(int i=2; i*i<=sieveLimit; ++i){
			if (sieve[i]) {
				for (int j = i; i*j <= sieveLimit; j++) {
					sieve[i*j] = false;
                }
			}
		}
		
		return sieve;
	}
}
