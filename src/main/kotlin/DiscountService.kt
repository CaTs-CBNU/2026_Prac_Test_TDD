import kotlin.random.Random

enum class MemberShipType(val discountAmount: Int) {
    FREE(0),
    STANDARD(3000),
    PREMIUM(5000),
}

class DiscountService {
    fun calculateDiscount(type: MemberShipType): Int {
        var totalDiscountAmount = 0
        totalDiscountAmount += membershipDiscount(discountType = type)
        totalDiscountAmount += eventDiscount()

        return totalDiscountAmount
    }

    fun membershipDiscount(discountType: MemberShipType): Int {
        return when (discountType) {
            MemberShipType.FREE -> discountType.discountAmount
            MemberShipType.STANDARD -> discountType.discountAmount
            MemberShipType.PREMIUM -> discountType.discountAmount
        }
    }

    fun eventDiscount(): Int {
        val number = Random.nextInt(1, 10)

        return if (number > 5) 10_000
        else 0
    }
}
