data class Order(
    val productName: String,
    val finalPrice: Int,
    val isDiscounted: Boolean,
)


class OrderService(private val discountService: DiscountService) {
    fun createOrder(
        productName: String,
        price: Int,
        memberShipType: MembershipType
    ): Order {
        val discount = discountService.calculateDiscount(memberShipType)
        val isDiscounted = (discount > 0)
        return Order(
            productName = productName,
            finalPrice = price - discount,
            isDiscounted = isDiscounted,
        )
    }
}
