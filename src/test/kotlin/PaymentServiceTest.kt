import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import testFixture.OverFiveNumberGenerator
import testFixture.UnderFiveNumberGenerator

class PaymentServiceTest {

    @Test
    fun `멤버십 할인 타입에 따라 올바른 할인 금액이 반환된다`() {
        val paymentService = DiscountService(UnderFiveNumberGenerator)
        val discountTypes = MembershipType.entries

        discountTypes.forEach { type ->
            val expectedDiscountAmount = paymentService.calculateDiscount(type)

            expectedDiscountAmount shouldBe type.discountAmount
        }
    }

    @Test
    fun `생성된 숫자가 5 초과라면 랜덤 할인 이벤트 금액이 적용된다`() {
        val paymentService = DiscountService(OverFiveNumberGenerator)

        val discountAmount = paymentService.eventDiscount()
        discountAmount shouldBe 5000
    }

    @Test
    fun `생성된 숫자가 5 미만이라면 랜덤 할인 이벤트 금액이 적용되지 않는다`() {
        val paymentService = DiscountService(UnderFiveNumberGenerator)

        val discountAmount = paymentService.eventDiscount()
        discountAmount shouldBe 0
    }
}