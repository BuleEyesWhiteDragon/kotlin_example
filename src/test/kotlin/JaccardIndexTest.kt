import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers.`is`

class JaccardIndexTest{
    @Test
    fun testIphoneAndAndroid(){
        val calculator = JaccardIndex()
		assertThat(calculator.calculate("iphone", "android"), `is`(3.0/9.0)) // 0.3333
    }
}
