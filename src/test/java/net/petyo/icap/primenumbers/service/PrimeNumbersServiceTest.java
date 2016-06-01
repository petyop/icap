package net.petyo.icap.primenumbers.service;

import static org.junit.Assert.*;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

public class PrimeNumbersServiceTest {
	
	PrimeNumberService service = new PrimeNumberService();
	
	@Test
	public void testIsPrimeForPrimes() throws InterruptedException, ExecutionException {		
		assertTrue(service.isPrime(3));
		assertTrue(service.isPrime(5));
		assertTrue(service.isPrime(2719));
		assertTrue(service.isPrime(15485863));
	}
	
	@Test
	public void testIsPrimeForNonPrimes() throws InterruptedException, ExecutionException {
		assertFalse(service.isPrime(0));
		assertFalse(service.isPrime(1));
		assertFalse(service.isPrime(579584378));
		assertFalse(service.isPrime(999));
	}	
	
	@Test
	public void testIsPrimeForNegative() throws InterruptedException, ExecutionException {
		assertFalse(service.isPrime(-4));
	}
	
}
