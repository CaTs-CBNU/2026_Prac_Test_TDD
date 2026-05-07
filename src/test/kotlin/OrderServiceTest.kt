import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import testFixture.UnderFiveNumberGenerator
import kotlin.test.Test

class OrderServiceTest {

    @Test
    fun `주문 객체는 상품 이름과 총 결제 금액을 갖는다`() {
        val discountService = DiscountService(numberGenerator = UnderFiveNumberGenerator)
        val orderService = OrderService(discountService = discountService)

        val order = orderService.createOrder(
            productName = "호호치킨",
            price = 10_000,
            memberShipType = MembershipType.FREE
        )

        // 바꿔보세요~
        order.finalPrice shouldBe 10_000
        order.productName shouldBe "호호치킨"
    }

    @Test
    fun `할인의 적용여부가 주문 객체에 반영된다`() {
        val discountService = DiscountService(numberGenerator = UnderFiveNumberGenerator)
        val orderService = OrderService(discountService = discountService)

        val notDiscountedOrder = orderService.createOrder(
            productName = "호호치킨",
            price = 10_000,
            memberShipType = MembershipType.FREE
        )

        val discountedOrder = orderService.createOrder(
            productName = "호호치킨",
            price = 10_000,
            memberShipType = MembershipType.PREMIUM
        )

        // 채워보세요~
        notDiscountedOrder.isDiscounted shouldBe false
        discountedOrder.isDiscounted shouldBe true
    }
}
