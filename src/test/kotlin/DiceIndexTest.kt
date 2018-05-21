import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers.`is`

class DiceIndexTest{
    @Test
    fun testIphoneAndAndroid(){
        val calculator = DiceIndex()
		assertThat(calculator.calculate("iphone", "android"), `is`((2.0 * 3.0)/(6.0 + 7.0))) // 0.4615...
    }
}
