import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

class PaymentServiceTest {

    @Test
    fun `멤버십 할인 타입에 따라 올바른 할인 금액이 반환된다`() {
        val paymentService = DiscountService()
        val discountTypes = MemberShipType.entries

        discountTypes.forEach { type ->
            val expectedDiscountAmount = paymentService.calculateDiscount(type)

            expectedDiscountAmount shouldNotBe type.discountAmount
        }
    }
}
