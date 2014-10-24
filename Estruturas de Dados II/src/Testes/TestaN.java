package Testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import Arvores.ArvoreN;

public class TestaN {

	@Test
	public void testaConstrutor(){
		ArvoreN a = new ArvoreN("AAA", 3);
		Assert.assertEquals("AAA", a.getInf());
	}
	
	@Test
	public void testaInserir(){
		ArvoreN a = new ArvoreN("AAA", 2);
		a.inserir(new ArvoreN("BBB", 2));
		a.inserir(new ArvoreN("CCC", 2));
		a.inserir(new ArvoreN("DDD", 2));
		a.inserir(new ArvoreN("EEE", 2));
		a.inserir(new ArvoreN("FFF", 2));
		
		Assert.assertEquals("AAA", a.getInf());
		Assert.assertEquals("BBB", a.getFilhos()[0].getInf());
		Assert.assertEquals("CCC", a.getFilhos()[1].getInf());
		Assert.assertEquals("DDD", a.getFilhos()[0].getFilhos()[0].getInf());
		Assert.assertEquals("EEE", a.getFilhos()[0].getFilhos()[1].getInf());
//		Assert.assertEquals("FFF", a.getFilhos()[1].getFilhos()[0].getInf());
		
	}

}
