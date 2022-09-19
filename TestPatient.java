
import static org.junit.Assert.*;

import org.junit.*;

public class TestPatient {
	@Test
	public void ReturnsTrueIfThePatientIsOver18(){
		Patient p = new Patient("Mickey", "2002-01-01","985654235");
		assertTrue(p.isAbove18());
	}
	@Test
	public void ReturnsFalseIfThePatientIsOver18(){
		Patient p = new Patient("Mickey", "2012-01-01","985654235");
		assertFalse(p.isAbove18());
	}
	@Test
	public void CheckIfGetAgeReturnsExpectedAge21() {
		Patient p = new Patient("Elmo", "2000-04-25","132879666");
		assertEquals(p.getAge(),21);
	}
	@Test
	public void CheckIfGetAgeReturnsExpectedAge100() {
		Patient p = new Patient("Elmo", "1921-04-25","132879666");
		assertEquals(p.getAge(),100);
	}
	@Test
	public void ReturnsTrueIfThePatientIsOver65() {
		Patient p = new Patient("Mickey" ,"1925-01-01","985654235");
		assertTrue(p.isAbove65());

	}
	@Test
	public void ReturnsFalseIfThePatientIsOver65() {
		Patient p = new Patient("Mickey", "2021-01-01","985654235");
		assertFalse(p.isAbove65());

	}
}
