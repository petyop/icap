package net.petyo.icap.primenumbers.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import net.petyo.icap.primenumbers.domain.PrimeNumberDTO;
import net.petyo.icap.primenumbers.service.PrimeNumberService;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PrimeNumberControllerTest {
	
	@Spy
    private PrimeNumberService service = mock(PrimeNumberService.class);
	
	@InjectMocks
	private PrimeNumberController controller = new PrimeNumberController();

	@Test
	public void testIsPrime() throws Exception {
		when(service.isPrime(10)).thenReturn(true);
		
		PrimeNumberDTO result = controller.isPrime(10).call();
		
		assertEquals(result.getNumber(), 10);
		assertTrue(result.isPrime());
		
		verify(service, times(1)).isPrime(10);
		verifyNoMoreInteractions(service);
	}

}
