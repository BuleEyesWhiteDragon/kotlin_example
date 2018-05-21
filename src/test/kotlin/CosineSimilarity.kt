import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.closeTo

class CosineSimilarityTest {
    @Test
    fun testIphoneAndAndroid(){
        val calculator = CosineSimilarity()
		assertThat(calculator.calculate("iphone", "android"), `is`(closeTo(0.408248, 0.0001)))
    }
}
