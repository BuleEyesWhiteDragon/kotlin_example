import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers.`is`

class SimpsonIndexTest{
    @Test
    fun testIphoneAndAndroid(){
        val calculator = SimpsonIndex()
		assertThat(calculator.calculate("iphone", "android"), `is`(3.0/Math.min(6.0, 7.0))) // 5.0
    }
}
