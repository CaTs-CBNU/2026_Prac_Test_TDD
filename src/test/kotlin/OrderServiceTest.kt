import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import kotlin.test.Test

class OrderServiceTest {

    @Test
    fun `주문 객체는 상품 이름과 총 결제 금액을 갖는다`() {
        val discountService = DiscountService(numberGenerator = UnderFiveNumberGenerator())
        val orderService = OrderService(discountService = discountService)

        val order = orderService.createOrder(
            productName = "호호치킨",
            price = 10_000,
            memberShipType = MembershipType.FREE
        )

        // 바꿔보세요~
        order.finalPrice
        order.productName
    }
}
