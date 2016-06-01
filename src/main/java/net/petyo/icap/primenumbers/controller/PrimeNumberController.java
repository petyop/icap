package net.petyo.icap.primenumbers.controller;

import java.util.concurrent.Callable;

import net.petyo.icap.primenumbers.domain.PrimeNumberDTO;
import net.petyo.icap.primenumbers.service.PrimeNumberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PrimeNumberController {
	
	@Autowired
	private PrimeNumberService primeNumberService;

	@RequestMapping("/isprime/{number}")
	public Callable<PrimeNumberDTO> isPrime(@PathVariable(value="number") int number) {
		return () -> {
			PrimeNumberDTO result = new PrimeNumberDTO();
			result.setNumber(number);
			result.setPrime(primeNumberService.isPrime(number));
			return result;
		};
	}

}
