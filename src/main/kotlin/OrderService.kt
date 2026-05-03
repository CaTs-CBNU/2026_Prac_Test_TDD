data class Order(
    val productName: String,
    val finalPrice: Int,
)


class OrderService(private val discountService: DiscountService) {
    fun createOrder(
        productName: String,
        price: Int,
        memberShipType: MembershipType
    ): Order {
        val discount = discountService.calculateDiscount(memberShipType)
        return Order(
            productName = productName,
            finalPrice = price - discount
        )
    }
}
